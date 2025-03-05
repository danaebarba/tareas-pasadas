/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolenario;

/**
 *
 * @author danae
 */
public class ArbolEnario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol<String> arbol = new Arbol<>("Raiz");
        Nodo<String> raiz = arbol.getRaiz();

        Nodo<String> hijo1 = new Nodo<>("Hijo 1");
        Nodo<String> hijo2 = new Nodo<>("Hijo 2");
        Nodo<String> hijo3 = new Nodo<>("Hijo 3");

        raiz.agregarHijo(hijo1);
        raiz.agregarHijo(hijo2);
        raiz.agregarHijo(hijo3);

        Nodo<String> nieto1 = new Nodo<>("Nieto 1");
        Nodo<String> nieto2 = new Nodo<>("Nieto 2");

        hijo1.agregarHijo(nieto1);
        hijo1.agregarHijo(nieto2);
        
        System.out.println("Dato de la raíz: " + raiz.getDato());
        System.out.println("Hijos de la raíz:");
        for (Nodo<String> hijo : raiz.getHijos()) {
            System.out.println(hijo.getDato());
        }
    }
    
}
