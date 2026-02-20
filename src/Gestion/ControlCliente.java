
package Gestion;

import Clases.ClienteHistoria;
import Estructuras.LinkedPila;

public class ControlCliente {
  
    public LinkedPila <ClienteHistoria> historialClientes() { 
        ClienteDAO consulta = new ClienteDAO();
        return consulta.historialClientes();
    }
}
