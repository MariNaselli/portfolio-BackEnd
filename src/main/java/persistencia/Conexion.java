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
        String url = "jdbc:mysql://u3g0v5ifv2f3tjfi:Hkmqa7jlTMABJi8TFD26@bsgymph2iqvvqrnia5pu-mysql.services.clever-cloud.com:3306/bsgymph2iqvvqrnia5pu";
        String usuario = "u3g0v5ifv2f3tjfi";
        String contrasena = "Hkmqa7jlTMABJi8TFD26";

        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
