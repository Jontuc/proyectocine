/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.persistence;

import com.mycompany.spi.proyectocine.model.Funcion;
import com.mycompany.spi.proyectocine.model.Pelicula;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionDAO implements DAO<Funcion> {

    private PeliculaDAO peliculaDAO = new PeliculaDAO();

    @Override
    public List<Funcion> getAll() {
        List<Funcion> funciones = new ArrayList<>();
        String query = "SELECT * FROM funciones";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pelicula pelicula = peliculaDAO.get(resultSet.getInt("pelicula_id"));
                Funcion funcion = new Funcion(
                    resultSet.getInt("id"),
                    pelicula,
                    resultSet.getDate("fecha").toLocalDate(),
                    resultSet.getTime("hora").toLocalTime(),
                    resultSet.getString("sala")
                );
                funciones.add(funcion);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las funciones: " + e.getMessage());
        }
        return funciones;
    }

    @Override
    public void add(Funcion funcion) {
        String query = "INSERT INTO funciones (pelicula_id, fecha, hora, sala) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, funcion.getPelicula().getId());
            statement.setDate(2, java.sql.Date.valueOf(funcion.getFecha()));
            statement.setTime(3, java.sql.Time.valueOf(funcion.getHora()));
            statement.setString(4, funcion.getSala());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al añadir la función: " + e.getMessage());
        }
    }

    public Funcion get(int id) {
        Funcion funcion = null;
        String query = "SELECT * FROM funciones WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Pelicula pelicula = peliculaDAO.get(resultSet.getInt("pelicula_id"));
                    funcion = new Funcion(
                        resultSet.getInt("id"),
                        pelicula,
                        resultSet.getDate("fecha").toLocalDate(),
                        resultSet.getTime("hora").toLocalTime(),
                        resultSet.getString("sala")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la función: " + e.getMessage());
        }
        return funcion;
    }

    @Override
    public void update(Funcion t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}