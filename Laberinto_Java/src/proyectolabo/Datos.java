package proyectolabo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Datos {
   private ArrayList<Jugador> array_jugadores = new ArrayList();
   private ArrayList<Partida> array_partidas = new ArrayList();
   private Connection conn;
   private final String DB_NAME = "laberintolabo";
   private final String URL_DB = "jdbc:mysql://localhost:3306/laberintolabo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
   private final String URL_ROOT = "jdbc:mysql://localhost:3306/";
   private final String USER = "root";
   private final String PASS = "";

   public Datos() {
      try {
         Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");

         try {
            Statement st = c.createStatement();

            try {
               st.executeUpdate("CREATE DATABASE IF NOT EXISTS laberintolabo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci");
            } catch (Throwable var10) {
               if (st != null) {
                  try {
                     st.close();
                  } catch (Throwable var8) {
                     var10.addSuppressed(var8);
                  }
               }

               throw var10;
            }

            if (st != null) {
               st.close();
            }
         } catch (Throwable var11) {
            if (c != null) {
               try {
                  c.close();
               } catch (Throwable var7) {
                  var11.addSuppressed(var7);
               }
            }

            throw var11;
         }

         if (c != null) {
            c.close();
         }

         this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laberintolabo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "");
         String ddlJugadores = "    CREATE TABLE IF NOT EXISTS jugadores (\n      id           INT AUTO_INCREMENT PRIMARY KEY,\n      nombre       VARCHAR(50)    NOT NULL,\n      edad         VARCHAR(10)    NOT NULL,\n      sexo         VARCHAR(10)    NOT NULL,\n      usuario      VARCHAR(50)    NOT NULL UNIQUE,\n      password     VARCHAR(100)   NOT NULL,\n      puntuacionMAX  INT            NOT NULL DEFAULT 0\n    );\n";
         String ddlPartidas = "    CREATE TABLE IF NOT EXISTS partida (\n      id          INT(11) AUTO_INCREMENT PRIMARY KEY,\n      nombre      TEXT       NOT NULL,\n      hora_inicio TEXT       NOT NULL,\n      fecha       TEXT       NOT NULL,\n      hora_final  TEXT,\n      estado      TEXT       NOT NULL\n    );\n";
         Statement st = this.conn.createStatement();

         try {
            st.execute(ddlJugadores);
            st.execute(ddlPartidas);
         } catch (Throwable var9) {
            if (st != null) {
               try {
                  st.close();
               } catch (Throwable var6) {
                  var9.addSuppressed(var6);
               }
            }

            throw var9;
         }

         if (st != null) {
            st.close();
         }

         this.limpiarPartidasSinJugador();
         this.obtener();
         this.obtenerPartidas();
      } catch (SQLException ex) {
         ex.printStackTrace();
      }

   }

   private void obtener() throws SQLException {
      String sql = "SELECT nombre, edad, sexo, usuario, password, puntuacionMAX FROM jugadores";
      Statement st = this.conn.createStatement();

      try {
         ResultSet rs = st.executeQuery(sql);

         try {
            while(rs.next()) {
               Jugador j = new Jugador(rs.getString("nombre"), rs.getString("edad"), rs.getString("sexo"), rs.getString("usuario"), rs.getString("password"), rs.getInt("puntuacionMAX"));
               this.array_jugadores.add(j);
            }
         } catch (Throwable var8) {
            if (rs != null) {
               try {
                  rs.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
               }
            }

            throw var8;
         }

         if (rs != null) {
            rs.close();
         }
      } catch (Throwable var9) {
         if (st != null) {
            try {
               st.close();
            } catch (Throwable var6) {
               var9.addSuppressed(var6);
            }
         }

         throw var9;
      }

      if (st != null) {
         st.close();
      }

   }

   private void obtenerPartidas() throws SQLException {
      String sql = "SELECT id, nombre, hora_inicio, fecha, hora_final, estado FROM partida";
      Statement st = this.conn.createStatement();

      try {
         ResultSet rs = st.executeQuery("SELECT id, nombre, hora_inicio, fecha, hora_final, estado FROM partida");

         try {
            while(rs.next()) {
               this.array_partidas.add(new Partida(rs.getString("nombre"), rs.getString("hora_inicio"), rs.getString("fecha"), rs.getString("hora_final"), rs.getString("estado")));
            }
         } catch (Throwable var8) {
            if (rs != null) {
               try {
                  rs.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
               }
            }

            throw var8;
         }

         if (rs != null) {
            rs.close();
         }
      } catch (Throwable var9) {
         if (st != null) {
            try {
               st.close();
            } catch (Throwable var6) {
               var9.addSuppressed(var6);
            }
         }

         throw var9;
      }

      if (st != null) {
         st.close();
      }

   }

   public void eliminarJugadores(String usuario) {
      String sql = "DELETE FROM jugadores WHERE usuario = ?";

      try {
         PreparedStatement ps = this.conn.prepareStatement("DELETE FROM jugadores WHERE usuario = ?");

         try {
            ps.setString(1, usuario);
            ps.executeUpdate();
         } catch (Throwable var7) {
            if (ps != null) {
               try {
                  ps.close();
               } catch (Throwable var6) {
                  var7.addSuppressed(var6);
               }
            }

            throw var7;
         }

         if (ps != null) {
            ps.close();
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
      }

      if (!this.array_jugadores.isEmpty()) {
         for(int i = 0; i < this.array_jugadores.size(); ++i) {
            if (((Jugador)this.array_jugadores.get(i)).getUser().equals(usuario)) {
               this.array_jugadores.remove(i);
            }
         }
      }

      if (!this.array_partidas.isEmpty()) {
         for(int i = this.array_partidas.size() - 1; i >= 0; --i) {
            if (((Partida)this.array_partidas.get(i)).getNombre().equals(usuario)) {
               this.array_partidas.remove(i);
            }
         }
      }

      this.limpiarPartidasSinJugador();
   }

   private void limpiarPartidasSinJugador() {
      String sql = "    DELETE p\n    FROM partida p\n    LEFT JOIN jugadores j\n      ON p.nombre = j.usuario\n    WHERE j.usuario IS NULL;\n";

      try {
         Statement st = this.conn.createStatement();

         try {
            st.executeUpdate("    DELETE p\n    FROM partida p\n    LEFT JOIN jugadores j\n      ON p.nombre = j.usuario\n    WHERE j.usuario IS NULL;\n");
         } catch (Throwable var6) {
            if (st != null) {
               try {
                  st.close();
               } catch (Throwable var5) {
                  var6.addSuppressed(var5);
               }
            }

            throw var6;
         }

         if (st != null) {
            st.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void agregaJugador(Jugador obJugador) {
      String sql = "    INSERT INTO jugadores(nombre, edad, sexo, usuario, password,puntuacionMAX)\n    VALUES (?, ?, ?, ?, ?,?)\n";

      try {
         PreparedStatement ps = this.conn.prepareStatement(sql);

         try {
            ps.setString(1, obJugador.getNombre());
            ps.setString(2, obJugador.getEdad());
            ps.setString(3, obJugador.getSexo());
            ps.setString(4, obJugador.getUser());
            ps.setString(5, obJugador.getPass());
            ps.setInt(6, obJugador.getPuntuacionMax());
            ps.executeUpdate();
            this.array_jugadores.add(obJugador);
         } catch (Throwable var7) {
            if (ps != null) {
               try {
                  ps.close();
               } catch (Throwable var6) {
                  var7.addSuppressed(var6);
               }
            }

            throw var7;
         }

         if (ps != null) {
            ps.close();
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
      }

   }

   public void agregarPartida(Partida p) {
      String sql = "    INSERT INTO partida(nombre, hora_inicio, fecha, hora_final, estado)\n    VALUES (?, ?, ?, ?, ?);\n";

      try {
         PreparedStatement ps = this.conn.prepareStatement("    INSERT INTO partida(nombre, hora_inicio, fecha, hora_final, estado)\n    VALUES (?, ?, ?, ?, ?);\n", 1);

         try {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getHoraI());
            ps.setString(3, p.getFecha());
            ps.setString(4, p.getHoraF());
            ps.setString(5, p.getEstado());
            ps.executeUpdate();
            this.array_partidas.add(p);
         } catch (Throwable var7) {
            if (ps != null) {
               try {
                  ps.close();
               } catch (Throwable var6) {
                  var7.addSuppressed(var6);
               }
            }

            throw var7;
         }

         if (ps != null) {
            ps.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void insertarPuntuacion(String usuario, int puntuacion) {
      String sql = "  UPDATE jugadores\n  SET puntuacionMAX = GREATEST(puntuacionMAX, ?)\n  WHERE usuario = ?\n";

      try {
         PreparedStatement ps = this.conn.prepareStatement(sql);

         try {
            ps.setInt(1, puntuacion);
            ps.setString(2, usuario);
            ps.executeUpdate();
         } catch (Throwable var8) {
            if (ps != null) {
               try {
                  ps.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
               }
            }

            throw var8;
         }

         if (ps != null) {
            ps.close();
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
      }

   }

   public int verificaUser(String user, String pass) {
      for(Jugador e : this.array_jugadores) {
         if (e.getUser().equals(user)) {
            if (e.getPass().equals(pass)) {
               return this.array_jugadores.indexOf(e);
            }

            return -1;
         }
      }

      return -2;
   }

   public ArrayList<Jugador> getArray_jugadores() {
      return this.array_jugadores;
   }

   public ArrayList<Partida> getArray_partidas() {
      return this.array_partidas;
   }
}
