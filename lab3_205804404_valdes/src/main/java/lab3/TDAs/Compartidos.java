/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.TDAs;

class Compartidos {
    
    //atributos
    private final String Nombre;
    private final String Permiso;

    public Compartidos(String Nombre, String Permiso) {
        this.Nombre = Nombre;
        this.Permiso = Permiso;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPermiso() {
        return Permiso;
    }

    @Override
    public String toString() {
        return "Compartidos{" 
                + "Nombre=" 
                + Nombre 
                + ", Permiso=" 
                + Permiso 
                + '}';
    }
    
}
