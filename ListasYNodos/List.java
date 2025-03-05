/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

/**
 *
 * @author danae
 */
public class List <V> {
    private int id;
    //Contador de numero de listas creadas.
    public static int NUM_LISTS = 0;
    //El primer nodo de la lista.
    private Node <V> first = null;

    /**
     * Contador vacio.
     * Le agrega uno al numero de listas cada que se crea una.
     */
    public List() {
        this.id = NUM_LISTS++;
    }
    
    /**
     * Se agrega el data dado a la lista.
     * @param data 
     */
    public void add(V data){
        //Se crea el nodo seleccionado, y el nodo que se va a insertar.
        Node nodeToInsert = new Node(data);
        Node selectNode = new Node();
        //Si el primer lugar de la lista esta vacio, se inserta el nodo ahi.
        if(this.first == null){
            this.first = nodeToInsert;
        } else {
            //Si no, se agrega a el que siga hasta que este vacio.
            selectNode = this.first;
            //Mientras el nodo que siga no este vaccio, se obtendra el siguiente.
            while (selectNode.getNext() != null){
            selectNode = selectNode.getNext();
          }
            //Cuando se encuentre uno vacio, se agrega ahi.
            selectNode.setNext(nodeToInsert);
        }
    }
    
    /**
     * Se inserta el nodo al principio de la lista
     */
    public void insertAtFirst(){
       Node nodeToInsert = new Node();
       nodeToInsert.setNext(first);
       first = nodeToInsert;
    } 
    
    /**
     * Se inserta el nodo al principio de la lista
     * @param data 
     */
    public void insertAtFirst(V data){
        Node dataNode = new Node(data);
        dataNode.setNext(first);
        first = dataNode;
    }
    
    /**
     * Se inserta el nodo a cierto lugar establecido.
     * @param id 
     */
    public void insertAt(int id){
        Node currentNode = new Node();
        Node beforeNode = new Node();
        Node nodeToInsert = new Node();
        currentNode = first;
        for(int i = 2; i <= id; i++){
            beforeNode = currentNode;
            currentNode = currentNode.getNext();
        }
        beforeNode.setNext(nodeToInsert);
        nodeToInsert.setNext(currentNode);
    }
    
    /**
     * Se inserta el nodo a cierto lugar establecido.
     * @param id
     * @param data 
     */
    public void insertAt(int id, V data){
        Node currentNode = new Node();
        Node beforeNode = new Node();
        Node nodeToInsert = new Node();
        currentNode = first;
        for(int i = 2; i <= id; i++){
            beforeNode = currentNode;
            currentNode = currentNode.getNext();
        }
        beforeNode.setNext(nodeToInsert);
        nodeToInsert.setNext(currentNode);
    }
    
    /**
     * Se define di un lugar esta vacio.
     * @return 
     */
    public boolean isNull(){
        //Si el lugar esta vacio, se marca como vacio.
        boolean isNull = false;
        if(first == null){
            isNull = true;
        }
        return isNull;
    }
    
    /**
     * Se define el tamaño de la lista
     * @return 
     */
    public int size(){
        int nodeCount = 0;
        
        // Si esta vacia se regresa el numero.
        if(this.isNull() == true){
            return nodeCount;
        } else {
            //Se crea un nuevo nodo desde el principio.
            Node currentNode = first;
            //Mientras que el siguiente nodo no sea nulo se sigue repitiendo.
            while(currentNode.getNext() != null){
                //Se agrega uns a la cuenta de nodos
                nodeCount++;
                currentNode = currentNode.getNext();
            }
            nodeCount++;
            return nodeCount;
        }
    }
    
    /**
     * Se borra el elemento en un lugar especifico.
     * @param id 
     */
    public void deleteAt(int id){ 
        Node currentNode = new Node();
        Node beforeNode = new Node();
        currentNode = first;
        for(int i = 2; i <= id; i++){
            beforeNode = currentNode;
            currentNode = currentNode.getNext();
        }
        beforeNode.setNext(currentNode.getNext());
    }

    /**
     * Regresa la lista completa de todos los nodos con su data.
     * @return 
     */
    @Override
    public String toString() {
        if(this.isNull() == true){
            return "Esta vacío";
        } else {
            Node currentNode = first;
            String listText = "List( Node (";
            while(currentNode.getNext() != null){
                listText = listText + currentNode.getData() + "), Node(";
                currentNode = currentNode.getNext();
            }
            listText = listText + currentNode.getData() + "))";
            return listText;
        }
    }
}
