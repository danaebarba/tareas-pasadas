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
    public static int [] attempts = {6,5,4};
    /**
     * Regresa la palabra seleccionada de acuerdo al nivel
     * @param level nivel
     * @return palabra
     */
    public static String selectWord(int level){
        String result = " ";
        try{
        //numero al azar entre 0 y 1
        double randomNumber = Math
                .random();
        //Multiploco la cantidad de palabras por nivel elegido por el numero al 
        //azar y luego lo hago entero
        int index = (int)(randomNumber * words[level].length);
        //elige la palabra al azar
        result = words[level][index];
        }catch(Exception ex){
        System.out.println("Error");
    }
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
        int result = 0;
        Scanner sc = new Scanner(System.in);
        do{
            try{
            System.out.println("¿Que nivel de dificultad te gustaria jugar?");
            result = (sc.nextInt()-1);
            }catch(Exception ex){
                System.out.println("Error");
            }
        }while (result < 0 || result > 2);
        return result;
    }
    /**
     * obtiene un caracter
     * @return caracter obtenido
     */
    public static char getChar(){
        char result = ' ';
        Scanner sc = new Scanner(System.in);
        result = sc.next().charAt(0);
        return result;
    }
    public static void hangman(int fails){
       switch(fails){
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
    }    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        showMenu();
        level = getLevel();
        Word myWord = new Word(selectWord(level));
        int fails = 0;
        char letter =' ';
        //System.out.println(myWord);
        //Si se marca 0 acabar el juego
            //mostrar los guiones
            do{
            //pedir letra
            hangman(fails);
            System.out.print("Dame una letra: ");
            letter = getChar();
            //revisar si esta dentro de la palabra secreta
            // en caso de si: sustituir
            if (myWord.containsChar(letter)){
                myWord.replaceDash(letter);
            }else { 
                //en caso de que no aumentar fallos
                fails++;
            }
            System.out.println(myWord.replaceDash(letter));
            }while (letter != '0' && !myWord.isComplete()
                    && fails < attempts[level]);
            
            //System.out.println(!myWord.isComplete() );
            //System.out.println(letter != '0');
            //System.out.println(attempts[level]);
            
            }
          }
    

        //si la letra existe colocarla en su lugar
        //en caso de que no, aumentar los fallos
        //preguntar si esta completa la palabra o se acabaron los fallos
        //o puso cero
        //si gano mostrar mensaje de ganaste, si no mostrar mensaje de perdiste



    

