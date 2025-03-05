/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema2;

/**
 *
 * @author danae
 */
public class Tema2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear un nuevo nodo que su elemento sea la palabra Patito e imprimirlo
        Node myNode = new Node("Patito");
        System.out.println(myNode);
        //Crear una nueva lista donde se agregaran los elementos, unicamente de 
        //integer ya que se define aqui.
        List<Integer> myList = new List();
        myList.add(5);
        //Se agrega a la lista el dato y se imprime
        System.out.println(myList);
        //Se agrega a la lista el dato y se imprime
        myList.add(8);
        System.out.println(myList);
        //Se agrega a la lista el dato y se imprime
        myList.add(6);
        System.out.println(myList);
        //Se agrega a la lista el dato y se imprime
        myList.add(7);
        System.out.println(myList);
        //Se elimina el elemento en la posicion seleccionada y se imprime.
        myList.deleteAt(2);
        System.out.println(myList);
        //Se inserta un dato establecido en una posicion especifica y se imprime.
        myList.insertAt(1, 9);
        System.out.println(myList);
        //Se inserta el dato dado en el principio de la lista y se imprime.
        myList.insertAtFirst(5);
        System.out.println(myList);
    }
    
}
