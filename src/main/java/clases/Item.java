/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Daskalos
 */
public class Item {
    private int codigo_item;
    private String nombre;
    private String titulo;
    private String periodo;
    private String descripcion;
    private String url;
    private int nivel_progreso;
    private int eliminado;
    private int codigo_persona;
    private int codigo_seccion;

    public Item(int codigo_item, String nombre, String titulo, String periodo, String descripcion, String url, int nivel_progreso, int eliminado, int codigo_persona, int codigo_seccion) {
        this.codigo_item = codigo_item;
        this.nombre = nombre;
        this.titulo = titulo;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.url = url;
        this.nivel_progreso = nivel_progreso;
        this.eliminado = eliminado;
        this.codigo_persona = codigo_persona;
        this.codigo_seccion = codigo_seccion;
    }

    // getters and setters

    public int getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(int codigo_item) {
        this.codigo_item = codigo_item;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNivel_progreso() {
        return nivel_progreso;
    }

    public void setNivel_progreso(int nivel_progreso) {
        this.nivel_progreso = nivel_progreso;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public int getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(int codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }
}

