/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolenario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danae
 */
public class Nodo<E> {
    private E dato;
    private List<Nodo<E>> hijos;

    public Nodo(E dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public E getDato() {
        return dato;
    }

    public List<Nodo<E>> getHijos() {
        return hijos;
    }

    public void agregarHijo(Nodo<E> hijo) {
        this.hijos.add(hijo);
    }
}
