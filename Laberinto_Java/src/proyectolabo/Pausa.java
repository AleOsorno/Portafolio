package proyectolabo;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Pausa extends JDialog {
   private Jugador jugador;
   private Datos datos;
   private String dificultad;
   private int[][] mapa;
   private String fecha;
   private String hora;
   private boolean teclaW;
   private boolean teclaZ;
   private boolean teclaQ;
   private boolean teclaV;
   private JButton ReanudarButton;
   private JButton SalirButton;
   private JLabel jLabel1;
   private JPanel jPanel1;

   public Pausa(Frame parent, boolean modal) {
      super(parent, modal);
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
   }

   public Pausa(Frame parent, boolean modal, Jugador jugador, Datos datos, String dificultad, int[][] mapa, String fecha, String hora, boolean teclaW, boolean teclaZ, boolean teclaQ, boolean teclaV) {
      super(parent, modal);
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
      this.jugador = jugador;
      this.datos = datos;
      this.dificultad = dificultad;
      this.mapa = mapa;
      this.fecha = fecha;
      this.hora = hora;
      this.teclaW = teclaW;
      this.teclaZ = teclaZ;
      this.teclaQ = teclaQ;
      this.teclaV = teclaV;
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.SalirButton = new JButton();
      this.ReanudarButton = new JButton();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(0);
      this.setTitle("Pausa");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.SalirButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/PausaImagen/Salir-removebg-preview.png")));
      this.SalirButton.setBorderPainted(false);
      this.SalirButton.setContentAreaFilled(false);
      this.SalirButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Pausa.this.SalirButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.SalirButton, new AbsoluteConstraints(90, 160, -1, -1));
      this.ReanudarButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/PausaImagen/ReanudarButton__2_-removebg-preview.png")));
      this.ReanudarButton.setBorderPainted(false);
      this.ReanudarButton.setContentAreaFilled(false);
      this.ReanudarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Pausa.this.ReanudarButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.ReanudarButton, new AbsoluteConstraints(90, 40, -1, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/PausaImagen/FondoPausa.gif")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, 400, 300));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void ReanudarButtonActionPerformed(ActionEvent evt) {
      this.dispose();
      (new Laberinto(this.jugador, this.dificultad, this.datos, this.mapa, this.fecha, this.hora, this.teclaW, this.teclaZ, this.teclaQ, this.teclaV)).setVisible(true);
   }

   private void SalirButtonActionPerformed(ActionEvent evt) {
      this.dispose();
      (new PAUSAROGANAR(this.jugador.getUser(), this.datos, this.fecha, this.hora)).setVisible(true);
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
         Logger.getLogger(Pausa.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Pausa.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Pausa.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Pausa.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            Pausa dialog = new Pausa(new JFrame(), true);
            dialog.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                  System.exit(0);
               }
            });
            dialog.setVisible(true);
         }
      });
   }
}
