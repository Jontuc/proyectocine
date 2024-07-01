/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.model;

/**
 *
 * @author IA-JED
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {
    private int id;
    private Pelicula pelicula;
    private LocalDate fecha;
    private LocalTime hora;
    private String sala;

    // Constructor, getters y setters

    public Funcion(int id, Pelicula pelicula, LocalDate fecha, LocalTime hora, String sala) {
        this.id = id;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    public int getPeliculaId(){
        return pelicula.getId();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
}