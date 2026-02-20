package Gestion;

import Clases.Cliente;
import Clases.ClienteFrecuente;
import Clases.ClienteHistoria;
import Estructuras.LinkedPila;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ClienteDAO {
    private Object con;
    
    public LinkedPila <ClienteHistoria> historialClientes(){
    
        LinkedPila <ClienteHistoria> pilaCliente=new LinkedPila <> ();
        
        try{
        Connection conex = Coneccion.getConnection();
            
    String sql="SELECT c.id_cliente, c.nombre, c.telefono, "
      + "COUNT(r.id_reserva) AS total_reservas, MAX(r.fecha) AS ultima_fecha "
      + "FROM cliente c LEFT JOIN reserva r "
      + "ON r.fk_cliente = c.id_cliente GROUP BY c.id_cliente, c.nombre, c.telefono "
      + "ORDER BY ultima_fecha DESC NULLS LAST;";
    
    PreparedStatement ps = conex.prepareStatement(sql); 
    ResultSet rs = ps.executeQuery();
    
    while(rs.next()){
    
        Cliente cli = new Cliente(); 
        cli.setId(rs.getInt("id_cliente")); 
        cli.setNombre(rs.getString("nombre")); 
        cli.setTelefono(rs.getString("telefono"));
        
        ClienteFrecuente cf=new ClienteFrecuente();
        cf.setCliente(cli);
        cf.setCant_reserva(rs.getInt("total_reservas"));
        
        ClienteHistoria ch=new ClienteHistoria();
        ch.setFrecuente(cf);
        ch.setFecha(rs.getDate("ultima_fecha"));
        
        pilaCliente.push(ch);
    }
    
    
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR EN METODO HISTORIAL CLIENTE");
        }
    
        return pilaCliente;
    }
}
