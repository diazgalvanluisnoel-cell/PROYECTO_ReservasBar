package Clases;


import java.time.LocalDate;
import java.time.LocalTime;


public class Reserva {
    
   private int idReserva;
   private String nombre;
   private String telefono;
   private LocalDate fecha;
   private LocalTime hora;
   private int mesa;
   private int personas;
   private String estado;

    public Reserva(int idReserva, String nombre, String telefono, LocalDate fecha, LocalTime hora, int mesa, int personas, String estado) {
        this.idReserva = idReserva;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
        this.hora = hora;
        this.mesa = mesa;
        this.personas = personas;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "ID=" + idReserva + ", Nombre=" + nombre + ", Telefono=" + telefono + ", Fecha=" + fecha + ", Hora=" + hora + ", Mesa=" + mesa + ", Personas=" + personas + ", Estado=" + estado + '}';
    }
   
   
    
    
    
    
}
