package proyectolabo;

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
      return this.id;
   }

   public String getPregunta() {
      return this.pregunta;
   }

   public int getCorrecto() {
      return this.correcto;
   }

   public int getTiempo() {
      return this.tiempo;
   }

   public String[] getOpciones() {
      return this.opciones;
   }
}
