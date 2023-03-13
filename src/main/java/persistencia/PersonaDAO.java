/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import clases.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    Conexion conexion = new Conexion();

    public Persona obtenerPorCodigo(int codigo) throws SQLException {
        // Consulta a la base de datos
        String sql = "SELECT codigo, nombre, apellido, titulo, descripcion, email, telefono, ubicacion, url_instagram, url_github, url_linkedin, contraseña, url_foto FROM personas WHERE codigo = ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Creación del objeto persona a partir de los resultados de la consulta
                int codigoPersona = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String ubicacion = rs.getString("ubicacion");
                String urlInstagram = rs.getString("url_instagram");
                String urlGithub = rs.getString("url_github");
                String urlLinkedin = rs.getString("url_linkedin");
                String contrasena = rs.getString("contraseña");
                String url_foto = rs.getString("url_foto");

                return new Persona(codigoPersona, nombre, apellido, titulo, descripcion, email, telefono, ubicacion, urlInstagram, urlGithub, urlLinkedin, contrasena, url_foto);
            } else {
                return null;
            }
        }
    }

    public void actualizarPersona(Persona persona) throws SQLException {
        // Sentencia SQL para actualizar los datos de una persona
        String sql = "UPDATE personas SET nombre = ?, apellido = ?, titulo = ?, descripcion = ?, email = ?, telefono = ?, ubicacion = ?, url_instagram = ?, url_github = ?, url_linkedin = ?, contraseña = ?, url_foto = ? "
                + "WHERE codigo = ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Establecer los valores de los parámetros de la sentencia SQL
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido());
            pstmt.setString(3, persona.getTitulo());
            pstmt.setString(4, persona.getDescripcion());
            pstmt.setString(5, persona.getEmail());
            pstmt.setString(6, persona.getTelefono());
            pstmt.setString(7, persona.getUbicacion());
            pstmt.setString(8, persona.getUrlInstagram());
            pstmt.setString(9, persona.getUrlGithub());
            pstmt.setString(10, persona.getUrlLinkedin());
            pstmt.setString(11, persona.getContrasena());
            pstmt.setString(12, persona.getUrlFoto());
            pstmt.setInt(13, persona.getCodigo());
            // Ejecutar la sentencia SQL
            pstmt.executeUpdate();
        }
    }

    public List<Persona> listarPersonas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        // Consulta a la base de datos
        String sql = "SELECT codigo, nombre, apellido, titulo, descripcion, email, telefono, ubicacion, url_instagram, url_github, url_linkedin FROM personas";
        try (Connection conn = conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Creación del objeto persona a partir de los resultados de la consulta
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String ubicacion = rs.getString("ubicacion");
                String urlInstagram = rs.getString("url_instagram");
                String urlGithub = rs.getString("url_github");
                String urlLinkedin = rs.getString("url_linkedin");
                personas.add(new Persona(codigo, nombre, apellido, titulo, descripcion, email, telefono, ubicacion, urlInstagram, urlGithub, urlLinkedin));
            }
        }
        return personas;
    }

}
