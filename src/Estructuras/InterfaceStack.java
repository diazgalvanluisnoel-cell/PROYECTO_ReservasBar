package Estructuras;

import Clases.Reserva;

public interface InterfaceStack <E> {
    
    boolean isEmpty();
    void push(E item);
    E pop();
    E top();
}
