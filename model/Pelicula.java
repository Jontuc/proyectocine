/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.model;

/**
 *
 * @author IA-JED
 */
public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int duracion; // en minutos

    // Constructor, getters y setters

    public Pelicula(int id, String titulo, String director, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
        
}