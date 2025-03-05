/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import java.util.ArrayList;

/**
 *
 * @author danae
 */
public class Stack <E> {
    private int id = 0;
    private ArrayList<E> myData = new ArrayList<E>();
    public static int num = 0;

    public Stack() {
        this.id = num++;
    }
    
    public void push(E dataToInsert){
        myData.add(dataToInsert);
    }
    
    public boolean isEmpty(){
        return myData.isEmpty();
    }
    
    public E pop() throws Exception{
        E result = null;
        if(this.isEmpty()){
            throw new Exception("La lista esta vacia.");
        }
        result = this.myData.get(this.size()-1);
        this.myData.remove(this.size()-1);
        return result;
    }
    
    public E peek() throws Exception{
        E result = null;
        if(this.isEmpty()){
            throw new Exception("La lista esta vacia.");
        }
        result = this.myData.get(this.size()-1);
        return result;
    }
    
    public int size(){
        return myData.size();
    }
    
    public String show(){
        return myData.toString();
    }
    
    public void insertAtBottom(E dataToInsert) throws Exception {  
        if (isEmpty()){  
        push(dataToInsert);  
        } else {  
            E top = pop();  
            insertAtBottom(dataToInsert);  
            push(top);
        }  
    }  
    
    public void reverse() throws Exception {  
        if (!isEmpty()) {
            E top = pop();
            reverse();
            insertAtBottom(top);
        }
    }  
}
