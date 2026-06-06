package proyectolabo;

public class Partida {
   private String nombre;
   private String horaI;
   private String horaF;
   private String fecha;
   private String estado;

   public Partida(String nombre, String horaI, String fecha, String horaF, String estado) {
      this.nombre = nombre;
      this.horaI = horaI;
      this.horaF = horaF;
      this.fecha = fecha;
      this.estado = estado;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getHoraI() {
      return this.horaI;
   }

   public void setHoraI(String horaI) {
      this.horaI = horaI;
   }

   public String getHoraF() {
      return this.horaF;
   }

   public void setHoraF(String horaF) {
      this.horaF = horaF;
   }

   public String getFecha() {
      return this.fecha;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public String getEstado() {
      return this.estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }
}
