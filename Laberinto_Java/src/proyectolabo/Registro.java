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
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Registro extends JFrame {
   ButtonGroup group = new ButtonGroup();
   private Datos Datos;
   private ArrayList<Personaje> personajes;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JPanel jPanel1;
   private JRadioButton jRadioButton1;
   private JRadioButton jRadioButton2;
   private JSeparator jSeparator1;
   private JSeparator jSeparator2;
   private JSlider jSlider1;
   private JTextField jTextField1;
   private JLabel muestraEdad;
   private JTextField nombreField;
   private JTextField passField1;
   private JTextField passField2;
   private JButton registrarButton;
   private JButton regresar;
   private JTextField userField;

   public Registro() {
      this.initComponents();
      this.nombreField.setForeground(new Color(158, 158, 158));
      this.userField.setForeground(new Color(158, 158, 158));
      this.passField1.setForeground(new Color(158, 158, 158));
      this.passField2.setForeground(new Color(158, 158, 158));
      this.group.add(this.jRadioButton1);
      this.group.add(this.jRadioButton2);
      this.setLocationRelativeTo((Component)null);
   }

   public Registro(Datos Datos, ArrayList<Personaje> personajes) {
      this.initComponents();
      this.nombreField.setForeground(new Color(158, 158, 158));
      this.userField.setForeground(new Color(158, 158, 158));
      this.passField1.setForeground(new Color(158, 158, 158));
      this.passField2.setForeground(new Color(158, 158, 158));
      this.Datos = Datos;
      this.personajes = personajes;
      this.group.add(this.jRadioButton1);
      this.group.add(this.jRadioButton2);
      this.setLocationRelativeTo((Component)null);
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.nombreField = new JTextField();
      this.userField = new JTextField();
      this.passField1 = new JTextField();
      this.jLabel2 = new JLabel();
      this.passField2 = new JTextField();
      this.jSeparator1 = new JSeparator();
      this.jRadioButton1 = new JRadioButton();
      this.jRadioButton2 = new JRadioButton();
      this.jSeparator2 = new JSeparator();
      this.jSlider1 = new JSlider();
      this.muestraEdad = new JLabel();
      this.registrarButton = new JButton();
      this.regresar = new JButton();
      this.jLabel1 = new JLabel();
      this.jTextField1 = new JTextField();
      this.setDefaultCloseOperation(3);
      this.setTitle("Registro");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.nombreField.setFont(new Font("Arial Black", 1, 12));
      this.nombreField.setHorizontalAlignment(0);
      this.nombreField.setText("Nombre");
      this.nombreField.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent evt) {
            Registro.this.nombreFieldFocusGained(evt);
         }

         public void focusLost(FocusEvent evt) {
            Registro.this.nombreFieldFocusLost(evt);
         }
      });
      this.jPanel1.add(this.nombreField, new AbsoluteConstraints(20, 130, 220, -1));
      this.userField.setFont(new Font("Arial Black", 1, 12));
      this.userField.setHorizontalAlignment(0);
      this.userField.setText("Usuario");
      this.userField.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent evt) {
            Registro.this.userFieldFocusGained(evt);
         }

         public void focusLost(FocusEvent evt) {
            Registro.this.userFieldFocusLost(evt);
         }
      });
      this.jPanel1.add(this.userField, new AbsoluteConstraints(20, 170, 220, -1));
      this.passField1.setFont(new Font("Arial Black", 1, 12));
      this.passField1.setHorizontalAlignment(0);
      this.passField1.setText("Contraseña");
      this.passField1.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent evt) {
            Registro.this.passField1FocusGained(evt);
         }

         public void focusLost(FocusEvent evt) {
            Registro.this.passField1FocusLost(evt);
         }
      });
      this.jPanel1.add(this.passField1, new AbsoluteConstraints(20, 210, 220, -1));
      this.jLabel2.setHorizontalAlignment(0);
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/RegistroImagen/RegistroLetras.png")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 10, 500, -1));
      this.passField2.setFont(new Font("Arial Black", 1, 12));
      this.passField2.setHorizontalAlignment(0);
      this.passField2.setText("Contraseña");
      this.passField2.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent evt) {
            Registro.this.passField2FocusGained(evt);
         }

         public void focusLost(FocusEvent evt) {
            Registro.this.passField2FocusLost(evt);
         }
      });
      this.jPanel1.add(this.passField2, new AbsoluteConstraints(20, 250, 220, -1));
      this.jPanel1.add(this.jSeparator1, new AbsoluteConstraints(290, 130, 190, 10));
      this.jRadioButton1.setFont(new Font("Microsoft YaHei", 1, 12));
      this.jRadioButton1.setForeground(new Color(255, 255, 255));
      this.jRadioButton1.setText("Hombre");
      this.jRadioButton1.setOpaque(false);
      this.jPanel1.add(this.jRadioButton1, new AbsoluteConstraints(290, 140, -1, -1));
      this.jRadioButton2.setFont(new Font("Microsoft YaHei", 1, 12));
      this.jRadioButton2.setForeground(new Color(255, 255, 255));
      this.jRadioButton2.setText("Mujer");
      this.jRadioButton2.setOpaque(false);
      this.jPanel1.add(this.jRadioButton2, new AbsoluteConstraints(410, 140, -1, -1));
      this.jPanel1.add(this.jSeparator2, new AbsoluteConstraints(290, 170, 190, 10));
      this.jSlider1.setMaximum(64);
      this.jSlider1.setMinimum(14);
      this.jSlider1.setPaintLabels(true);
      this.jSlider1.setValue(14);
      this.jSlider1.setOpaque(false);
      this.jSlider1.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent evt) {
            Registro.this.jSlider1StateChanged(evt);
         }
      });
      this.jPanel1.add(this.jSlider1, new AbsoluteConstraints(280, 200, -1, 30));
      this.muestraEdad.setFont(new Font("Dialog", 1, 12));
      this.muestraEdad.setForeground(new Color(255, 255, 255));
      this.muestraEdad.setText("Edad");
      this.muestraEdad.setToolTipText("");
      this.jPanel1.add(this.muestraEdad, new AbsoluteConstraints(380, 180, -1, -1));
      this.registrarButton.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/RegistroImagen/Registrarboton.png")));
      this.registrarButton.setBorderPainted(false);
      this.registrarButton.setContentAreaFilled(false);
      this.registrarButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Registro.this.registrarButtonActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.registrarButton, new AbsoluteConstraints(250, 230, -1, -1));
      this.regresar.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/RegistroImagen/Regresarboton.png")));
      this.regresar.setBorderPainted(false);
      this.regresar.setContentAreaFilled(false);
      this.regresar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Registro.this.regresarActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.regresar, new AbsoluteConstraints(360, 230, -1, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/RegistroImagen/RegistroBackground.gif")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, 500, -1));
      this.jTextField1.setText("jTextField1");
      this.jPanel1.add(this.jTextField1, new AbsoluteConstraints(10, 50, -1, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void nombreFieldFocusGained(FocusEvent evt) {
      if (this.nombreField.getText().equals("Nombre")) {
         this.nombreField.setText("");
         this.nombreField.setForeground(new Color(0, 0, 0));
      }

   }

   private void nombreFieldFocusLost(FocusEvent evt) {
      if (this.nombreField.getText().isEmpty()) {
         this.nombreField.setText("Nombre");
         this.nombreField.setForeground(new Color(158, 158, 158));
      }

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

   private void passField1FocusGained(FocusEvent evt) {
      if (this.passField1.getText().equals("Contraseña")) {
         this.passField1.setText("");
         this.passField1.setForeground(new Color(0, 0, 0));
      }

   }

   private void passField1FocusLost(FocusEvent evt) {
      if (this.passField1.getText().isEmpty()) {
         this.passField1.setText("Contraseña");
         this.passField1.setForeground(new Color(158, 158, 158));
      }

   }

   private void passField2FocusGained(FocusEvent evt) {
      if (this.passField2.getText().equals("Contraseña")) {
         this.passField2.setText("");
         this.passField2.setForeground(new Color(0, 0, 0));
      }

   }

   private void passField2FocusLost(FocusEvent evt) {
      if (this.passField2.getText().isEmpty()) {
         this.passField2.setText("Contraseña");
         this.passField2.setForeground(new Color(158, 158, 158));
      }

   }

   private void jSlider1StateChanged(ChangeEvent evt) {
      this.muestraEdad.setText(Integer.toString(this.jSlider1.getValue()));
   }

   private void registrarButtonActionPerformed(ActionEvent evt) {
      String nombre = this.nombreField.getText();
      String user = this.userField.getText();
      String pass1 = this.passField1.getText();
      String pass2 = this.passField2.getText();
      String edad = Integer.toString(this.jSlider1.getValue());
      String sexo = "";
      if (this.jRadioButton1.isSelected()) {
         sexo = "Hombre";
      } else if (this.jRadioButton2.isSelected()) {
         sexo = "Mujer";
      }

      if (!nombre.isEmpty() && !user.isEmpty() && !pass1.isEmpty() && !pass2.isEmpty() && !edad.isEmpty() && !sexo.isEmpty()) {
         if (pass1.equals(pass2)) {
            Jugador jugador = new Jugador(nombre, edad, sexo, user, pass1, 0);
            this.Datos.agregaJugador(jugador);
            JOptionPane.showMessageDialog((Component)null, "Haz sido registrado", "INFORMATION_MESSAGE", 1);
            (new Login(this.Datos, this.personajes)).setVisible(true);
            this.dispose();
         } else {
            JOptionPane.showMessageDialog((Component)null, "Contraseña diferente", "INFORMATION_MESSAGE", 1);
         }
      } else {
         JOptionPane.showMessageDialog((Component)null, "Llena todos los campos", "INFORMATION_MESSAGE", 1);
      }

   }

   private void regresarActionPerformed(ActionEvent evt) {
      (new Login(this.Datos, this.personajes)).setVisible(true);
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
         Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new Registro()).setVisible(true);
         }
      });
   }
}
