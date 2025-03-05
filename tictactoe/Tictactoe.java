/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Tictactoe {

    /**
     * @param args the command line arguments
     */
    static Scanner input= new Scanner(System.in);
    
    public static void main(String[] args) {
        //Se crea un nuevo tablero cada que se inicializa el juego.
        Board game = new Board();
        //Se generan todas las casillas por tablero.
        game.generateTiles();
        //Inicio del juego.
        System.out.println("Bienvenido al juego del gato.");
        //Se crea el primer jugador.
        Player player1 = new Player();
        System.out.println("Primer jugador tu icono es la X.");
        //Se define el icono del primer jugador.
        player1.setIcon('X');
        //Se crea el segundo jugador.
        Player player2 = new Player();
        System.out.println("Segundo jugador tu icono es la O.");
        //Se define el icono del segundo jugador.
        player2.setIcon('O');
        //Un while
        //Este se hace mientras que el boolean de isGameOver no sea verdadero
        while(!game.isGameOver()){
            //Primero se imprime el tablero del juego.
            System.out.println(game);
            //Se le pide al jugador que diga su primera coordenada.
            System.out.println("Jugador uno escoge la primera coordenada de"
                    + " tu posicion. (1-3)");
            //Se guarda el numero en la primera coordenada.
            int coordinate1 = input.nextInt() - 1;
            //Se le pide al jugador que diga su segunda coordenada.
            System.out.println("Jugador uno, escoge la segunda coordenada "
                    + "de tu posicion. (1-3)");
            //Se guarda el numero en la segunda coordenada.
            int coordinate2 = input.nextInt() - 1;
            //Se guardan la primera y segunda coordenada respectivamente y 
            //en estas se pone el icono del primer jugador.
            game.tiles[coordinate1][coordinate2].setIcon((player1.getIcon()));
            System.out.println(game);
            game.checkWin();
            if(!game.hasWon){
            //Se le pide al jugador que diga su primera coordenada.
            System.out.println("Jugador dos, escoge la primera coordenada "
                    + "de tu posicion. (1-3)");
            //Se guarda el numero en la primera coordenada.
            int coordinate3 = input.nextInt() - 1;
            //Se le pide al jugador que diga su segunda coordenada.
            System.out.println("Jugador dos, escoge la segunda coordenada"
                    + " de tu posicion. (1-3)");
            //Se guarda el numero en la segunda coordenada.
            int coordinate4 = input.nextInt() - 1;
            //Se guardan la primera y segunda coordenada respectivamente y 
            //en estas se pone el icono del segundo jugador.
            game.tiles[coordinate3][coordinate4].setIcon((player2.getIcon()));
            //Se checa si el jugador ha ganado
            game.checkWin();
            }
        }
        //Si el jugador ha ganado se le felicita.
        if(game.hasWon){
            System.out.println("Has ganado! Felicidades.");
        }
    }
    
}
