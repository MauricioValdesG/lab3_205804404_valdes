/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.TDAs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Editor{
    
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
    
    public void llenarStack(Editor editor1){
        Usuario user1= new Usuario("user1", "pass1");
        Usuario user2= new Usuario("user2", "pass2");
        Usuario user3= new Usuario("user3", "pass3");
        Usuario user4= new Usuario("user4", "pass4");
        Usuario user5= new Usuario("user5", "pass5");
        Contenido contenido1= new Contenido("cont1");
        Contenido contenido2= new Contenido("cont2");
        Contenido contenido3= new Contenido("cont3");
        Contenido contenido4= new Contenido("cont4");
        Contenido contenido5= new Contenido("cont5");
        Contenido contenido6= new Contenido("cont6");
        Contenido contenido7= new Contenido("cont7");
        Contenido contenido8= new Contenido("cont8");
        Contenido contenido9= new Contenido("cont9");
        Contenido contenido10= new Contenido("cont10");
        Documento doc1= new Documento("autor1", "nombre1");
        Documento doc2= new Documento("autor2", "nombre2");
        Documento doc3= new Documento("autor3", "nombre3");
        Documento doc4= new Documento("autor4", "nombre4");
        Documento doc5= new Documento("autor5", "nombre5");
        Documento doc6= new Documento("autor6", "nombre6");
        Documento doc7= new Documento("autor7", "nombre7");
        Documento doc8= new Documento("autor8", "nombre8");
        Documento doc9= new Documento("autor9", "nombre9");
        Documento doc10= new Documento("autor10", "nombre10");
        doc1.contenido.add(contenido1);
        doc2.contenido.add(contenido2);
        doc3.contenido.add(contenido3);
        doc4.contenido.add(contenido4);
        doc5.contenido.add(contenido5);
        doc6.contenido.add(contenido6);
        doc7.contenido.add(contenido7);
        doc8.contenido.add(contenido8);
        doc9.contenido.add(contenido9);
        doc10.contenido.add(contenido10);
        editor1.userlist.add(user1);
        editor1.userlist.add(user2);
        editor1.userlist.add(user3);
        editor1.userlist.add(user4);
        editor1.userlist.add(user5);
        editor1.doclist.add(doc1);
        editor1.doclist.add(doc2);
        editor1.doclist.add(doc3);
        editor1.doclist.add(doc4);
        editor1.doclist.add(doc5);
        editor1.doclist.add(doc6);
        editor1.doclist.add(doc7);
        editor1.doclist.add(doc8);
        editor1.doclist.add(doc9);
        editor1.doclist.add(doc10);
    }
    
    public void register(String NombreUser, String contraseniaUser){
        
        if(userlist == null || userlist.isEmpty()){
            Usuario newuser= new Usuario(NombreUser, contraseniaUser);
            userlist.add(newuser);
            System.out.println("Usuario registrado.");
        }else{
            int aux=0;
            for(int i=0;i<userlist.size();i++){
                if (userlist.get(i).getNombre().equals(NombreUser)){
                    aux=1;
                    break;
                }
            }
            if (aux==1){
                System.out.println("El usuario ya se encuentra registrado");
            }else{
                Usuario newuser= new Usuario(NombreUser, contraseniaUser);
                userlist.add(newuser);
                System.out.println("Usuario registrado.");
            }
        }
    }
    
    public void login(String NombreUser, String contraseniaUser){
        
        int aux=0;
        if (userlist == null || userlist.isEmpty()){
            System.out.println("No existen usuarios registrados");
        }else{
            for(int i=0;i<userlist.size();i++){
                if (userlist.get(i).getNombre().equals(NombreUser)){
                    if (userlist.get(i).getContrasenia().equals(contraseniaUser)){
                        this.activeUser=NombreUser;
                        aux=1;
                        System.out.println("Sesion iniciada");
                    }else{
                        System.out.println("Contrasenia incorrecta");
                    }break; 
                }
            }
            if (aux==0) {
                System.out.println("Usuario no registrado");
            }
        }
    }
    
    public void logout(){
        this.activeUser = "";
    }
    
    @Override
    public String toString(){
        if (activeUser.equals("")) {
            return "usuarios:"
                    + "\n"                    
                    + userlist.toString()
                    + "\n"
                    + " publicaciones:"
                    + "\n"
                    + doclist.toString();
        }
        return null;
        
    }
    
    
}
