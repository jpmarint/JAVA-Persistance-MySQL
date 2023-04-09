import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajosDAO {

    public static void CrearMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();

                System.out.println("Mensaje creado correctamente :)");
                System.out.println(mensaje.getMensaje());

            }catch (SQLException e){
                System.out.println("Falló :( creación de mensaje");
                System.out.println(e);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void LeerMensajesDB() {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT * FROM `mensajes`";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: "+ rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println();
            }
        }catch (SQLException ex){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }

    public static void BorrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id_mensaje);
            int countRowsUpdated = ps.executeUpdate();
            if (countRowsUpdated != 0) {
                System.out.println("Menssage has been deleted successfully.");
            } else {
                System.out.println("Message was not found.");
            }

        }catch (SQLException ex){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }

    public static void ActualizarMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try{
               String query =  "UPDATE `mensajes` SET `mensaje` = ? WHERE `mensajes`.`id_mensaje` = ?;";
               ps = conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());
               ps.executeUpdate();
               System.out.println("Mensaje actualizado correctamente");
            }catch (SQLException e){
                System.out.println("No se pudo actualizar el mensaje");
                System.out.println(e);
            }

        }catch (SQLException ex){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }
}
