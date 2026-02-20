package Clases;


import Clases.Cliente;


public class ClienteFrecuente {
  
   private Cliente cliente;
   private int cant_reserva;

    public ClienteFrecuente(Cliente cliente, int cant_reserva) {
        this.cliente = cliente;
        this.cant_reserva = cant_reserva;
    }

    public ClienteFrecuente() {
      
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCant_reserva() {
        return cant_reserva;
    }

    public void setCant_reserva(int cant_reserva) {
        this.cant_reserva = cant_reserva;
    }

    @Override
    public String toString() {
        return "ClienteFrecuente{" + "cliente=" + cliente + ", cant_reserva=" + cant_reserva + '}';
    }
    
   
    
}
