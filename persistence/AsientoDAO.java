/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.persistence;



import com.mycompany.spi.proyectocine.model.Asiento;
import com.mycompany.spi.proyectocine.model.Funcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsientoDAO implements DAO<Asiento> {

    @Override
    public List<Asiento> getAll() {
        FuncionDAO funcionDAO = new FuncionDAO();
        List<Asiento> asientos = new ArrayList<>();
        String query = "SELECT * FROM asientos";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Funcion funcion = funcionDAO.get(resultSet.getInt("funcion_id"));
                Asiento asiento = new Asiento(
                    resultSet.getInt("id"),
                    funcion,
                    resultSet.getString("fila").charAt(0),
                    resultSet.getInt("numero"),
                    resultSet.getString("estado")
                );
                asientos.add(asiento);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los asientos: " + e.getMessage());
        }
        return asientos;
    }

    @Override
    public void add(Asiento asiento) {
        String query = "INSERT INTO asientos (funcion_id, fila, numero, estado) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, asiento.getFuncionId());
            statement.setString(2, String.valueOf(asiento.getFila()));
            statement.setInt(3, asiento.getNumero());
            statement.setString(4, asiento.getEstado());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al añadir el asiento: " + e.getMessage());
        }
    }

    @Override
    public void update(Asiento asiento) {
        String query = "UPDATE asientos SET funcion_id = ?, fila = ?, numero = ?, estado = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, asiento.getFuncionId());
            statement.setString(2, String.valueOf(asiento.getFila()));
            statement.setInt(3, asiento.getNumero());
            statement.setString(4, asiento.getEstado());
            statement.setInt(5, asiento.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el asiento: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM asientos WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el asiento: " + e.getMessage());
        }
    }
}