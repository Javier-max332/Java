/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOException;
import Modelo.Pelicula;
import java.util.List;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.IPeliculaDAO;

/**
 *
 * @author Javier
 */
public class MySQLPeliculaDAO implements IPeliculaDAO{

    // propiedades para manipular la base de datos
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO peliculas (titulo, anio)"
            + " Values(?, ?)";
    private final String UPDATE = "UPDATE peliculas SET titulo = ?, anio=?"
            + " WHERE idPelicula = ?";
    private final String DELETE = "DELETE FROM peliculas WHERE idPelicula = ?";
    private final String GETALL = "SELECT idPelicula, titulo, anio "
            + " FROM peliculas";
    private final String GETONE = "SELECT idPelicula, titulo, anio"
            + " FROM peliculas WHERE idPelicula = ?";
    
    @Override
    public void insertar(Pelicula pelicula) throws DAOException {
        try {
            //Creamos la Coneción a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getAnio());
            
            //ejecutamos la consulta y verificamos el resultado
            if (ps.executeUpdate() == 0) {//if 1.0
                throw new DAOException("No se pudo guardar la nueva pelicula");
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {//if 1.1
                    pelicula.setIdPelicula(rs.getInt(1));
                } else {
                    throw new DAOException("No se pudo asignar el ID a esta pelicula");
                }// fin del if 1.1
            }// fin del if 1.0
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
    public void modificar(Pelicula pelicula) throws DAOException {
        try {
            //creamos la conexión a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getAnio());
            ps.setInt(3, pelicula.getIdPelicula());
            
            //ejecutamos la consulta y verificamos el resultado 
            if (ps.executeUpdate() == 0) {//si es igual con 0 es que hubo un problema
                throw new DAOException("Hubo un problema y no se guardaron los cambios");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }//fin del dinally
    }//fin del método modificar

    @Override
    public void eliminar(Integer id) throws DAOException {
        try {
            //creamos la coneción a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, id);
            
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
    public List<Pelicula> obtenerTodos() throws DAOException {
        //Lista de peliculas a retonar 
        List <Pelicula> misPeliculas = new ArrayList<Pelicula>();
        
        try {
            //creamos la conexión a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta
            ps = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado 
            //en un objeto ResultSet
            rs = ps.executeQuery();
            
            
            //Recorremos el ResultSet y agregamos cada item al arrayList
            while (rs.next()) {                
                Pelicula miPelicula = new Pelicula();
                miPelicula.setIdPelicula(rs.getInt("idPelicula"));
                miPelicula.setTitulo(rs.getString("titulo"));
                miPelicula.setAnio(rs.getString("anio"));
                misPeliculas.add(miPelicula);
            }//fin del while
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL: ", ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }
        return misPeliculas;
    }//fin del método obtenerTodos

    @Override
    public Pelicula obtener(Integer id) throws DAOException {
        //Lista de peliculas a retonar
        Pelicula miPelicula = null;
        
        try {
            //creamos la conexión a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y definimos sus parámetros que rrecibe la consulta
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, id);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            /*
            verificamos si el resultset obtuvo el resultado y lo asignamos al objeto 
            correspondiente
            */
            if (rs.next()) {
                miPelicula = new Pelicula();
                miPelicula.setIdPelicula(rs.getInt("idPelicula"));
                miPelicula.setTitulo(rs.getString("titulo"));
                miPelicula.setAnio(rs.getString("anio"));
            } else {
                throw new DAOException("No se encontro el elemento");
            }
        } catch (SQLException ex) {
            throw new DAOException(" ERROR de SQL: ", ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }
        return miPelicula;
    }//fin del método obtener
    
}
