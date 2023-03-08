/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import clases.Item;
import clases.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daskalos
 */
public class SeccionDAO {

    public Seccion obtenerPorCodigoPersona(int _codigoPersona, int _codigoSeccion) throws SQLException {
        // Consulta a la base de datos
        String sql = "SELECT s.codigo_seccion, s.nombre_seccion, s.orden, "
                + "i.codigo_item, i.nombre, i.titulo, i.periodo, i.descripcion, i.url, i.nivel_progreso, i.eliminado "
                + "FROM secciones s "
                + "INNER JOIN items i ON s.codigo_seccion = i.codigo_seccion "
                + "WHERE i.codigo_persona = ? "
                + "AND s.codigo_seccion = ? "
                + "AND i.eliminado = 0";
        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, _codigoPersona);
            pstmt.setInt(2, _codigoSeccion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Creación del objeto seccion a partir de los resultados de la consulta
                int codigoSeccion = rs.getInt("codigo_seccion");
                String nombreSeccion = rs.getString("nombre_seccion");
                int orden = rs.getInt("orden");
                List<Item> items = new ArrayList<>();
                do {
                    int codigoItem = rs.getInt("codigo_item");
                    String nombre = rs.getString("nombre");
                    String titulo = rs.getString("titulo");
                    String periodo = rs.getString("periodo");
                    String descripcion = rs.getString("descripcion");
                    String url = rs.getString("url");
                    int nivelProgreso = rs.getInt("nivel_progreso");
                    int eliminado = rs.getInt("eliminado");
                    items.add(new Item(codigoItem, nombre, titulo, periodo, descripcion, url, nivelProgreso, eliminado, _codigoPersona, codigoSeccion));
                } while (rs.next());

                return new Seccion(codigoSeccion, nombreSeccion, orden, items);
            } else {
                return null;
            }
        }
    }

}
