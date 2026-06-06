package proyectolabo;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class PAUSAROGANAR extends JFrame {
   private String nombre;
   private Datos datos;
   private String fecha;
   private String horaI;
   private JButton jButton1;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JPanel jPanel1;

   public PAUSAROGANAR() {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
   }

   public PAUSAROGANAR(String nombre, Datos datos, String fecha, String horaI) {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
      this.datos = datos;
      this.fecha = fecha;
      this.horaI = horaI;
      Date hora = new Date();
      DateFormat formato = new SimpleDateFormat("HH:mm:ss a");
      String horaF = formato.format(hora);
      String estado = "Pausado";
      Partida partida = new Partida(nombre, horaI, fecha, horaF, estado);
      datos.agregarPartida(partida);
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.jLabel2 = new JLabel();
      this.jButton1 = new JButton();
      this.jLabel3 = new JLabel();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Pausar");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.jLabel2.setHorizontalAlignment(0);
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/PausaImagen/JUEGOTERMINADO.png")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 0, 640, 170));
      this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/PausaImagen/TERMINADOBUTTON.png")));
      this.jButton1.setBorderPainted(false);
      this.jButton1.setContentAreaFilled(false);
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            PAUSAROGANAR.this.jButton1ActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.jButton1, new AbsoluteConstraints(240, 250, -1, -1));
      this.jLabel3.setFont(new Font("Rockwell Extra Bold", 1, 14));
      this.jLabel3.setForeground(new Color(255, 255, 255));
      this.jLabel3.setHorizontalAlignment(0);
      this.jLabel3.setText("¡ESPERAMOS QUE VUELVAS!");
      this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(-3, 200, 640, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/PausaImagen/TerminadoBackground.gif")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, -1, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void jButton1ActionPerformed(ActionEvent evt) {
      (new Menu(this.datos)).setVisible(true);
      this.dispose();
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
         Logger.getLogger(PAUSAROGANAR.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(PAUSAROGANAR.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(PAUSAROGANAR.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(PAUSAROGANAR.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new PAUSAROGANAR()).setVisible(true);
         }
      });
   }
}
