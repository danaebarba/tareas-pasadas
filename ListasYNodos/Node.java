/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

/**
 *
 * @author danae
 */
//Clase node con la variable de V para que se pueda definir cualquier elemento 
//como cualquier variable.
public class Node <V> {
    private int id = 0;
    //Contador de nodos creados.
    public static int NUM_NODES = 0;
    //Data de cualquier tipo de variable.
    private V data = null;
    //Nodo que le sigue al nodo creado.
    private Node next = null;

    /**
     * Constructor vacio que le agrega el contador de nodos cada que se crea uno
     * nuevo.
     */
    public Node() {
        this.id = NUM_NODES++;
    }
    
    /**
     * Crea este data como el data dado en el main.
     * @param data 
     */
    public Node(V data){
        this();
        this.data = data;
    }

    /**
     * Obtiene el data dado.
     * @return 
     */
    public V getData() {
        return data;
    }

    /**
     * Establece el data
     * @param data 
     */
    public void setData(V data) {
        this.data = data;
    }

    /**
     * Obtiene el ID
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el next, que es el siguiente nodo de este.
     * @param next 
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     * @return 
     */
    public Node getNext() {
        return next;
    }

    /**
     * Imprime el nodo y su data.
     * @return 
     */
    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
