package proyectolabo;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Login extends JFrame {
   ButtonGroup group = new ButtonGroup();
   private Datos Datos;
   private ArrayList<Personaje> personajes;
   private JButton accederButton;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JPanel jPanel1;
   private JRadioButton jRadioButton1;
   private JRadioButton jRadioButton2;
   private JTextField jTextField1;
   private JTextField passField;
   private JButton regresarButton;
   private JTextField userField;

   public Login() {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
      this.userField.setForeground(new Color(158, 158, 158));
      this.passField.setForeground(new Color(158, 158, 158));
      this.group.add(this.jRadioButton1);
      this.group.add(this.jRadioButton2);
   }

   public Login(Datos Datos, ArrayList<Personaje> personajes) {
      this.initComponents();
      this.Datos = Datos;
      this.personajes = personajes;
      this.setLocationRelativeTo((Component)null);
      this.userField.setForeground(new Color(158, 158, 158));
      this.passField.setForeground(new Color(158, 158, 158));
      this.group.add(this.jRadioButton1);
      this.group.add(this.jRadioButton2);
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.userField = new JTextField();
      this.passField = new JTextField();
      this.jLabel2 = new JLabel();
      this.accederButton = new JButton();
      this.regresarButton = new JButton();
      this.jRadioButton1 = new JRadioButton();
      this.jRadioButton2 = new JRadioButton();
      this.jLabel1 = new JLabel();
      this.jTextField1 = new JTextField();
      this.setDefaultCloseOperation(3);
      this.setTitle("Login");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.userField.setFont(new Font("Arial Black", 1, 12));
      this.userField.setForeground(new Color(102, 102, 102));
      this.userField.setHorizontalAlignment(0);
      this.userField.setText("Usuario");
      this.userField.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent evt) {
            Login.this.userFieldFocusGained(evt);
         }

         public void focusLost(FocusEvent evt) {
            Login.this.userFieldFocusLost(evt);
         }
      });
      this.jPanel1.add(this.userField, new AbsoluteConstraints(60, 140, 250, -1));
      this.passField.setFont(new Font("Arial Black", 1, 12));
      this.passField.setForeground(new Color(102, 102, 102));
      this.passField.setHorizontalAlignment(0);
      this.passField.setText("Contraseña");
      this.passField.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent evt) {
            Login.this.passFieldFocusGained(evt);
         }

         public void focusLost(FocusEvent evt) {
            Login.this.passFieldFocusLost(evt);
         }
      });
      this.jPanel1.add(this.passField, new AbsoluteConstraints(60, 200, 250, -1));
      this.jLabel2.setHorizontalAlignment(0);
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LoginImagen/LoginLetras.png")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 20, 520, -1));
      this.accederButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LoginImagen/AccederButton.png")));
      this.accederButton.setBorderPainted(false);
      this.accederButton.setContentAreaFilled(false);
      this.accederButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Login.this.accederButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.accederButton, new AbsoluteConstraints(60, 240, -1, -1));
      this.regresarButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LoginImagen/RegresarButton.png")));
      this.regresarButton.setBorderPainted(false);
      this.regresarButton.setContentAreaFilled(false);
      this.regresarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Login.this.regresarButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.regresarButton, new AbsoluteConstraints(310, 240, -1, -1));
      this.jRadioButton1.setFont(new Font("Arial Black", 1, 12));
      this.jRadioButton1.setForeground(new Color(255, 255, 255));
      this.jRadioButton1.setText("Facil");
      this.jRadioButton1.setOpaque(false);
      this.jPanel1.add(this.jRadioButton1, new AbsoluteConstraints(350, 150, 90, -1));
      this.jRadioButton2.setFont(new Font("Arial Black", 1, 12));
      this.jRadioButton2.setForeground(new Color(255, 255, 255));
      this.jRadioButton2.setText("Dificil");
      this.jRadioButton2.setOpaque(false);
      this.jPanel1.add(this.jRadioButton2, new AbsoluteConstraints(350, 200, 90, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/LoginImagen/LoginBackground.gif")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, -1, -1));
      this.jTextField1.setText("jTextField1");
      this.jPanel1.add(this.jTextField1, new AbsoluteConstraints(10, 40, -1, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
      this.pack();
   }

   private void userFieldFocusGained(FocusEvent evt) {
      if (this.userField.getText().equals("Usuario")) {
         this.userField.setText("");
         this.userField.setForeground(new Color(0, 0, 0));
      }

   }

   private void userFieldFocusLost(FocusEvent evt) {
      if (this.userField.getText().isEmpty()) {
         this.userField.setText("Usuario");
         this.userField.setForeground(new Color(158, 158, 158));
      }

   }

   private void passFieldFocusGained(FocusEvent evt) {
      if (this.passField.getText().equals("Contraseña")) {
         this.passField.setText("");
         this.passField.setForeground(new Color(0, 0, 0));
      }

   }

   private void passFieldFocusLost(FocusEvent evt) {
      if (this.passField.getText().isEmpty()) {
         this.passField.setText("Contraseña");
         this.passField.setForeground(new Color(158, 158, 158));
      }

   }

   private void accederButtonActionPerformed(ActionEvent evt) {
      String user = this.userField.getText();
      String pass = this.passField.getText();
      int p = this.Datos.verificaUser(user, pass);
      String seleccion = "";
      if (this.jRadioButton1.isSelected()) {
         seleccion = "Facil";
      } else if (this.jRadioButton2.isSelected()) {
         seleccion = "Dificil";
      }

      if (!user.isEmpty() && !pass.isEmpty() && !seleccion.isEmpty()) {
         if (p >= 0) {
            for(Jugador e : this.Datos.getArray_jugadores()) {
               if (user.equals(e.getUser())) {
                  (new SeleccionPersonaje(this.personajes, e, seleccion, this.Datos)).setVisible(true);
               }
            }

            this.dispose();
         } else if (p == -1) {
            JOptionPane.showMessageDialog((Component)null, "Vuelve a introducir la contraseña", "INFORMATION_MESSAGE", 1);
         } else {
            (new Registro(this.Datos, this.personajes)).setVisible(true);
            this.dispose();
         }
      } else {
         JOptionPane.showMessageDialog((Component)null, "Llena todos los espacios", "INFORMATION_MESSAGE", 1);
      }

   }

   private void regresarButtonActionPerformed(ActionEvent evt) {
      (new Menu(this.Datos)).setVisible(true);
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
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new Login()).setVisible(true);
         }
      });
   }
}
