package Gestion;


import Clases.Cliente;
import Clases.ClienteFrecuente;
import Clases.ReservaDtaos;
import Clases.Reservacion;
import Estructuras.ListaEnlazada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;


public class ReservaDAO {
    
   public ListaEnlazada <ReservaDtaos> buscarPorNombre(String nombre){
   
   ListaEnlazada <ReservaDtaos> lista=new ListaEnlazada<>();
   
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
           
           ReservaDtaos r = new ReservaDtaos( 
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
     
     // Obtener datos de una reserva por su id
    public Reservacion obtenerReservaPorId(int idReserva) {

    String sql = "SELECT * FROM reserva WHERE id_reserva = ?";

    try (Connection con = Coneccion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idReserva);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Reservacion r = new Reservacion();

            r.setIdReserva(rs.getInt("id_reserva"));
            r.setFkmesa(rs.getInt("fk_mesa"));
            r.setFkcliente(rs.getInt("fk_cliente"));
            r.setFecha(rs.getDate("fecha").toLocalDate());
            r.setHora(rs.getTime("hora").toLocalTime());
            r.setHorafin(rs.getTime("hora_fin").toLocalTime());
            r.setPersonas(rs.getInt("cant_personas"));
            r.setEstado(rs.getString("estado"));

            return r;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
     
     
     /* En la opcion de modificar la fecha se verifica 
     que en la nueva fecha la mesa de esa reserva este disponible 
     */
     public int modificarFechaReserva (int idReserva, int fkMesa ,  LocalDate nuevafecha , 
             LocalTime hora , LocalTime horafin ){
         
         try(Connection con = Coneccion.getConnection()){
                  
         //Capacidad de la mesa actual
         String sqlCapacidad = "SELECT capacidad FROM mesa WHERE id_mesa = ?";
         
        PreparedStatement psCapacidad = con.prepareStatement(sqlCapacidad);
        psCapacidad.setInt(1, fkMesa);
        
        ResultSet rsCap = psCapacidad.executeQuery();
                
        int capacidad=0;
        
        if(rsCap.next()){
        capacidad = rsCap.getInt("capacidad");
        }
        
        // Buscar mesa disponible con esa capacidad
        
        String sqlMesa = "SELECT m.id_mesa FROM mesa m WHERE m.capacidad = ? "
                + "AND m.id_mesa NOT IN ( SELECT r.fk_mesa FROM reserva r WHERE r.fecha = ? "
                + "AND ( ? < r.hora_fin AND ? > r.hora) "
                + ") LIMIT 1";
        
        PreparedStatement psBuscar = con.prepareStatement(sqlMesa);
        psBuscar.setInt(1, capacidad);
        psBuscar.setDate(2, Date.valueOf(nuevafecha));
        psBuscar.setTime(3, Time.valueOf(hora));
        psBuscar.setTime(4, Time.valueOf(horafin));

        ResultSet rsMesa = psBuscar.executeQuery();

        if (!rsMesa.next()) {
            return -1;
        }

        int nuevaMesa = rsMesa.getInt("id_mesa");

        // Actualizar fecha y mesa
        String sqlUpdate = "UPDATE reserva "
            + "SET fecha = ?, fk_mesa = ?, hora = ? , hora_fin = ? "
            + "WHERE id_reserva = ?" ;

        PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
        psUpdate.setDate(1, Date.valueOf(nuevafecha));
        psUpdate.setInt(2, nuevaMesa);
        psUpdate.setTime(3, Time.valueOf(hora));
        psUpdate.setTime(4, Time.valueOf(horafin));
        psUpdate.setInt(5, idReserva);

        psUpdate.executeUpdate();
       // System.out.println(filas);
        
        return nuevaMesa;
        
                }catch(SQLException e){
                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR EN METODO modificarMesa");
                return -1;
                }
       
          
       
     }
     
     
   }
    
    

