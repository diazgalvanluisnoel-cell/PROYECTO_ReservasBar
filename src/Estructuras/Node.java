package Estructuras; 

public class Node<E> { 
    
    protected E info; 
    protected Node<E> next; 
    
    public Node(E info) {
        this.info = info;
        this.next = null; }
    
    public Node(E info, Node<E> next) { 
        this.info = info; 
        this.next = next; }
    
    public E getInfo() {
        return info; } 
    
    public void setInfo(E info) {
        this.info = info; } 
    
    public Node<E> getNext() { 
        return next; } 
    
    public void setNext(Node<E> next) { 
        this.next = next; } }