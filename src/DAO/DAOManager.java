/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author Javier
 */
public interface DAOManager {
    //mediante esta interfaz haremos una forma centralizada
    //de pedir cualquier DAO, de pelicula, de genero, etx.
    IPeliculaDAO getPeliculaDAO();
    IGeneroDAO getGeneroDAO();
    IGeneroPelicula getGeneroPeliculaDAO();
}
