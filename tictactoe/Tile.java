/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

/**
 *
 * @author danae
 */
public class Tile {
    //ID de la casilla.
    private int id=0;
    //Se define el icono en la casilla.
    private char icon= '.';

    /***
     * Constructor vacio.
     */
    public Tile() {
    }

    /***
     * Constructor lleno.
     * @param id
     * @param icon 
     */
    public Tile(int id, char icon) {
        this.id = id;
        this.icon = icon;
    }

    /***
     * Se obtiene el id de la casilla.
     * @return 
     */
    public int getId() {
        return id;
    }

    /***
     * Se define el id de la casilla.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Se obtiene el icono de la casilla.
     * @return 
     */
    public char getIcon() {
        return icon;
    }

    /***
     * Se define el icono de la casilla.
     * @param icon 
     */
    public void setIcon(char icon) {
        this.icon = icon;
    }

    /***
     * Muestra el icono de la casilla.
     * @return 
     */
    @Override
    public String toString() {
        return icon + "";
    }
    
}
