import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("------------------------------------");
            System.out.println("  Aplicación de mensajes  ");
            System.out.println("   1. crear mensaje");
            System.out.println("   2. listar mensaje");
            System.out.println("   3. editar mensaje");
            System.out.println("   4. eliminar mensaje");
            System.out.println("   5. SALIR");

            // leer opcion del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMesnaje();
                    break;
                case 4:
                    MensajesService.borrarMensajes();
                    break;
                default:
                    System.out.println("Indique una opción válida.");
                    break;
            }
        }while (opcion != 5);

    }
}