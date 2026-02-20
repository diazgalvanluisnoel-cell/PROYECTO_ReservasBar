package Gestion;


import Clases.Cliente;
import Clases.ClienteFrecuente;
import Clases.Reserva;
import Estructuras.ListaEnlazada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;


public class ReservaDAO {
    
   public ListaEnlazada <Reserva> buscarPorNombre(String nombre){
   
   ListaEnlazada <Reserva> lista=new ListaEnlazada<>();
   
   String sql = "SELECT r.id_reserva, r.fecha, r.hora, r.estado, " + 
           "r.fk_mesa, r.cant_personas, c.nombre, c.telefono " + "FROM reserva r " + 
           "JOIN cliente c ON r.fk_cliente = c.id_cliente " + "WHERE c.nombre LIKE ?"; 
   
   try (Connection con = Coneccion.getConnection();
           PreparedStatement ps = con.prepareStatement(sql)) { 
       
       ps.setString(1, "%" + nombre + "%"); 
       ResultSet rs = ps.executeQuery();
       
       while (rs.next()) {
           LocalDate fechac = rs.getDate("fecha").toLocalDate();
           LocalTime horac = rs.getTime("hora").toLocalTime();
           
           Reserva r = new Reserva( 
                   rs.getInt("id_reserva"), 
                   rs.getString("nombre"), 
                   rs.getString("telefono"), 
                   fechac, 
                   horac,  
                   rs.getInt("fk_mesa"), 
                   rs.getInt("cant_personas"), 
                   rs.getString("estado") );
           
                 lista.add(r); 
       }
   } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "ERROR EN METODO buscarNombre");
   }
   return lista; 
   }

     public int actualizarEstado(){

      try{
            Connection con = Coneccion.getConnection();
            
            String sql = "UPDATE reserva SET estado = 'Completada' WHERE estado = 'Pendiente' AND (fecha < CURRENT_DATE "
                    + "OR (fecha = CURRENT_DATE AND hora > CURRENT_TIME ) )";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
           return ps.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en actualizar reservaciones .");
            return 0;
        }

      }
     
     public boolean verificarClienteEnReserva(String nombre) {

        try {

            Connection conex = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva , r.fk_cliente ,c.nombre,c.telefono,c.id_cliente "
                    + "FROM reserva r JOIN cliente c ON r.fk_cliente = c.id_cliente WHERE c.nombre = ? ";

            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return true;
            }

            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN METODO VERIFICAR UN CLIENTE EN UNA RESERVA");
        }
        return false;

    }
      
     // Buscar cliente mas frecuente del bar
     public ClienteFrecuente masfrecuente(){
     
         Cliente  clienteFrecuente = null;
         ClienteFrecuente resultado = null;
         
     try{
         
         Connection con = Coneccion.getConnection();
         
   String sql="  SELECT c.id_cliente, c.nombre,c.telefono, COUNT(r.fk_cliente) AS total_reservas "
           + "FROM reserva r JOIN cliente c ON r.fk_cliente = c.id_cliente "
           + "GROUP BY c.id_cliente, c.nombre,c.telefono ORDER BY total_reservas DESC LIMIT 1";
   
   PreparedStatement ps = con.prepareStatement(sql); 
   
   ResultSet rs = ps.executeQuery();
   
   
   if (rs.next()) {
       
    clienteFrecuente = new Cliente();
       
    clienteFrecuente.setId(rs.getInt("id_cliente"));
    clienteFrecuente.setNombre(rs.getString("nombre"));
    clienteFrecuente.setTelefono(rs.getString("telefono"));
    
    resultado = new ClienteFrecuente();
    resultado.setCliente(clienteFrecuente);
    resultado.setCant_reserva(rs.getInt("total_reservas"));
    
   }
   
   if(resultado==null){
   JOptionPane.showMessageDialog(null, "No hay reservaciones en el sistema");
   return null;
   }
             }catch(SQLException e){
                 e.printStackTrace();
             JOptionPane.showMessageDialog(null, "ERROR EN METODO CLIENTE FRECUENTE");
             }
     
     return resultado;
     }
     
     // Pendiente
     public void disponibleMesa(Date fecha){
     
         ListaEnlazada <Integer> numeros=new ListaEnlazada <>();
         
         try{
          Connection con = Coneccion.getConnection();
         
         String sql="SELECT * FROM reserva WHERE fecha = ?";
     
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setDate(1, fecha);
         
         ResultSet rs=ps.executeQuery();
         
         while(rs.next()){
         numeros.add(rs.getInt("fk_mesa"));
         }
         
         
         
         }catch(SQLException e){
         e.printStackTrace();
         }
     }
   }
    
    

