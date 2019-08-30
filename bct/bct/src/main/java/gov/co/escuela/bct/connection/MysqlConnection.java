package gov.co.escuela.bct.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	private static String url = "jdbc:mysql://localhost:3306/registroacademico";
    private static String usuario = "esc_judicial";
    private static String password = "escuela";
    private static Connection conexion = null;

    
    
    /**
     * metodo encargado de conectarse a la base de datos
     * @return 
     */
    public static Connection conectar() {
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la base de datos");
        }
        return conexion;
    }
    
    public static void desconectar() {
    	try {
			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

