/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectolabo;

/**
 *
 * @author alexo
 */
public class Pregunta {
    private int id;
    private String pregunta;
    private int correcto;
    private int tiempo;
    private String[] opciones = new String[4];

    public Pregunta(int id, String pregunta, int correcto, int tiempo, String[] opciones) {
        this.id = id;
        this.pregunta = pregunta;
        this.correcto = correcto;
        this.tiempo = tiempo;
        this.opciones = opciones;
    }

    public int getId() {
        return id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public int getCorrecto() {
        return correcto;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String[] getOpciones() {
        return opciones;
    }
}
