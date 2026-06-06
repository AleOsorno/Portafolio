/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectolabo;

/**
 *
 * @author alexo
 */
public class Jugador {
    
    private Personaje personaje;
    private int vidas;
    private int puntos, puntuacionMax;
    private String Nombre,edad, sexo, user, pass;

    public Jugador(String Nombre, String edad, String sexo, String user, String pass, int puntuacionMax) {
        this.Nombre = Nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.user = user;
        this.pass = pass;
        this.puntuacionMax = puntuacionMax;
        setVidas(3);
        setPuntos(50);
    }
    
    public void sumarPuntos(int cantidad){
        puntos+=cantidad;
    }
    
    public void sumarVidas(int cantidad){
        vidas+=cantidad;
    }
    
    public void restarPuntos(int cantidad){
        if(puntos-cantidad >= 0){
            puntos-=cantidad;
        }else{
            puntos = 0;
        }
    }
    
    public void restarVidas(int cantidad){
        if(vidas-cantidad >= 0){
            vidas-=cantidad;
        }else{
            vidas = 0;
        }
    }

    public Personaje getPersonaje() {
        return personaje;
    }
    
    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public int getPuntuacionMax() {
        return puntuacionMax;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPuntuacionMax(int puntuacionMax) {
        this.puntuacionMax = puntuacionMax;
    }
    
}
