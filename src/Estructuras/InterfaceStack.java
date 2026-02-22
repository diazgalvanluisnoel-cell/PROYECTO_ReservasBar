package Estructuras;

import Clases.ReservaDtaos;

public interface InterfaceStack <E> {
    
    boolean isEmpty();
    void push(E item);
    E pop();
    E top();
}
