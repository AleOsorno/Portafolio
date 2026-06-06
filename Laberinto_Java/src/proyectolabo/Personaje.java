package proyectolabo;

public class Personaje {
   private String nombre;
   private String ImagenArribaSeleccion;
   private String ImagenAbajoSeleccion;
   private String ImagenIzquierdaSeleccion;
   private String ImagenDerechaSeleccion;
   private String ImagenArribaLab;
   private String ImagenAbajoLab;
   private String ImagenIzquierdaLab;
   private String ImagenDerechaLab;
   private String ImagenArribaLab2;
   private String ImagenAbajoLab2;
   private String ImagenIzquierdaLab2;
   private String ImagenDerechaLab2;

   public Personaje(String nombre, String ImagenAbajoSeleccion, String ImagenIzquierdaSeleccion, String ImagenDerechaSeleccion, String ImagenArribaSeleccion, String ImagenAbajoLab, String ImagenIzquierdaLab, String ImagenDerechaLab, String ImagenArribaLab, String ImagenAbajoLab2, String ImagenIzquierdaLab2, String ImagenDerechaLab2, String ImagenArribaLab2) {
      this.nombre = nombre;
      this.ImagenArribaSeleccion = ImagenArribaSeleccion;
      this.ImagenAbajoSeleccion = ImagenAbajoSeleccion;
      this.ImagenIzquierdaSeleccion = ImagenIzquierdaSeleccion;
      this.ImagenDerechaSeleccion = ImagenDerechaSeleccion;
      this.ImagenArribaLab = ImagenArribaLab;
      this.ImagenAbajoLab = ImagenAbajoLab;
      this.ImagenIzquierdaLab = ImagenIzquierdaLab;
      this.ImagenDerechaLab = ImagenDerechaLab;
      this.ImagenArribaLab2 = ImagenArribaLab2;
      this.ImagenAbajoLab2 = ImagenAbajoLab2;
      this.ImagenIzquierdaLab2 = ImagenIzquierdaLab2;
      this.ImagenDerechaLab2 = ImagenDerechaLab2;
   }

   public String getNombre() {
      return this.nombre;
   }

   public String getImagenArribaSeleccion() {
      return this.ImagenArribaSeleccion;
   }

   public String getImagenAbajoSeleccion() {
      return this.ImagenAbajoSeleccion;
   }

   public String getImagenIzquierdaSeleccion() {
      return this.ImagenIzquierdaSeleccion;
   }

   public String getImagenDerechaSeleccion() {
      return this.ImagenDerechaSeleccion;
   }

   public String getImagenArribaLab() {
      return this.ImagenArribaLab;
   }

   public String getImagenAbajoLab() {
      return this.ImagenAbajoLab;
   }

   public String getImagenIzquierdaLab() {
      return this.ImagenIzquierdaLab;
   }

   public String getImagenDerechaLab() {
      return this.ImagenDerechaLab;
   }

   public String getImagenArribaLab2() {
      return this.ImagenArribaLab2;
   }

   public String getImagenAbajoLab2() {
      return this.ImagenAbajoLab2;
   }

   public String getImagenIzquierdaLab2() {
      return this.ImagenIzquierdaLab2;
   }

   public String getImagenDerechaLab2() {
      return this.ImagenDerechaLab2;
   }
}
