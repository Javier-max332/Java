/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Javier
 */
public class GeneroPelicula {
    private int idGenero;
    private int idPelicula;
    
    //constructor sin parámetros
    public GeneroPelicula(){
        
    }
    
    //constructor con dos parámetros definiendo primero el idPelicula
    public GeneroPelicula(int idPelicula, int idGenero){
        this.setIdGenero(idGenero);
        this.setIdPelicula(idPelicula);
    }
    
    //dscriptores de acceso
    public int getIdGenero(){
        return idGenero;
    }
    
    public void setIdGenero(int idGenero){
        this.idGenero = idGenero;
    }
    
    public int getIdPelicula(){
        return idPelicula;
    }
    
    public void setIdPelicula(int idPelicula){
        this.idPelicula = idPelicula;
    }
}
