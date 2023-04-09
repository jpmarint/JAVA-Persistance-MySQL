import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Escribe tu mensaje:");
        String mensaje = sc.nextLine();
        System.out.println("Tu nombre:");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajosDAO.CrearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajosDAO.LeerMensajesDB();
    }

    public static void borrarMensajes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje a borrar: ");
        int id_mensaje = sc.nextInt();
        MensajosDAO.BorrarMensajeDB(id_mensaje);
    }

    public static void editarMesnaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribre tu nuevo mensaje");
        String nuevoMensaje = sc.nextLine();

        System.out.println("Indica el ID del mensaje: ");
        int id = sc.nextInt();
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id);
        actualizacion.setMensaje(nuevoMensaje);

        MensajosDAO.ActualizarMensajeDB(actualizacion);
    }
}
