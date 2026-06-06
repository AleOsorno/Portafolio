package proyectolabo;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Animacion extends JPanel implements Runnable {
   private Thread hilo;
   private int incremento = 0;
   private int width;
   private int height;
   private BufferedImage buffer;
   private Image img;
   private Toolkit herramienta;
   private int cuadros;

   public Animacion(String Imagen, int width, int height, int cuadros) {
      this.setPreferredSize(new Dimension(width, height));
      this.setOpaque(false);
      this.width = width;
      this.height = height;
      this.cuadros = cuadros;
      this.hilo = new Thread(this);
      this.buffer = new BufferedImage(width, height, 2);
      this.herramienta = Toolkit.getDefaultToolkit();
      this.img = this.herramienta.getImage(this.getClass().getResource(Imagen));
      this.hilo.start();
   }

   public void setImg(String Imagen) {
      this.img = this.herramienta.getImage(this.getClass().getResource(Imagen));
      this.incremento = 0;
      this.repaint();
   }

   public void paint(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2D = this.buffer.createGraphics();
      g2D.setComposite(AlphaComposite.Clear);
      g2D.fillRect(0, 0, this.width, this.height);
      g2D.setComposite(AlphaComposite.SrcOver);
      int mx = this.incremento % this.cuadros * this.width;
      g2D.drawImage(this.img, 0, 0, this.width, this.height, mx, 0, mx + this.width, this.height, this);
      g.drawImage(this.buffer, 0, 0, this);
   }

   public void run() {
      while(true) {
         try {
            Thread.sleep(150L);
         } catch (InterruptedException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, (String)null, ex);
         }

         ++this.incremento;
         if (this.incremento >= this.cuadros) {
            this.incremento = 0;
         }

         this.repaint();
      }
   }
}
