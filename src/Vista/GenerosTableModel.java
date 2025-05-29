/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import DAO.DAOException;
import Modelo.Genero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import DAO.IGeneroPelicula;

/**
 *
 * @author Javier
 */
public class GenerosTableModel extends AbstractTableModel{
    //Propiedades
    private IGeneroPelicula generopelicula;

    //lista de elementos de tipo Genero
    private List<Genero> datos = new ArrayList<>();

    //constructor con un parámetro
    public GenerosTableModel (IGeneroPelicula generopelicula){
        this.generopelicula = generopelicula;
    }


    /**
     * retorna el nombre de cada columna
     * @param column
     * @return
     */
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Id Genero";
            case 1: return "Descripcion";
            default: return "[no]";
        }
    }

    /**
     * retorna el número de elementos obtenidos de la tabla titulos
     * @return
     */
    @Override
    public int getRowCount(){
        return datos.size();
    }
    /**
     * retorna el número de columnas
     * @return
     */
    @Override
    public int getColumnCount(){
        return 2;
    }

    /**
     * retorna el valor que contenga la intersección de una fila y columna
     * pasadas como parámetro
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Genero preguntado = datos.get(rowIndex);
        switch (columnIndex){
            case 0: return preguntado.getIdGenero();
            case 1: return preguntado.getDescripcion();
            
            default:
                return "";
        }
    }

    /**
     * Muestra una lista de la tabla Generos basados en su Pelicula
     * @param datos
     */
    public void updateModel(int idPelicula) throws DAOException {
        this.datos = generopelicula.obtenerGeneroPorPelicula(idPelicula);
    }

}//fin de la clase
