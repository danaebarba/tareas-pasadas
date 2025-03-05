/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lavaca;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 *
 * @author danae
 */
public class LaVaca {
    
    //Nodo donde se inicia el arbol
    private static Nodo arbol;
    //Nodo de la pregunta en la que se encuentra actualmente
    private static Nodo preguntaActual;
    //String con la respuesta actual
    private static String respuestaActual;

    public static void construirArbol() throws FileNotFoundException, IOException, ClassNotFoundException {
        try{
            //De-serialization donde se leera el archivo si es que existe
           FileInputStream fis = new FileInputStream("LaVaca.txt"); 
           ObjectInputStream ois = new ObjectInputStream(fis); 
           //El arbol se define como lo que se encuentra en el archivo
           arbol = (Nodo)ois.readObject();
        }catch (FileNotFoundException ex){ 
            //Si no existe aun un archivo, se empieza un juego nuevo.
            //Se define la primera pregunta, que siempre sera:
            Nodo raiz = new Nodo("¿El animal tiene cuernos?");
            //Si la respuesta es si, el nodo se ira a la vaca.
            raiz.agregarHijo("Si", new Nodo("Vaca"));
            //Si la respuesta es no, el nodo se ira al gato.
            raiz.agregarHijo("No", new Nodo("Gato"));
            //Aqui el arbol se define como la raiz creada anteriormente.
            arbol = raiz;
        }
    }
    
    /**
     * Aqui se produce el juego, donde se iran haciendo cada turno, y se repite de 
     * manera recursiva si este sigue.
     * @param nodo
     * @throws IOException 
     */
    public static void jugar(Nodo nodo) throws IOException {
        Scanner sc = new Scanner(System.in);
        //Si el nodo es hoja, o sea no tiene nodos hijos.
        if (nodo.esHoja()) {
            //Entonces te pregunta su el valor al que se ha llegado es en el que estas pensando.
            System.out.println("¿Estás pensando en un(a) " + nodo.getValor() + "? (Sí/No)");
            String respuesta = sc.nextLine();
            //Si el caso es si.
            if (respuesta.equalsIgnoreCase("Si")) {
                //Te avisa que ha adivinado.
                System.out.println("¡Adiviné!");
                //Y pregunta si deseas jugar nuevamente.
                System.out.println("¿Quieres jugar de nuevo? (Sí/No)");
                respuesta = sc.nextLine();
                //Si la respuesta es si, se vuelve a jugar.
                //Aqui es donde este caso es recursivo, se sigue jugando cuando 
                //tu respuesta es si
                if (respuesta.equalsIgnoreCase("Sí")) {
                    jugar(arbol);
                } else {
                    //En el otro caso, se despide. Pero se guardan los resultados
                    System.out.println("¡Hasta luego!");
                }
            } else {
                //Si no se ha adivinado al animal, se manda a llamar el metodo de aprender.
                aprender(nodo);
            }
        } else {
            //Si la pregunta no es hoja, entonces la pregunta actual se cambia al nodo siguiente.
            preguntaActual = nodo;
            //Se pregunta el valor que se tiene en ese nodo, o sea la diferencia
            //que ya se tiene aprendida
            System.out.println(nodo.getValor());
            System.out.println("¿Si o No?");
            String respuesta2 = sc.nextLine();
            //Se define a la respuesta dada como la respuesta actual.
            respuestaActual = respuesta2;
            //Con esta respuesta se decide a que nodo de ira, ya sea el si o el no.
            //Con esto se define el siguiente nodo
            Nodo siguienteNodo = respuesta2.equalsIgnoreCase("Si") ? nodo.getHijo("Si") : nodo.getHijo("No");
            //Y de aqui se manda de manera recursiva al siguente nodo.
            jugar(siguienteNodo);
        }
    }
    
    /**
     * Aqui se utiliza el serialization, este sirve para guardar lo que es lo aprendido
     * en cada juego realizado, para que estos datos puedan ser utilizados en
     * futuros juegos.
     * @throws IOException 
     */
    public static void serialization() throws IOException {
        try{
        FileOutputStream fos = new FileOutputStream("LaVaca.txt"); 
        ObjectOutputStream oos = new ObjectOutputStream(fos); 
        oos.writeObject(arbol); 
        }catch (Error error){
        }
    }
    
    /**
     * Este metodo sirve para aprender de cada juego, y que esto se guarde como
     * un nuevo arbol.
     * @param nodo
     * @throws IOException 
     */
    public static void aprender(Nodo nodo) throws IOException {
        Scanner sc = new Scanner(System.in);
        //Despues de que el jugador haya dicho que no era el animal pensado.
        //Se le pregunta al jugador cual es el animal pensado.
        System.out.println("¿En qué animal estabas pensando?");
        //Su respuesta se guarda en animalPensado.
        String animalPensado = sc.nextLine();
        //Se le pregunta al jugador cual es la diferencia entre el animal pensado y el dado.
        System.out.println("¿Cuál es la diferencia entre un " + animalPensado + " y un " + nodo.getValor() + "?");
       //La respuesta se guarda como diferencia.
        String diferencia = sc.nextLine();
        //Despues como confirmacion se pregunta si el animal pensado cumple con la condicion dada.
        System.out.println("El animal " + animalPensado + " cumple con la condicion: " + diferencia);
        System.out.println("¿Si o no?");
        String respuesta = sc.nextLine();
        //Se crea un nuevo nodo de diferencia.
        Nodo newNodo = new Nodo(diferencia);
        //Si la respuesta es si.
        if(respuesta.equalsIgnoreCase("Si")){
            //Se agrega al nodo de la diferencia como si el animal pensado.
            newNodo.agregarHijo("Si", new Nodo(animalPensado) );
            //Y al no el otro valor dado.
            newNodo.agregarHijo("No", new Nodo(nodo.getValor()) );
            //Y se le dice al jugador el nuevo animal y su diferencia del otro animal.
            System.out.println("Gracias por enseñarme. Ahora sé que un(a) " + animalPensado + " " + diferencia + ".");
        } else {
            //Si la respuesta es no
            //Se agrega a no, el animal pensado.
            newNodo.agregarHijo("No", new Nodo(animalPensado) );
            //Y a si, el otro valor dado.
            newNodo.agregarHijo("Si", new Nodo(nodo.getValor()) );
            //Y se le dice al jugador el valor dado y su diferencia del otro animal.
            System.out.println("Gracias por enseñarme. Ahora sé que un(a) " + nodo.getValor() + " " + diferencia + ".");
        }
        //Si la respuesta actual es si se agrega a la pregunta actual en el hijo si, un nuevo nodo. 
        if(respuestaActual.equalsIgnoreCase("Si")){
            preguntaActual.agregarHijo("Si", newNodo);
        } else {
            //Si la respuesta actual es no, se le agrega a la pregunta actual en el nodo no, un nuevo nodo.
            preguntaActual.agregarHijo("No", newNodo);
        }
        //Se le pregunta al jugador si quiere jugar de nuevo.
        System.out.println("¿Quieres jugar de nuevo? (Sí/No)");
        String respuesta2 = sc.nextLine();

        //Si la respuesta es si, se crea un nuevo juego, utilizando el mismo arbol.
        if (respuesta2.equalsIgnoreCase("Si")) {
            jugar(arbol);
        } else {
            //Si no, utilizamos el serialization para guardar lo aprendido en un archivo y se despide.
            serialization();
            System.out.println("¡Hasta luego!");
        }
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        //Se contruye el arbol incial.
        construirArbol();
        //Empieza el juego con el arbol ya construido.
        jugar(arbol);
    }
    
}
