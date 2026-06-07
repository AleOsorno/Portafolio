#define CUSTOM_SETTINGS
#define INCLUDE_GAMEPAD_MODULE
#include <DabbleESP32.h>
#include "I2Cdev.h"
#include "MPU6050.h"
#include "Wire.h"
#include "driver/gpio.h"

//Configuracion del sensor MPU6050
MPU6050 mpu;
int16_t ax, ay, az, gx, gy, gz;
float angulo_x = 0, angulo_y = 0; 
float desvio_gx, desvio_gy, desvio_gz, desvio_acelerometro_x, desvio_acelerometro_y;

//Pines de los motores: Frontal Izquierdo, Trasero Izquierdo, Trasero Derecho, Frontal Derecho
const int motores[] = {2, 1, 6, 7};
unsigned long ultimo_tiempo;

//Variables de vuelo y seguridad
int potencia = 0;
bool armado = false;
float zona_muerta = 1.2;

//Control PID y variables de error
float Kp = 1.8;
float Ki = 0.02; 
float Kd = 0.6;  
float error_x_previo = 0, error_y_previo = 0;
float integral_x = 0, integral_y = 0;

//Angulos deseados y comando de rotacion
float angulo_pitch = 0;
float angulo_roll = 0;
int comando_yaw = 0;

void setup() {
  //Configura los pines de los motores como salida y los apaga
  for(int i=0; i<4; i++) {
    pinMode(motores[i], OUTPUT);
    digitalWrite(motores[i], LOW);
  }

  //Inicia la conexion bluetooth con el nombre del dron
  Dabble.begin("Dron_Final_C3"); 

  //Configura el PWM de los motores a 22kHz y resolucion de 8 bits
  for(int i=0; i<4; i++) {
    ledcSetup(i, 22000, 8); 
    ledcAttachPin(motores[i], i);
    ledcWrite(i, 0);
  }

  //Inicia el bus I2C en los pines 4 y 5
  Wire.begin(4, 5);
  delay(3000); 
  mpu.initialize();

  //Calibracion: saca el promedio de 400 lecturas para eliminar errores del sensor
  for(int i=0; i<400; i++) {
    mpu.getMotion6(&ax, &ay, &az, &gx, &gy, &gz);
    desvio_gx += gx; desvio_gy += gy; desvio_gz += gz;
    desvio_acelerometro_x += atan2(-ax, sqrt(ay * ay + az * az)) * 180 / PI;
    desvio_acelerometro_y += atan2(ay, az) * 180 / PI;
    delay(4);
  }
  desvio_gx /= 400.0; desvio_gy /= 400.0; desvio_gz /= 400.0;
  desvio_acelerometro_x /= 400.0; desvio_acelerometro_y /= 400.0;
  
  ultimo_tiempo = millis();
}

void loop() {
  //Recibe los datos del control por bluetooth
  Dabble.processInput(); 

  //Boton Start para armar el dron y Select para apagarlo por seguridad
  if (GamePad.isStartPressed()) {
    armado = true;
  }
  if (GamePad.isSelectPressed()) { 
    armado = false; 
    potencia = 0;
    integral_x = 0; 
    integral_y = 0;
  }
  
  if (armado) {
    //Lectura del joystick izquierdo para potencia y rotacion
    int joyL_Y = GamePad.getYaxisData(); 
    int joyL_X = GamePad.getXaxisData(); 
    
    //Mapeo para usar todo el rango de potencia de 0 a 255
    if (joyL_Y > 0) {
      potencia = map(joyL_Y, 0, 7, 0, 255);
    }
    else if (joyL_Y < 0) {
      potencia = map(joyL_Y, 0, -7, 0, 0);
    }
    else {
      potencia = 0;
    }

    //Mapeo del giro sobre su propio eje
    comando_yaw = map(joyL_X, -7, 7, -25, 25);

    //Lectura de botones de la derecha para inclinar el dron
    if (GamePad.isTrianglePressed()) {
      angulo_pitch = 15;
    }
    else if (GamePad.isCrossPressed()) {
      angulo_pitch = -15;
    }
    else {
      angulo_pitch = 0;
    }

    if (GamePad.isCirclePressed()) {
      angulo_roll = 15;
    }
    else if (GamePad.isSquarePressed()) {
      angulo_roll = -15;
    }
    else {
      angulo_roll = 0;
    }
  }

  //Calcula el tiempo transcurrido desde el ultimo ciclo
  float dt = (millis() - ultimo_tiempo) / 1000.0;
  ultimo_tiempo = millis();

  //Si el dron no esta armado apaga los motores y detiene el codigo aqui
  if (!armado) {
    for(int i=0; i<4; i++) {
      ledcWrite(i, 0);
    }
    return;
  }

  //Lee el acelerometro y giroscopio
  mpu.getMotion6(&ax, &ay, &az, &gx, &gy, &gz);

  //Calcula los angulos actuales
  float acelerometro_x = (atan2(-ax, sqrt(ay * ay + az * az)) * 180 / PI) - desvio_acelerometro_x;
  float acelerometro_y = (atan2(ay, az) * 180 / PI) - desvio_acelerometro_y;
  angulo_x = 0.98 * (angulo_x + ((gx - desvio_gx) / 131.0) * dt) + 0.02 * acelerometro_x;
  angulo_y = 0.98 * (angulo_y + ((gy - desvio_gy) / 131.0) * dt) + 0.02 * acelerometro_y;

  //Calcula la diferencia entre el angulo real y el deseado
  float error_x = angulo_x - angulo_pitch;
  float error_y = angulo_y - angulo_roll;

  //Calculo de la parte Integral del PID con limite para evitar sobretiros
  integral_x = constrain(integral_x + error_x * dt, -40, 40);
  integral_y = constrain(integral_y + error_y * dt, -40, 40);

  //Calculo de la parte Derivativa del PID
  float deriv_x = (error_x - error_x_previo) / dt;
  float deriv_y = (error_y - error_y_previo) / dt;

  //Suma de las correcciones Proporcional, Integral y Derivativa
  float corrP = (error_x * Kp) + (integral_x * Ki) + (deriv_x * Kd);
  float corrR = (error_y * -Kp) + (integral_y * -Ki) + (deriv_y * -Kd);

  //Guarda los errores actuales para el siguiente ciclo
  error_x_previo = error_x;
  error_y_previo = error_y;

  //Mezcla de potencia base y correcciones PID para cada motor
  int pFI = potencia + corrP + corrR + comando_yaw;
  int pTI = potencia - corrP + corrR - comando_yaw;
  int pTD = potencia - corrP - corrR + comando_yaw;
  int pFD = potencia + corrP - corrR - comando_yaw;

  //Envia la potencia final limitando los valores entre 0 y 255
  ledcWrite(0, constrain(pFI, 0, 255)); 
  ledcWrite(1, constrain(pTI, 0, 255)); 
  ledcWrite(2, constrain(pTD, 0, 255)); 
  ledcWrite(3, constrain(pFD, 0, 255)); 

  delay(10);
}
