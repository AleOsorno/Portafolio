/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectolabo;

/**
 *
 * @author alexo
 */
public class PROYECTOLABO {

    /**
     * @param args the command line argumentss
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Datos Datos = new Datos();//creamos el objeto datos que pasara por todas nuestras clases e inicializa la base de datos antes que todo lo demás
        new Menu(Datos).setVisible(true);//llamamos al JFrame menu
    }
    
}
