
package Gestion;

import Clases.ClienteFrecuente;
import Clases.ReservaDtaos;
import Clases.Reservacion;
import Estructuras.ListaEnlazada;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;


public class ControlReserva {
    
    private ReservaDAO consultas; 
    
    public ControlReserva() { 
        this.consultas = new ReservaDAO();
    } 
// --------------------------------------------------------- 
// 1. Buscar reservas por nombre (usa LinkedList) 
// ---------------------------------------------------------
    public ListaEnlazada <ReservaDtaos> buscarReservasPorNombre(String nombre) {
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
    
    public Reservacion obtenerReservaPorTd(int id){
    
        ReservaDAO rd = new ReservaDAO();
        
        return rd.obtenerReservaPorId(id);
    }
    
    public void modificarFecha(int idReserva, LocalDate nuevafecha ){
        
       Reservacion reserva = consultas.obtenerReservaPorId(idReserva);

    if (reserva == null) {
        JOptionPane.showMessageDialog(null, "Reserva no encontrada");
        return;
    }

    // Llamar al método DAO pasando los datos desde el objeto
    int mesaAsignada = consultas.modificarFechaReserva(
            reserva.getIdReserva(),
            reserva.getFkmesa(),
            nuevafecha,
            reserva.getHora(),
            reserva.getHorafin()
    );

    
    //  Mostrar mensaje según resultado
    if (mesaAsignada == -1) {
        JOptionPane.showMessageDialog(null,
            "No hay mesas disponibles para la fecha "+nuevafecha);
    } else {
        JOptionPane.showMessageDialog(null,
            "Reserva modificada. Mesa asignada: \n" + mesaAsignada+"\nNueva fecha : "+nuevafecha);
    }
    }
} 


