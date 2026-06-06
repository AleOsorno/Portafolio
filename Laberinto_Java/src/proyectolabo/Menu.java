package proyectolabo;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Menu extends JFrame {
   private Datos Datos;
   private JButton AyudaButton;
   private JButton JugarButton;
   private JButton ReporteButton;
   private JButton SalirButton;
   private JLabel jLabel2;
   private JPanel jPanel1;

   public Menu() {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
   }

   public Menu(Datos datos) {
      this.initComponents();
      this.Datos = datos;
      this.setLocationRelativeTo((Component)null);
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.JugarButton = new JButton();
      this.ReporteButton = new JButton();
      this.AyudaButton = new JButton();
      this.SalirButton = new JButton();
      this.jLabel2 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Menú");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.JugarButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/MenuImagen/JugarButton.png")));
      this.JugarButton.setBorderPainted(false);
      this.JugarButton.setContentAreaFilled(false);
      this.JugarButton.setFocusPainted(false);
      this.JugarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Menu.this.JugarButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.JugarButton, new AbsoluteConstraints(60, 70, -1, -1));
      this.ReporteButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/MenuImagen/ReporteButton.png")));
      this.ReporteButton.setBorderPainted(false);
      this.ReporteButton.setContentAreaFilled(false);
      this.ReporteButton.setCursor(new Cursor(0));
      this.ReporteButton.setFocusPainted(false);
      this.ReporteButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Menu.this.ReporteButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.ReporteButton, new AbsoluteConstraints(360, 70, -1, -1));
      this.AyudaButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/MenuImagen/AyudaButton.png")));
      this.AyudaButton.setBorderPainted(false);
      this.AyudaButton.setContentAreaFilled(false);
      this.AyudaButton.setFocusPainted(false);
      this.AyudaButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Menu.this.AyudaButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.AyudaButton, new AbsoluteConstraints(60, 230, -1, -1));
      this.SalirButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/MenuImagen/SalirButton.png")));
      this.SalirButton.setBorderPainted(false);
      this.SalirButton.setContentAreaFilled(false);
      this.SalirButton.setFocusPainted(false);
      this.SalirButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Menu.this.SalirButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.SalirButton, new AbsoluteConstraints(360, 230, -1, -1));
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/MenuImagen/MenuBackground.gif")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 0, -1, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
      this.pack();
   }

   private void JugarButtonActionPerformed(ActionEvent evt) {
      ArrayList<Personaje> Personajes = new ArrayList();
      Personajes.add(new Personaje("Ash", "/proyectolabo/PersonajesImagenes/p1.1.png", "/proyectolabo/PersonajesImagenes/p1.2.png", "/proyectolabo/PersonajesImagenes/p1.3.png", "/proyectolabo/PersonajesImagenes/p1.4.png", "/proyectolabo/PersonajesImagenes/p1.1_1.png", "/proyectolabo/PersonajesImagenes/p1.2_1.png", "/proyectolabo/PersonajesImagenes/p1.3_1.png", "/proyectolabo/PersonajesImagenes/p1.4_1.png", "/proyectolabo/PersonajesImagenes/p1.1_2.png", "/proyectolabo/PersonajesImagenes/p1.2_2.png", "/proyectolabo/PersonajesImagenes/p1.3_2.png", "/proyectolabo/PersonajesImagenes/p1.4_2.png"));
      Personajes.add(new Personaje("Maya", "/proyectolabo/PersonajesImagenes/p2.1.png", "/proyectolabo/PersonajesImagenes/p2.2.png", "/proyectolabo/PersonajesImagenes/p2.3.png", "/proyectolabo/PersonajesImagenes/p2.4.png", "/proyectolabo/PersonajesImagenes/p2.1_1.png", "/proyectolabo/PersonajesImagenes/p2.2_1.png", "/proyectolabo/PersonajesImagenes/p2.3_1.png", "/proyectolabo/PersonajesImagenes/p2.4_1.png", "/proyectolabo/PersonajesImagenes/p2.1_2.png", "/proyectolabo/PersonajesImagenes/p2.2_2.png", "/proyectolabo/PersonajesImagenes/p2.3_2.png", "/proyectolabo/PersonajesImagenes/p2.4_2.png"));
      Personajes.add(new Personaje("Brock", "/proyectolabo/PersonajesImagenes/p3.1.png", "/proyectolabo/PersonajesImagenes/p3.2.png", "/proyectolabo/PersonajesImagenes/p3.3.png", "/proyectolabo/PersonajesImagenes/p3.4.png", "/proyectolabo/PersonajesImagenes/p3.1_1.png", "/proyectolabo/PersonajesImagenes/p3.2_1.png", "/proyectolabo/PersonajesImagenes/p3.3_1.png", "/proyectolabo/PersonajesImagenes/p3.4_1.png", "/proyectolabo/PersonajesImagenes/p3.1_2.png", "/proyectolabo/PersonajesImagenes/p3.2_2.png", "/proyectolabo/PersonajesImagenes/p3.3_2.png", "/proyectolabo/PersonajesImagenes/p3.4_2.png"));
      Personajes.add(new Personaje("Iris", "/proyectolabo/PersonajesImagenes/p4.1.png", "/proyectolabo/PersonajesImagenes/p4.2.png", "/proyectolabo/PersonajesImagenes/p4.3.png", "/proyectolabo/PersonajesImagenes/p4.4.png", "/proyectolabo/PersonajesImagenes/p4.1_1.png", "/proyectolabo/PersonajesImagenes/p4.2_1.png", "/proyectolabo/PersonajesImagenes/p4.3_1.png", "/proyectolabo/PersonajesImagenes/p4.4_1.png", "/proyectolabo/PersonajesImagenes/p4.1_2.png", "/proyectolabo/PersonajesImagenes/p4.2_2.png", "/proyectolabo/PersonajesImagenes/p4.3_2.png", "/proyectolabo/PersonajesImagenes/p4.4_2.png"));
      (new Login(this.Datos, Personajes)).setVisible(true);
      this.dispose();
   }

   private void ReporteButtonActionPerformed(ActionEvent evt) {
      if (!this.Datos.getArray_jugadores().isEmpty()) {
         Reporte dialog = new Reporte(new JFrame(), true, this.Datos);
         dialog.setVisible(true);
      } else {
         JOptionPane.showMessageDialog((Component)null, "No hay jugadores registrados", "INFORMATION_MESSAGE", 1);
      }

   }

   private void AyudaButtonActionPerformed(ActionEvent evt) {
      (new Ayuda(this.Datos)).setVisible(true);
      this.dispose();
   }

   private void SalirButtonActionPerformed(ActionEvent evt) {
      System.exit(0);
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
         Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new Menu()).setVisible(true);
         }
      });
   }
}
