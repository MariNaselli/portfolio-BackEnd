package persistencia;

import clases.Item;
import clases.Persona;
import clases.Portfolio;
import clases.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioDAO {
    
    public Portfolio obtenerPortfolioPorCodigoPersona(int _codigoPersona) throws SQLException {
        String sql = "SELECT "
                + "p.codigo 'codigo_persona', p.nombre 'nombre_persona', p.apellido, p.titulo 'titulo_persona', p.descripcion 'descripcion_persona', p.email, p.telefono, p.ubicacion, p.url_instagram, p.url_github, p.url_linkedin, p.url_foto, "
                + "s.codigo_seccion, s.nombre_seccion, s.orden, "
                + "i.codigo_item, i.nombre 'nombre_item', i.titulo 'titulo_item', i.periodo, i.descripcion 'descripcion_item', i.url, i.nivel_progreso, i.eliminado "
                + "FROM secciones s "
                + "INNER JOIN items i ON s.codigo_seccion = i.codigo_seccion "
                + "INNER JOIN personas p ON p.codigo = i.codigo_persona "
                + "WHERE i.codigo_persona = ? "
                + "AND i.eliminado = 0";
        
        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, _codigoPersona);
            ResultSet rs = pstmt.executeQuery();
            Map<Integer, Seccion> seccionesMap = new HashMap<>();
            Persona persona = null;
            
            while (rs.next()) {
                if (persona == null) {
                    int codigo = rs.getInt("codigo_persona");
                    String nombre = rs.getString("nombre_persona");
                    String apellido = rs.getString("apellido");
                    String titulo = rs.getString("titulo_persona");
                    String descripcion = rs.getString("descripcion_persona");
                    String email = rs.getString("email");
                    String telefono = rs.getString("telefono");
                    String ubicacion = rs.getString("ubicacion");
                    String urlInstagram = rs.getString("url_instagram");
                    String urlGithub = rs.getString("url_github");
                    String urlLinkedin = rs.getString("url_linkedin");
                    String urlFoto = rs.getString("url_foto");
                    persona = new Persona(codigo, nombre, apellido, titulo, descripcion, email, telefono, ubicacion, urlInstagram, urlGithub, urlLinkedin, null, urlFoto);
                }
                
                int codigoSeccion = rs.getInt("codigo_seccion");
                if (!seccionesMap.containsKey(codigoSeccion)) {
                    String nombreSeccion = rs.getString("nombre_seccion");
                    int orden = rs.getInt("orden");
                    List<Item> items = new ArrayList<>();
                    seccionesMap.put(codigoSeccion, new Seccion(codigoSeccion, nombreSeccion, orden, items));
                }
                
                int codigoItem = rs.getInt("codigo_item");
                String nombre = rs.getString("nombre_item");
                String titulo = rs.getString("titulo_item");
                String periodo = rs.getString("periodo");
                String descripcion = rs.getString("descripcion_item");
                String url = rs.getString("url");
                int nivelProgreso = rs.getInt("nivel_progreso");
                int eliminado = rs.getInt("eliminado");
                seccionesMap.get(codigoSeccion).addItem(new Item(codigoItem, nombre, titulo, periodo, descripcion, url,
                        nivelProgreso, eliminado, _codigoPersona, codigoSeccion));
            }
            
            List<Seccion> secciones = new ArrayList<>(seccionesMap.values());
            secciones.sort((s1, s2) -> s1.getOrden() - s2.getOrden());
            if (persona != null) {
                Portfolio portfolio = new Portfolio(persona, secciones);
                return portfolio;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
           
