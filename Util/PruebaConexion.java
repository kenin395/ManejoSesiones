package Util;

import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        try {
            // Intentar conexión
            if (Conexion.getConnection() != null) {
                System.out.println("✅ Conexión exitosa a la base de datos.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
