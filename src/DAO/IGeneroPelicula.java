/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Genero;
import Modelo.GeneroPelicula;
import Modelo.Pelicula;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IGeneroPelicula extends IDAO<GeneroPelicula, String> {

    List<Pelicula> obtenerPeliculaPorGenero(int idGenero) throws DAOException;

    List<Genero> obtenerGeneroPorPelicula(int idPelicula) throws DAOException;

    void eliminar(GeneroPelicula a) throws DAOException;
}

