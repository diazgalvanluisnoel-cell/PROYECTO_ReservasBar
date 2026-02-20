package Gestion;

import Interfaces.VistaInicial;
import java.sql.*;

public class Principal {
    
    public static void main (String [] args) throws SQLException{
        Coneccion.live();
    
     //System.out.println(LocalTime.now()); 
        
        VistaInicial vi =new VistaInicial();
        vi.setLocationRelativeTo(null);
        vi.setVisible(true);
        
         
    }
}
