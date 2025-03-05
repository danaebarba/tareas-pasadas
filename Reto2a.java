/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto2a;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Reto2a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Un programa que sea útil para apoyar al dueño de un parque
        de diversiones que tiene una máquina para vender boletos.*/
        //INICIO
        Scanner input = new Scanner(System.in);
        //Variables
         int adulto=100;
         int niño= 70;
         int noinapam= 70;
         int inapam = 50;
         char option;
         char choice;
    do{
        // Pedirle al usuario que escoga un boleto
      System.out.println("¿Qué tipo de boleto desea comprar?");
      System.out.println("A. adulto");
      System.out.println("N. niño");
      System.out.println("I. adulto mayo con credencial del INAPAM");
      System.out.println("B. adulto mayor sin credencial del INAPAM");
      choice = input.next().charAt(0);
      //Darle al usuario el valor de los boletos
      switch(choice){
        case 'A':
        System.out.println("El boleto tiene un valor de "+ adulto);
        break;
        case 'N':
        System.out.println("El boleto tiene un valor de "+ niño);
        break;
        case 'I':
        System.out.println("El boleto tiene un valor de "+ inapam);
        break;
        case 'B':
        System.out.println("El boleto tiene un valor de "+ noinapam);
        break;
      } //Preguntarle al usuario si desea otro boleto, si desea otro,
      //volver a darle las opciones de boleto
      System.out.println("Desea otro boleto (S/N)");
      option = input.next().charAt(0);
    }while(!(option !='S'));
    //Si no desea otro finalizar el programa
    System.out.println("Programa finalizado, vuelva pronto");
    }
    //FIN
}
