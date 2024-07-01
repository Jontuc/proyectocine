/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.controller;



import com.mycompany.spi.proyectocine.model.Asiento;
import com.mycompany.spi.proyectocine.model.Funcion;
import com.mycompany.spi.proyectocine.model.Pelicula;
import com.mycompany.spi.proyectocine.service.CinemaService;
import java.util.List;


public class CinemaController {
    private CinemaService cinemaService = new CinemaService();

    public List<Pelicula> getPeliculas() {
        return cinemaService.obtenerTodasLasPeliculas();
    }

    public List<Funcion> getFuncionesPorPelicula(int peliculaId) {
        return cinemaService.buscarFuncionesPorPelicula(peliculaId);
    }

    public Asiento[] getAsientosDisponibles(int funcionId) {
        return cinemaService.obtenerAsientosDisponibles(funcionId);
    }

    public void comprarAsiento(int asientoId) {
        cinemaService.comprarAsiento(asientoId);
    }
}