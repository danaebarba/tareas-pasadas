/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto1;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Reto1 {

    /**
     * Programa que resuelva operaciones de suma, resta, multiplicación y
     * división.
     * @param args
     */
    public static void main(String[] args) {
        //Inicio
        //Declarar variables x1, x2
        
        //variables de entrada:
        int x1, x2 = 0;
        int choice;
        double factorial = 1;
        int num1 = 0, num2 = 1, suma = 1;
        //variables de salida:
        float respuesta = 0;
        String operacion = "x";
         Scanner input = new Scanner(System.in);
        //pedir al usuario que eliga una operacion 
        System.out.println("Elige una opcion de operación: ");
        System.out.println("1. suma");
        System.out.println("2. resta");
        System.out.println("3. multiplicación");
        System.out.println("4. división");
        System.out.println("5. módulo/resto");
        System.out.println("6. logaritmo");
        System.out.println("7. factorial");
        System.out.println("8. fibonacci");
        choice = input.nextInt();
        //pedir al usuario dos números
        if (choice == 7 || choice == 8){
            System.out.println("Dame un numero entero");
            x1 = input.nextInt();
        } else {
            System.out.println("Dame un numero entero");
            x1 = input.nextInt();
            System.out.println("Dame otro numero entero");
            x2 = input.nextInt();
        }
        //calcular la operacion escogida
        //imprimir resultados
       switch (choice){
            case 1 -> {
                respuesta = (x1 + x2);
                operacion = "+";
                System.out.println("Tu operacion es: " + x1 + operacion + x2 + 
                        "=" + respuesta);
            }
            case 2 -> {
                respuesta = (x1 - x2);
                operacion = "-"; 
                System.out.println("Tu operacion es: " + x1 + operacion + x2 + 
                        "=" + respuesta);
            }
            case 3 -> {
                respuesta = (x1 * x2);
                operacion = "*";
                System.out.println("Tu operacion es: " + x1 + operacion + x2 + 
                        "=" + respuesta);
            }
            case 4 -> {
                if (x2 == 0)
                    System.out.println("No puedes poner 0 como divisor");
                respuesta = (x1 / x2);
                operacion = "/";
                System.out.println("Tu operacion es: " + x1 + operacion + x2 + 
                        "=" + respuesta);
            }
            case 5 -> {
                respuesta = (x1 % x2);
                operacion = "%";
                System.out.println("Tu operacion es: " + x1 + operacion + x2 + 
                        "=" + respuesta);
            }
            case 6 -> {
                respuesta = (int) (Math.log(x1) / Math.log(x2));
                System.out.println("El logaritmo " + x1 + " con base " + x2
                + " es " + respuesta);
            }
            case 7 -> {
		 for( int i = 1; i <= x1; i++ ) {
                     factorial *= i;
                 }
                System.out.println("El factorial de " + x1 + " es: " + 
                        factorial);
            }
            case 8 -> {
                for (int i = 1; i < x1; i++) {
                    System.out.println(suma + ", ");
                    suma = num1 + num2;
                    num1 = num2;
                    num2 = suma;
                    
                }
            }
        }
        //Fin
    }
    
}
