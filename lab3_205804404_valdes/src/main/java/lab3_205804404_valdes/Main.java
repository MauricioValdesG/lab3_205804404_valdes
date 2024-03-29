
package lab3_205804404_valdes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import lab3.TDAs.Editor;

public class Main {

    public static void main(String[] args) {
        
        Editor editor = new Editor("editor");
        Scanner sn1 = new Scanner(System.in);
        Scanner sn9 = new Scanner(System.in);
        int opcion=0;
        int opcion1=0;
        Scanner sn2 = new Scanner(System.in);
        boolean salir2 = false;
        boolean salir = false;
        while (!salir){
            
            System.out.println("1. iniciar el editor colaborativo con datos");
            System.out.println("2. iniciar el editor colaborativo sin datos");
            System.out.println("3. Salir del programa");
            
                try{
                    System.out.println("Escribe el numero de una de las opciones");
                    opcion1 = sn9.nextInt();
                    switch (opcion1){
                        case 1:
                            System.out.println("Has seleccionado la opcion 1, el editor colaborativo iniciara con datos");
                            editor.llenarStack(editor);
                            salir=true;
                            break;
                        case 2:
                            System.out.println("Has seleccionado la opcion 2, el editor colaborativo iniciara sin datos");
                            salir=true;
                            break;
                        case 3:
                            System.out.println("Has seleccionado Salir del programa, hasta la proxima");
                            salir = true;
                            salir2=true;
                            break;
                        default:
                            System.out.println("Solo n�meros entre 1 y 3");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Debes insertar un n�mero");
                    sn2.nextInt();
                }
        }
        while (!salir2) {
 
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. visualizar editor colaborativo");
            System.out.println("4. Salir del programa");
            
            try {
                System.out.println("Elige una de las opciones");
                opcion = sn1.nextInt();
 
                switch (opcion) {
                    case 1:
                        String nombreUser = null;
                        String contraseniaUser = null;
                        Scanner sn3 = new Scanner(System.in);
                        Scanner sn4 = new Scanner(System.in);
                        System.out.println("Eligio la opcion de registrarse, a continuacion escriba su nombre de usuario");
                        nombreUser = sn3.nextLine();
                        System.out.println("Ahora escriba su contrasenia");
                        contraseniaUser = sn4.nextLine();
                        editor.register(nombreUser, contraseniaUser);
                        break;  
                    case 2:
                        String nombreUser2 = null;
                        String contraseniaUser2 = null;
                        Scanner sn5 = new Scanner(System.in);
                        Scanner sn6 = new Scanner(System.in);
                        System.out.println("Has seleccionado Iniciar sesion, a continuacion escriba su nombre de usuario");
                        nombreUser2 = sn5.nextLine();
                        System.out.println("Ahora escriba su contrasenia");
                        contraseniaUser2 = sn6.nextLine();
                        editor.login(nombreUser2, contraseniaUser2);
                        if (editor.getActiveUser().equals(nombreUser2)){
                            boolean salir3 = false;
                            while(!salir3){
                                int opcion2=0;
                                System.out.println("1. Crear nuevo documento");
                                System.out.println("2. Compartir documento");
                                System.out.println("3. Agregar contenido a un documento");
                                System.out.println("4. Restaurar versi�n de un documento");
                                System.out.println("5. Revocar acceso a un documento");
                                System.out.println("6. Buscar en los documentos");
                                System.out.println("7. Visualizar documentos");
                                System.out.println("8. Cerrar sesi�n");
                                System.out.println("9. Salir del programa");
                                Scanner sn7 = new Scanner(System.in);
                                try {                                   
                                    System.out.println("Elige una de las opciones");
                                    opcion2 = sn7.nextInt();
                                    switch (opcion2) {
                                        case 1:
                                            System.out.println("Has seleccionado Crear nuevo documento");
                                            Scanner sn10 = new Scanner(System.in);
                                            String nombreDoc;
                                            System.out.println("Escriba el Nombre del Documento que desea crear:");
                                            nombreDoc = sn10.nextLine();
                                            Scanner sn11 = new Scanner(System.in);
                                            String contenidoDoc;
                                            System.out.println("Escriba el Contenido del Documento que desea crear:");
                                            contenidoDoc = sn11.nextLine();
                                            editor.create(nombreDoc, contenidoDoc);
                                            break;
                                        case 2:
                                            System.out.println("Has seleccionado Compartir documento");
                                            System.out.println("Escriba el id del documento");
                                            int idDoc;
                                            idDoc = sn2.nextInt();
                                            System.out.println("A continuacion es el tipo de permiso");
                                            String permiso = null;
                                            boolean flagAux1=false;
                                            while(!flagAux1){
                                                System.out.println("Solo se admite W, R, C, todos en mayuscula");
                                                System.out.println("Escriba el tipo de permiso:");
                                                permiso = sn5.next();
                                                if(permiso.equals("W") || permiso.equals("R") || permiso.equals("C")){
                                                    flagAux1=true;
                                                }else{
                                                    System.out.println("Error en el tipo de permiso");
                                                }
                                            }
                                            System.out.println("A continuacion escribe los nombres de los usuarios a los cuales quieres compartir la publicacion");
                                            ArrayList<String> destinatarios=new ArrayList();
                                            int aux;
                                            boolean flagAux=false;
                                            while(!flagAux){
                                                String dest;
                                                System.out.println("Ingrese un usuario");
                                                dest=sn9.next();
                                                destinatarios.add(dest);
                                                System.out.println("Desea ingresar otro?");
                                                System.out.println("1. Si\n2. No");
                                                aux=sn2.nextInt();
                                                if(aux==2){
                                                    flagAux=true;
                                                }
                                            }
                                        {
                                            editor.share(destinatarios, idDoc, permiso);
                                        }
                                            break;


                                        case 3:
                                            System.out.println("Has seleccionado Agregar contenido a un documento");
                                            System.out.println("Escriba el id del documento");
                                            int idDoc2;
                                            idDoc2= sn2.nextInt();
                                            System.out.println("Escriba el texto que desea agregar");
                                            String textoAgregar;
                                            textoAgregar = sn5.nextLine();
                                            editor.add(idDoc2, textoAgregar);
                                            break;
                                        case 4:
                                            System.out.println("Has seleccionado Restaurar versi�n de un documento");
                                            System.out.println("Escriba el id del documento");
                                            int idDoc3;
                                            idDoc3= sn2.nextInt();
                                            System.out.println("Escriba el id de la version que desea restaurar");
                                            int versionRestaurar;
                                            versionRestaurar = sn5.nextInt();
                                            editor.rollback(idDoc3, versionRestaurar);
                                            break;
                                        case 5:
                                            System.out.println("Has seleccionado Revocar acceso a un documento");
                                            System.out.println("Escriba el id del documento");
                                            int idDoc4;
                                            idDoc4= sn2.nextInt();
                                            editor.revokeAccess(idDoc4);
                                            break;
                                        case 6:
                                            System.out.println("Has seleccionado Buscar en los documentos");
                                            System.out.println("Esta funcion no esta implementada");
                                            break;
                                        case 7:
                                            System.out.println("Has seleccionado Visualizar el editor colaborativo");
                                            System.out.println(editor.toString());
                                            break;
                                        case 8:
                                            System.out.println("Has seleccionado Cerrar sesi�n");
                                            editor.logout();
                                            salir3 = true;
                                            break;
                                        case 9:
                                            System.out.println("Has seleccionado Salir del programa, hasta la proxima");
                                            salir3 = true;
                                            salir2 = true;
                                            break;
                                        default:
                                            System.out.println("Solo n�meros entre 1 y 9");
                                    }
                                }catch (InputMismatchException e) {
                                    System.out.println("Debes insertar un n�mero");
                                    sn2.nextInt();
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Has seleccionado Visualizar editor colaborativo");
                        System.out.println(editor.toString());
                        break;
                    case 4:
                        System.out.println("Has seleccionado Salir del programa, hasta la proxima");
                        salir2 = true;
                        break;
                    default:
                        System.out.println("Solo n�meros entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un n�mero");
                sn2.nextInt();
            }
        }
        
    }
}
