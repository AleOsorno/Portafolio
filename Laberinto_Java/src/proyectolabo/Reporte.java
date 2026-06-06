package proyectolabo;

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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Reporte extends JDialog {
   private Datos datos;
   private DefaultTableModel formato;
   private JTable TablaDatos;
   private JButton jButton1;
   private JButton jButton2;
   private JLabel jLabel1;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JPanel jPanel3;
   private JScrollPane jScrollPane1;
   private JToggleButton jToggleButton1;

   public Reporte(Frame parent, boolean modal) {
      super(parent, modal);
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
   }

   public Reporte(Frame parent, boolean modal, Datos datos) {
      super(parent, modal);
      this.initComponents();
      this.datos = datos;
      this.setLocationRelativeTo((Component)null);
      this.mostrarUsuarios();
   }

   private void mostrarUsuarios() {
      this.jLabel1.setText("Usuarios registrados");
      String[] cols = new String[]{"Nombre", "Usuario", "Contraseña", "Género", "Edad", "Puntuación Max"};
      this.formato = new DefaultTableModel((Object[][])null, cols) {
         public boolean isCellEditable(int r, int c) {
            return false;
         }
      };

      for(Jugador j : this.datos.getArray_jugadores()) {
         this.formato.addRow(new Object[]{j.getNombre(), j.getUser(), j.getPass(), j.getSexo(), j.getEdad(), j.getPuntuacionMax()});
      }

      this.TablaDatos.setModel(this.formato);
      this.TablaDatos.setDefaultEditor(Object.class, (TableCellEditor)null);
   }

   private void mostrarPartidas() {
      this.jLabel1.setText("Partidas registradas");
      String[] cols = new String[]{"ID", "Usuario", "Hora inicio", "Fecha", "Hora final", "Estado"};
      this.formato = new DefaultTableModel((Object[][])null, cols) {
         public boolean isCellEditable(int r, int c) {
            return false;
         }
      };
      int i = 1;

      for(Partida p : this.datos.getArray_partidas()) {
         this.formato.addRow(new Object[]{i, p.getNombre(), p.getHoraI(), p.getFecha(), p.getHoraF(), p.getEstado()});
         ++i;
      }

      this.TablaDatos.setModel(this.formato);
      this.TablaDatos.setDefaultEditor(Object.class, (TableCellEditor)null);
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.jScrollPane1 = new JScrollPane();
      this.TablaDatos = new JTable();
      this.jPanel2 = new JPanel();
      this.jLabel1 = new JLabel();
      this.jPanel3 = new JPanel();
      this.jToggleButton1 = new JToggleButton();
      this.jButton1 = new JButton();
      this.jButton2 = new JButton();
      this.setDefaultCloseOperation(2);
      this.setTitle("Reporte");
      this.TablaDatos.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}}, new String[]{"Nombre", "Usuario", "Contraseña", "Genero", "Edad", "Puntuacion Max"}) {
         Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class};

         public Class getColumnClass(int columnIndex) {
            return this.types[columnIndex];
         }
      });
      this.jScrollPane1.setViewportView(this.TablaDatos);
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 0, 32767).addContainerGap()));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 101, -2).addContainerGap(-1, 32767)));
      this.jLabel1.setFont(new Font("Rockwell Extra Bold", 1, 14));
      this.jLabel1.setHorizontalAlignment(0);
      this.jLabel1.setText("Usuarios registrados");
      GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
      this.jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -1, 573, 32767).addContainerGap()));
      jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -1, 23, 32767).addContainerGap()));
      this.jToggleButton1.setText("Ver Partidas");
      this.jToggleButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reporte.this.jToggleButton1ActionPerformed(evt);
         }
      });
      this.jButton1.setText("Salir");
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reporte.this.jButton1ActionPerformed(evt);
         }
      });
      this.jButton2.setText("Eliminar");
      this.jButton2.setToolTipText("");
      this.jButton2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reporte.this.jButton2ActionPerformed(evt);
         }
      });
      GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
      this.jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(76, 76, 76).addComponent(this.jToggleButton1).addGap(101, 101, 101).addComponent(this.jButton2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 61, -2).addGap(84, 84, 84)));
      jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jToggleButton1).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(-1, 32767)));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addContainerGap(20, 32767)));
      this.pack();
   }

   private void jToggleButton1ActionPerformed(ActionEvent evt) {
      if (this.jToggleButton1.isSelected()) {
         if (!this.datos.getArray_partidas().isEmpty()) {
            this.jButton2.setVisible(false);
            this.mostrarPartidas();
            this.jToggleButton1.setText("Ver Usuarios");
         } else {
            JOptionPane.showMessageDialog(this, "Sin partidas registradas", "Error", 0);
            this.jToggleButton1.setSelected(false);
            this.jToggleButton1.setText("Ver Partidas");
         }
      } else {
         this.jButton2.setVisible(true);
         this.mostrarUsuarios();
         this.jToggleButton1.setText("Ver Partidas");
      }

   }

   private void jButton1ActionPerformed(ActionEvent evt) {
      this.dispose();
   }

   private void jButton2ActionPerformed(ActionEvent evt) {
      int usuario = this.TablaDatos.getSelectedRow();
      if (usuario != -1) {
         String nombre = (String)this.formato.getValueAt(usuario, 1);
         this.datos.eliminarJugadores(nombre);
         this.mostrarUsuarios();
      } else {
         JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar", "Error", 0);
      }

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
         Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (InstantiationException ex) {
         Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (IllegalAccessException ex) {
         Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, (String)null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            Reporte dialog = new Reporte(new JFrame(), true);
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
