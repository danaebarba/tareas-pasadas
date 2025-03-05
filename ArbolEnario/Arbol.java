/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolenario;

/**
 *
 * @author danae
 */
public class Arbol<E> {
     private Nodo<E> raiz;

    public Arbol(E datoRaiz) {
        this.raiz = new Nodo<>(datoRaiz);
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }
}
