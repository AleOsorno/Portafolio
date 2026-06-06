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
public class Control {
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

    public Control(JButton[][] MapaLab, Jugador jugador, Datos datos, String fecha, String horaI) {
        this.MapaLab = MapaLab;//inicializamos los datos
        this.jugador = jugador;
        this.datos = datos;
        this.fecha = fecha;
        this.horaI = horaI;
        this.cerrando = false;
        
        this.preguntas.add(new Pregunta(5, "<html>¿Qué suceso marcó el inicio de la <br>guerra de la independencia?</html>", 2, 30,//creamos y guardamos los desafios de nuestro mapa
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
            
            this.animaciones.add(new Animacion(jugador.getPersonaje().getImagenAbajoLab(),85,75,4));//creamos y guardamos las animaciones de nuestro mapa
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon1_Lastimado.png",40,60,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon2_Pose.png",40,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon3_Cringe.png",40,60,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon4_Idle.png",64,75,5));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon5_Charge.png",52,75,10));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon6_Charge.png",52,65,10));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon7_Shoot.png",60,75,17));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon8_Sleep.png",40,75,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon9_Eat.png",55,70,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon10_Pull.png",46,75,7));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon11_Shock.png",65,60,13));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon12_Eat.png",88,75,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon13_RearUp.png",65,75,11));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon14_Sleep.png",45,75,2));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Pokemon15_Idle.png",53,65,6));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Escudo.png",40,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/PuntosExtra.png",60,60,8));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Cura.png",60,60,4));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Informacion.png",95,60,3));
            this.animaciones.add(new Animacion("/proyectolabo/LaberintoImagen/Informacion.png",95,60,3));
            
            this.mapa = new int[10][10];//creamos la estructura del mapa
            
            this.mapa = new int[][] {
                {  1,  3,  1,  0, 1, 3, 1, 4,0,3 },
                {  0, 4, 4, 4, 4, 0, 0, 4, 4,0 },
                {  1, 4, 4, 4, 3, 1, 1, 3, 4, 1 },
                {  3, 4, 25, 4, 1, 4, 4, 4, 4, 3 },
                {  1, 4, 3, 4, 1, 0, 1, 3, 1, 1 },
                {  0, 4, 3,0, 4, 4,0, 4, 4, 4 },
                {  1, 4,0, 4, 3, 1, 1, 3, 1, 1 },
                {  28, 3, 1, 4, 0, 4, 4, 4, 4,0 },
                {  4, 4, 4, 4, 1, 0, 3, 1, 4, 3 },
                {  0, 1, 3, 0, 1, 0, 3, 27, 4, 26 }
            };
            
            mapa[0][3] = idPreguntas();
            mapa[1][0] = idPreguntas();
            mapa[1][5] = idPreguntas();
            mapa[1][6] = idPreguntas();
            mapa[1][9] = idPreguntas();
            mapa[4][5] = idPreguntas();
            mapa[5][0] = idPreguntas();
            mapa[5][6] = idPreguntas();
            mapa[6][2] = idPreguntas();
            mapa[7][4] = idPreguntas();
            mapa[7][9] = idPreguntas();
            mapa[8][5] = idPreguntas();
            mapa[9][3] = idPreguntas();
            mapa[9][5] = idPreguntas();
            mapa[0][8] = idPowerUp();
            mapa[5][3] = idPowerUp();
            mapa[9][0] = idPowerUp();
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
    
    public boolean isWinner() {
        return winner;
    }

    public boolean isLoser() {
        return loser;
    }
    
    public void validarMovimiento(int movimiento){//método que permite saber si el personaje puede moverse a cierta direccion
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(mapa[i][j] == 28){
                    switch(movimiento){
                        case 1://moverse hacia arriba
                            if(i > 0 && mapa[i-1][j] >= 5 && mapa[i-1][j] <= 19){//valida si hay o no un desafio
                                
                                if(proteccion != true){//valida si hay un escudo o no
                                    int pregunta = mapa[i-1][j] - 5;
                                    this.cerrando = true;
                                    Desafios desafio = new Desafios(//creamos el JDialog del desafios
                                        null,
                                        true,
                                        this.preguntas.get(pregunta).getPregunta(),
                                        this.preguntas.get(pregunta).getCorrecto(),
                                        this.preguntas.get(pregunta).getTiempo(),
                                        this.preguntas.get(pregunta).getOpciones()
                                    );

                                    desafio.setVisible(true);

                                    if (desafio.isAcierto()) {//validamos que la respuesta haya sido crrecta o incorrecta
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
                                        
                                        if (jugador.getVidas() <= 0) {//si las vidas llegan a 0 cerramos el juego y llamamos al JFrame de la ventana perdida
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
                            }else if(i > 0 && mapa[i-1][j] == 25){//acertijos
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i > 0 && mapa[i-1][j] == 26){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                Arriba();
                            }
                            break;
                        case 2://moverse hacia abajo
                            if(i < 9 && mapa[i+1][j] >= 5 && mapa[i+1][j] <= 19){
                                
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
                            }else if(i < 9 && mapa[i+1][j] == 25){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "No soy espada, no soy poción, pero al presionarme, doy dirección. No estoy en el mando, eso es verdad, pero en el teclado soy velocidad", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i < 9 && mapa[i+1][j] == 26){
                                this.cerrando = true;
                                JOptionPane.showMessageDialog(null, "Para agacharme con destreza uso la tecla con firmeza", "Acertijo", JOptionPane.INFORMATION_MESSAGE);
                            }else if(i < 9 && mapa[i+1][j] == 27){
                                this.cerrando = true;
                                new GANAROPERDER(jugador.getPuntos(),jugador.getVidas(),jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                winner = true;
                            }else{
                                Abajo();
                            }
                            break;
                        case 3://moverse hacia la izquierda
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
                            }else if(j > 0 && mapa[i][j-1] >= 21 && mapa[i][j-1] <= 23){
                                switch(mapa[i][j-1]){
                                    case 21:
                                        this.proteccion = true;
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 22:
                                        jugador.sumarPuntos(50);
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                    case 23:
                                        jugador.sumarVidas(1);
                                        mapa[i][j-1] = 0;
                                        Izquierda();
                                        break;
                                }
                            }else{
                                Izquierda();
                            }
                            break;
                        case 4://moverse hacia la derecha
                            if(j < 9 && mapa[i][j+1] >= 5 && mapa[i][j+1] <= 19){
                                
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
                            }else if(j < 9 && mapa[i][j+1] >= 21 && mapa[i][j+1] <= 23){
                                switch(mapa[i][j+1]){
                                    case 21:
                                        this.proteccion = true;
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 22:
                                        jugador.sumarPuntos(50);
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                    case 23:
                                        jugador.sumarVidas(1);
                                        mapa[i][j+1] = 0;
                                        Derecha();
                                        break;
                                }
                            }else if(j < 9 && mapa[i][j+1] == 27){
                                this.cerrando = true;
                                new GANAROPERDER(jugador.getPuntos(),jugador.getVidas(),jugador.getUser(),datos,fecha,horaI).setVisible(true);
                                winner = true;
                            }else{
                               Derecha();
                            }
                            break;
                        case 5://tecla w
                            
                            if(mapa[0][5] != 28){
                               mapa[0][5] = 28;
                                mapa[i][j] = 0;
                                System.out.println("------------------------------------");
                                MostrarMapa(); 
                            }
                            break;
                        case 6://tecla z
                            
                            if(mapa[4][2] != 28){
                                mapa[4][2] = 28;
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
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(mapa[i][j] == 28 && i-1 >= 0 && mapa[i-1][j] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenArribaLab());
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
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(mapa[i][j] == 28 && i+1 < 10 && mapa[i+1][j] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenAbajoLab());
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
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(mapa[i][j] == 28 && j-1 >= 0 && mapa[i][j-1] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenIzquierdaLab());
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
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(mapa[i][j] == 28 && j+1 < 10 && mapa[i][j+1] != 4){

                        MapaLab[i][j].removeAll();
                        animaciones.get(0).setImg(jugador.getPersonaje().getImagenDerechaLab());
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
    
    
    public void MostrarMapa(){//mostrar los recursos del mapa
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                MapaLab[i][j].removeAll();
                MapaLab[i][j].revalidate();
                MapaLab[i][j].repaint();
                
                MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/caminoHierba.png")));
                
                if(mapa[i][j] == 1){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/caminoLiso.png")));
                }else if(mapa[i][j] == 3){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/caminoFlores.png")));
                }else if(mapa[i][j] == 4){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/muro.png")));
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
                }else if(mapa[i][j] >= 21 && mapa[i][j] < 24){
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
                    }
                }else if(mapa[i][j] == 25){
                    MapaLab[i][j].add(animaciones.get(19), BorderLayout.CENTER);
                }else if(mapa[i][j] == 26){
                    MapaLab[i][j].add(animaciones.get(20), BorderLayout.CENTER);
                }else if(mapa[i][j] == 27){
                    MapaLab[i][j].setIcon(new ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/Meta.png")));
                }else if(mapa[i][j] == 28){
                    MapaLab[i][j].add(animaciones.get(0), BorderLayout.CENTER);
                }
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    private int idPreguntas(){//agregar las preguntas aleatoriamente
        int numero;
        boolean bandera = false;
        
        do{
            numero = (int)(Math.random()*15)+5;
            bandera = false;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
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
    
    private int idPowerUp(){//agregar los powerUp aleatoreamente
        int numero;
        boolean bandera = false;
        
        do{
            numero = (int)(Math.random()*3)+ 21;
            bandera = false;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
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
