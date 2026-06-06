package proyectolabo;

public class Jugador {
   private Personaje personaje;
   private int vidas;
   private int puntos;
   private int puntuacionMax;
   private String Nombre;
   private String edad;
   private String sexo;
   private String user;
   private String pass;

   public Jugador(String Nombre, String edad, String sexo, String user, String pass, int puntuacionMax) {
      this.Nombre = Nombre;
      this.edad = edad;
      this.sexo = sexo;
      this.user = user;
      this.pass = pass;
      this.puntuacionMax = puntuacionMax;
      this.setVidas(3);
      this.setPuntos(50);
   }

   public void sumarPuntos(int cantidad) {
      this.puntos += cantidad;
   }

   public void sumarVidas(int cantidad) {
      this.vidas += cantidad;
   }

   public void restarPuntos(int cantidad) {
      if (this.puntos - cantidad >= 0) {
         this.puntos -= cantidad;
      } else {
         this.puntos = 0;
      }

   }

   public void restarVidas(int cantidad) {
      if (this.vidas - cantidad >= 0) {
         this.vidas -= cantidad;
      } else {
         this.vidas = 0;
      }

   }

   public Personaje getPersonaje() {
      return this.personaje;
   }

   public String getUser() {
      return this.user;
   }

   public String getPass() {
      return this.pass;
   }

   public String getNombre() {
      return this.Nombre;
   }

   public String getEdad() {
      return this.edad;
   }

   public String getSexo() {
      return this.sexo;
   }

   public int getPuntuacionMax() {
      return this.puntuacionMax;
   }

   public void setPersonaje(Personaje personaje) {
      this.personaje = personaje;
   }

   public int getVidas() {
      return this.vidas;
   }

   public void setVidas(int vidas) {
      this.vidas = vidas;
   }

   public int getPuntos() {
      return this.puntos;
   }

   public void setPuntos(int puntos) {
      this.puntos = puntos;
   }

   public void setPuntuacionMax(int puntuacionMax) {
      this.puntuacionMax = puntuacionMax;
   }
}
