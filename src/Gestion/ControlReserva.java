
package Gestion;

import Clases.ClienteFrecuente;
import Clases.Reserva;
import Estructuras.ListaEnlazada;
import javax.swing.JOptionPane;


public class ControlReserva {
    
    private ReservaDAO consultas; 
    
    public ControlReserva() { 
        this.consultas = new ReservaDAO();
    } 
// --------------------------------------------------------- 
// 1. Buscar reservas por nombre (usa LinkedList) 
// ---------------------------------------------------------
    public ListaEnlazada <Reserva> buscarReservasPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.matches(".*\\d.*")) { 
            
            JOptionPane.showMessageDialog(null, "Nombre invalido","Error",JOptionPane.ERROR_MESSAGE);
            return new ListaEnlazada<>();
        }
        return consultas.buscarPorNombre(nombre);
    }
  
    public int actualizarEstadoAutomatico(){
    
    ReservaDAO rc=new ReservaDAO();
    
    return rc.actualizarEstado();
    
    }
    
    public boolean verificarClienteReserva(String nombre){
    
    ReservaDAO rc= new ReservaDAO();
    
    return rc.verificarClienteEnReserva(nombre.toUpperCase());
    
    }
    
    public ClienteFrecuente clienteMasFrecuente(){
    
    ReservaDAO rcon=new ReservaDAO();
    
    return rcon.masfrecuente();
    
    
    }
    
    
} 


