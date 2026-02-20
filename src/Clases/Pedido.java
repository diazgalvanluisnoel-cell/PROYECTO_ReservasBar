package Clases;


import java.time.LocalDate;


public class Pedido {
    
    int id;
    Cliente cliente;
    String estado;
    LocalDate fecha;

    public Pedido(int id, Cliente cliente, String estado, LocalDate fecha) {
        this.id = id;
        this.cliente = cliente;
        this.estado = "Pendiente";
        this.fecha = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", estado=" + estado + ", fecha=" + fecha + '}';
    }
    
    
}
