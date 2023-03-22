/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Persona {

    public int codigo;
    private String nombre;
    private String apellido;
    private String titulo;
    private String descripcion;
    private String email;
    private String telefono;
    private String ubicacion;
    private String urlInstagram;
    private String urlGithub;
    private String urlLinkedin;
    private String contrasena;
    private String urlFoto;

    public Persona() {
    }

    public Persona(int codigo, String nombre, String apellido, String titulo, String descripcion, String email,
            String telefono, String ubicacion, String urlInstagram, String urlGithub, String urlLinkedin,
            String contrasena, String urlFoto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.email = email;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.urlInstagram = urlInstagram;
        this.urlGithub = urlGithub;
        this.urlLinkedin = urlLinkedin;
        this.contrasena = contrasena;
        this.urlFoto = urlFoto;
    }

    public Persona(int codigo, String nombre, String apellido, String titulo, String descripcion, String email, String telefono, String ubicacion, String urlInstagram, String urlGithub, String urlLinkedin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrlInstagram() {
        return urlInstagram;
    }

    public void setUrlInstagram(String urlInstagram) {
        this.urlInstagram = urlInstagram;
    }

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public String getUrlLinkedin() {
        return urlLinkedin;
    }

    public void setUrlLinkedin(String urlLinkedin) {
        this.urlLinkedin = urlLinkedin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the url_foto
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * @param urlFoto the url_foto to set
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
