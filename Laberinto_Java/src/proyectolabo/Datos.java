/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectolabo;

import java.util.*;
import java.sql.*;

/**
 *
 * @author alexo
 */
public class Datos {
    private ArrayList<Jugador> array_jugadores;//jugadores en memoria 
    private ArrayList<Partida> array_partidas;//partidas en memoria
    private Connection conn;//conexion con la bd
    private final String DB_NAME = "laberintolabo";
    private final String URL_DB  = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private final String URL_ROOT= "jdbc:mysql://localhost:3306/"; // sin BD
    private final String USER = "root";
    private final String PASS = "";
    
    public Datos(){
        this.array_jugadores = new ArrayList<>();
        this.array_partidas = new ArrayList<>();
        
        try {
            try (Connection c = DriverManager.getConnection(URL_ROOT, USER, PASS);//crear BD si no exite
                Statement  st = c.createStatement()) {

                st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME + " CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci");
            }
            conn = DriverManager.getConnection(URL_DB, USER, PASS);//conectar a la BD
            
            //crear tablas sino existen
            String ddlJugadores = """
                CREATE TABLE IF NOT EXISTS jugadores (
                  id           INT AUTO_INCREMENT PRIMARY KEY,
                  nombre       VARCHAR(50)    NOT NULL,
                  edad         VARCHAR(10)    NOT NULL,
                  sexo         VARCHAR(10)    NOT NULL,
                  usuario      VARCHAR(50)    NOT NULL UNIQUE,
                  password     VARCHAR(100)   NOT NULL,
                  puntuacionMAX  INT            NOT NULL DEFAULT 0
                );
            """;
            String ddlPartidas = """
                CREATE TABLE IF NOT EXISTS partida (
                  id          INT(11) AUTO_INCREMENT PRIMARY KEY,
                  nombre      TEXT       NOT NULL,
                  hora_inicio TEXT       NOT NULL,
                  fecha       TEXT       NOT NULL,
                  hora_final  TEXT,
                  estado      TEXT       NOT NULL
                );
            """;
            try (Statement st = conn.createStatement()) {
                st.execute(ddlJugadores);
                st.execute(ddlPartidas);
            }
            //sincronizar datos en los arrayList
            limpiarPartidasSinJugador();
            obtener();
            obtenerPartidas();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    private void obtener() throws SQLException {//guarda a los jugadores de la BD en el array_jugadores
        String sql = "SELECT nombre, edad, sexo, usuario, password, puntuacionMAX FROM jugadores";//extraemos los valores y construimos al jugador
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Jugador j = new Jugador(
                    rs.getString("nombre"),
                    rs.getString("edad"),
                    rs.getString("sexo"),
                    rs.getString("usuario"),
                    rs.getString("password"),
                    rs.getInt("puntuacionMAX")
                );
                array_jugadores.add(j);
            }
        }
    }
    
    private void obtenerPartidas() throws SQLException {//guarda las partidas de la BD en el array_partidas
        final String sql = "SELECT id, nombre, hora_inicio, fecha, hora_final, estado FROM partida";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                array_partidas.add(new Partida(
                    rs.getString("nombre"),
                    rs.getString("hora_inicio"),
                    rs.getString("fecha"),
                    rs.getString("hora_final"),
                    rs.getString("estado")
                ));
            }
        }
    }
    
    public void eliminarJugadores(String usuario){//elimina a los jugadores seleccionados
        final String sql = "DELETE FROM jugadores WHERE usuario = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(!array_jugadores.isEmpty()){
            for(int i = 0; i < array_jugadores.size(); i++) {
                if(array_jugadores.get(i).getUser().equals(usuario)){
                    array_jugadores.remove(i);
                }
            }
        }
        
        if(!array_partidas.isEmpty()){
            for(int i = array_partidas.size()-1; i >= 0; i--) {
                if(array_partidas.get(i).getNombre().equals(usuario)){
                    array_partidas.remove(i);
                }
            }
        }

        limpiarPartidasSinJugador();
    }
    
    private void limpiarPartidasSinJugador() {//se asegura de no tener partidas de algun jugador no existente
        final String sql = """
            DELETE p
            FROM partida p
            LEFT JOIN jugadores j
              ON p.nombre = j.usuario       
            WHERE j.usuario IS NULL;
        """;
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void agregaJugador(Jugador obJugador){//insertamos los jugadores nuevos
        String sql = """
            INSERT INTO jugadores(nombre, edad, sexo, usuario, password,puntuacionMAX)
            VALUES (?, ?, ?, ?, ?,?)
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obJugador.getNombre());
            ps.setString(2, obJugador.getEdad());
            ps.setString(3, obJugador.getSexo());
            ps.setString(4, obJugador.getUser());
            ps.setString(5, obJugador.getPass());
            ps.setInt(6, obJugador.getPuntuacionMax());
            ps.executeUpdate();
            array_jugadores.add(obJugador);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void agregarPartida(Partida p) {//insertamos las nuevas partidas
        final String sql = """
            INSERT INTO partida(nombre, hora_inicio, fecha, hora_final, estado)
            VALUES (?, ?, ?, ?, ?);
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getHoraI());
            ps.setString(3, p.getFecha());
            ps.setString(4, p.getHoraF());
            ps.setString(5, p.getEstado());

            ps.executeUpdate();
            array_partidas.add(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertarPuntuacion(String usuario,int puntuacion){//insertamos la puntuación maxima de los usuarios
         String sql = """
            UPDATE jugadores
            SET puntuacionMAX = GREATEST(puntuacionMAX, ?)
            WHERE usuario = ?
          """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
          ps.setInt(1, puntuacion);
          ps.setString(2, usuario);
          ps.executeUpdate();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
    }
    
    public int verificaUser(String user, String pass){//verificamos que el usuario exista
        
        for(Jugador e : this.array_jugadores){
            if(e.getUser().equals(user)){
                if(e.getPass().equals(pass)){
                    return this.array_jugadores.indexOf(e);
                }else{
                    return -1;
                }
            }
        }
        return -2;
    }

    public ArrayList<Jugador> getArray_jugadores() {
        return array_jugadores;
    }

    public ArrayList<Partida> getArray_partidas() {
        return array_partidas;
    }
}
