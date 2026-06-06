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

public class GANAROPERDER extends JFrame {
   private int puntos;
   private int vidas;
   private String nombre;
   private Datos datos;
   private String fecha;
   private String horaI;
   private JLabel LabelVidas;
   private JLabel PuntosLabel;
   private JLabel felicitacion;
   private JButton jButton1;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JPanel jPanel1;

   public GANAROPERDER() {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
   }

   public GANAROPERDER(int puntos, int vidas, String nombre, Datos datos, String fecha, String horaI) {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
      this.puntos = puntos;
      this.vidas = vidas;
      this.nombre = nombre;
      this.datos = datos;
      this.fecha = fecha;
      this.horaI = horaI;
      this.setLabelVidas();
      this.setPuntosLabel();
      this.setNombre();

      for(Jugador e : datos.getArray_jugadores()) {
         if (nombre.equals(e.getUser())) {
            if (e.getPuntuacionMax() < puntos) {
               e.setPuntuacionMax(puntos);
            }

            datos.insertarPuntuacion(e.getUser(), e.getPuntuacionMax());
         }
      }

      Date hora = new Date();
      DateFormat formato = new SimpleDateFormat("HH:mm:ss a");
      String horaF = formato.format(hora);
      String estado = "Ganado";
      Partida partida = new Partida(nombre, horaI, fecha, horaF, estado);
      datos.agregarPartida(partida);
   }

   private void setLabelVidas() {
      this.LabelVidas.setText("" + this.vidas);
   }

   private void setPuntosLabel() {
      this.PuntosLabel.setText("" + this.puntos);
   }

   private void setNombre() {
      this.felicitacion.setText("¡FELICIDADES: " + this.nombre + "!");
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.jButton1 = new JButton();
      this.jLabel2 = new JLabel();
      this.jLabel3 = new JLabel();
      this.LabelVidas = new JLabel();
      this.PuntosLabel = new JLabel();
      this.felicitacion = new JLabel();
      this.jLabel4 = new JLabel();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Ganar");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/GanarImagen/MenuButton.png")));
      this.jButton1.setBorderPainted(false);
      this.jButton1.setContentAreaFilled(false);
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            GANAROPERDER.this.jButton1ActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.jButton1, new AbsoluteConstraints(120, 510, -1, -1));
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/GanarImagen/Corazon.png")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(40, 440, -1, -1));
      this.jLabel3.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/GanarImagen/Puntuacion.png")));
      this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(330, 440, -1, -1));
      this.LabelVidas.setFont(new Font("Arial Black", 1, 14));
      this.LabelVidas.setForeground(new Color(255, 255, 255));
      this.LabelVidas.setText("_");
      this.jPanel1.add(this.LabelVidas, new AbsoluteConstraints(80, 440, 100, 30));
      this.PuntosLabel.setFont(new Font("Arial Black", 1, 14));
      this.PuntosLabel.setForeground(new Color(255, 255, 255));
      this.PuntosLabel.setHorizontalAlignment(4);
      this.PuntosLabel.setText("_");
      this.jPanel1.add(this.PuntosLabel, new AbsoluteConstraints(210, 441, 110, 30));
      this.felicitacion.setFont(new Font("Arial", 1, 18));
      this.felicitacion.setForeground(new Color(255, 255, 255));
      this.felicitacion.setHorizontalAlignment(0);
      this.felicitacion.setText("jLabel4");
      this.jPanel1.add(this.felicitacion, new AbsoluteConstraints(0, 350, 400, -1));
      this.jLabel4.setHorizontalAlignment(0);
      this.jLabel4.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/GanarImagen/bailecito.gif")));
      this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(0, 110, 400, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/GanarImagen/GanarBackground.png")));
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
         Logger.getLogger(GANAROPERDER.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(GANAROPERDER.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(GANAROPERDER.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(GANAROPERDER.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new GANAROPERDER()).setVisible(true);
         }
      });
   }
}
