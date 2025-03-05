/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lavaca;

import java.io.Serializable;

/**
 *
 * @author danae
 */
class Nodo implements Serializable {
    private String valor;
    private Nodo hijoSi;
    private Nodo hijoNo;

    public Nodo(String valor) {
        this.valor = valor;
        this.hijoSi = null;
        this.hijoNo = null;
    }
    public String getValor() {
        return valor;
    }

    public Nodo getHijo(String respuesta) {
        if (respuesta.equalsIgnoreCase("Si")) {
            return hijoSi;
        } else {
            return hijoNo;
        }
    }
    
    public void agregarHijo(String respuesta, Nodo nodo) {
        if (respuesta.equalsIgnoreCase("Si")) {
            hijoSi = nodo;
        } else {
            hijoNo = nodo;
        }
    }

    public boolean esHoja() {
        return hijoSi == null && hijoNo == null;
    }
}
