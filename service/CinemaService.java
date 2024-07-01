/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.service;


import com.mycompany.spi.proyectocine.model.*;
import com.mycompany.spi.proyectocine.persistence.PeliculaDAO;
import com.mycompany.spi.proyectocine.persistence.FuncionDAO;



import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class CinemaService {
    private PeliculaDAO peliculaDAO = new PeliculaDAO();
    private FuncionDAO funcionDAO = new FuncionDAO();

    private List<Funcion> funciones = new ArrayList<>();
    private List<Asiento> asientos = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();

    public CinemaService() {
    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaDAO.getAll();
    }

    public void añadirPelicula(Pelicula pelicula) {
        peliculaDAO.add(pelicula);
    }
    
    public List<Funcion> obtenerTodasLasFunciones(){
        return funcionDAO.getAll();
    }



    public List<Funcion> buscarFuncionesPorPelicula(int peliculaId) {
        this.funciones = this.obtenerTodasLasFunciones();
        List<Funcion> funcionesPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPeliculaId() == peliculaId) {
                funcionesPelicula.add(funcion);
            }
        }
        return funcionesPelicula;
    }

    public Asiento[] obtenerAsientosDisponibles(int funcionId) {
        List<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientos) {
            if (asiento.getFuncion().getId() == funcionId && asiento.getEstado().equals("disponible")) {
                disponibles.add(asiento);
            }
        }
        return disponibles.toArray(Asiento[]::new);
    }

    public void comprarAsiento(int asientoId) {
        for (Asiento asiento : asientos) {
            if (asiento.getId() == asientoId) {
                asiento.setEstado("vendido");
                compras.add(new Compra(asiento, "Usuario", LocalDate.now()));
            }
        }
    }

    public List<Compra> obtenerCompras() {
        return new ArrayList<>(compras);
    }
    
}