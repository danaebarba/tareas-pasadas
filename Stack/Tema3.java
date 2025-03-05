/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema3;

/**
 *
 * @author danae
 */
public class Tema3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Se crea un nuevo stack.
        Stack Articles = new Stack();
        //Random para sacar un numero entre 2 y 4, que es el tiempo que tarda
        //Albert en hacer un articulo.
        int random_Rep = (int)Math.floor(Math.random() * (4 - 2 +1) + 2);
        //Número de meses que han pasado.
        int passedMonths = 0;
        //Número de articulos hechos.
        int numArt = 1;
        
        //For que se repite durante los meses que trabaje Albert
        for(int i = 1; i <= 24; i++){
            System.out.println("Mes " + i);
            //Se agrega un mes al número de meses que han pasado.
            passedMonths++;
            //Si el numero de meses que han pasado, es igual al numero random.
            if(passedMonths == random_Rep){
                //Albert Einstein imprimio un articulo, por lo que se agrega 
                //uno al tope
                System.out.println("Albert Einstein termino un articulo.");
                Articles.push(numArt);
                //Se crea un nuevo número.
                random_Rep = (int)Math.floor(Math.random() * (4 - 2 +1) + 2);
                //Se reinicia el numero de meses pasados.
                passedMonths = 0;
                //Se agrega un número a los articulos
                numArt++;
            }
            //Si el numero de meses pasados es 3 y hay articulos, se entrega uno
            //Se saca el articulo de hasta el tope.
            if((i % 3) == 0 && Articles.isEmpty() == false){
                System.out.println("Se ha entregado el articulo.");
                Articles.pop();
            }
            //Se imprimen los articulos que hay actualmente.
            System.out.println(Articles.show());
        }
    }
    
}