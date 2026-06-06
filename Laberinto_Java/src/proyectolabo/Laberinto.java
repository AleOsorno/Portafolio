/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectolabo;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author alexo
 */
public class Laberinto extends javax.swing.JFrame implements KeyListener{

    /**
     * Creates new form Laberinto
     */
    private JButton[][] matrizBotones;
    private Jugador jugador;
    private Control control;
    private Control2 control2;
    private boolean teclaW;
    private boolean teclaZ;
    private boolean teclaQ;
    private boolean teclaV;
    private boolean laberinto2 = false;
    private Datos datos;
    private String dificultad;
    private int[][] mapa;
    private String fecha;
    private String horaI;
    
    public Laberinto() {
        initComponents();
        setLocationRelativeTo(null);
        configurarEventosVentana(); 
    }
    
    public Laberinto(Jugador jugador, String dificultad, Datos datos) {//constructor para cuando iniciamos por primera vez el juego
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.jugador = jugador;
        this.datos = datos;
        this.dificultad = dificultad;
        this.teclaW = false;
        this.teclaZ = false;
        this.teclaQ = false;
        this.teclaV = false;
        
        Date fecha = new Date();//obtenemos la fecha y hora en los que se inicio la partida
        DateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
        this.fecha = formato.format(fecha);
        Date hora = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss a");
        this.horaI = formatoHora.format(hora);
        
        if(this.dificultad.equals("Dificil")){//revisamos la dificultad y creamos los mapas dependiendo de esta
            this.matrizBotones = new JButton[20][20];
            setSize(1000, 1000);  
            AnadirMatrizBotones(20);
        }else{
            this.matrizBotones = new JButton[10][10];
            setSize(900,900);
            AnadirMatrizBotones(10);
        }
        
        jugador.setVidas(3);
        jugador.setPuntos(50);
        
        valores();//mostramos las vidas y puntos en el JFrame
        
        setLocationRelativeTo(null);
        configurarEventosVentana();//configuramos los estados de la ventana
    }
    
    public Laberinto(Jugador jugador, String dificultad, Datos datos, int[][] mapa, String fecha, String hora, 
            boolean teclaW, boolean teclaZ, boolean teclaQ, boolean teclaV) {//constructor para cuando el juego ya fue empezado pero pausado
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.jugador = jugador;
        this.datos = datos;
        this.dificultad = dificultad;
        this.mapa = mapa;
        this.horaI = hora;
        this.fecha = fecha;
        this.teclaW = teclaW;
        this.teclaZ = teclaZ;
        this.teclaQ = teclaQ;
        this.teclaV = teclaV;
        
        if(this.dificultad.equals("Dificil")){
            this.matrizBotones = new JButton[20][20];
            setSize(1000, 1000);  
            AnadirMatrizBotones(20);
        }else{
            this.matrizBotones = new JButton[10][10];
            setSize(900,900);
            AnadirMatrizBotones(10);
        }
        
        valores();
        
        setLocationRelativeTo(null);
        configurarEventosVentana(); 
    }
    
