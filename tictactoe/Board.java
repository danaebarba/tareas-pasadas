/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

import java.util.Arrays;

/**
 *
 * @author danae
 */
public class Board{
    //ID del tablero.
    private int id;
    //Arreglo de las casillas del tablero.
    public Tile[][] tiles= new Tile[3][3];
    //Se define si alguien ha ganado.
    public boolean hasWon = false;

    /***
     * Constructor vacio.
     */
    public Board() {
    }

    /***
     * Constructor lleno.
     * @param id
     * @param hasWon 
     */
    public Board(int id, boolean hasWon) {
        this.id = id;
        this.hasWon = hasWon;
    }

    /***
     * Se obtiene el id del tablero.
     * @return id
     */
    public int getId() {
        return id;
    }

    /***
     * Se define el id del tablero.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Enseña el tablero completo con las casillas, ya sean vacias o llenas.
     * @return 
     */
    @Override
    public String toString() {
        return ("""
                | - | - | - | 
                | """+tiles[0][0]+" | " +tiles[0][1]+
                " | "+tiles[0][2]+ " | \n" + "| - | - | - | \n" + "| "+tiles[1][0]+" | "
                +tiles[1][1]+" | "+tiles[1][2]+ " | \n" + "| - | - | - | \n"
                + "| "+tiles[2][0]+" | "
                +tiles[2][1]+" | "+tiles[2][2]+ " | \n" + "| - | - | - |") ;
    }
    
    /***
     * Obtiene las casillas del arreglo.
     * @return 
     */
    public Tile[][] getTiles(){
        return tiles;
    }
    
    /***
     * Define las casillas del arreglo.
     * @param tiles 
     */
    public void setTiles(Tile[][] tiles){
        this.tiles = tiles;
    }
    
    /***
     * Genera las casillas del tablero, y les da una coordenada.
     */
    public void generateTiles(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tiles[i][j] = new Tile();
            }
        }
    }
    
    /***
     * Checa si se ha ganado en cualquier lado.
     */
    public void checkWin(){
        //Este for checa todas las casillas del arreglo.
        for(int i = 0; i < 3; i++){
            //Define si hay casillas iguales en las filas.
            if(tiles[i][0] != null  && tiles[i][0] == tiles[i][1] && tiles[i][1]
                    == tiles[i][2]){
                //Si si, se define como que se ha ganado.
                hasWon = true;
                return;
            }
            //Define si hay casillas iguales en las columnas.
            if(tiles[0][i]!= null && tiles[0][i] == tiles[1][i] && tiles[1][i]
                    == tiles[2][i]){
                //Si si, se define como que se ha ganado.
                hasWon = true;
                return;
            }
        }
        //Se define si hay un ganador de manera horizontal.
        if(tiles[0][0] != null && tiles[0][0] == tiles[1][1] && tiles[1][1] ==
                tiles[2][2]){
            //Si si, se define el juego como ganado.
            hasWon = true;
        }
        //Se define si hay un ganador de manera horizontal.
        if(tiles[0][2] != null && tiles[0][2] == tiles[1][1] && tiles[1][1] == 
                tiles[2][0]){
            //Si si, se define el juego como ganado.
            hasWon = true;
        }
    }
    
    /***
     * Se define si el juego se ha acabado.
     * @return 
     */
    public boolean isGameOver(){
        return hasWon;
    }
}
