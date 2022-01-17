/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.TDAs;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
    
    //atributos
    private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final Date fecha;
    private final String Nombre;
    private final String Contrasenia;

    public Usuario(String Nombre, String Contrasenia) {
        this.id = counter.incrementAndGet();
        this.fecha = new Date();
        this.Nombre = Nombre;
        this.Contrasenia = Contrasenia;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "id=" 
                + id 
                + ", Nombre=" 
                + Nombre 
                + ", fecha=" 
                + fecha 
                + '}';
    }
}
