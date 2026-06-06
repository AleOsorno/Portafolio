package proyectolabo;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Desafios extends JDialog {
   private String pregunta;
   private int opCorrecta;
   private int tiempo;
   private String[] op;
   private boolean acierto = false;
   private ButtonGroup group = new ButtonGroup();
   private JButton Enviar;
   private JRadioButton Op1;
   private JRadioButton Op2;
   private JRadioButton Op3;
   private JRadioButton Op4;
   private JLabel Pregunta;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JPanel jPanel1;

   public Desafios(Frame parent, boolean modal) {
      super(parent, modal);
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
   }

   public Desafios(Frame parent, boolean modal, String pregunta, int opCorrecta, int tiempo, String[] op) {
      super(parent, modal);
      this.initComponents();
      this.pregunta = pregunta;
      this.opCorrecta = opCorrecta;
      this.tiempo = tiempo;
      this.op = op;
      this.group.add(this.Op1);
      this.group.add(this.Op2);
      this.group.add(this.Op3);
      this.group.add(this.Op4);
      this.setPregunta();
      this.setOp();
      this.setLocationRelativeTo((Component)null);
      Timer timer = new Timer(tiempo * 1000, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Desafios.this.acierto = false;
            Desafios.this.dispose();
         }
      });
      timer.setRepeats(false);
      timer.start();
   }

   private void setPregunta() {
      this.Pregunta.setText(this.pregunta);
   }

   private void setOp() {
      this.Op1.setText(this.op[0]);
      this.Op2.setText(this.op[1]);
      this.Op3.setText(this.op[2]);
      this.Op4.setText(this.op[3]);
   }

   public boolean isAcierto() {
      return this.acierto;
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.jLabel1 = new JLabel();
      this.jLabel3 = new JLabel();
      this.Pregunta = new JLabel();
      this.Op1 = new JRadioButton();
      this.Op2 = new JRadioButton();
      this.Op3 = new JRadioButton();
      this.Op4 = new JRadioButton();
      this.Enviar = new JButton();
      this.jLabel2 = new JLabel();
      this.setDefaultCloseOperation(2);
      this.setTitle("Desafio");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(27, 22, -1, -1));
      this.jLabel3.setHorizontalAlignment(0);
      this.jLabel3.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/DesafioImagen/desafio.png")));
      this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(0, 20, 600, -1));
      this.Pregunta.setFont(new Font("Arial", 1, 14));
      this.Pregunta.setForeground(new Color(255, 255, 255));
      this.Pregunta.setHorizontalAlignment(0);
      this.Pregunta.setText("jLabel4");
      this.jPanel1.add(this.Pregunta, new AbsoluteConstraints(321, 126, 260, 190));
      this.Op1.setFont(new Font("Arial Black", 1, 12));
      this.Op1.setForeground(new Color(255, 255, 255));
      this.Op1.setText("Op1");
      this.Op1.setOpaque(false);
      this.jPanel1.add(this.Op1, new AbsoluteConstraints(40, 130, 270, -1));
      this.Op2.setFont(new Font("Arial Black", 1, 12));
      this.Op2.setForeground(new Color(255, 255, 255));
      this.Op2.setText("Op2");
      this.Op2.setOpaque(false);
      this.jPanel1.add(this.Op2, new AbsoluteConstraints(40, 170, 270, -1));
      this.Op3.setFont(new Font("Arial Black", 1, 12));
      this.Op3.setForeground(new Color(255, 255, 255));
      this.Op3.setText("Op3");
      this.Op3.setOpaque(false);
      this.jPanel1.add(this.Op3, new AbsoluteConstraints(40, 210, 270, -1));
      this.Op4.setFont(new Font("Arial Black", 1, 12));
      this.Op4.setForeground(new Color(255, 255, 255));
      this.Op4.setText("Op4");
      this.Op4.setOpaque(false);
      this.jPanel1.add(this.Op4, new AbsoluteConstraints(40, 250, 270, -1));
      this.Enviar.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/DesafioImagen/EnviarButton.png")));
      this.Enviar.setBorderPainted(false);
      this.Enviar.setContentAreaFilled(false);
      this.Enviar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Desafios.this.EnviarActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Enviar, new AbsoluteConstraints(100, 280, -1, -1));
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/DesafioImagen/DesafioBackground.gif")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 0, -1, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void EnviarActionPerformed(ActionEvent evt) {
      if (this.Op1.isSelected()) {
         if (this.opCorrecta == 0) {
            this.acierto = true;
         } else {
            this.acierto = false;
         }
      } else if (this.Op2.isSelected()) {
         if (this.opCorrecta == 1) {
            this.acierto = true;
         } else {
            this.acierto = false;
         }
      } else if (this.Op3.isSelected()) {
         if (this.opCorrecta == 2) {
            this.acierto = true;
         } else {
            this.acierto = false;
         }
      } else if (this.Op4.isSelected()) {
         if (this.opCorrecta == 3) {
            this.acierto = true;
         } else {
            this.acierto = false;
         }
      }

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
         Logger.getLogger(Desafios.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Desafios.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Desafios.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Desafios.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            Desafios dialog = new Desafios(new JFrame(), true);
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
