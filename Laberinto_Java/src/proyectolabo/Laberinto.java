package proyectolabo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Laberinto extends JFrame implements KeyListener {
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
   private JLabel ContadorPuntuacion;
   private JLabel ContadorVidas;
   private JButton MenuButton;
   private JPanel PanelCentro;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JPanel jPanel1;
   private JPanel jPanel2;

   public Laberinto() {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
      this.configurarEventosVentana();
   }

   public Laberinto(Jugador jugador, String dificultad, Datos datos) {
      this.initComponents();
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
      Date fecha = new Date();
      DateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
      this.fecha = formato.format(fecha);
      Date hora = new Date();
      DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss a");
      this.horaI = formatoHora.format(hora);
      if (this.dificultad.equals("Dificil")) {
         this.matrizBotones = new JButton[20][20];
         this.setSize(1000, 1000);
         this.AnadirMatrizBotones(20);
      } else {
         this.matrizBotones = new JButton[10][10];
         this.setSize(900, 900);
         this.AnadirMatrizBotones(10);
      }

      jugador.setVidas(3);
      jugador.setPuntos(50);
      this.valores();
      this.setLocationRelativeTo((Component)null);
      this.configurarEventosVentana();
   }

   public Laberinto(Jugador jugador, String dificultad, Datos datos, int[][] mapa, String fecha, String hora, boolean teclaW, boolean teclaZ, boolean teclaQ, boolean teclaV) {
      this.initComponents();
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
      if (this.dificultad.equals("Dificil")) {
         this.matrizBotones = new JButton[20][20];
         this.setSize(1000, 1000);
         this.AnadirMatrizBotones(20);
      } else {
         this.matrizBotones = new JButton[10][10];
         this.setSize(900, 900);
         this.AnadirMatrizBotones(10);
      }

      this.valores();
      this.setLocationRelativeTo((Component)null);
      this.configurarEventosVentana();
   }

   private void AnadirMatrizBotones(int numero) {
      this.PanelCentro.setLayout(new GridLayout(numero, numero, 0, 0));

      for(int i = 0; i < numero; ++i) {
         for(int j = 0; j < numero; ++j) {
            this.matrizBotones[i][j] = new JButton(" ");
            this.matrizBotones[i][j].setPreferredSize(new Dimension(40, 40));
            this.matrizBotones[i][j].setMinimumSize(new Dimension(40, 40));
            this.matrizBotones[i][j].setMaximumSize(new Dimension(40, 40));
            this.matrizBotones[i][j].setBorderPainted(false);
            this.matrizBotones[i][j].setContentAreaFilled(false);
            this.matrizBotones[i][j].setFocusPainted(false);
            this.matrizBotones[i][j].setOpaque(false);
            this.PanelCentro.add(this.matrizBotones[i][j]);
         }
      }

      if (numero == 20) {
         if (this.mapa == null) {
            this.control2 = new Control2(this.matrizBotones, this.jugador, this.datos, this.fecha, this.horaI);
            this.laberinto2 = true;
            this.control2.MostrarMapa();
         } else {
            this.control2 = new Control2(this.matrizBotones, this.jugador, this.datos, this.fecha, this.horaI);
            this.control2.setMapa(this.mapa);
            this.laberinto2 = true;
            this.control2.MostrarMapa();
         }
      } else if (this.mapa == null) {
         this.control = new Control(this.matrizBotones, this.jugador, this.datos, this.fecha, this.horaI);
         this.laberinto2 = false;
         this.control.MostrarMapa();
      } else {
         this.control = new Control(this.matrizBotones, this.jugador, this.datos, this.fecha, this.horaI);
         this.control.setMapa(this.mapa);
         this.laberinto2 = false;
         this.control.MostrarMapa();
      }

   }

   private void configurarEventosVentana() {
      this.setDefaultCloseOperation(2);
      this.addWindowListener(new WindowAdapter() {
         public void windowDeactivated(WindowEvent e) {
            if (!Laberinto.this.laberinto2) {
               if (!Laberinto.this.control.isCerrando()) {
                  Laberinto.this.mostrarPausa();
               }
            } else if (!Laberinto.this.control2.isCerrando()) {
               Laberinto.this.mostrarPausa();
            }

         }

         public void windowIconified(WindowEvent e) {
            if (!Laberinto.this.laberinto2) {
               if (!Laberinto.this.control.isCerrando()) {
                  Laberinto.this.mostrarPausa();
               }
            } else if (!Laberinto.this.control2.isCerrando()) {
               Laberinto.this.mostrarPausa();
            }

         }
      });
   }

   private void mostrarPausa() {
      this.dispose();
      if (this.laberinto2) {
         Pausa dialog = new Pausa(this, true, this.jugador, this.datos, this.dificultad, this.control2.getMapa(), this.fecha, this.horaI, this.teclaW, this.teclaZ, this.teclaQ, this.teclaV);
         dialog.setVisible(true);
      } else {
         Pausa dialog = new Pausa(this, true, this.jugador, this.datos, this.dificultad, this.control.getMapa(), this.fecha, this.horaI, this.teclaW, this.teclaZ, this.teclaQ, this.teclaV);
         dialog.setVisible(true);
      }

   }

   public void keyPressed(KeyEvent e) {
      if (!this.laberinto2) {
         if (e.getKeyCode() == 38) {
            this.control.validarMovimiento(1);
            this.valores();
            if (this.control.isLoser() || this.control.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 40) {
            this.control.validarMovimiento(2);
            this.valores();
            if (this.control.isLoser() || this.control.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 37) {
            this.control.validarMovimiento(3);
            this.valores();
            if (this.control.isLoser() || this.control.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 39) {
            this.control.validarMovimiento(4);
            this.valores();
            if (this.control.isLoser() || this.control.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 87 && !this.teclaW) {
            this.control.validarMovimiento(5);
            this.valores();
            if (this.control.isLoser() || this.control.isWinner()) {
               this.dispose();
            }

            this.teclaW = true;
         }

         if (e.getKeyCode() == 90 && !this.teclaZ) {
            this.control.validarMovimiento(6);
            this.valores();
            if (this.control.isLoser() || this.control.isWinner()) {
               this.dispose();
            }

            this.teclaZ = true;
         }
      } else {
         if (e.getKeyCode() == 38) {
            this.control2.validarMovimiento(1);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 40) {
            this.control2.validarMovimiento(2);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 37) {
            this.control2.validarMovimiento(3);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 39) {
            this.control2.validarMovimiento(4);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }
         }

         if (e.getKeyCode() == 87 && !this.teclaW) {
            this.control2.validarMovimiento(5);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }

            this.teclaW = true;
         }

         if (e.getKeyCode() == 90 && !this.teclaZ) {
            this.control2.validarMovimiento(6);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }

            this.teclaZ = true;
         }

         if (e.getKeyCode() == 81 && !this.teclaQ) {
            this.control2.validarMovimiento(7);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }

            this.teclaQ = true;
         }

         if (e.getKeyCode() == 86 && !this.teclaV) {
            this.control2.validarMovimiento(8);
            this.valores();
            if (this.control2.isLoser() || this.control2.isWinner()) {
               this.dispose();
            }

            this.teclaV = true;
         }
      }

   }

   public void valores() {
      this.ContadorVidas.setText(Integer.toString(this.jugador.getVidas()));
      this.ContadorPuntuacion.setText(Integer.toString(this.jugador.getPuntos()));
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.PanelCentro = new JPanel();
      this.jPanel2 = new JPanel();
      this.jLabel1 = new JLabel();
      this.jLabel2 = new JLabel();
      this.ContadorVidas = new JLabel();
      this.jLabel3 = new JLabel();
      this.ContadorPuntuacion = new JLabel();
      this.MenuButton = new JButton();
      this.setDefaultCloseOperation(3);
      this.setTitle("Laberinto");
      this.setPreferredSize(new Dimension(900, 900));
      this.PanelCentro.setLayout(new GridLayout(1, 0));
      this.jLabel1.setFont(new Font("Dialog", 1, 18));
      this.jLabel1.setHorizontalAlignment(0);
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/LaberintoLetras.png")));
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/Corazon.png")));
      this.ContadorVidas.setText("___");
      this.jLabel3.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/Puntuacion.png")));
      this.ContadorPuntuacion.setText("___");
      this.MenuButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LaberintoImagen/MenuBarraButton-removebg-preview.png")));
      this.MenuButton.setBorderPainted(false);
      this.MenuButton.setContentAreaFilled(false);
      this.MenuButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Laberinto.this.MenuButtonActionPerformed(evt);
         }
      });
      GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
      this.jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1, -1, 424, 32767).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addGap(68, 68, 68).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.ContadorVidas).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.MenuButton, -1, -1, 32767).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.ContadorPuntuacion).addGap(90, 90, 90)))));
      jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(0, 0, 32767)).addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(this.ContadorPuntuacion, Alignment.TRAILING).addComponent(this.ContadorVidas, Alignment.TRAILING).addComponent(this.jLabel2, Alignment.TRAILING).addComponent(this.MenuButton, Alignment.TRAILING)))).addContainerGap()));
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.PanelCentro, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.PanelCentro, -1, 250, 32767).addContainerGap()));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void MenuButtonActionPerformed(ActionEvent evt) {
      this.mostrarPausa();
   }

   public static void main(String[] args) {
      try {
         for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(Laberinto.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Laberinto.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Laberinto.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Laberinto.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new Laberinto()).setVisible(true);
         }
      });
   }

   public void keyTyped(KeyEvent e) {
   }

   public void keyReleased(KeyEvent e) {
   }
}
