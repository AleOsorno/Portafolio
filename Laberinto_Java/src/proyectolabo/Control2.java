/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectolabo;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author alexo
 */
public class Control2 {
    private int[][] mapa;
    private JButton[][] MapaLab;
    private Jugador jugador;
    private int intentos = 0;
    private boolean proteccion = false;
    private boolean winner = false;
    private boolean loser = false;
    private ArrayList<Animacion> animaciones = new ArrayList<>();
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    private Datos datos;
    private String fecha;
    private String horaI;
    private boolean cerrando;

    public Control2(JButton[][] MapaLab, Jugador jugador, Datos datos, String fecha, String horaI) {
        this.MapaLab = MapaLab;
        this.jugador = jugador;
        this.datos = datos;
        this.fecha = fecha;
        this.horaI = horaI;
        this.cerrando = false;
        
        this.preguntas.add(new Pregunta(5, "<html>¿Qué suceso marcó el inicio de la <br>guerra de la independencia?</html>", 2, 30,
            new String[]{"La firma de la constitución", "Las leyes de la reforma", "El grito de Dolores", "La caída de Teotihuacán"}));

        this.preguntas.add(new Pregunta(6, "<html>¿Cuántos elementos se han descubierto en la Tierra?</html>", 0, 30,
            new String[]{"118", "119", "117", "116"}));

        this.preguntas.add(new Pregunta(7, "<html>Si estás corriendo y pasas al corredor que va en segundo lugar,<br> ¿en qué posición estás ahora?</html>", 2, 20,
            new String[]{"Cuarto lugar", "Tercer lugar", "Segundo lugar", "Primer lugar"}));

        this.preguntas.add(new Pregunta(8, "<html>Si + significa ÷, ÷ significa –, – significa x <br>y x significa +, entonces: 9 + 3 ÷ 5 – 3 x 7 = ?</html>", 3, 40,
            new String[]{"5", "15", "25", "Ninguno de estos"}));

        this.preguntas.add(new Pregunta(9, "<html>Ordena el siguiente código: <br>1. for(int i = 0;i < numeros.lenght; i++)<br>2.System.out.println(numeros[i]);<br>3. numeros[i] = (int)(Math.random()*30)+1;<br>4. int[] numeros = new int[15]</html>", 1, 45,
            new String[]{"4, 1, 2, 3", "4, 1, 3, 2", "1, 4, 3, 2", "4, 3, 1, 2"}));

        this.preguntas.add(new Pregunta(10, "<html>¿Cuál es la instrucción fundamental en programación<br> que permite tomar decisiones basadas en una condición (en inglés)?</html>", 2, 20,
            new String[]{"While", "For", "If", "Switch"}));

        this.preguntas.add(new Pregunta(11, "<html>¿Cuál es el valor de π (pi) con sus<br> dos primeros decimales?</html>", 2, 20,
            new String[]{"3.13", "3.12", "3.14", "3.15"}));

        this.preguntas.add(new Pregunta(12, "<html>¿Quién fue el primer presidente de los<br> Estados Unidos Mexicanos?</html>", 1, 30,
            new String[]{"Benito Juárez", "Guadalupe Victoria", "Miguel Hidalgo", "Agustín de Iturbide"}));

        this.preguntas.add(new Pregunta(13, "<html>¿Qué tipo de razonamiento va de<br> lo general a lo particular?</html>", 0, 20,
            new String[]{"Deductivo", "Inductivo", "Analítico", "Sintético"}));

        this.preguntas.add(new Pregunta(14, "<html>¿Cuál es el proceso por el cual las plantas<br> convierten la luz solar en energía química?</html>", 0, 25,
            new String[]{"Fotosíntesis", "Respiración", "Fermentación", "Germinación"}));

        this.preguntas.add(new Pregunta(15, "<html>Si un numero al cuadrado menos el doble<br> de sí mismo da 35, ¿cuál es el número?</html>", 1, 30,
            new String[]{"5 y -7", "7 y -5", "6 y -6", "8 y -4"}));

        this.preguntas.add(new Pregunta(16, "<html>Hay un número. Si lo multiplicas por 4 y luego le sumas 6, obtienes el mismo<br> resultado que si lo multiplicas por 5 y le restas 4. ¿Qué número es?</html>", 3, 30,
            new String[]{"6", "8", "12", "10"}));

        this.preguntas.add(new Pregunta(17, "<html>¿Cuál de los siguientes elementos es un gas noble?</html>", 1, 20,
            new String[]{"Nitrógeno", "Helio", "Oxígeno", "Hidrógeno"}));

        this.preguntas.add(new Pregunta(18, "<html>¿Cuál es el resultado del siguiente algoritmo? <br> entero resultado = 1 <br>para i = 2 hasta 4 hacer<br>  resultado = resultado * i<br>escribir(resultado)</html>", 3, 40,
            new String[]{"6", "12", "20", "24"}));

        this.preguntas.add(new Pregunta(19, "<html>¿Cuál de los siguientes tratados puso <br>oficialmente fin a la Primera Guerra Mundial?</html>", 1, 30,
            new String[]{"Tratado de París", "Tratado de Versalles", "Tratado de Tordesillas", "Tratado de Utrecht"}));
        
        this.animaciones.add(new Animacion(jugador.getPersonaje().getImagenAbajoLab2(),33,60,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon1_Lastimado.png",20,60,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon2_Pose.png",30,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon3_Cringe.png",30,60,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon4_Idle.png",40,60,5));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon5_Charge.png",27,60,10));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon6_Charge.png",30,60,10));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon7_Shoot.png",38,60,17));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon8_Sleep.png",25,60,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon9_Eat.png",35,60,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon10_Pull.png",34,60,7));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon11_Shock.png",37,60,13));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon12_Eat.png",42,60,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon13_RearUp.png",42,60,11));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon14_Sleep.png",20,60,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Pokemon15_Idle.png",32,60,6));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Escudo.png",24,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Escudo.png",24,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/PuntosExtra.png",38,60,8));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/PuntosExtra.png",38,60,8));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Cura.png",41,60,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Cura.png",41,60,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Informacion.png",48,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Informacion.png",48,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Informacion.png",48,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen2/Informacion.png",48,60,3));
        
        this.mapa = new int[20][20];
            
            this.mapa = new int[][]{
                {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
                {4,28, 4, 1, 3, 1, 1, 3, 1, 1, 4, 0, 1, 1, 1, 4, 3, 1, 1, 4},
                {4, 1, 4, 4, 4, 3, 4, 4, 4, 1, 4, 4, 4, 3, 4, 4, 1, 4, 1, 4},
                {4, 1, 3, 1, 1, 1, 4, 0, 4, 1, 3, 0, 4, 1, 1, 0, 1, 4, 1, 4},
                {4, 4, 4, 0, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 3, 4},
                {4, 1, 3, 1, 4, 3, 1, 1, 1, 1, 4, 3, 1, 1, 4, 4, 1, 1, 1, 4},
                {4, 1, 4, 4, 4, 3, 4, 1, 3, 1, 4, 1, 1, 1, 4, 0, 1, 0, 4, 4},
                {4, 1, 3, 1, 4, 0, 4, 1, 4, 1, 0, 1, 4, 3, 1, 1, 4, 1, 4, 4},
                {4, 4, 4, 3, 4, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 1, 1, 3, 4, 4},
                {4, 1, 4, 1, 4, 1, 3, 1, 4, 4,27, 1, 1, 0, 1, 1, 4, 4, 4, 4},
                {4, 3, 4, 1, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 4, 3, 4, 0, 0, 4},
                {4, 1, 4, 3, 1, 0, 4, 1, 1, 1, 1, 1, 3, 1, 1, 1, 4, 1, 1, 4},
                {4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 1, 4},
                {4, 1, 3, 1, 0, 1, 1, 1, 1, 4, 3, 1, 1, 1, 3, 1, 4, 1, 1, 4},
                {4, 4, 4, 4, 4, 1, 4, 4, 1, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 4},
                {4, 1, 1, 1, 3, 1, 4, 0, 3, 4, 0, 1, 1, 1, 4, 4, 4, 4, 3, 4},
                {4, 1, 4, 1, 4, 1, 4, 4, 4, 4, 4, 4, 1, 1, 3, 1, 4, 4, 1, 4},
                {4, 1, 4, 3, 4, 4, 4, 1, 0, 1, 1, 4, 4, 1, 4, 1, 0, 1, 1, 4},
                {4, 0, 4, 1, 1, 3, 1, 1, 0, 3, 1, 1, 1, 1, 4, 1, 0, 3, 1, 4},
                {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
            };
            
            mapa[3][15] = idPreguntas();
            mapa[4][3] = idPreguntas();
            mapa[4][7] = idPreguntas();
            mapa[6][15] = idPreguntas();
            mapa[6][17] = idPreguntas();
            mapa[7][10] = idPreguntas();
            mapa[9][2] = idPreguntas();
            mapa[9][13] = idPreguntas();
            mapa[10][7] = idPreguntas();
            mapa[11][12] = idPreguntas();
            mapa[13][4] = idPreguntas();
            mapa[17][8] = idPreguntas();
            mapa[17][16] = idPreguntas();
            mapa[18][8] = idPreguntas();
            mapa[18][16] = idPreguntas();
            mapa[3][7] = idPowerUp();
            mapa[3][11] = idPowerUp();
            mapa[7][5] = idPowerUp();
            mapa[10][18] = idPowerUp();
            mapa[11][5] = idPowerUp();
            mapa[15][7] = idPowerUp();
            mapa[18][1] = 29;
            mapa[15][10] = 31;
            mapa[10][17] = 30;
            mapa[1][11] = 32;
    }

    public int[][] getMapa() {
        return mapa;
    }
    
    public boolean isCerrando() {
        return cerrando;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }
    
    public void MostrarMapa(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                
                MapaLab[i][j].removeAll();
                MapaLab[i][j].revalidate();
                MapaLab[i][j].repaint();
                
                MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen2/caminoHierba.png")));
                
                if(mapa[i][j] == 1){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen2/caminoLiso.png")));
                }else if(mapa[i][j] == 3){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen2/caminoFlores.png")));
                }else if(mapa[i][j] == 4){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen2/muro.png")));
                }else if(mapa[i][j] >= 5 && mapa[i][j] < 20){
                    switch(mapa[i][j]) {
                        case 5:
                            MapaLab[i][j].add(animaciones.get(1), BorderLayout.CENTER);
                            break;
                        case 6:
                            MapaLab[i][j].add(animaciones.get(2), BorderLayout.CENTER);
                            break;
                        case 7:
                            MapaLab[i][j].add(animaciones.get(3), BorderLayout.CENTER);
                            break;
                        case 8:
                            MapaLab[i][j].add(animaciones.get(4), BorderLayout.CENTER);
                            break;
                        case 9:
                            MapaLab[i][j].add(animaciones.get(5), BorderLayout.CENTER);
                            break;
                        case 10:
                            MapaLab[i][j].add(animaciones.get(6), BorderLayout.CENTER);
                            break;
                        case 11:
                            MapaLab[i][j].add(animaciones.get(7), BorderLayout.CENTER);
                            break;
                        case 12:
                            MapaLab[i][j].add(animaciones.get(8), BorderLayout.CENTER);
                            break;
                        case 13:
                            MapaLab[i][j].add(animaciones.get(9), BorderLayout.CENTER);
                            break;
                        case 14:
                            MapaLab[i][j].add(animaciones.get(10), BorderLayout.CENTER);
                            break;
                        case 15:
                            MapaLab[i][j].add(animaciones.get(11), BorderLayout.CENTER);
                            break;
                        case 16:
                            MapaLab[i][j].add(animaciones.get(12), BorderLayout.CENTER);
                            break;
                        case 17:
                            MapaLab[i][j].add(animaciones.get(13), BorderLayout.CENTER);
                            break;
                        case 18:
                            MapaLab[i][j].add(animaciones.get(14), BorderLayout.CENTER);
                            break;
                        case 19:
                            MapaLab[i][j].add(animaciones.get(15), BorderLayout.CENTER);
                            break;
                    }
                }else if(mapa[i][j] >= 21 && mapa[i][j] < 27){
                    switch(mapa[i][j]) {
                        case 21:
                            MapaLab[i][j].add(animaciones.get(16), BorderLayout.CENTER);
                            break;
                        case 22:
                            MapaLab[i][j].add(animaciones.get(17), BorderLayout.CENTER);
                            break;
                        case 23:
                            MapaLab[i][j].add(animaciones.get(18), BorderLayout.CENTER);
                            break;
                        case 24:
                            MapaLab[i][j].add(animaciones.get(19), BorderLayout.CENTER);
                            break;
                        case 25:
                            MapaLab[i][j].add(animaciones.get(20), BorderLayout.CENTER);
                            break;
                        case 26:
                            MapaLab[i][j].add(animaciones.get(21), BorderLayout.CENTER);
                            break;
                    }
                }else if(mapa[i][j] == 29){
                    MapaLab[i][j].add(animaciones.get(22), BorderLayout.CENTER);
                }else if(mapa[i][j] == 30){
                    MapaLab[i][j].add(animaciones.get(23), BorderLayout.CENTER);
                }else if(mapa[i][j] == 31){
                    MapaLab[i][j].add(animaciones.get(24), BorderLayout.CENTER);
                }else if(mapa[i][j] == 32){
                    MapaLab[i][j].add(animaciones.get(25), BorderLayout.CENTER);
                }else if(mapa[i][j] == 27){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen2/Meta.png")));
                }else if(mapa[i][j] == 28){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen2/PIEDRA-removebg-preview.png")));
                    MapaLab[i][j].add(animaciones.get(0), BorderLayout.CENTER);
                }
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public boolean isWinner() {
        return winner;
    }

    public boolean isLoser() {
        return loser;
    }
    
    public void validarMovimiento(int movimiento){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if(mapa[i][j] == 28){
                    switch(movimiento){
                        case 1:
                            if(i > 0 && mapa[i-1][j] >= 5 && mapa[i-1][j] <= 19){
                                
                                if(proteccion != true){
                                    int pregunta = mapa[i-1][j] - 5;
                                    this.cerrando = true;
                                    Desafios desafio = new Desafios(
                                        null,
                                        true,
                                        this.preguntas.get(pregunta).getPregunta(),
                                        this.preguntas.get(pregunta).getCorrecto(),
                                        this.preguntas.get(pregunta).getTiempo(),
                                        this.preguntas.get(pregunta).getOpciones()
                                    );

                                    desafio.setVisible(true);

                                    if (desafio.isAcierto()) {
                                        JOptionPane.showMessageDialog(null, "¡Correcto!", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
                                        mapa[i-1][j] = 0;
                                        jugador.sumarPuntos(20);
                                        Arriba();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Incorrecto...", "Respuesta", JOptionPane.ERROR_MESSAGE);

                                        if(intentos % 2 != 0){
                                            if(jugador.getVidas() > 0){
                                               jugador.restarVidas(1); 
                                            }
                                        }else{
                                            if(jugador.getPuntos() - 10 > 0){
                                               jugador.restarPuntos(10); 
                                            }else{
                                                jugador.setPuntos(0);
                                            }
                                        }
                                        
                                        if (jugador.getVidas() <= 0) {
                                            this.cerrando = true;
                                            new PERDEROGANAR(jugador.getPuntos(), jugador.getVidas(), jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                            loser = true;
                                        }
                                        
                                        intentos++;
                                    }
                                }else{
                                    mapa[i-1][j] = 0;
                                    Arriba();
                                    proteccion = false;
                                }
                            }else if(i > 0 && mapa[i-1][j] == 29){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i > 0 && mapa[i-1][j] == 30){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i > 0 && mapa[i-1][j] == 31){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Soy tu primer hechizo en batalla, el truco básico que desatas; sin mí tu barra de habilidades quedaría vacía. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i > 0 && mapa[i-1][j] == 32){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Cuando el chat silencioso apaga tu voz, me presionas y todo el equipo te escucha con ‘push to talk’. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i > 0 && mapa[i-1][j] >= 21 && mapa[i-1][j] <= 26){
                                switch(mapa[i-1][j]){
                                    case 21:
                                        this.proteccion = true;
                                        mapa[i-1][j] = 0;
                                        Arriba();
                                        break;
                                    case 22:
                                        this.proteccion = true;
                                        mapa[i-1][j] = 0;
                                        Arriba();
                                        break;
                                    case 23:
                                        jugador.sumarPuntos(50);
                                        mapa[i-1][j] = 0;
                                        Arriba();
                                        break;
                                    case 24:
                                        jugador.sumarPuntos(50);
                                        mapa[i-1][j] = 0;
                                        Arriba();
                                        break;
                                    case 25:
                                        jugador.sumarVidas(1);
                                        mapa[i-1][j] = 0;
                                        Arriba();
                                        break;
                                    case 26:
                                        jugador.sumarVidas(1);
                                        mapa[i-1][j] = 0;
                                        Arriba();
                                        break;
                                }
                            }else{
                                Arriba();
                            }
                            break;
                        case 2:
                            if(i < 19 && mapa[i+1][j] >= 5 && mapa[i+1][j] <= 19){
                                
                                if(proteccion != true){
                                    int pregunta = mapa[i+1][j] - 5;
                                    this.cerrando = true;
                                    Desafios desafio = new Desafios(
                                        null,
                                        true,
                                        this.preguntas.get(pregunta).getPregunta(),
                                        this.preguntas.get(pregunta).getCorrecto(),
                                        this.preguntas.get(pregunta).getTiempo(),
                                        this.preguntas.get(pregunta).getOpciones()
                                    );

                                    desafio.setVisible(true);

                                    if (desafio.isAcierto()) {
                                        JOptionPane.showMessageDialog(null, "¡Correcto!", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
                                        mapa[i+1][j] = 0;
                                        jugador.sumarPuntos(20);
                                        Abajo();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Incorrecto...", "Respuesta", JOptionPane.ERROR_MESSAGE);

                                        if(intentos % 2 != 0){
                                            if(jugador.getVidas() > 0){
                                               jugador.restarVidas(1); 
                                            }
                                        }else{
                                            if(jugador.getPuntos() - 10 > 0){
                                               jugador.restarPuntos(10); 
                                            }else{
                                                jugador.setPuntos(0);
                                            }
                                        }
                                        
                                        if (jugador.getVidas() <= 0) {
                                            this.cerrando = true;
                                            new PERDEROGANAR(jugador.getPuntos(), jugador.getVidas(), jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                            loser = true;
                                        }
                                        
                                        intentos++;
                                    }
                                }else{
                                    mapa[i+1][j] = 0;
                                    Abajo();
                                    proteccion = false;
                                }
                            }else if(i < 19 && mapa[i+1][j] == 29){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i < 19 && mapa[i+1][j] == 30){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i < 19 && mapa[i+1][j] == 31){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Soy tu primer hechizo en batalla, el truco básico que desatas; sin mí tu barra de habilidades quedaría vacía. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i < 19 && mapa[i+1][j] == 32){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Cuando el chat silencioso apaga tu voz, me presionas y todo el equipo te escucha con ‘push to talk’. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i < 19 && mapa[i+1][j] >= 21 && mapa[i+1][j] <= 26){
                                switch(mapa[i+1][j]){
                                    case 21:
                                        this.proteccion = true;
                                        mapa[i+1][j] = 0;
                                        Abajo();
                                        break;
                                    case 22:
                                        this.proteccion = true;
                                        mapa[i+1][j] = 0;
                                        Abajo();
                                        break;
                                    case 23:
                                        jugador.sumarPuntos(50);
                                        mapa[i+1][j] = 0;
                                        Abajo();
                                        break;
                                    case 24:
                                        jugador.sumarPuntos(50);
                                        mapa[i+1][j] = 0;
                                        Abajo();
                                        break;
                                    case 25:
                                        jugador.sumarVidas(1);
                                        mapa[i+1][j] = 0;
                                        Abajo();
                                        break;
                                    case 26:
                                        jugador.sumarVidas(1);
                                        mapa[i+1][j] = 0;
                                        Abajo();
                                        break;
                                }
                            }else{
                                Abajo();
                            }
                            break;
                        case 3:
                            if(j > 0 && mapa[i][j-1] >= 5 && mapa[i][j-1] <= 19){
                                
                                if(proteccion != true){
                                    int pregunta = mapa[i][j-1] - 5;
                                    this.cerrando = true;
                                    Desafios desafio = new Desafios(
                                        null,
                                        true,
                                        this.preguntas.get(pregunta).getPregunta(),
                                        this.preguntas.get(pregunta).getCorrecto(),
                                        this.preguntas.get(pregunta).getTiempo(),
                                        this.preguntas.get(pregunta).getOpciones()
                                    );

                                    desafio.setVisible(true);

                                    if (desafio.isAcierto()) {
                                        JOptionPane.showMessageDialog(null, "¡Correcto!", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
                                        mapa[i][j-1] = 0;
                                        jugador.sumarPuntos(20);
                                        Izquierda();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Incorrecto...", "Respuesta", JOptionPane.ERROR_MESSAGE);

                                        if(intentos % 2 != 0){
                                            if(jugador.getVidas() > 0){
                                               jugador.restarVidas(1); 
                                            }
                                        }else{
                                            if(jugador.getPuntos() - 10 > 0){
                                               jugador.restarPuntos(10); 
                                            }else{
                                                jugador.setPuntos(0);
                                            }
                                        }
                                        
                                        if (jugador.getVidas() <= 0) {
                                            this.cerrando = true;
                                            new PERDEROGANAR(jugador.getPuntos(), jugador.getVidas(), jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                            loser = true;
                                        }
                                        
                                        intentos++;
                                    }
                                }else{
                                   mapa[i][j-1] = 0;
                                   Izquierda();
                                   proteccion = false; 
                                }
                            }else if(j > 0 && mapa[i][j-1] == 29){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j > 0 && mapa[i][j-1] == 30){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j > 0 && mapa[i][j-1] == 31){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "Soy tu primer hechizo en batalla, el truco básico que desatas; sin mí tu barra de habilidades quedaría vacía. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j > 0 && mapa[i][j-1] == 32){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "Cuando el chat silencioso apaga tu voz, me presionas y todo el equipo te escucha con ‘push to talk’. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j > 0 && mapa[i][j-1] >= 21 && mapa[i][j-1] <= 26){
                                switch(mapa[i][j-1]){
                                    case 21:
                                        this.proteccion = true;
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 22:
                                        this.proteccion = true;
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 23:
                                        jugador.sumarPuntos(50);
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 24:
                                        jugador.sumarPuntos(50);
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 25:
                                        jugador.sumarVidas(1);
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 26:
                                        jugador.sumarVidas(1);
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                }
                            }else if(j > 0 && mapa[i][j-1] == 27){
                                this.cerrando = true;
                                new GANAROPERDER(jugador.getPuntos(),jugador.getVidas(),jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                winner = true;
                            }else{
                                Izquierda();
                            }
                            break;
                        case 4:
                            if(j < 19 && mapa[i][j+1] >= 5 && mapa[i][j+1] <= 19){
                                
                                if(proteccion != true){
                                    int pregunta = mapa[i][j+1] - 5;
                                    this.cerrando = true;
                                    Desafios desafio = new Desafios(
                                        null,
                                        true,
                                        this.preguntas.get(pregunta).getPregunta(),
                                        this.preguntas.get(pregunta).getCorrecto(),
                                        this.preguntas.get(pregunta).getTiempo(),
                                        this.preguntas.get(pregunta).getOpciones()
                                    );

                                    desafio.setVisible(true);

                                    if (desafio.isAcierto()) {
                                        JOptionPane.showMessageDialog(null, "¡Correcto!", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
                                        mapa[i][j+1] = 0;
                                        jugador.sumarPuntos(20);
                                        Derecha();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Incorrecto...", "Respuesta", JOptionPane.ERROR_MESSAGE);

                                        if(intentos % 2 != 0){
                                            if(jugador.getVidas() > 0){
                                               jugador.restarVidas(1); 
                                            }
                                        }else{
                                            if(jugador.getPuntos() - 10 > 0){
                                               jugador.restarPuntos(10); 
                                            }else{
                                                jugador.setPuntos(0);
                                            }
                                        }
                                        
                                        if (jugador.getVidas() <= 0) {
                                            this.cerrando = true;
                                            new PERDEROGANAR(jugador.getPuntos(), jugador.getVidas(), jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                            loser = true;
                                        }
                                        
                                        intentos++;
                                    }
                                }else{
                                   mapa[i][j+1] = 0;
                                   Derecha();
                                   proteccion = false; 
                                }
                            }else if(j < 19 && mapa[i][j-1] == 29){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j < 19 && mapa[i][j+1] == 30){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j < 19 && mapa[i][j+1] == 31){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "Soy tu primer hechizo en batalla, el truco básico que desatas; sin mí tu barra de habilidades quedaría vacía. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j < 19 && mapa[i][j+1] == 32){
                                this.cerrando = true;
                                    JOptionPane.showMessageDialog(null, "Cuando el chat silencioso apaga tu voz, me presionas y todo el equipo te escucha con ‘push to talk’. ¿Qué tecla soy?", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                                }else if(j < 19 && mapa[i][j+1] >= 21 && mapa[i][j+1] <= 26){
                                switch(mapa[i][j+1]){
                                    case 21:
                                        this.proteccion = true;
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 22:
                                        this.proteccion = true;
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 23:
                                        jugador.sumarPuntos(50);
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 24:
                                        jugador.sumarPuntos(50);
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 25:
                                        jugador.sumarVidas(1);
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 26:
                                        jugador.sumarVidas(1);
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                }
                            }else if(j < 19 && mapa[i][j+1] == 27){
                                this.cerrando = true;
                                new GANAROPERDER(jugador.getPuntos(),jugador.getVidas(),jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                winner = true;
                            }else{
                               Derecha();
                            }
                            break;
                        case 5:
                            
                            if(mapa[18][10] != 28){
                               mapa[18][10] = 28;
                                mapa[i][j] = 0;
                                System.out.println("------------------------------------");
                                MostrarMapa(); 
                            }
                            break;
                        case 6:
                            
                            if(mapa[18][6] != 28){
                                mapa[18][6] = 28;
                                mapa[i][j] = 0;
                                System.out.println("------------------------------------");
                                MostrarMapa();
                            }
                            break;
                        case 7:
                            
                            if(mapa[1][17] != 28){
                                mapa[1][17] = 28;
                                mapa[i][j] = 0;
                                System.out.println("------------------------------------");
                                MostrarMapa();
                            }
                            break;
                        case 8:
                            
                            if(mapa[9][5] != 28){
                                mapa[9][5] = 28;
                                mapa[i][j] = 0;
                                System.out.println("------------------------------------");
                                MostrarMapa();
                            }
                            break;
                    }
                    if(!winner){
                        this.cerrando = false;
                    }
                }
            }
        }
    }
    
    private void Arriba(){
        System.out.println("------------------------------------");
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(mapa[i][j] == 28 && i-1 >= 0 && mapa[i-1][j] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenArribaLab2());
                        MapaLab[i][j].add(animaciones.get(0), BorderLayout.CENTER);
                        MapaLab[i][j].revalidate();
                        MapaLab[i][j].repaint();

                        int k = i;
                        int l = j;

                        new javax.swing.Timer(500, e -> {
                            int numero = mapa[k-1][l];
                            mapa[k-1][l] = mapa[k][l];
                            mapa[k][l] = numero;

                            MostrarMapa();
                            ((javax.swing.Timer)e.getSource()).stop();
                        }).start();

                        return;
                    }
                }
            }
        
    }
    
    private void Abajo(){
        System.out.println("------------------------------------");
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(mapa[i][j] == 28 && i+1 < 20 && mapa[i+1][j] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenAbajoLab2());
                        MapaLab[i][j].add(animaciones.get(0), BorderLayout.CENTER);
                        MapaLab[i][j].revalidate();
                        MapaLab[i][j].repaint();

                        int k = i;
                        int l = j;

                        new javax.swing.Timer(500, e -> {
                            int numero = mapa[k+1][l];
                            mapa[k+1][l] = mapa[k][l];
                            mapa[k][l] = numero;

                            MostrarMapa();
                            ((javax.swing.Timer)e.getSource()).stop();
                        }).start();

                        return;
                    }
                }
            }
        
    }
    
    private void Izquierda(){
        System.out.println("------------------------------------");
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(mapa[i][j] == 28 && j-1 >= 0 && mapa[i][j-1] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenIzquierdaLab2());
                        MapaLab[i][j].add(animaciones.get(0), BorderLayout.CENTER);
                        MapaLab[i][j].revalidate();
                        MapaLab[i][j].repaint();

                        int k = i;
                        int l = j;

                        new javax.swing.Timer(500, e -> {
                            int numero = mapa[k][l-1];
                            mapa[k][l-1] = mapa[k][l];
                            mapa[k][l] = numero;

                            MostrarMapa();
                            ((javax.swing.Timer)e.getSource()).stop();
                        }).start();

                        return;
                    }
                }
            }
    }
    
    private void Derecha(){
        System.out.println("------------------------------------");
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(mapa[i][j] == 28 && j+1 < 20 && mapa[i][j+1] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenDerechaLab2());
                        MapaLab[i][j].add(animaciones.get(0), BorderLayout.CENTER);
                        MapaLab[i][j].revalidate();
                        MapaLab[i][j].repaint();

                        int k = i;
                        int l = j;

                        new javax.swing.Timer(500, e -> {
                            int numero = mapa[k][l+1];
                            mapa[k][l+1] = mapa[k][l];
                            mapa[k][l] = numero;

                            MostrarMapa();
                            ((javax.swing.Timer)e.getSource()).stop();
                        }).start();

                        return;
                    }
                }
            }
    }
    
    private int idPreguntas(){
        int numero;
        boolean bandera = false;
        
        do{
            numero = (int)(Math.random()*15)+5;
            bandera = false;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(numero == mapa[i][j]){
                        bandera = true;
                        break;
                    }
                }
                if(bandera){
                    break;
                }
            }
        }while(bandera);
        
        return numero;
    }
    
    private int idPowerUp(){
        int numero;
        boolean bandera = false;
        
        do{
            numero = (int)(Math.random()*6)+ 21;
            bandera = false;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(numero == mapa[i][j]){
                        bandera = true;
                        break;
                    }
                }
                if(bandera){
                    break;
                }
            }
        }while(bandera);
        
        return numero;
    }
}
