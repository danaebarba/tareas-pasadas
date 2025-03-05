/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

/**
 *
 * @author danae
 */
public class Player {
    //ID del jugador.
    private int id=0;
    //Icono del jugador.
    private char icon=' ';
    //Boolean que define si el jugador ha ganado o no.
    private boolean hasWon = false;

    /***
     * Constructor vacio
     */
    public Player() {
    }

    /***
     * Constructor lleno
     * @param id
     * @param icon
     * @param hasWon 
     */
    public Player(int id, char icon, boolean hasWon) {
        this.id = id;
        this.icon = icon;
        this.hasWon = hasWon;
    }

    /***
     * Se obtiene el id del jugador.
     * @return id
     */
    public int getId() {
        return id;
    }

    /***
     * Da un id al jugador.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Se obtiene el icono del jugador.
     * @return icon
     */
    public char getIcon() {
        return icon;
    }

    /***
     * Se le da un icono al jugador.
     * @param icon 
     */
    public void setIcon(char icon) {
        this.icon = icon;
    }
}
