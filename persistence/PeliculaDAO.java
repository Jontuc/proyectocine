/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.persistence;

/**
 *
 * @author IA-JED
 */
import com.mycompany.spi.proyectocine.model.Pelicula;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula> {

    @Override
    public List<Pelicula> getAll() {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT * FROM peliculas";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getString("director"),
                    resultSet.getInt("duracion")
                );
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las películas: " + e.getMessage());
        }
        return peliculas;
    }

    @Override
    public void add(Pelicula pelicula) {
        String query = "INSERT INTO peliculas (titulo, director, duracion) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getDirector());
            statement.setInt(3, pelicula.getDuracion());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al añadir la película: " + e.getMessage());
        }
    }

    @Override
    public void update(Pelicula pelicula) {
        String query = "UPDATE peliculas SET titulo = ?, director = ?, duracion = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getDirector());
            statement.setInt(3, pelicula.getDuracion());
            statement.setInt(4, pelicula.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar la película: " + e.getMessage());
        }
    }
    
    public Pelicula get(int id){
        Pelicula pelicula = null;
        String query = "SELECT * FROM peliculas WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    pelicula = new Pelicula(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getString("director"),
                    resultSet.getInt("duracion")
                );
                } 
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la película: " + e.getMessage());
        } 
        return pelicula;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM peliculas WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar la película: " + e.getMessage());
        }
    }
}
