/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evidencia1;

/**
 *
 * @author danae
 * @param <E>
 */
public class PriorityNode<E> {
    //Se crea el id
    private int id;
    //Se crea el numero de nodos que tiene.
    private int NUM_NODES = 0;
    //Se define la prioridad
    private int priority;
    //Define el numero de la fila
    private int num_Fila;
    //Define los datos que tendra adentro.
    private E data;

    /**
     * constructor vacío
     */
    public PriorityNode() {
        this.id = NUM_NODES++;
    }    

    /**
     * Constructor lleno
     * @param priority
     * @param data
     * @param num_Fila 
     */
    public PriorityNode(int priority, E data, int num_Fila) {
      this.priority  = priority;
      this.data  = data;
      this.num_Fila = num_Fila;
      }   

    /**
     * Te da el numero de la fila.
     * @return num_Fila
     */
    public int getNum_Fila() {
        return num_Fila;
    }

    /**
     * Te da el numero de nodos
     * @return NUM_NODES
     */
    public int getNUM_NODES() {
        return NUM_NODES;
    }

    //setters &  getters
    public int getPriority() {
      return priority;
      }    

    public void setPriority(int  priority) {
      this.priority  = priority;
      }    

    public E getData() {
      return data;
      }    

    public void setData(E data) {
      this.data  = data;
      }    

    @Override
    public String toString() {
      return data + "";
      }
}
