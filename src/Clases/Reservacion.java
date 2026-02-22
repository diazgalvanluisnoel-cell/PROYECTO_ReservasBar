
package Clases;

import java.time.LocalDate;
import java.time.LocalTime;


public class Reservacion {
    
   private int idReserva;
   private LocalDate fecha;
   private LocalTime hora;
   private LocalTime horafin;
   private int fkmesa;
   private int personas;
   private String estado;
   private int fkcliente;

    public Reservacion(int idReserva, LocalDate fecha, LocalTime hora, LocalTime horafin, int fkmesa, int personas, String estado, int fkcliente) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.hora = hora;
        this.horafin = horafin;
        this.fkmesa = fkmesa;
        this.personas = personas;
        this.estado = estado;
        this.fkcliente = fkcliente;
    }

    public Reservacion() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public LocalTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

    public int getFkmesa() {
        return fkmesa;
    }

    public void setFkmesa(int fkmesa) {
        this.fkmesa = fkmesa;
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

    public int getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "idReserva=" + idReserva + ", fecha=" + fecha + ", hora=" + hora + ", horafin=" + horafin + ", fkmesa=" + fkmesa + ", personas=" + personas + ", estado=" + estado + ", fkcliente=" + fkcliente + '}';
    }
   
   
   
}
