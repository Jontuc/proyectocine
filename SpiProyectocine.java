/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.spi.proyectocine;

/**
 *
 * @author IA-JED
 */


import com.mycompany.spi.proyectocine.controller.CinemaController;
import com.mycompany.spi.proyectocine.model.Asiento;
import com.mycompany.spi.proyectocine.model.Funcion;
import com.mycompany.spi.proyectocine.model.Pelicula;
import java.util.List;
import java.util.Scanner;

public class SpiProyectocine {

    private static CinemaController cinemaController = new CinemaController();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                switch (opcion) {
                    case 1:
                        mostrarPeliculas();
                        break;
                    case 2:
                        buscarFunciones();
                        break;
                    case 3:
                        mostrarAsientosDisponibles();
                        break;
                    case 4:
                        comprarAsiento();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Mostrar Películas");
        System.out.println("2. Buscar Funciones por Película");
        System.out.println("3. Mostrar Asientos Disponibles por Función");
        System.out.println("4. Comprar Asiento");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarPeliculas() {
        System.out.println("Peliculas");
        List<Pelicula> peliculas = cinemaController.getPeliculas();
        for (Pelicula pelicula : peliculas) {
            System.out.println("id: "+pelicula.getId() +" titulo: " + pelicula.getTitulo());
        }
        System.out.println();
    }

    private static void buscarFunciones() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la película: ");
        int peliculaId = scanner.nextInt();
        List<Funcion> funciones = cinemaController.getFuncionesPorPelicula(peliculaId);
        for (Funcion funcion : funciones) {
            System.out.println("id: "+funcion.getId() +" Fecha: " + funcion.getFecha() + "Hora: " +funcion.getHora());
        }
    }

    private static void mostrarAsientosDisponibles() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la función: ");
        int funcionId = scanner.nextInt();
        Asiento[] asientos = cinemaController.getAsientosDisponibles(funcionId);
        for (Asiento asiento : asientos) {
            System.out.println(asiento);
        }
    }

    private static void comprarAsiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del asiento a comprar: ");
        int asientoId = scanner.nextInt();
        cinemaController.comprarAsiento(asientoId);
        System.out.println("Asiento comprado con éxito.");
    }
}