    private void AnadirMatrizBotones(int numero){//añadimos la matriz de botones
        PanelCentro.setLayout(new GridLayout(numero,numero,0,0));
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                matrizBotones[i][j] = new JButton(" ");
                matrizBotones[i][j].setPreferredSize(new Dimension(40, 40));
                matrizBotones[i][j].setMinimumSize(new Dimension(40, 40));
                matrizBotones[i][j].setMaximumSize(new Dimension(40, 40)); 
                matrizBotones[i][j].setBorderPainted(false);
                matrizBotones[i][j].setContentAreaFilled(false);
                matrizBotones[i][j].setFocusPainted(false);
                matrizBotones[i][j].setOpaque(false);
                PanelCentro.add(matrizBotones[i][j]);
            }
        }
        
        if(numero == 20){
            if(mapa == null){
               this.control2 = new Control2(matrizBotones,jugador,datos,fecha,horaI);
               this.laberinto2 = true;
               control2.MostrarMapa(); 
            }else{
               this.control2 = new Control2(matrizBotones,jugador,datos,fecha,horaI);
               control2.setMapa(this.mapa);
               this.laberinto2 = true;
               control2.MostrarMapa(); 
            }
            
        }else{
            if(mapa == null){
                this.control = new Control(matrizBotones,jugador,datos,fecha,horaI);
                this.laberinto2 = false;
                control.MostrarMapa();
            }else{
                this.control = new Control(matrizBotones,jugador,datos,fecha,horaI);
                control.setMapa(this.mapa);
                this.laberinto2 = false;
                control.MostrarMapa();
            }
            
        }
    }
    
    private void configurarEventosVentana() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {

            @Override // si se pierde el foco de la ventana llama al menu de pausa      
            public void windowDeactivated(java.awt.event.WindowEvent e) {
                if(!laberinto2){
                    if(!control.isCerrando()){
                        mostrarPausa();
                    }
                }else{
                    if(!control2.isCerrando()){
                        mostrarPausa();
                    }
                }
            }

            @Override // si se minimiza la ventana llama al menu de pause    
            public void windowIconified(java.awt.event.WindowEvent e) {
                if(!laberinto2){
                    if(!control.isCerrando()){
                        mostrarPausa();
                    }
                }else{
                    if(!control2.isCerrando()){
                        mostrarPausa();
                    }
                }
            }
        });
    }
    
    private void mostrarPausa() {
        dispose();
        if(laberinto2){
            Pausa dialog = new Pausa(this, true,jugador,datos,dificultad,control2.getMapa(),fecha,horaI,this.teclaW,this.teclaZ,this.teclaQ,this.teclaV);
            dialog.setVisible(true);
        }else{
            Pausa dialog = new Pausa(this, true,jugador,datos,dificultad,control.getMapa(),fecha,horaI,this.teclaW,this.teclaZ,this.teclaQ,this.teclaV);
            dialog.setVisible(true);
        }
    }
    
    public void keyPressed(KeyEvent e) {//recibe y valida las teclas de movimiento
        if(!this.laberinto2){
            if (e.getKeyCode() == KeyEvent.VK_UP){
                control.validarMovimiento(1);
                valores();

                if(control.isLoser() || control.isWinner()){
                    dispose();
                }
            } 
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                control.validarMovimiento(2);
                valores();

                if(control.isLoser() || control.isWinner()){
                    dispose();
                }
            } 
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                control.validarMovimiento(3);
                valores();

                if(control.isLoser() || control.isWinner()){
                    dispose();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                control.validarMovimiento(4);
                valores();

                if(control.isLoser() || control.isWinner()){
                    dispose();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_W){

                if(!teclaW){
                    control.validarMovimiento(5);
                    valores();

                    if(control.isLoser() || control.isWinner()){
                        dispose();
                    }
                    teclaW = true;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_Z){

                if(!teclaZ){
                    control.validarMovimiento(6);
                    valores();

                    if(control.isLoser() || control.isWinner()){
                        dispose();
                    }
                    teclaZ = true;
                }
            }
        }else{//laberinto 2 ------------------------------------------------------------------------------------------
            if (e.getKeyCode() == KeyEvent.VK_UP){
                control2.validarMovimiento(1);
                valores();

                if(control2.isLoser() || control2.isWinner()){
                    dispose();
                }
            } 
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                control2.validarMovimiento(2);
                valores();

                if(control2.isLoser() || control2.isWinner()){
                    dispose();
                }
            } 
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                control2.validarMovimiento(3);
                valores();

                if(control2.isLoser() || control2.isWinner()){
                    dispose();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                control2.validarMovimiento(4);
                valores();

                if(control2.isLoser() || control2.isWinner()){
                    dispose();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_W){

                if(!teclaW){
                    control2.validarMovimiento(5);
                    valores();

                    if(control2.isLoser() || control2.isWinner()){
                        dispose();
                    }
                    teclaW = true;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_Z){

                if(!teclaZ){
                    control2.validarMovimiento(6);
                    valores();

                    if(control2.isLoser() || control2.isWinner()){
                        dispose();
                    }
                    teclaZ = true;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_Q){

                if(!teclaQ){
                    control2.validarMovimiento(7);
                    valores();

                    if(control2.isLoser() || control2.isWinner()){
                        dispose();
                    }
                    teclaQ = true;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_V){

                if(!teclaV){
                    control2.validarMovimiento(8);
                    valores();

                    if(control2.isLoser() || control2.isWinner()){
                        dispose();
                    }
                    teclaV = true;
                }
            }
        }
    }
    
    public void valores(){
        ContadorVidas.setText(Integer.toString(jugador.getVidas()));
        ContadorPuntuacion.setText(Integer.toString(jugador.getPuntos()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelCentro = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ContadorVidas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ContadorPuntuacion = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laberinto");
        setPreferredSize(new java.awt.Dimension(900, 900));

        PanelCentro.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/LaberintoLetras.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/Corazon.png"))); // NOI18N

        ContadorVidas.setText("___");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/Puntuacion.png"))); // NOI18N

        ContadorPuntuacion.setText("___");

        MenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectolabo/LaberintoImagen/MenuBarraButton-removebg-preview.png"))); // NOI18N
        MenuButton.setBorderPainted(false);
        MenuButton.setContentAreaFilled(false);
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContadorVidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContadorPuntuacion)
                        .addGap(90, 90, 90))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContadorPuntuacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ContadorVidas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MenuButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelCentro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        // TODO add your handling code here:
        mostrarPausa();
    }//GEN-LAST:event_MenuButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laberinto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContadorPuntuacion;
    private javax.swing.JLabel ContadorVidas;
    private javax.swing.JButton MenuButton;
    private javax.swing.JPanel PanelCentro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
