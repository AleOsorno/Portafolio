unsigned int s_der; //Registro sensor derecho
unsigned int s_izq; //Registro sensor izquierdo

//(Superficie clara / Linea oscura)
const unsigned int UMBRAL_DER = 100;
const unsigned int UMBRAL_IZQ = 200;

//Estado de memoria (0: Centrado, 1: Desvio Izq, 2: Desvio Der)
unsigned short memoria = 0; 

//Filtro digital para mitigar ruido en la lectura analoga
unsigned int leer_estable(unsigned char canal) {
    unsigned int suma = 0; short i;
    for(i=0; i<5; i++) { suma += ADC_Read(canal); Delay_us(50); }
    return (suma / 5);
}

void main() {
    //Configuracion de Perifericos e I/O
    ADCON1 = 0x04; //AN0 y AN1 como analogicos; resto digitales
    TRISA = 0b00000011; //Puerto A: RA0 y RA1 como entradas (Sensores)
    TRISC = 0b00000000; //Puerto C: Salidas (Control de Motores / Puente H)
    TRISB = 0b00000000; //Puerto B: Salidas (LEDs inhabilitados por consumo)

    ADC_Init();
    PORTA = 0; PORTC = 0; PORTB = 0;

    //SEGURO ANTI-REINICIO
    Delay_ms(3000); //3 segundos para que la pila junte fuerza

    //Configuracion del Modulo PWM
    PWM1_Init(5000); //Frecuencia de a 5 kHz
    PWM1_Start();
    PWM1_Set_Duty(185); //Ciclo de trabajo optimizado

    //Paro inicial de motores
    PORTC.F4 = 0; PORTC.F5 = 0; PORTC.F6 = 0; PORTC.F7 = 0;

    //Lazo de Control Principal
    while(1) {
        s_der = leer_estable(0);
        s_izq = leer_estable(1);

        //Matriz de Conmutacion de Motores
        
        if (s_izq >= UMBRAL_IZQ && s_der >= UMBRAL_DER) {
            //AMBOS EN BLANCO: Rescate con memoria (sin reversa)
            if (memoria == 1) {
                //Se perdio por izquierda -> Sigue girando a la izquierda
                PORTC.F4 = 1; PORTC.F5 = 0; //Falsa Izquierda empuja
                PORTC.F6 = 0; PORTC.F7 = 0; //Falsa Derecha frena
            }
            else if (memoria == 2) {
                //Se perdio por derecha -> Sigue girando a la derecha
                PORTC.F4 = 0; PORTC.F5 = 0; //Falsa Izquierda frena
                PORTC.F6 = 1; PORTC.F7 = 0; //Falsa Derecha empuja
            }
            else {
                //Recta
                PORTC.F4 = 1; PORTC.F5 = 0;
                PORTC.F6 = 1; PORTC.F7 = 0;
            }
        }
        else if (s_der < UMBRAL_DER && s_izq >= UMBRAL_IZQ) {
            //DERECHO VE NEGRO -> GIRA A LA DERECHA
            memoria = 2;
            PORTC.F4 = 0; PORTC.F5 = 0; //Frena
            PORTC.F6 = 1; PORTC.F7 = 0; //Empuja
        }
        else if (s_izq < UMBRAL_IZQ && s_der >= UMBRAL_DER) {
            //IZQUIERDO VE NEGRO -> GIRA A LA IZQUIERDA
            memoria = 1;
            PORTC.F4 = 1; PORTC.F5 = 0; //Empuja
            PORTC.F6 = 0; PORTC.F7 = 0; //Frena
        }
        else {
            //AMBOS EN NEGRO
            memoria = 0;
            PORTC.F4 = 1; PORTC.F5 = 0;
            PORTC.F6 = 1; PORTC.F7 = 0;
        }

        Delay_ms(10);
    }
}
