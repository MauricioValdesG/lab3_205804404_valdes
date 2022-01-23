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
        Documento doc1= new Documento("user1", "nombre1");
        Documento doc2= new Documento("user2", "nombre2");
        Documento doc3= new Documento("user3", "nombre3");
        Documento doc4= new Documento("user4", "nombre4");
        Documento doc5= new Documento("user5", "nombre5");
        Documento doc6= new Documento("user1", "nombre6");
        Documento doc7= new Documento("user2", "nombre7");
        Documento doc8= new Documento("user3", "nombre8");
        Documento doc9= new Documento("user4", "nombre9");
        Documento doc10= new Documento("user5", "nombre10");
        contenido1.setId(doc1.getContenido().size());
        contenido2.setId(doc2.getContenido().size());
        contenido3.setId(doc3.getContenido().size());
        contenido4.setId(doc4.getContenido().size());
        contenido5.setId(doc5.getContenido().size());
        contenido6.setId(doc6.getContenido().size());
        contenido7.setId(doc7.getContenido().size());
        contenido8.setId(doc8.getContenido().size());
        contenido9.setId(doc9.getContenido().size());
        contenido10.setId(doc10.getContenido().size());
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
    
    public void create(String nombre, String contenido){
        if ("".equals(activeUser)) {
            System.out.println("Debe iniciar sesion primero.");
        }
        else{
            Documento newDocumento = new Documento(activeUser, nombre);
            Contenido newContenido = new Contenido(contenido);
            newContenido.setId(newDocumento.getContenido().size()+1);
            newDocumento.contenido.add(newContenido);
            doclist.add(newDocumento);
            System.out.println("La publicacion se ha realizado con exito.");
        }
    }
    
    public void share(List<String> usuariosCompartir, int id, String permiso){
    
        int aux=0;
        int aux2=0;
        if (usuariosCompartir == null || usuariosCompartir.isEmpty()) {
            System.out.println("Debe ingresar una lista de usuarios a compartir.");
        }
        ArrayList<String> listaAux = new ArrayList();
        for (int i = 0; i < usuariosCompartir.size(); i++) {
            for (int j = 0; j < userlist.size(); j++) {
                if (userlist.get(j).getNombre().equals(usuariosCompartir.get(i))) {
                    listaAux.add(usuariosCompartir.get(i));
                }
            }   
        }
        if (listaAux == null || listaAux.isEmpty()) {
            System.out.println("Ninguno de los usuarios existe.");
        }else{
            for (int i = 0; i < doclist.size(); i++) {
                if (doclist.get(i).getId() == id && doclist.get(i).getAutor().equals(activeUser)) {
                    for (int j = 0; j < listaAux.size(); j++) {
                        if (!listaAux.get(j).equals(activeUser)) {
                            Compartidos compartidoActual = new Compartidos(listaAux.get(j), permiso);
                            doclist.get(i).compartidos.add(compartidoActual);
                            aux=1;
                        }else{
                            aux2=1;
                        }
                    }
                }
            }
            if (aux2==1){
                System.out.println("No se puede compartir el documento a usted mismo.");
            }
            if (aux==1) {
                System.out.println("Se ha compartido con exito.");
            }else{
                System.out.println("No se ha podido compartir el documento.");
            }
            
        }
    }
    
    public void add(int idDoc, String textoAgregar){
        String textoAntiguo;
        String textoNuevo;
        int flag=0;
        int idActivo;
        for (int i = 0; i < doclist.size(); i++) {
            if (doclist.get(i).getId()==idDoc) {
                if (doclist.get(i).getAutor().equals(activeUser)) {
                    flag=1;
                    idActivo= doclist.get(i).getContenido().size()-1;
                    textoAntiguo=doclist.get(i).getContenido().get(idActivo).getTexto();
                    textoNuevo=textoAntiguo.concat(textoAgregar);
                    Contenido contenidoAgregar= new Contenido(textoNuevo);
                    contenidoAgregar.setId(idActivo+1);
                    doclist.get(i).contenido.add(contenidoAgregar);
                    System.out.println("El texto se ha añadido con exito como una nueva version del documento.");
                    break;
                }else{
                    for (int j = 0; j < doclist.get(i).getCompartidos().size(); j++) {
                        if (doclist.get(i).getCompartidos().get(j).getNombre().equals(activeUser) && doclist.get(i).getCompartidos().get(j).getPermiso().equals("W")) {
                            flag=1;
                            textoAntiguo=doclist.get(i).getContenido().get(doclist.get(i).getContenido().size()-1).getTexto();
                            textoNuevo=textoAntiguo.concat(textoAgregar);
                            Contenido contenidoAgregar= new Contenido(textoNuevo);
                            contenidoAgregar.setId(doclist.get(i).getContenido().size());
                            doclist.get(i).contenido.add(contenidoAgregar);
                            System.out.println("El texto se ha añadido con exito como una nueva version del documento.");
                            break;
                        }else{
                            flag=2;
                        }
                    }
                }
            }
        }
        
        if (flag==2) {
            System.out.println("Usted no posee permisos para escribir en este documento.");
        }
        if (flag==0) {
            System.out.println("No se encontro el documento.");
        }
    }
    
    public void rollback(int idDoc, int idVersion){
    
        int flag=0;
        String textoAntiguo = null;
        for (int i = 0; i < doclist.size(); i++) {
            if (doclist.get(i).getId()==idDoc) {
                if (doclist.get(i).getAutor().equals(activeUser)) {
                    for (int j = 0; j < doclist.get(i).getContenido().size(); j++) {
                        if (doclist.get(i).getContenido().get(j).getId()==idVersion) {
                            flag=1;
                            textoAntiguo=doclist.get(i).getContenido().get(j).getTexto();
                            Contenido contenidoAgregar= new Contenido(textoAntiguo);
                            contenidoAgregar.setId(doclist.get(i).getContenido().size());
                            doclist.get(i).contenido.add(contenidoAgregar);
                            System.out.println("La version señalada se ha restaurad como una nueva version del documento y ahora esta es la version activa.");
                            break;
                        }else{
                            flag=3;
                        }
                    }
                    break;
                }else{
                    flag=2;
                }
            }
        }
        if (flag==0) {
            System.out.println("No se encontro el documento.");
        }
        if (flag==2) {
            System.out.println("Usted no es el autor de este documento.");
        }
        if (flag==3) {
            System.out.println("No se encontro la version.");
        }
    }
    
    public void revokeAccess(int idDoc){
        
        int flag=0;
        ArrayList<Compartidos> listaVacia = new ArrayList();
        for (int i = 0; i < doclist.size(); i++) {
            if (doclist.get(i).getId()==idDoc) {
                if (doclist.get(i).getAutor().equals(activeUser)) {
                    flag=1;
                    doclist.get(i).setCompartidos(listaVacia);
                    System.out.println("Se revocaron todos los permisos de este archivo.");
                    break;
                }else{
                    flag=2;
                }
            }
        }
        if (flag==0) {
            System.out.println("No se encontro el documento.");
        }
        if (flag==2) {
            System.out.println("No es el autor de este documento.");
        }
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
