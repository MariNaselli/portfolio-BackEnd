/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import clases.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public void eliminarItem(int codigoItem) throws SQLException {
        String sql = "UPDATE items SET eliminado = 1 WHERE codigo_item = ?";

        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigoItem);
            pstmt.executeUpdate();
        }
    }

    public List<Item> listarItems() throws SQLException {
        String sql = "SELECT codigo_item, nombre, titulo, periodo, descripcion, url, nivel_progreso, eliminado, codigo_persona, codigo_seccion FROM items WHERE eliminado = 0";
        List<Item> listaItems = new ArrayList<>();

        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("codigo_item"),
                            rs.getString("nombre"),
                            rs.getString("titulo"),
                            rs.getString("periodo"),
                            rs.getString("descripcion"),
                            rs.getString("url"),
                            rs.getInt("nivel_progreso"),
                            rs.getInt("eliminado"),
                            rs.getInt("codigo_persona"),
                            rs.getInt("codigo_seccion"));
                    listaItems.add(item);
                }
            }
        }

        return listaItems;
    }

    public Item obtenerPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT codigo_item, nombre, titulo, periodo, descripcion, url, nivel_progreso, eliminado, codigo_persona, codigo_seccion FROM items WHERE codigo_item = ?";
        Item item = null;

        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    item = new Item(
                            rs.getInt("codigo_item"),
                            rs.getString("nombre"),
                            rs.getString("titulo"),
                            rs.getString("periodo"),
                            rs.getString("descripcion"),
                            rs.getString("url"),
                            rs.getInt("nivel_progreso"),
                            rs.getInt("eliminado"),
                            rs.getInt("codigo_persona"),
                            rs.getInt("codigo_seccion"));
                }
            }
        }

        return item;
    }

    public void crearItem(Item item) throws SQLException {
        String sql = "INSERT INTO items(nombre, titulo, periodo, descripcion, url, nivel_progreso, eliminado, codigo_persona, codigo_seccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getNombre());
            pstmt.setString(2, item.getTitulo());
            pstmt.setString(3, item.getPeriodo());
            pstmt.setString(4, item.getDescripcion());
            pstmt.setString(5, item.getUrl());
            pstmt.setInt(6, item.getNivel_progreso());
            pstmt.setInt(7, item.getEliminado());
            pstmt.setInt(8, item.getCodigo_persona());
            pstmt.setInt(9, item.getCodigo_seccion());

            pstmt.executeUpdate();
        }
    }

    public void actualizarItem(Item item) throws SQLException {
        String sql = "UPDATE items SET nombre = ?, titulo = ?, periodo = ?, descripcion = ?, url = ?, nivel_progreso = ?, eliminado = ?, codigo_persona = ?, codigo_seccion = ? WHERE codigo_item = ?";

        try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getNombre());
            pstmt.setString(2, item.getTitulo());
            pstmt.setString(3, item.getPeriodo());
            pstmt.setString(4, item.getDescripcion());
            pstmt.setString(5, item.getUrl());
            pstmt.setInt(6, item.getNivel_progreso());
            pstmt.setInt(7, item.getEliminado());
            pstmt.setInt(8, item.getCodigo_persona());
            pstmt.setInt(9, item.getCodigo_seccion());
            pstmt.setInt(10, item.getCodigo_item());

            pstmt.executeUpdate();
        }
    }

}
