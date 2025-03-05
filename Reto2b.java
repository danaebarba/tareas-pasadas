/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto2b;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Reto2b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Un programa para construir un conjunto de pirámides
        Scanner input = new Scanner(System.in);
        //variables
        int size;
        
        do{
            //Pedir al usuario el valor de la piramide, que sea mayor que 3
            System.out.println("Dame un valor mayor a 3");
            size = input.nextInt();
            //Si es menor, decirle al usuario que su numero es invalido
            if (size < 3){
                System.out.println("Numero invalido");
            }
        } while (size < 3);
        for (int i = 1; i <= size; i++){
            for(int x = 1; x <= size - i; x++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (i*2); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
