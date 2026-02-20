
package Clases;

import java.sql.Date;
import java.time.LocalDate;

public class ClienteHistoria {
 
    private ClienteFrecuente frecuente;
    private Date fecha;

    public ClienteHistoria(ClienteFrecuente frecuente, Date fecha) {
        this.frecuente = frecuente;
        this.fecha = fecha;
    }

    public ClienteHistoria() {
    }
    
    public ClienteFrecuente getFrecuente() {
        return frecuente;
    }

    public void setFrecuente(ClienteFrecuente frecuente) {
        this.frecuente = frecuente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    
}
