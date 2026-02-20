package Estructuras; 

public class LinkedPila<E> implements InterfaceStack<E> {
    private Node<E> top;
    
    public LinkedPila() {
        top = null; } 
    
    @Override public boolean isEmpty() 
    { return top == null; } 
    
    @Override public void push(E item) { 
        Node<E> nuevo = new Node<>(item);
        nuevo.setNext(top); top = nuevo; } 
    
    @Override public E pop() { 
        if (isEmpty()) { return null; }
        
        E aux = top.getInfo(); 
        top = top.getNext(); 
        return aux; } 
    
    @Override public E top() {
        if (isEmpty()) { return null; }
        return top.getInfo(); } }
