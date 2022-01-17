
package lab3_205804404_valdes;

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
                            System.out.println("Solo números entre 1 y 3");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
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
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn2.nextInt();
            }
        }
        
    }
}
