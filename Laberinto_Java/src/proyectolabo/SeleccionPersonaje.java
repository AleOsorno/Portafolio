package proyectolabo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class SeleccionPersonaje extends JFrame {
   private int posicion;
   private ArrayList<Personaje> personajes;
   private Animacion animacion;
   private Jugador jugador;
   private String dificultad;
   private Datos datos;
   private JButton Derecha;
   private JButton Izquierda;
   private JPanel PanelPersonaje;
   private JButton START;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JPanel jPanel1;

   public SeleccionPersonaje() {
      this.initComponents();
   }

   public SeleccionPersonaje(ArrayList<Personaje> personajes, Jugador jugador, String dificultad, Datos datos) {
      this.initComponents();
      this.personajes = personajes;
      this.jugador = jugador;
      this.dificultad = dificultad;
      this.datos = datos;
      this.setLocationRelativeTo((Component)null);
      this.setDefaultCloseOperation(3);
      this.getContentPane().setBackground(new Color(182, 177, 202));
      this.jPanel1.setBackground(new Color(182, 177, 202));
      this.Izquierda.setBorderPainted(false);
      this.Izquierda.setContentAreaFilled(false);
      this.Izquierda.setFocusPainted(false);
      this.Izquierda.setOpaque(false);
      this.Derecha.setBorderPainted(false);
      this.Derecha.setContentAreaFilled(false);
      this.Derecha.setFocusPainted(false);
      this.Derecha.setOpaque(false);
      this.START.setBorderPainted(false);
      this.START.setContentAreaFilled(false);
      this.START.setFocusPainted(false);
      this.START.setOpaque(false);
      this.PanelPersonaje.setLayout(new BorderLayout());
      this.PanelPersonaje.setPreferredSize(new Dimension(156, 110));
      this.animacion = new Animacion(((Personaje)personajes.get(this.posicion)).getImagenAbajoSeleccion(), 156, 110, 4);
      this.PanelPersonaje.add(this.animacion, "Center");
      this.PanelPersonaje.revalidate();
      this.PanelPersonaje.repaint();
      this.pack();
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.PanelPersonaje = new JPanel();
      this.Derecha = new JButton();
      this.Izquierda = new JButton();
      this.START = new JButton();
      this.jLabel2 = new JLabel();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Seleccionar personaje");
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.PanelPersonaje.setOpaque(false);
      GroupLayout PanelPersonajeLayout = new GroupLayout(this.PanelPersonaje);
      this.PanelPersonaje.setLayout(PanelPersonajeLayout);
      PanelPersonajeLayout.setHorizontalGroup(PanelPersonajeLayout.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      PanelPersonajeLayout.setVerticalGroup(PanelPersonajeLayout.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      this.jPanel1.add(this.PanelPersonaje, new AbsoluteConstraints(190, 170, -1, -1));
      this.Derecha.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/SeleccionImagen/Derecha.png")));
      this.Derecha.setBorderPainted(false);
      this.Derecha.setContentAreaFilled(false);
      this.Derecha.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            SeleccionPersonaje.this.DerechaActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Derecha, new AbsoluteConstraints(390, 170, -1, -1));
      this.Izquierda.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/SeleccionImagen/Izquierda.png")));
      this.Izquierda.setToolTipText("");
      this.Izquierda.setBorderPainted(false);
      this.Izquierda.setContentAreaFilled(false);
      this.Izquierda.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            SeleccionPersonaje.this.IzquierdaActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Izquierda, new AbsoluteConstraints(10, 170, -1, -1));
      this.START.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/SeleccionImagen/SeleccionarButton_1.png")));
      this.START.setBorderPainted(false);
      this.START.setContentAreaFilled(false);
      this.START.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            SeleccionPersonaje.this.STARTActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.START, new AbsoluteConstraints(170, 330, -1, -1));
      this.jLabel2.setHorizontalAlignment(0);
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/SeleccionImagen/PersonajesLetras.png")));
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 40, 520, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/proyectolabo/SeleccionImagen/seleccionBackground.jpg")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, 520, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void IzquierdaActionPerformed(ActionEvent evt) {
      if (this.posicion <= 0) {
         this.posicion = 3;
      } else {
         --this.posicion;
      }

      this.PanelPersonaje.removeAll();
      this.animacion.setImg(((Personaje)this.personajes.get(this.posicion)).getImagenAbajoSeleccion());
      this.PanelPersonaje.add(this.animacion, "Center");
      this.PanelPersonaje.revalidate();
      this.PanelPersonaje.repaint();
   }

   private void DerechaActionPerformed(ActionEvent evt) {
      if (this.posicion >= 3) {
         this.posicion = 0;
      } else {
         ++this.posicion;
      }

      this.PanelPersonaje.removeAll();
      this.animacion.setImg(((Personaje)this.personajes.get(this.posicion)).getImagenAbajoSeleccion());
      this.PanelPersonaje.add(this.animacion, "Center");
      this.PanelPersonaje.revalidate();
      this.PanelPersonaje.repaint();
   }

   private void STARTActionPerformed(ActionEvent evt) {
      this.jugador.setPersonaje((Personaje)this.personajes.get(this.posicion));
      (new Laberinto(this.jugador, this.dificultad, this.datos)).setVisible(true);
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
         Logger.getLogger(SeleccionPersonaje.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(SeleccionPersonaje.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(SeleccionPersonaje.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(SeleccionPersonaje.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new SeleccionPersonaje()).setVisible(true);
         }
      });
   }
}
