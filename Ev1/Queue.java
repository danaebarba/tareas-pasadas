/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evidencia1;

import java.util.ArrayList;

/**
 *
 * @author danae
 */
public class Queue<E> {
    private int id;
    private ArrayList<E> myData = new ArrayList<E>();
    public static int num = 0;
    private int sizeLimit;

    /**
     * Constructor lleno
     * @param sizeLimit 
     */
    public Queue(int sizeLimit) {
        this.id = num++;
        this.sizeLimit = sizeLimit;
    }
    
    /**
     * Agrega un dato nuevo a la lista.
     * @param dataToInsert 
     */
    public void push(E dataToInsert){
        myData.add(dataToInsert);
    }
    
    /**
     * Determina si la lista esta vacía
     * @return 
     */
    public boolean isEmpty(){
        return myData.isEmpty();
    }
    
    /**
     * Elimina el primer dato de la lista
     * @return
     * @throws Exception 
     */
    public E pop() throws Exception{
        E result;
        if(this.isEmpty()){
            throw new Exception("La lista esta vacia.");
        }
        result = this.myData.get(0);
        for(int i = 0; i < this.size() - 1; i++){
            this.myData.set(i, this.myData.get(i + 1));
        }
        this.myData.remove(this.size()-1);
        return result;
    }
    
    /**
     * te muestra el primer dato de la lista
     * @return
     * @throws Exception 
     */
    public E peek() throws Exception{
        E result;
        if(this.isEmpty()){
            throw new Exception("La lista esta vacia.");
        }
        result = this.myData.get(0);
        return result;
    }
    
    /**
     * Te muestra el tamaño de la lista
     * @return 
     */
    public int size(){
        return myData.size();
    }
    
    /**
     * Te muestra lo que contiene la lista
     * @return 
     */
    public String show(){
        return myData.toString();
    }
    
    /**
     * determina si la lista esta llena.
     * @return 
     */
    public boolean isFull(){
        boolean result = false;
        if(myData.size() == sizeLimit){
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return myData + " ";
    }
    
}
