package proyectolabo;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;

public class Ayuda extends JFrame {
   private Datos datos;
   private JButton jButton1;
   private JLabel jLabel2;

   public Ayuda() {
      this.initComponents();
   }

   public Ayuda(Datos datos) {
      this.initComponents();
      this.datos = datos;
      this.setLocationRelativeTo((Component)null);
   }

   private void initComponents() {
      this.jButton1 = new JButton();
      this.jLabel2 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Ayuda");
      this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/AyudaImagen/back.png")));
      this.jButton1.setBorderPainted(false);
      this.jButton1.setContentAreaFilled(false);
      this.jButton1.setFocusPainted(false);
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Ayuda.this.jButton1ActionPerformed(evt);
         }
      });
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/AyudaImagen/fondito.png")));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 1080, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(440, 440, 440).addComponent(this.jButton1, -2, 212, -2)).addComponent(this.jLabel2, -2, 1080, -2)).addGap(0, 0, 32767))));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 607, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(490, 490, 490).addComponent(this.jButton1, -2, 102, -2)).addComponent(this.jLabel2, -2, 607, -2)).addGap(0, 0, 32767))));
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
         Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new Ayuda()).setVisible(true);
         }
      });
   }
}
