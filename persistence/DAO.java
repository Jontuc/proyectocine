/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spi.proyectocine.persistence;

/**
 *
 * @author IA-JED
 */

import java.util.List;
// Intarfaz para todos los objetos de acceso a datos
public interface DAO<T> {
    List<T> getAll();
    void add(T t);
    void update(T t);
    void delete(int id);
}