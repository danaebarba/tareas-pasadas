/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad4;

import java.util.ArrayList;

/**
 *
 * @author danae
 * @param <E>
 */
public class PriorityQueue<E> {
    private int id;
    public static int NUM_LISTS = 0;
    private ArrayList<PriorityNode> data = null;

    /**
     * Constructor vacio.
     */
    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    /**
     * Agrega el dato dado a la fila
     * @param dataToInsert 
     */
    public void push(PriorityNode dataToInsert){
      data.add(dataToInsert);
    }
    
    /**
     * Determina si la fila esta vacia.
     * @return 
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }
    
    /**
     * Saca el primer elemento de la lista.
     * @return
     * @throws Exception 
     */
    public PriorityNode pop() throws Exception{
        PriorityNode result = null;
        if(this.isEmpty()){
            throw new Exception("La lista esta vacia.");
        }
        result = this.data.get(0);
        for(int i = 0; i < this.size() - 1; i++){
            this.data.set(i, this.data.get(i + 1));
        }
        this.data.remove(this.size()-1);
        return result;
    }
    
    /**
     * Te enseña el primer elemento de la lista
     * @return
     * @throws Exception 
     */
    public PriorityNode peek() throws Exception{
        PriorityNode result = null;
        if(this.isEmpty()){
            throw new Exception("La lista esta vacia.");
        }
        result = this.data.get(0);
        return result;
    }
    
    /**
     * Agrega un nuevo elemento a la lista y lo reordena dependiendo de su 
     * prioridad.
     * @param priority
     * @param value
     * @param list 
     */
    public void push(int priority, String value, int list){
        //creamos  nodo a insertar
        PriorityNode nodeToInsert = new PriorityNode(priority, value, list);
        //si es el  primero lo ponemos en la posición 1 y listo
        if (size() ==1){
            data.add(nodeToInsert);
        } else {
            //Si no  está vacía la cola priorizada
            //la  posición temporal es la última
            int myPosition = size();
            //ponemos  el nodo ahí
            data.set(myPosition, nodeToInsert);
            //encontramos  la posición del padre
            int myParentPosition =(int)(myPosition/2);
            //Y  guardamos el valor del padre
            PriorityNode myParent =  data.get(myParentPosition);
            //repetimos  intercambiar el padre con el hijo hasta que el padre
            //tenga  mayor prioridad que el hijo
            while (myPosition!=1&&  myParent.getPriority()>nodeToInsert.getPriority()
                    ){
                data.set(myPosition, myParent);
                data.set(myParentPosition, nodeToInsert);
                myPosition =myParentPosition;
                myParentPosition = (int)(myParentPosition/2);
                myParent= data.get(myParentPosition);
            }
        }
    }
    
    /**
     * Determina el tamaño de la fila
     * @return 
     */
    public int size(){
        return data.size();
    }
    
    /**
     * Te muestra la fila.
     * @return 
     */
    public String show(){
        return data.toString();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" + "data=" + data + '}';
    }
}
