/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;
import DAO.DAOManager;
import DAO.IPeliculaDAO;
import DAO.IGeneroPelicula;
import DAO.IGeneroDAO;

/**
 *
 * @author Javier
 */
public class MySQLDAOManager implements DAOManager{
    private IPeliculaDAO peliculas = null;
    private IGeneroDAO genero = null;
    private IGeneroPelicula generoPelicula = null;
    
    //con esta haremos uso del patrón singleton para reutilizar objetos si
    //estos ya han sido creados.
    @Override
    public IPeliculaDAO getPeliculaDAO(){
        if (peliculas == null) {
            peliculas = new MySQLPeliculaDAO();
        }
        return peliculas;
    }//fin del método getPeliculaDAO
    
    @Override
    public IGeneroPelicula getGeneroPeliculaDAO(){
        if (generoPelicula == null) {
            generoPelicula = (IGeneroPelicula) new MySQLGeneroPeliculaDAO();
        }
        return generoPelicula;
    }//fin del método getGeneroPeliculaDAO
        
    @Override
    public IGeneroDAO getGeneroDAO(){
        if (genero == null) {
            genero = new MySQLGeneroDAO();
        }
        return genero;
    }//fin del método getTituloDAO
}//fin de la clase
