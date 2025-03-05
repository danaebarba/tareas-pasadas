/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema1b;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Tema1b {

    /**
     * Calcula la formula general
     * @param args 
     */
    public static void main(String[] args) {
        //1- Inicio
        //2- Declarar variables x1, x2, a, b, c
        
        //Variables de entrada:
        float a = 0.0f, b = 0.0f, c = 0.0f; 
        //Variables de salida: 
        float x1 = 0.0f, x2 = 0.0f;
        Scanner input = new Scanner(System.in);
        
        //3- Pedir al usuario a, b, c
        System.out.println("Programa que obtiene los valores de la formula"
        +" general");
        System.out.println("Dame el valor de a");
        a = Float.parseFloat(input.nextLine());
        System.out.println("Dame el valor de b");
        b = input.nextFloat();
        System.out.println("Dame el valor de c");
        c = input.nextFloat();
        if (b*b<4*a*c){
            System.out.println("No hay resultado");
        } else{
        
        //4- Calcular x1
        x1 = (float) ((-b + (Math.sqrt((b*b)-4*a*c)))/(2*a));
        //5- Calcular x2
        x2 = (float) ((-b - (Math.sqrt((b*b)-4*a*c)))/(2*a));
        //6- Imprimir resultados
        System.out.println("Primer resultado: " + x1);
        System.out.println("Segundo resultado: " + x2);
        
        //7- Fin
    }
    
    }
}
