/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOException;
import Modelo.Pelicula;
import Modelo.GeneroPelicula;
import Modelo.Genero;
import java.util.List;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.IPeliculaDAO;
import DAO.IGeneroPelicula;
/**
 *
 * @author Javier
 */
public class MySQLGeneroPeliculaDAO implements IGeneroPelicula{
    // propiedades para el acceso a datos
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO generopelicula (idgenero, idpelicula) "
            + " Values(?, ?)";
    private final String DELETE = "DELETE FROM generopelicula WHERE idgenero = ? AND idpelicula = ?";
    private final String GETALLGENSBYFILM = "SELECT genero.idgenero, descripcion "
            + " FROM genero INNER JOIN generopelicula ON genero.idgenero = generopelicula.idgenero "
            + " INNER JOIN peliculas ON generopelicula.idpelicula = peliculas.idpelicula"
            + " WHERE peliculas.idpelicula = ?";
    
    /**
     * obtiene todos los generos del id. pelicula pasado como parámetro
     * @param idPelicula del que se buscarán todos sus generos
     * @return Retorna una lista de todos los generos de la peliculacon el id. esp.
     * @throws DAOException 
     */
    @Override
    public List<Genero> obtenerGeneroPorPelicula(int idPelicula) throws DAOException {
        List<Genero> misGeneros = null;
        try {
            //creamos la instaciación del parámetro a retonar
            misGeneros = new ArrayList<Genero>();
            
            //creamos la conexión a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta
            ps = conn.prepareStatement(GETALLGENSBYFILM);
            ps.setInt(1, idPelicula);
            
            //ejecutamos la consulta y almacenamos el resultado enun objeto resulset
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item al arraylist
            while (rs.next()) {                
                Genero miGenero = new Genero();
                miGenero.setIdGenero(rs.getInt("idgenero"));
                miGenero.setDescripcion(rs.getString("descripcion"));
                misGeneros.add(miGenero);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            cerrarConexiones(ps,rs,conn);
        }
        
        return misGeneros;
    }//fin del método
    
    @Override
    public void insertar(GeneroPelicula a) throws DAOException {
        try {
            //Creamos la Coneción a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, a.getIdGenero());
            ps.setInt(2, a.getIdPelicula());
            
            if (ps.executeUpdate()==0) {
                throw new DAOException("No se pudo guardar la relación entre pelicula y genero");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL ", ex);
        } finally{
            cerrarConexiones(ps,rs,conn);
        }//fin del finally
    }//fin del método insertar
    
    private void cerrarConexiones
        (PreparedStatement ps, ResultSet rs,Connection conn) throws DAOException{
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        }
    }//fin del método

    @Override
    public void eliminar(GeneroPelicula a) throws DAOException {
        try {
            //creamos la coneción a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, a.getIdGenero());
            ps.setInt(2, a.getIdPelicula());
            
            //ejecutamos la consulta y verificamos el resultado 
            if (ps.executeUpdate() == 0) {//si es igual con 0 hubo un problema
                throw new DAOException("Hubo un problema y no se pudo eliminar el registro"); 
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL ", ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }//fin del finally
    }//fin del método eliminar

    @Override
    public List<Pelicula> obtenerPeliculaPorGenero(int idPelicula) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(GeneroPelicula a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GeneroPelicula> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GeneroPelicula obtener(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
