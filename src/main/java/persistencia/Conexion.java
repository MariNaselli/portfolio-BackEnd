/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author Daskalos
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class Conexion {

    // private String url = "jdbc:mysql://127.0.0.1:3306/portfolio_web";
    // private String username = "root";
    // private String password = "mari122527";
    public Conexion() {

    }

    public static Connection getConnection() throws SQLException {
        // Conexión a la base de datos
        //String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10606392";
        //String usuario = "sql10606392";
        //String contrasena = "4VMaa4kKyE";

        String url = "jdbc:mysql://127.0.0.1:3306/portfolio_web";
        String usuario = "root";
        String contrasena = "mari122527";

        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
