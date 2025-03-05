/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto4;

import java.util.Scanner;

/**
 *
 * @author danae
 */
public class Reto4 {
    
    public static int level = 0;
    public static int count = 0;
    public static String [][] words = { {"gato","casa","caro","pato"},
        {"carros","perros","patito"}, {"miercoles","sabado","computadora"}};
    public static int attempts = 6;
    /**
     * Regresa la palabra seleccionada de acuerdo al nivel
     * @param level nivel
     * @return palabra
     */
    public static String selectWord(int level){
        String result;
        //numero al azar entre 0 y 1
        double randomNumber = Math.random();
        //Multiploco la cantidad de palabras por nivel elegido por el numero al 
        //azar y luego lo hago entero
        int index = (int)(randomNumber * words[level].length);
        //elige la palabra al azar
        result = words[level][index];
        return result;
    }
    /**
     * Enseña el menu del juego
     */
    public static void showMenu(){
        System.out.println("Bienvenido al juego del ahorcado");
        System.out.println("Niveles de dificultad");
        System.out.println("1. Facil");
        System.out.println("2. Intermedio");
        System.out.println("3. Dificil");
        System.out.println("0. Salir del juego");
    }
    /**
     * Pregunta y regresa el nivel
     * @return 
     */
    public static int getLevel(){
        int result;
        System.out.println("¿Que nivel de dificultad te gustaria jugar?");
        Scanner sc = new Scanner(System.in); 
        result = sc.nextInt();
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        char [] word;
        showMenu();
        level = getLevel();
        Word word1 = new Word();
        //Si se marca 0 acabar el juego
        if(level > 0){
            //mostrar los guiones
            Word myWord = new Word(selectWord(level));
            word = selectWord(level).toCharArray();
            System.out.println(myWord);
            //pedir letra
            System.out.println("Dame una letra");
            char letter = sc.nextLine().charAt(0);
            for(int i = 0; i < selectWord(level).length(); i++){
            if(letter == word[i]){
                word1.replaceDash(letter);
            }
            if(letter != word[i]){
                count = count + 1;
            }
            }
                switch(count){
            case 1 -> {
                System.out.println(".___________     ");
                System.out.println("|           |    ");
                System.out.println("|          ()    ");
                System.out.println("                 ");
                System.out.println("|                ");
                System.out.println("|                ");
                System.out.println("|                ");
            }
                
            case 2 -> {
                System.out.println(".___________     ");
                System.out.println("|           |    ");
                System.out.println("|          ()    ");
                System.out.println("           ||    ");
                System.out.println("|          ||    ");
                System.out.println("|                ");
                System.out.println("|                ");
            }
                
            case 3 -> {
                System.out.println(".___________     ");
                System.out.println("|           |    ");
                System.out.println("|          ()    ");
                System.out.println("           ||\\  ");
                System.out.println("|          ||    ");
                System.out.println("|                ");
                System.out.println("|                ");
            }
                
            case 4 -> {
                System.out.println(".___________     ");
                System.out.println("|           |    ");
                System.out.println("|          ()    ");
                System.out.println("          /||\\  ");
                System.out.println("|          ||    ");
                System.out.println("|                ");
                System.out.println("|                ");
            }
                
            case 5 -> {
                System.out.println(".___________     ");
                System.out.println("|           |    ");
                System.out.println("|          ()    ");
                System.out.println("          /||\\  ");
                System.out.println("|          ||    ");
                System.out.println("|            \\  ");
                System.out.println("|                ");
            }
            case 6 -> {
                System.out.println(".___________     ");
                System.out.println("|           |    ");
                System.out.println("|          ()    ");
                System.out.println("          /||\\  ");
                System.out.println("|          ||    ");
                System.out.println("|          / \\  ");
                System.out.println("|                ");
                System.out.println("Bien jugado. \n Fin del juego.");
                     }
            }
          }
        if (level == 0)
            System.out.println("Se ha acabado el juego");
    }
        //si la letra existe colocarla en su lugar
        //en caso de que no, aumentar los fallos
        //preguntar si esta completa la palabra o se acabaron los fallos
        //o puso cero
        //si gano mostrar mensaje de ganaste, si no mostrar mensaje de perdiste
}


    

