/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Daskalos
 */
import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private int codigo_seccion;
    private String nombre_seccion;
    private int orden;
    private List<Item> items;

    public Seccion(int codigo_seccion, String nombre_seccion, int orden, List<Item> items) {
        this.codigo_seccion = codigo_seccion;
        this.nombre_seccion = nombre_seccion;
        this.orden = orden;
        this.items = items;
    }
    // getters and setters

    public int getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(int codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}

