/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOException;
import Modelo.Genero;
import java.util.List;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.IGeneroDAO;
/**
 *
 * @author Javier
 */
public class MySQLGeneroDAO implements IGeneroDAO{
    // propiedades para manipular la base de datos
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO genero (idGenero, descripcion)"
            + " Values(?, ?)";
    private final String UPDATE = "UPDATE genero SET descripcion=?"
            + " WHERE idgenero = ?";
    private final String DELETE = "DELETE FROM genero WHERE idgenero = ?";
    private final String GETALL = "SELECT idgenero, descripcion"
            + " FROM genero"; 
    private final String GETONE = "SELECT idgenero, descripcion"
            + " FROM genero WHERE idgenero = ?";
    
    @Override
    public void insertar(Genero genero) throws DAOException {
        try {
            //Creamos la Coneción a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, genero.getIdGenero());
            ps.setString(2, genero.getDescripcion());
            
            //ejecutamos la consulta y verificamos el resultado
            if (ps.executeUpdate() == 0) {//if 1.0
                throw new DAOException("No se pudo guardar el nuevo genero");
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
    public void modificar(Genero genero) throws DAOException {
        try {
            //creamos la conexión a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, genero.getDescripcion());
            ps.setInt(2, genero.getIdGenero());
            
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
    public void eliminar(Integer idGenero) throws DAOException {
        try {
            //creamos la coneción a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parámetros de entrada
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, idGenero);
            
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
    public List<Genero> obtenerTodos() throws DAOException {
        //Lista de Generos a retonar 
        List <Genero> misGeneros = new ArrayList<Genero>();
        
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
                Genero miGenero = new Genero();
                miGenero.setIdGenero(rs.getInt("idGenero"));
                miGenero.setDescripcion(rs.getString("descripcion"));
                misGeneros.add(miGenero);
            }//fin del while
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL: ", ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }
        return misGeneros;
    }//fin del método obtenerTodos

    @Override
    public Genero obtener(Integer idGenero) throws DAOException {
        //Lista de Generos a retonar
        Genero miGenero = null;
        
        try {
            //creamos la conexión a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y definimos sus parámetros que recibe la consulta
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, idGenero);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            /*
            verificamos si el resultset obtuvo el resultado y lo asignamos al objeto 
            correspondiente
            */
            if (rs.next()) {
                miGenero = new Genero();
                miGenero.setIdGenero(rs.getInt("idGenero"));
                miGenero.setDescripcion(rs.getString("descripcion"));
            } else {
                throw new DAOException("No se encontro el elemento");
            }
        } catch (SQLException ex) {
            throw new DAOException(" ERROR de SQL: ", ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }
        return miGenero;
    }//fin del método obtener
}
