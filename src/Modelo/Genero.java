/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Javier
 */
public class Genero {
    //campos o propiedades
    private int idGenero;
    private String descripcion;
    
    //declaración del constructor vacío 
    public Genero(){
        super();
    }
    
    //declaración del constructor con tres parámetros
    public Genero(String descripcion){
        super();
        this.setDescripcion(descripcion);
    }
    
    //declaración del constructor con tres parámetros
    public Genero(int idGenero, String descripcion){
        super();
        this.setIdGenero(idGenero);
        this.setDescripcion(descripcion);
    }
    
    //declaración de getters y setters
    public int getIdGenero(){
        return idGenero;
    }
    
    public void setIdGenero(int idGenero){
        this.idGenero = idGenero;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return this.getDescripcion();
    }
}
