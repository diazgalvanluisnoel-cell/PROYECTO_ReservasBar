package Estructuras;

import Clases.ReservaDtaos;

public class ListaEnlazada <E>  {
   
   private Node <E> head;

    public ListaEnlazada() {
        this.head = null;
    }

    public Node<E> getCabeza() {
        return head;
    }
    
    public boolean isEmpty(){
    return head==null;
    }
    
    public void add(E dato){
        
    Node nuevo=new Node(dato);
    if(isEmpty()){
    head=nuevo;
    }
    else{
    Node temp=head;
    while(temp.getNext()!=null){
    temp=temp.getNext();
    }
    temp.setNext(nuevo);
    
    }
       }
    
    public void imprimir (){
    Node temp=head;
    if(temp==null){
    System.out.println("Lista vacia" );
   return;
    }
    while(temp != null){
      System.out.println(temp.getInfo());
        if(temp.getNext()!=null)
            System.out.println("->");
        temp=temp.getNext();
        
    }
    
    System.out.println();
    }

    
   
}
