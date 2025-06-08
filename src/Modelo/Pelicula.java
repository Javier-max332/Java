/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Javier
 */
public class Pelicula {
    //campos o propiedades
    private int idPelicula;
    private String titulo;
    private String anio;
    private Set generoses = new HashSet(0);
    
    public Set getTitulos(){
        return this.generoses;
    }
    
    //declaración del constructor vacío 
    public Pelicula(){
        super();
    }
    
    public void setGenero(Set tituloses){
        this.generoses = tituloses;
    }
    
    //declaración del constructor con dos parámetros
    public Pelicula(String titulo, String anio){
        super();
        this.setTitulo(titulo);
        this.setAnio(anio);
    }
    
    //declaración del constructor con tres parámetros
    public Pelicula(int id, String titulo, String anio){
        super();
        this.setIdPelicula(id);
        this.setTitulo(titulo);
        this.setAnio(anio);
    }
    
    //declaración de getters y setters
    public int getIdPelicula(){
        return idPelicula;
    }
    
    public void setIdPelicula(int idPelicula){
        this.idPelicula = idPelicula;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAnio(){
        return anio;
    }
    
    public void setAnio(String anio){
        this.anio = anio;
    }
    
    @Override
    public String toString(){
        return this.getTitulo();
    }
}//fin de la clase Pelicula
