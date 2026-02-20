package Gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {

    private static final String url = "jdbc:postgresql://localhost:5432/BarProyecto";
    private static final String usuario = "postgres";
    private static final String clave = "luisno";
    private static Connection conn = null;
    
    public static Connection getConnection() throws SQLException {
        if(conn == null || conn.isClosed()) {
            conectar();
        }
        return conn;
    }
    
    public static void conectar() {
        try {
            conn = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public static void live() throws SQLException {
        if(conn == null || conn.isClosed()) {
            conectar();
        }
    }

}
