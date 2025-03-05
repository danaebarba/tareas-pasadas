/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gatosabiofinal;

import java.util.Scanner;

/**
 *
 * @author danaebarba
 */
public class GatoSabioFinal {

    //El tamaño del tablero siempre sera 3, por lo que es final.
    private static final int SIZE = 3;
    //El juagador siempre sera X
    private static final char PLAYER = 'X';
    //Y la computadora O
    private static final char COMPUTER = 'O';
    private static char[][] board;

    public static void main(String[] args) {
        //Siempre que se vuelve a jugar se hace un nuevo tablero
        board = new char[SIZE][SIZE];
        //Se inicializa el nuevo tablero
        initializeBoard();

        Scanner scanner = new Scanner(System.in);

        //Esto se seguira haciendo mientras el juego no se haya acabado
        //Ya sea por que alguien haya ganado, o por un empate.
        while (true) {
            printBoard();
            //Turno del jugador
            playerMove(scanner);
            //Si en el turno se gano, se empato o se lleno el tablero, se detiene el juego.
            if (isGameFinished()) 
                break;
            printBoard();
            //Turno de la computadora
            System.out.println("Turno de la computadora:");
            //De los nodos agarra el mejor juego que tiene, utilizando el algoritmo minimax
            Node bestMove = minimax(COMPUTER);
            //Ya que se definio el mejor movimiento, se hace el cambio
            makeMove(bestMove.row, bestMove.col, COMPUTER);
            printBoard();
            //Si en el turno se gano, se empato o se lleno el tablero, se detiene el juego.
            if (isGameFinished()) 
                break;
        }
    }
    
    /**
     * Este es el turno del jugador, se le pregunta su movimiento y se realiza el cambio
     * tambien se checa si este movimiento es valido.
     * @param scanner 
     */
    public static void playerMove(Scanner scanner) {
        int row, col;
        do {
            System.out.println("Ingresa tu movimiento");
            System.out.println("Fila:");
            row = scanner.nextInt() - 1;
            System.out.println("Columna:");
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = 'X';
    }
    
    /**
     * Aqui se inicializa el tablero, definienfo todas sus casillas como vacias.
     */
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    /**
     * Este metodo checa en cada movimiento si el juego se ha terminado,
     * en cada una de sus posibilidades, y si alguien ha ganado se le avisa
     * al jugador.
     * @return 
     */
    public static boolean isGameFinished() {
        if (checkWin('X')) {
            printBoard();
            System.out.println("Felicidades! Le ganaste");
            return true;
        } else if (checkWin('O')) {
            printBoard();
            System.out.println("Haz perdido.");
            return true;
        } else if (isBoardFull()) {
            printBoard();
            System.out.println("Es un empate.");
            return true;
        }
        return false;
    }
    
    /**
     * Se imprime el tablero actual
     */
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    /**
     * Checa si el movimiento que se esta haciendo es valido, es valido si es
     * un numero de casilla y si esta vacio.
     * @param row
     * @param col
     * @return 
     */
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    /**
     * Aqui se realiza el movimiento de la computadora, se define que casilla sera
     * y se pone en esa.
     * @param row
     * @param col
     * @param player 
     */
    private static void makeMove(int row, int col, char player) {
        board[row][col] = player;
    }
    
    /**
     * Aqui se checa si se ha ganado, de cualquier manera, las columnas, las filas
     * y las diagonales.
     * @param player
     * @return 
     */
    private static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    /**
     * Se checa si el tablero esta lleno.
     * @return 
     */
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') 
                    return false;
            }
        }
        return true;
    }
    
    /**\
     * Aqui se realiza el algoritmo minimax, este algoritmo lo que hace es
     * definir todas las posibilidades que se tiene de movimientos, despues se
     * le asigna un valor a cada posibilidad, con esto se elige el que tenga 
     * mayores posibilidades de ganar para la computadora y tambien menores 
     * posibilidades de ganar el jugador.
     * @param player
     * @return 
     */
    private static Node minimax(char player) {
        
        //Aqui lo que estamos haciendo es asignarle un valor a cada nodo, entre
        //Mayor posibilidad tenga de ganar el jugador, menos puntos se tiene
        if (checkWin(PLAYER)) {
            return new Node(-1, -1, -1);
            //entre mas posibilidades se tenga de ganar la computadora mayor
            //puntaje se tiene
        } else if (checkWin(COMPUTER)) {
            return new Node(1, -1, -1);
        } else if (isBoardFull()) {
            //El empate no da puntos
            return new Node(0, -1, -1);
        }

        //Se define el mejor puntaje por utilizar
        int bestScore = (player == COMPUTER) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        //Se crea un nuevo nodo con el mejor movimiento
        Node bestMove = new Node();

        //Aqui se checa en cada casilla si es un movimiento valido.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValidMove(i, j)) {
                    makeMove(i, j, player);
                    //Mientras el turno sea de la computadora, se busca el minimax
                    //del jugador, es lo que se piensa que sera el siguiente movimiento
                    //del jugador, ya que seria su mejor movimiento
                    if (player == COMPUTER) {
                        Node currentMove = minimax(PLAYER);
                        //Si este movimiento es mejor, tiene mayor puntaje
                        //que el mejor puntaje del minimax planeado
                        //se utiliza ese movimiento
                        if (currentMove.score > bestScore) {
                            bestScore = currentMove.score;
                            bestMove.row = i;
                            bestMove.col = j;
                        }
                    } else {
                        //Si no es su turno, se analiza cual sera su movimiento
                        Node currentMove = minimax(COMPUTER);
                        //si el puntaje de su movimiento es menor a su mejor movimiento
                        //se define como el mejor puntaje.
                        if (currentMove.score < bestScore) {
                            bestScore = currentMove.score;
                            bestMove.row = i;
                            bestMove.col = j;
                        }
                    }

                    makeMove(i, j, ' ');
                }
            }
        }
        //Se define el mejor puntaje para el mejor movimiento, que sera el que
        // se utilizara.
        bestMove.score = bestScore;
        return bestMove;
    }
}
        
