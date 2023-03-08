/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daskalos
 */
public class Conexion {

    public static Connection getConnection() throws SQLException {
        // Conexión a la base de datos
        String url = "jdbc:mysql://127.0.0.1:3306/portfolio_web";
        String usuario = "root";
        String contrasena = "mari122527";
        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
