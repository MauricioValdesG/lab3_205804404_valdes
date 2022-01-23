/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.TDAs;

import java.util.Date;



class Contenido{
    
    //atributo
    int id;
    private final String texto;
    private final Date fecha;

    public Contenido(String texto) {
        
        this.id = 0;
        this.fecha = new Date();
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contenido{" 
                + "id=" 
                + id 
                + ", texto=" 
                + texto 
                + ", fecha=" 
                + fecha 
                + '}';
    }
    
}
