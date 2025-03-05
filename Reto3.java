/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto3;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Reto3 {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static char[][] matriz = new char[15][15];
    
    public static void main(String[] args) {
        //Definir las variables
        int opcion;
        do{
            //Imprimir un menu donde vengan todas las opciones para escoger
            System.out.println("Menu:");
            System.out.println("1. Llenar matriz con un simbolo");
            System.out.println("2. Llenar columnas pares con un simbolo");
            System.out.println("3. Llenar renglones pares con un simbolo");
            System.out.println("4. Llenar una columna con un simbolo");
            System.out.println("5. Llenar un renglon con un simbolo");
            System.out.println("6. Llenar una casilla con un simbolo");
            System.out.println("7. Hacer la bandera del reino unido");
            System.out.println("8. Salir");
            //Pedir al usuario que escoja una de las opciones
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            //Hacer un switch para todas las opciones que hay y lo que cada
            //una hace
                switch(opcion) {
                case 1:
                    fullMatriz();
                    break;
                case 2:
                    fullPairColumns();
                    break;
                case 3:
                    fullPairLines();
                    break;
                case 4:
                    fullColumns();
                    break;
                case 5:
                    fullLines();
                    break;
                case 6:
                    fullBoxes();
                    break;
                case 7: 
                    UKflag();
                    break;
                case 8:
                    System.out.println("Fin del programa.");
                    break;
                //En caso de introducir una opcion invalida
                default:
                    System.out.println("Opción invalida");
            }
        } while (opcion != 8);
    }
    //Imprimir una matriz llena del simbolo escogido
    static void fullMatriz(){
        System.out.print("Escoje un simbolo: ");
        char symbol = sc.next().charAt(0);
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                matriz[i][j] = symbol;
            }
        }
        System.out.println(matriz[i][j]);
    }
    //Imprimir una matriz con las columnas pares llenas del simbolo escogido
    static void fullPairColumns(){
        System.out.print("Elige un simbolo: ");
        char symbol = sc.next().charAt(0);
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                if (j % 2 == 0){
                    matriz[i][j] = symbol;
                    System.out.println(matriz[i][j]);
                }
            }
        }
    }
    //Imprimir una matriz con los renglones pares llenas del simbolo escogido
    static void fullPairLines(){
        System.out.print("Elige un simbolo: ");
        char symbol = sc.next().charAt(0);
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                if (i % 2 == 0){
                    matriz[i][j] = symbol;
                    System.out.println(matriz[i][j]);
                }
            }
        }
    }
    //Imprimir una matriz con una columna llena del simbolo escogido
    static void fullColumns(){
        System.out.print("Elige un simbolo: ");
        char symbol = sc.next().charAt(0);
        for (int i = 0; i < 15; i++){
            int columns = 0;
            matriz[i][columns] = symbol;
            System.out.println(matriz[i][j]);
            }
        }
    //Imprimir una matriz con un renglon lleno del simbolo escogido
    static void fullLines(){
        System.out.print("Elige un simbolo: ");
        char symbol = sc.next().charAt(0);
        for (int j = 0; j < 15; j++){
            int lines = 0;
            matriz[lines][j] = symbol;
            System.out.println(matriz[i][j]);
            }
        }
    //Imprimir una matriz con una casilla llena de este simbolo
    static void fullBoxes(){
        System.out.print("Elige un simbolo: ");
        char symbol = sc.next().charAt(0);
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                matriz[i][j] = symbol;
                System.out.println(matriz[i][j]);
            }
        }
    }
    //Imprimir una matriz donde se vea la bandera del reino unido
    static void UKflag(){
        int linea = 1, linea2 = 11;
        int mitad = 0;
        
        for(int i = 1; i <= 11; i++){
            for(int j = 1; j <= 11; j++){
                if(j == linea || j== 6 || j == linea2 || mitad == 5){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            linea = linea + 1;
            linea2 = linea2 - 1;
            mitad = mitad + 1;
            System.out.println(" ");
        }
    }
}
