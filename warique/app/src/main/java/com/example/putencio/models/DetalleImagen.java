package com.example.putencio.models;

/**
 * Created by renzo on 17/12/15.
 */
public class DetalleImagen {
    private int id;
    private String rutaImagen;
    private String titulo;

    public DetalleImagen(int id, String rutaImagen, String titulo) {
        this.id = id;
        this.rutaImagen = rutaImagen;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
