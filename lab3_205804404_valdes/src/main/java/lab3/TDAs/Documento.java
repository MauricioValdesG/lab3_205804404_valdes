/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.TDAs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Documento {
    
    //atributo
    private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final String autor;
    private final Date fecha;
    private final String nombreDocumento;
    List<Contenido> contenido;
    List<Compartidos> compartidos;

    public Documento(String autor, String nombreDocumento) {
        this.id = counter.incrementAndGet();
        this.fecha = new Date();
        this.autor = autor;
        this.nombreDocumento = nombreDocumento;
        this.contenido = new ArrayList<>();
        this.compartidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public List<Contenido> getContenido() {
        return contenido;
    }

    public List<Compartidos> getCompartidos() {
        return compartidos;
    }

    public void setContenido(List<Contenido> contenido) {
        this.contenido = contenido;
    }

    public void setCompartidos(List<Compartidos> compartidos) {
        this.compartidos = compartidos;
    }

    @Override
    public String toString() {
        return "Documento{" 
                + "id=" 
                + id 
                + ", autor=" 
                + autor 
                + ", fecha=" 
                + fecha 
                + ", nombreDocumento=" 
                + nombreDocumento 
                + ", contenido=" 
                + contenido.toString()
                + ", compartidos=" 
                + compartidos.toString()
                + '}';
    }
    
}
