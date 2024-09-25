package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection conexion;
    private final static String usuario = "Miguelyoc";
    private final static String clave = "Mikymcvd#16020";
    private final static int puerto = 3306;
    private final static String db = "usuariosdb";
    private final static String url = "jdbc:mysql://localhost:" + puerto + "/" + db;

    private ConexionDB(){

    }

    public static Connection obtenerConexion(){
        if(conexion == null || estaCerrada(conexion)){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, clave);
                System.out.println("Conexión a la base de datos exitosa");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        } return conexion;
    }

    public static void cerrarConexion() throws SQLException {
        if(conexion != null){
            conexion.close();
            System.out.println("Conexión a la base de datos cerrada");
        }
    }

    public static boolean estaCerrada(Connection conn) {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            System.err.println("Error al verificar el estado de la conexión.");
            e.printStackTrace();
            return true;
        }
    }


}
