/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.TDAs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Editor {
    
    private final String nombreEditor;
    private final Date fecha;
    List<Usuario> userlist;
    List<Documento> doclist;
    String activeUser;

    public Editor(String nombreEditor) {
        this.nombreEditor = nombreEditor;
        this.fecha = new Date();
        this.userlist = new ArrayList<>();
        this.doclist = new ArrayList<>();
        this.activeUser = "";
    }

    public String getNombreEditor() {
        return nombreEditor;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Usuario> getUserlist() {
        return userlist;
    }

    public List<Documento> getDoclist() {
        return doclist;
    }

    public String getActiveUser() {
        return activeUser;
    }

    public void setUserlist(List<Usuario> userlist) {
        this.userlist = userlist;
    }

    public void setDoclist(List<Documento> doclist) {
        this.doclist = doclist;
    }

    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }
    
    
}
