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


public class Compra {
    private Asiento asiento;
    private String usuario;
    private LocalDate fecha;

    public Compra(Asiento asiento, String usuario, LocalDate fecha) {
        this.asiento = asiento;
        this.usuario = usuario;
        this.fecha = fecha;

    }

    // Getters and Setters

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    



    
}