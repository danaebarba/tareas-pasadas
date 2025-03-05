/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto2;

/**
 *
 * @author danae
 */
public class Reto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ejercicio 1: imprimir numeros del 1-10
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }
        //Ejercicio 2: Imprimir numeros del 1-1000000
        for(int i = 1; i <= 1000000; i++){
            System.out.println(i);
        }
        //Ejercicio 3: Imprimir numeros del 100-0
        for(int i = 100; i >= 0; i--){
            System.out.println(i);
        }
        //Ejercicio 4: Imprimir del 53-553 de 3 en 3
        for(int i = 53; i <= 553; i = i + 3){
            System.out.println(i);
        }
        //Ejercicio 5: imprimir 74-574 sin imprimir los q tienen 4
        for(int i = 74; i <= 574; i++){
            if (i%10 != 4){
                System.out.println(i);
            }
        }
        //Ejercicio 6: cuadrado de 10 renglones y 10 columnas de asteriscos
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        //Ejercicio 7: Triangulo invertido con #
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                    System.out.print("#");
                }    
                for (int j = i; j < 10; j++){
                    System.out.print("*");
                }
            System.out.println(" ");
        }
        //Ejercicio 8: La bandera de reino unido
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
        //Ejericio 9: Un espiral con *
    }
}