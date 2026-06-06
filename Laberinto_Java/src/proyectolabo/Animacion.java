/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author alexo
 */
public class Animacion extends JPanel implements Runnable {

    private Thread hilo;//hilo que ejecuta el bucle de animacion
    private int incremento = 0;//indice del fotograma
    private int width;//dimensiones del fotograma
    private int height;
    private BufferedImage buffer;//buffer que evita parpadeos
    private Image img;//sprite de 4 fotogramas o mas en una fila
    private Toolkit herramienta;//herramienta para cargar imagenes
    private int cuadros;

    public Animacion(String Imagen, int width, int height, int cuadros){
        setPreferredSize(new Dimension(width, height));
        setOpaque(false);
        
        this.width = width;
        this.height = height;
        this.cuadros = cuadros;
        
        hilo = new Thread(this);
        buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        herramienta = Toolkit.getDefaultToolkit();
        img = herramienta.getImage(getClass().getResource(Imagen));
        hilo.start();
    }
    
    public void setImg(String Imagen){
        img = herramienta.getImage(getClass().getResource(Imagen));
        incremento = 0;//volvemos al primer fotograma con otra imagen
        repaint();
    }
    
    @Override
    public void paint(Graphics g){//dibujamos el fotograma actual en el buffer y lo copiamos al panel
        super.paintComponent(g);
        
        Graphics2D g2D;//limpiamos el buffer
        g2D = buffer.createGraphics();
        g2D.setComposite(AlphaComposite.Clear);
        g2D.fillRect(0, 0, width, height);//restauramos el dibujo
        g2D.setComposite(AlphaComposite.SrcOver);
        
        int mx = (incremento%this.cuadros)*width;//calculamos la posición X del fotograma actual
        g2D.drawImage(img,0,0,width,height,mx,0,mx+width,height,this);
        
        g.drawImage(buffer,0,0,this);
    }
    
    @Override
    public void run() {
        while(true){//incrementamos el rango del indice y lo mantenemos en 0-3.
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            incremento++;
            
            if(incremento >= this.cuadros){
                incremento = 0;
            }
            repaint();
        }
    }
}
