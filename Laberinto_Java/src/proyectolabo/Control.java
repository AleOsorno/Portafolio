package proyectolabo;

import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Control {
   private int[][] mapa;
   private JButton[][] MapaLab;
   private Jugador jugador;
   private int intentos = 0;
   private boolean proteccion = false;
   private boolean winner = false;
   private boolean loser = false;
   private ArrayList<Animacion> animaciones = new ArrayList();
   private ArrayList<Pregunta> preguntas = new ArrayList();
   private Datos datos;
   private String fecha;
   private String horaI;
   private boolean cerrando;

   public Control(JButton[][] MapaLab, Jugador jugador, Datos datos, String fecha, String horaI) {
      this.MapaLab = MapaLab;
      this.jugador = jugador;
      this.datos = datos;
      this.fecha = fecha;
      this.horaI = horaI;
      this.cerrando = false;
      this.preguntas.add(new Pregunta(5, "<html>¿Qué suceso marcó el inicio de la <br>guerra de la independencia?</html>", 2, 30, new String[]{"La firma de la constitución", "Las leyes de la reforma", "El grito de Dolores", "La caída de Teotihuacán"}));
      this.preguntas.add(new Pregunta(6, "<html>¿Cuántos elementos se han descubierto en la Tierra?</html>", 0, 30, new String[]{"118", "119", "117", "116"}));
      this.preguntas.add(new Pregunta(7, "<html>Si estás corriendo y pasas al corredor que va en segundo lugar,<br> ¿en qué posición estás ahora?</html>", 2, 20, new String[]{"Cuarto lugar", "Tercer lugar", "Segundo lugar", "Primer lugar"}));
      this.preguntas.add(new Pregunta(8, "<html>Si + significa ÷, ÷ significa –, – significa x <br>y x significa +, entonces: 9 + 3 ÷ 5 – 3 x 7 = ?</html>", 3, 40, new String[]{"5", "15", "25", "Ninguno de estos"}));
      this.preguntas.add(new Pregunta(9, "<html>Ordena el siguiente código: <br>1. for(int i = 0;i < numeros.lenght; i++)<br>2.System.out.println(numeros[i]);<br>3. numeros[i] = (int)(Math.random()*30)+1;<br>4. int[] numeros = new int[15]</html>", 1, 45, new String[]{"4, 1, 2, 3", "4, 1, 3, 2", "1, 4, 3, 2", "4, 3, 1, 2"}));
      this.preguntas.add(new Pregunta(10, "<html>¿Cuál es la instrucción fundamental en programación<br> que permite tomar decisiones basadas en una condición (en inglés)?</html>", 2, 20, new String[]{"While", "For", "If", "Switch"}));
      this.preguntas.add(new Pregunta(11, "<html>¿Cuál es el valor de π (pi) con sus<br> dos primeros decimales?</html>", 2, 20, new String[]{"3.13", "3.12", "3.14", "3.15"}));
      this.preguntas.add(new Pregunta(12, "<html>¿Quién fue el primer presidente de los<br> Estados Unidos Mexicanos?</html>", 1, 30, new String[]{"Benito Juárez", "Guadalupe Victoria", "Miguel Hidalgo", "Agustín de Iturbide"}));
      this.preguntas.add(new Pregunta(13, "<html>¿Qué tipo de razonamiento va de<br> lo general a lo particular?</html>", 0, 20, new String[]{"Deductivo", "Inductivo", "Analítico", "Sintético"}));
      this.preguntas.add(new Pregunta(14, "<html>¿Cuál es el proceso por el cual las plantas<br> convierten la luz solar en energía química?</html>", 0, 25, new String[]{"Fotosíntesis", "Respiración", "Fermentación", "Germinación"}));
      this.preguntas.add(new Pregunta(15, "<html>Si un numero al cuadrado menos el doble<br> de sí mismo da 35, ¿cuál es el número?</html>", 1, 30, new String[]{"5 y -7", "7 y -5", "6 y -6", "8 y -4"}));
      this.preguntas.add(new Pregunta(16, "<html>Hay un número. Si lo multiplicas por 4 y luego le sumas 6, obtienes el mismo<br> resultado que si lo multiplicas por 5 y le restas 4. ¿Qué número es?</html>", 3, 30, new String[]{"6", "8", "12", "10"}));
      this.preguntas.add(new Pregunta(17, "<html>¿Cuál de los siguientes elementos es un gas noble?</html>", 1, 20, new String[]{"Nitrógeno", "Helio", "Oxígeno", "Hidrógeno"}));
      this.preguntas.add(new Pregunta(18, "<html>¿Cuál es el resultado del siguiente algoritmo? <br> entero resultado = 1 <br>para i = 2 hasta 4 hacer<br>  resultado = resultado * i<br>escribir(resultado)</html>", 3, 40, new String[]{"6", "12", "20", "24"}));
      this.preguntas.add(new Pregunta(19, "<html>¿Cuál de los siguientes tratados puso <br>oficialmente fin a la Primera Guerra Mundial?</html>", 1, 30, new String[]{"Tratado de París", "Tratado de Versalles", "Tratado de Tordesillas", "Tratado de Utrecht"}));
      this.animaciones.add(new Animacion(jugador.getPersonaje().getImagenAbajoLab(), 85, 75, 4));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon1_Lastimado.png", 40, 60, 2));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon2_Pose.png", 40, 60, 3));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon3_Cringe.png", 40, 60, 2));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon4_Idle.png", 64, 75, 5));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon5_Charge.png", 52, 75, 10));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon6_Charge.png", 52, 65, 10));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon7_Shoot.png", 60, 75, 17));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon8_Sleep.png", 40, 75, 2));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon9_Eat.png", 55, 70, 4));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon10_Pull.png", 46, 75, 7));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon11_Shock.png", 65, 60, 13));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon12_Eat.png", 88, 75, 4));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon13_RearUp.png", 65, 75, 11));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon14_Sleep.png", 45, 75, 2));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon15_Idle.png", 53, 65, 6));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Escudo.png", 40, 60, 3));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/PuntosExtra.png", 60, 60, 8));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Cura.png", 60, 60, 4));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Informacion.png", 95, 60, 3));
      this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Informacion.png", 95, 60, 3));
      this.mapa = new int[10][10];
      this.mapa = new int[][]{{1, 3, 1, 0, 1, 3, 1, 4, 0, 3}, {0, 4, 4, 4, 4, 0, 0, 4, 4, 0}, {1, 4, 4, 4, 3, 1, 1, 3, 4, 1}, {3, 4, 25, 4, 1, 4, 4, 4, 4, 3}, {1, 4, 3, 4, 1, 0, 1, 3, 1, 1}, {0, 4, 3, 0, 4, 4, 0, 4, 4, 4}, {1, 4, 0, 4, 3, 1, 1, 3, 1, 1}, {28, 3, 1, 4, 0, 4, 4, 4, 4, 0}, {4, 4, 4, 4, 1, 0, 3, 1, 4, 3}, {0, 1, 3, 0, 1, 0, 3, 27, 4, 26}};
      this.mapa[0][3] = this.idPreguntas();
      this.mapa[1][0] = this.idPreguntas();
      this.mapa[1][5] = this.idPreguntas();
      this.mapa[1][6] = this.idPreguntas();
      this.mapa[1][9] = this.idPreguntas();
      this.mapa[4][5] = this.idPreguntas();
      this.mapa[5][0] = this.idPreguntas();
      this.mapa[5][6] = this.idPreguntas();
      this.mapa[6][2] = this.idPreguntas();
      this.mapa[7][4] = this.idPreguntas();
      this.mapa[7][9] = this.idPreguntas();
      this.mapa[8][5] = this.idPreguntas();
      this.mapa[9][3] = this.idPreguntas();
      this.mapa[9][5] = this.idPreguntas();
      this.mapa[0][8] = this.idPowerUp();
      this.mapa[5][3] = this.idPowerUp();
      this.mapa[9][0] = this.idPowerUp();
   }

   public int[][] getMapa() {
      return this.mapa;
   }

   public boolean isCerrando() {
      return this.cerrando;
   }

   public void setMapa(int[][] mapa) {
      this.mapa = mapa;
   }

   public boolean isWinner() {
      return this.winner;
   }

   public boolean isLoser() {
      return this.loser;
   }

   public void validarMovimiento(int movimiento) {
      for(int i = 0; i < 10; ++i) {
         for(int j = 0; j < 10; ++j) {
            if (this.mapa[i][j] == 28) {
               label214:
               switch (movimiento) {
                  case 1:
                     if (i > 0 && this.mapa[i - 1][j] >= 5 && this.mapa[i - 1][j] <= 19) {
                        if (!this.proteccion) {
                           int pregunta = this.mapa[i - 1][j] - 5;
                           this.cerrando = true;
                           Desafios desafio = new Desafios((Frame)null, true, ((Pregunta)this.preguntas.get(pregunta)).getPregunta(), ((Pregunta)this.preguntas.get(pregunta)).getCorrecto(), ((Pregunta)this.preguntas.get(pregunta)).getTiempo(), ((Pregunta)this.preguntas.get(pregunta)).getOpciones());
                           desafio.setVisible(true);
                           if (desafio.isAcierto()) {
                              JOptionPane.showMessageDialog((Component)null, "¡Correcto!", "Respuesta", 1);
                              this.mapa[i - 1][j] = 0;
                              this.jugador.sumarPuntos(20);
                              this.Arriba();
                           } else {
                              JOptionPane.showMessageDialog((Component)null, "Incorrecto...", "Respuesta", 0);
                              if (this.intentos % 2 != 0) {
                                 if (this.jugador.getVidas() > 0) {
                                    this.jugador.restarVidas(1);
                                 }
                              } else if (this.jugador.getPuntos() - 10 > 0) {
                                 this.jugador.restarPuntos(10);
                              } else {
                                 this.jugador.setPuntos(0);
                              }

                              if (this.jugador.getVidas() <= 0) {
                                 this.cerrando = true;
                                 (new PERDEROGANAR(this.jugador.getPuntos(), this.jugador.getVidas(), this.jugador.getUser(), this.datos, this.fecha, this.horaI)).setVisible(true);
                                 this.loser = true;
                              }

                              ++this.intentos;
                           }
                        } else {
                           this.mapa[i - 1][j] = 0;
                           this.Arriba();
                           this.proteccion = false;
                        }
                     } else if (i > 0 && this.mapa[i - 1][j] == 25) {
                        this.cerrando = true;
                        JOptionPane.showMessageDialog((Component)null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", 1);
                     } else {
                        if (i > 0 && this.mapa[i - 1][j] == 26) {
                           this.cerrando = true;
                           JOptionPane.showMessageDialog((Component)null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", 1);
                           break;
                        }

                        this.Arriba();
                     }
                     break;
                  case 2:
                     if (i < 9 && this.mapa[i + 1][j] >= 5 && this.mapa[i + 1][j] <= 19) {
                        if (!this.proteccion) {
                           int pregunta = this.mapa[i + 1][j] - 5;
                           this.cerrando = true;
                           Desafios desafio = new Desafios((Frame)null, true, ((Pregunta)this.preguntas.get(pregunta)).getPregunta(), ((Pregunta)this.preguntas.get(pregunta)).getCorrecto(), ((Pregunta)this.preguntas.get(pregunta)).getTiempo(), ((Pregunta)this.preguntas.get(pregunta)).getOpciones());
                           desafio.setVisible(true);
                           if (desafio.isAcierto()) {
                              JOptionPane.showMessageDialog((Component)null, "¡Correcto!", "Respuesta", 1);
                              this.mapa[i + 1][j] = 0;
                              this.jugador.sumarPuntos(20);
                              this.Abajo();
                           } else {
                              JOptionPane.showMessageDialog((Component)null, "Incorrecto...", "Respuesta", 0);
                              if (this.intentos % 2 != 0) {
                                 if (this.jugador.getVidas() > 0) {
                                    this.jugador.restarVidas(1);
                                 }
                              } else if (this.jugador.getPuntos() - 10 > 0) {
                                 this.jugador.restarPuntos(10);
                              } else {
                                 this.jugador.setPuntos(0);
                              }

                              if (this.jugador.getVidas() <= 0) {
                                 this.cerrando = true;
                                 (new PERDEROGANAR(this.jugador.getPuntos(), this.jugador.getVidas(), this.jugador.getUser(), this.datos, this.fecha, this.horaI)).setVisible(true);
                                 this.loser = true;
                              }

                              ++this.intentos;
                           }
                        } else {
                           this.mapa[i + 1][j] = 0;
                           this.Abajo();
                           this.proteccion = false;
                        }
                     } else if (i < 9 && this.mapa[i + 1][j] == 25) {
                        this.cerrando = true;
                        JOptionPane.showMessageDialog((Component)null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", 1);
                     } else if (i < 9 && this.mapa[i + 1][j] == 26) {
                        this.cerrando = true;
                        JOptionPane.showMessageDialog((Component)null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", 1);
                     } else {
                        if (i < 9 && this.mapa[i + 1][j] == 27) {
                           this.cerrando = true;
                           (new GANAROPERDER(this.jugador.getPuntos(), this.jugador.getVidas(), this.jugador.getUser(), this.datos, this.fecha, this.horaI)).setVisible(true);
                           this.winner = true;
                           break;
                        }

                        this.Abajo();
                     }
                     break;
                  case 3:
                     if (j > 0 && this.mapa[i][j - 1] >= 5 && this.mapa[i][j - 1] <= 19) {
                        if (!this.proteccion) {
                           int pregunta = this.mapa[i][j - 1] - 5;
                           this.cerrando = true;
                           Desafios desafio = new Desafios((Frame)null, true, ((Pregunta)this.preguntas.get(pregunta)).getPregunta(), ((Pregunta)this.preguntas.get(pregunta)).getCorrecto(), ((Pregunta)this.preguntas.get(pregunta)).getTiempo(), ((Pregunta)this.preguntas.get(pregunta)).getOpciones());
                           desafio.setVisible(true);
                           if (desafio.isAcierto()) {
                              JOptionPane.showMessageDialog((Component)null, "¡Correcto!", "Respuesta", 1);
                              this.mapa[i][j - 1] = 0;
                              this.jugador.sumarPuntos(20);
                              this.Izquierda();
                           } else {
                              JOptionPane.showMessageDialog((Component)null, "Incorrecto...", "Respuesta", 0);
                              if (this.intentos % 2 != 0) {
                                 if (this.jugador.getVidas() > 0) {
                                    this.jugador.restarVidas(1);
                                 }
                              } else if (this.jugador.getPuntos() - 10 > 0) {
                                 this.jugador.restarPuntos(10);
                              } else {
                                 this.jugador.setPuntos(0);
                              }

                              if (this.jugador.getVidas() <= 0) {
                                 this.cerrando = true;
                                 (new PERDEROGANAR(this.jugador.getPuntos(), this.jugador.getVidas(), this.jugador.getUser(), this.datos, this.fecha, this.horaI)).setVisible(true);
                                 this.loser = true;
                              }

                              ++this.intentos;
                           }
                        } else {
                           this.mapa[i][j - 1] = 0;
                           this.Izquierda();
                           this.proteccion = false;
                        }
                     } else {
                        if (j > 0 && this.mapa[i][j - 1] >= 21 && this.mapa[i][j - 1] <= 23) {
                           switch (this.mapa[i][j - 1]) {
                              case 21:
                                 this.proteccion = true;
                                 this.mapa[i][j - 1] = 0;
                                 this.Izquierda();
                                 break label214;
                              case 22:
                                 this.jugador.sumarPuntos(50);
                                 this.mapa[i][j - 1] = 0;
                                 this.Izquierda();
                                 break label214;
                              case 23:
                                 this.jugador.sumarVidas(1);
                                 this.mapa[i][j - 1] = 0;
                                 this.Izquierda();
                              default:
                                 break label214;
                           }
                        }

                        this.Izquierda();
                     }
                     break;
                  case 4:
                     if (j < 9 && this.mapa[i][j + 1] >= 5 && this.mapa[i][j + 1] <= 19) {
                        if (!this.proteccion) {
                           int pregunta = this.mapa[i][j + 1] - 5;
                           this.cerrando = true;
                           Desafios desafio = new Desafios((Frame)null, true, ((Pregunta)this.preguntas.get(pregunta)).getPregunta(), ((Pregunta)this.preguntas.get(pregunta)).getCorrecto(), ((Pregunta)this.preguntas.get(pregunta)).getTiempo(), ((Pregunta)this.preguntas.get(pregunta)).getOpciones());
                           desafio.setVisible(true);
                           if (desafio.isAcierto()) {
                              JOptionPane.showMessageDialog((Component)null, "¡Correcto!", "Respuesta", 1);
                              this.mapa[i][j + 1] = 0;
                              this.jugador.sumarPuntos(20);
                              this.Derecha();
                           } else {
                              JOptionPane.showMessageDialog((Component)null, "Incorrecto...", "Respuesta", 0);
                              if (this.intentos % 2 != 0) {
                                 if (this.jugador.getVidas() > 0) {
                                    this.jugador.restarVidas(1);
                                 }
                              } else if (this.jugador.getPuntos() - 10 > 0) {
                                 this.jugador.restarPuntos(10);
                              } else {
                                 this.jugador.setPuntos(0);
                              }

                              if (this.jugador.getVidas() <= 0) {
                                 this.cerrando = true;
                                 (new PERDEROGANAR(this.jugador.getPuntos(), this.jugador.getVidas(), this.jugador.getUser(), this.datos, this.fecha, this.horaI)).setVisible(true);
                                 this.loser = true;
                              }

                              ++this.intentos;
                           }
                        } else {
                           this.mapa[i][j + 1] = 0;
                           this.Derecha();
                           this.proteccion = false;
                        }
                     } else if (j < 9 && this.mapa[i][j + 1] >= 21 && this.mapa[i][j + 1] <= 23) {
                        switch (this.mapa[i][j + 1]) {
                           case 21:
                              this.proteccion = true;
                              this.mapa[i][j + 1] = 0;
                              this.Derecha();
                              break label214;
                           case 22:
                              this.jugador.sumarPuntos(50);
                              this.mapa[i][j + 1] = 0;
                              this.Derecha();
                              break label214;
                           case 23:
                              this.jugador.sumarVidas(1);
                              this.mapa[i][j + 1] = 0;
                              this.Derecha();
                        }
                     } else {
                        if (j < 9 && this.mapa[i][j + 1] == 27) {
                           this.cerrando = true;
                           (new GANAROPERDER(this.jugador.getPuntos(), this.jugador.getVidas(), this.jugador.getUser(), this.datos, this.fecha, this.horaI)).setVisible(true);
                           this.winner = true;
                           break;
                        }

                        this.Derecha();
                     }
                     break;
                  case 5:
                     if (this.mapa[0][5] != 28) {
                        this.mapa[0][5] = 28;
                        this.mapa[i][j] = 0;
                        System.out.println("------------------------------------");
                        this.MostrarMapa();
                     }
                     break;
                  case 6:
                     if (this.mapa[4][2] != 28) {
                        this.mapa[4][2] = 28;
                        this.mapa[i][j] = 0;
                        System.out.println("------------------------------------");
                        this.MostrarMapa();
                     }
               }

               if (!this.winner) {
                  this.cerrando = false;
               }
            }
         }
      }

   }

   private void Arriba() {
      System.out.println("------------------------------------");

      for(int i = 0; i < 10; ++i) {
         for(int j = 0; j < 10; ++j) {
            if (this.mapa[i][j] == 28 && i - 1 >= 0 && this.mapa[i - 1][j] != 4) {
               this.MapaLab[i][j].removeAll();
               ((Animacion)this.animaciones.get(0)).setImg(this.jugador.getPersonaje().getImagenArribaLab());
               this.MapaLab[i][j].add((Component)this.animaciones.get(0), "Center");
               this.MapaLab[i][j].revalidate();
               this.MapaLab[i][j].repaint();
               
               final int filaActual = i;
               final int colActual = j;
               
               (new Timer(500, (e) -> {
                  int numero = this.mapa[filaActual - 1][colActual];
                  this.mapa[filaActual - 1][colActual] = this.mapa[filaActual][colActual];
                  this.mapa[filaActual][colActual] = numero;

                  this.MostrarMapa();
                  ((Timer)e.getSource()).stop();
               })).start();
               return;
            }
         }
      }

   }

   private void Abajo() {
      System.out.println("------------------------------------");

      for(int i = 0; i < 10; ++i) {
         for(int j = 0; j < 10; ++j) {
            if (this.mapa[i][j] == 28 && i + 1 < 10 && this.mapa[i + 1][j] != 4) {
               this.MapaLab[i][j].removeAll();
               ((Animacion)this.animaciones.get(0)).setImg(this.jugador.getPersonaje().getImagenAbajoLab());
               this.MapaLab[i][j].add((Component)this.animaciones.get(0), "Center");
               this.MapaLab[i][j].revalidate();
               this.MapaLab[i][j].repaint();
               
               final int filaActual = i;
               final int colActual = j;

               (new Timer(500, (e) -> {
                   int numero = this.mapa[filaActual + 1][colActual];
                   this.mapa[filaActual + 1][colActual] = this.mapa[filaActual][colActual];
                   this.mapa[filaActual][colActual] = numero;

                   this.MostrarMapa();
                   ((Timer)e.getSource()).stop();
               })).start();
               return;
            }
         }
      }

   }

   private void Izquierda() {
      System.out.println("------------------------------------");

      for(int i = 0; i < 10; ++i) {
         for(int j = 0; j < 10; ++j) {
            if (this.mapa[i][j] == 28 && j - 1 >= 0 && this.mapa[i][j - 1] != 4) {
               this.MapaLab[i][j].removeAll();
               ((Animacion)this.animaciones.get(0)).setImg(this.jugador.getPersonaje().getImagenIzquierdaLab());
               this.MapaLab[i][j].add((Component)this.animaciones.get(0), "Center");
               this.MapaLab[i][j].revalidate();
               this.MapaLab[i][j].repaint();
               
               final int filaActual = i;
               final int colActual = j;

               (new Timer(500, (e) -> {
                   int numero = this.mapa[filaActual][colActual - 1];
                   this.mapa[filaActual][colActual - 1] = this.mapa[filaActual][colActual];
                   this.mapa[filaActual][colActual] = numero;
                
                   this.MostrarMapa();
                   ((Timer)e.getSource()).stop();
               })).start();
               return;
            }
         }
      }

   }

   private void Derecha() {
      System.out.println("------------------------------------");

      for(int i = 0; i < 10; ++i) {
         for(int j = 0; j < 10; ++j) {
            if (this.mapa[i][j] == 28 && j + 1 < 10 && this.mapa[i][j + 1] != 4) {
               this.MapaLab[i][j].removeAll();
               ((Animacion)this.animaciones.get(0)).setImg(this.jugador.getPersonaje().getImagenDerechaLab());
               this.MapaLab[i][j].add((Component)this.animaciones.get(0), "Center");
               this.MapaLab[i][j].revalidate();
               this.MapaLab[i][j].repaint();
               final int filaActual = i;
               final int colActual = j;

               (new Timer(500, (e) -> {
                   int numero = this.mapa[filaActual][colActual + 1];
                   this.mapa[filaActual][colActual + 1] = this.mapa[filaActual][colActual];
                   this.mapa[filaActual][colActual] = numero;
                
                   this.MostrarMapa();
                   ((Timer)e.getSource()).stop();
               })).start();
               return;
            }
         }
      }

   }

   public void MostrarMapa() {
      for(int i = 0; i < 10; ++i) {
         for(int j = 0; j < 10; ++j) {
            this.MapaLab[i][j].removeAll();
            this.MapaLab[i][j].revalidate();
            this.MapaLab[i][j].repaint();
            this.MapaLab[i][j].setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/caminoHierba.png")));
            if (this.mapa[i][j] == 1) {
               this.MapaLab[i][j].setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/caminoLiso.png")));
            } else if (this.mapa[i][j] == 3) {
               this.MapaLab[i][j].setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/caminoFlores.png")));
            } else if (this.mapa[i][j] == 4) {
               this.MapaLab[i][j].setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/muro.png")));
            } else if (this.mapa[i][j] >= 5 && this.mapa[i][j] < 20) {
               switch (this.mapa[i][j]) {
                  case 5 -> this.MapaLab[i][j].add((Component)this.animaciones.get(1), "Center");
                  case 6 -> this.MapaLab[i][j].add((Component)this.animaciones.get(2), "Center");
                  case 7 -> this.MapaLab[i][j].add((Component)this.animaciones.get(3), "Center");
                  case 8 -> this.MapaLab[i][j].add((Component)this.animaciones.get(4), "Center");
                  case 9 -> this.MapaLab[i][j].add((Component)this.animaciones.get(5), "Center");
                  case 10 -> this.MapaLab[i][j].add((Component)this.animaciones.get(6), "Center");
                  case 11 -> this.MapaLab[i][j].add((Component)this.animaciones.get(7), "Center");
                  case 12 -> this.MapaLab[i][j].add((Component)this.animaciones.get(8), "Center");
                  case 13 -> this.MapaLab[i][j].add((Component)this.animaciones.get(9), "Center");
                  case 14 -> this.MapaLab[i][j].add((Component)this.animaciones.get(10), "Center");
                  case 15 -> this.MapaLab[i][j].add((Component)this.animaciones.get(11), "Center");
                  case 16 -> this.MapaLab[i][j].add((Component)this.animaciones.get(12), "Center");
                  case 17 -> this.MapaLab[i][j].add((Component)this.animaciones.get(13), "Center");
                  case 18 -> this.MapaLab[i][j].add((Component)this.animaciones.get(14), "Center");
                  case 19 -> this.MapaLab[i][j].add((Component)this.animaciones.get(15), "Center");
               }
            } else if (this.mapa[i][j] >= 21 && this.mapa[i][j] < 24) {
               switch (this.mapa[i][j]) {
                  case 21 -> this.MapaLab[i][j].add((Component)this.animaciones.get(16), "Center");
                  case 22 -> this.MapaLab[i][j].add((Component)this.animaciones.get(17), "Center");
                  case 23 -> this.MapaLab[i][j].add((Component)this.animaciones.get(18), "Center");
               }
            } else if (this.mapa[i][j] == 25) {
               this.MapaLab[i][j].add((Component)this.animaciones.get(19), "Center");
            } else if (this.mapa[i][j] == 26) {
               this.MapaLab[i][j].add((Component)this.animaciones.get(20), "Center");
            } else if (this.mapa[i][j] == 27) {
               this.MapaLab[i][j].setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/Meta.png")));
            } else if (this.mapa[i][j] == 28) {
               this.MapaLab[i][j].add((Component)this.animaciones.get(0), "Center");
            }

            System.out.print(this.mapa[i][j] + " ");
         }

         System.out.println("");
      }

   }

   private int idPreguntas() {
      boolean bandera = false;

      int numero;
      do {
         numero = (int)(Math.random() * (double)15.0F) + 5;
         bandera = false;

         for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j) {
               if (numero == this.mapa[i][j]) {
                  bandera = true;
                  break;
               }
            }

            if (bandera) {
               break;
            }
         }
      } while(bandera);

      return numero;
   }

   private int idPowerUp() {
      boolean bandera = false;

      int numero;
      do {
         numero = (int)(Math.random() * (double)3.0F) + 21;
         bandera = false;

         for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j) {
               if (numero == this.mapa[i][j]) {
                  bandera = true;
                  break;
               }
            }

            if (bandera) {
               break;
            }
         }
      } while(bandera);

      return numero;
   }
}
