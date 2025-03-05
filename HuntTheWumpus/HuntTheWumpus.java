/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package huntthewumpus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Danae Barba Montemayor
 * 2913512
 */
public class HuntTheWumpus {

    /**
     * @param args the command line arguments
     */
    private static Level level;
    private static int menu;
    private static Player player;
    static Scanner input= new Scanner(System.in);
    public static ArrayList<Cave> maze;
    
    /**
     * Crea el mundo en el que se va a jugar, de manera random 
     * cada que se inicia un juego nuevo.
     */
    public static void createNewWorld(){
        maze = new ArrayList<>();
        //Generar todas las caves.
        //For dependiendo el número de casillas que dicta el nivel.
        for(int i=0; i < level.getCaves(); i++){
            //new Cave() agregar al arreglo.
            maze.add(new Cave(i));
        }
        generateSpecials();
        //Generar las conexiones using random.
        for(int i=0; i<level.getCaves(); i++){
            Cave currentCave = maze.get(i);
            //Validar MyExits faltantes.
            int missingCaves = 3-currentCave.myExits.toArray().length;
            for (int c=0; c<missingCaves ; c++){
                //Número random entre 1 y total de cavernas.
                int caveID;
                //Validar que no se mande a llamar a si mismo.
                do{
                    caveID=(int)(Math.random()*level.getCaves());
                }while(caveID == currentCave.getCaveID() || 
                        currentCave.myExits.contains(maze.get(caveID)));
                //Agregar número a MyExits.
                //Buscar Cave correspondiente y agregar ID actual a MyExits.
                currentCave.connectCaves(maze.get(caveID));
            }
        }
    }
    /**
     * Genera las cavernas especiales y las inserta en
     * cavernas random ya creadas.
     */
    public static void generateSpecials(){
        int caveID;
        Cave currentCave;
        //Generar cavernas especiales al azar.
        //Generar Cave0.
            currentCave = new Cave0();
            //Establecerla como cave 0.
            currentCave.caveID=0;
            maze.set(0, currentCave);
            player.caveID = 0;
        //Generar ExtraOxygen.
        for (int i=0; i< level.getExtraOxygen(); i++){
            do{
                //Escoger la casilla random en la que se genera la special cave.
                caveID=(int)(Math.random()*level.getCaves());
                currentCave = maze.get(caveID);
                //Comprobar que no sea especial.
            }while(currentCave.isSpecial);
            //Crear y colocar la special cave.
            currentCave = new ExtraOxygen();
            currentCave.caveID=caveID;
            maze.set(caveID, currentCave);
        }
        //Generar WaterCave.
        for (int i=0; i<level.getWaterCave();i++){
            do{
                //Escoger la casilla random en la que se genera la special cave.
                caveID=(int)(Math.random()*level.getCaves());
                currentCave = maze.get(caveID);
                //Comprobar que no sea especial.
            }while(currentCave.isSpecial);
            //Crear y colocar la special cave.
            currentCave = new WaterCave();
            currentCave.caveID=caveID;
            maze.set(caveID, currentCave);
        }
        //Generar OxygenCave.
        for (int i=0; i<level.getTank();i++){
            do{
                //Escoger la casilla random en la que se genera la special cave.
                caveID=(int)(Math.random()*level.getCaves());
                currentCave = maze.get(caveID);
                //Comprobar que no sea especial.
            }while(currentCave.isSpecial);
            //Crear y colocar la special cave.
            currentCave = new OxygenCave();
            currentCave.caveID=caveID;
            maze.set(caveID, currentCave);
        }
        //Generar Pit.
        for (int i=0; i<level.getPit();i++){
            do{
                //Escoger la casilla random en la que se genera la special cave
                caveID=(int)(Math.random()*level.getCaves());
                currentCave = maze.get(caveID);
                //Comprobar que no sea especial
            }while(currentCave.isSpecial);
            //Crear y colocar la special cave
            currentCave = new Pit();
            currentCave.caveID=caveID;
            maze.set(caveID, currentCave);
        }
        //Generar GiantBat
        for (int i=0; i<level.getBat();i++){
            do{
                //Escoger la casilla random en la que se genera la special cave.
                caveID=(int)(Math.random()*level.getCaves());
                currentCave = maze.get(caveID);
                //Comprobar que no sea especial.
            }while(currentCave.isSpecial);
            //Crear y colocar la special cave.
            currentCave = new GiantBat();
            currentCave.caveID=caveID;
            maze.set(caveID, currentCave);
        }
        //Generar Wumpus.
        do{
            //Escoger la casilla random en la que se genera la special cave.
                caveID=(int)(Math.random()*level.getCaves());
                currentCave = maze.get(caveID);
                //Comprobar que no sea especial.
            }while(currentCave.isSpecial);
            //Crear y colocar la special cave.
            currentCave = new Wumpus();
            currentCave.caveID=caveID;
            maze.set(caveID, currentCave);
    }
    
    public static void main(String[] args) {
        //Empieza el juego.
        //Enseña el menú.
        startGame();
    }
    
    /**
     * Aquí es donde incia el juego, te imprime el menú, y de aqui puedes
     * seleccionar tus diferentes opciones para jugar.
     */
    public static void startGame(){
       //Crear un nuevo jugador cada que inicia el juego.
       player = new Player();
       //Imprimir menú
       System.out.println();
       System.out.println("¡Hola!"); 
       System.out.println("Bienvenido al juego de Hunt The Wumpus.");
       System.out.println("Selecciona una opción.");
       System.out.println("1. Lore");
       System.out.println("2. Seleccionar dificultad");
       System.out.println("3. Salir");
       //Catch error de input.
       try{
           menu=input.nextInt();
           //Switch de diferentes opciones del menú.
       switch(menu){
           case 1 -> {
               System.out.println();
               //Imprime el lore.
               System.out.println("El wumpus es conocido por ser una criatura "
                       + "tímida "
                       + "y gentil, pero peligrosa cuando se le molesta.");
               System.out.println("Eres un niño de 12 años, y te encantan los"
                       + " wumpus"
                       + " y sabes todo sobre ellos, ");
               System.out.println("por lo que le pides a tu mama uno"
                       + " de cumpleaños, a lo que ella por razones obvias te "
                       + "dice que"
                       + " no.");
               System.out.println("Eso te hace enojar, ya que era lo único que"
                       + " querías"
                       + " de cumpleaños, decides que si ella no te");
               System.out.println("iba a conseguir uno,"
                       + " lo conseguirías tu, por lo que te diriges al bosque,"
                       + " al tener"
                       + " muchos conocimientos");
               System.out.println("sobre los wumpus, sabes exactamente"
                       + " dónde buscarlos, una caverna de wumpus.");
               System.out.println("Te metes al bosque y al encontrar una "
                       + "decides "
                       + "entrar, ahora tendrás que recorrer toda la "
                       + "caverna en");
               System.out.println("busca de un wumpus y no puedes salir "
                       + "hasta encontrarlo.");
               //Imprime pantalla de incio nuevamente.
               startGame();
            }
           case 2 -> {
               System.out.println();
               //Escoger el nivel.
               chooseLevel();}
           case 3 -> {
               System.out.println();
               //Salir del juego.
               System.out.println("¡Gracias por jugar!");}
           default -> {
               //Si se introduce una opción no válida, se avisa al jugador
               //y se le vuelve a imprimir el menú.
               System.out.println("Inserta una opción valida.");
               startGame();
           }
       }
//Expepción si se introduce algo que no sea un número o un integer.
       }catch(Exception e){
           //Se le avisa al jugador que esta opción no es válida
           //y se le vuelve a imprimir el menú.
           input.next();
           System.out.println("Error. Inserta el formato solicitado.");
           startGame();
       }
    }
    /**
     * Se selecciona el nivel que el jugador desea jugar, y agregan las 
     * caracteristicas por nivel escogido.
     */
    public static void chooseLevel(){
        int answer;
        //Crea los diferentes niveles y sus caracteristicas.
        Level[] levels= {
            new Level(50, 20, 1, 3, 1,
                    2,3),
            new Level(45, 30, 2, 2, 2, 
                    6,2),
            new Level(40, 40, 4, 1, 3, 
                    8,1),
            new Level(30, 50, 8, 1, 4, 
                    10,0)
        };
        //Preguntar al jugador que nivel desea y darle sus opciones.
        System.out.println("¿Qué nivel de dificultad desea jugar?");
        System.out.println("1.Facil");
        System.out.println("2.Intermedio");
        System.out.println("3.Difícil");
        System.out.println("4.Super dificil");
        //El jugador da su nivel.
        try{
            answer = input.nextInt();
            if(answer <= levels.length && answer > 0){
                level = levels[answer - 1];
                //Establecer el nivel inicial de oxígeno del jugador.
                player.setOxygen(level.getOxygen());
                player.level = level;
                //Se crea el mundo con las caracteristicas escogidas.
                createNewWorld();
                //Imprime el estatus del jugador.
                showStatus();
            }else{
                //Si se inserta una opción inválida, se le avisa al jugador
                //y se vuelve a imprimir las opciones de nivel.
                System.out.println();
                System.out.println("Selecciona una opción válida.");
                chooseLevel();
            }
        }catch(Exception e){
            //Si se inserta una opción inválida, se le avisa al jugador
            //y se vuelve a imprimir las opciones de nivel.
            input.next();
            System.out.println();
            System.out.println("Seleccione una opcion válida.");
            chooseLevel();
        }
        
    }
    /**
     * Imprime el estatus del jugador, donde se ve su oxígeno, caverna
     * actual, diferentes salidas y sus notificaciones.
     */
    public static void showStatus(){
        //Sacar la caverna en la que esta el jugador actualmente.
        Cave currentCave = maze.get(player.caveID);
        int exitsCount;
        System.out.println();
        //Checar si el jugador esta actualmente en una caverna especial.
        //Si el jugador se encuentra en una caverna especial entonces realizar
        //la acción especial de la caverna en la que esta actualmente.
        if(currentCave instanceof SpecialCave){
                    SpecialCave specialCave = (SpecialCave) currentCave;
                    specialCave.doSpecialAction(player);
                }
        //Checar si el jugador tiene suficiente oxigeno para seguir jugando.
        if(player.getOxygen()<=0){
            //Si no, el jugador pierde.
            endGame(false);
        }else if(currentCave instanceof Cave0 && player.hasWumpus){
            //Si el jugador esta actualmente en la caverna 0 y tiene a wumpus
            //el jugador gana.
            endGame(true);
        }else{
            //Si ninguna de las dos sucede.
            //Se imprime el estatus del jugador.
            //Contiene la caverna donde se encuentra el jugador, 
            //su oxígeno, y sus salidas.
            System.out.println("Estás en la caverna:"+ player.caveID);
            System.out.println("Tienes "+ player.getOxygen() + " de oxígeno.");
            //Imprimir notificación, si tiene
            // Buscar todos los myExits de la cueva actual.
            // Obtener cada cueva que es una salida y verificar si tiene notificación.
            exitsCount = maze.get(player.caveID).myExits.toArray().length;
            for(int i = 0; i < exitsCount; i++){
                currentCave = maze.get(player.caveID).myExits.get(i);
                //Determinar si la cueva es una Water Cave.
                //Si es mandar a llamar notify.
                if(currentCave instanceof WaterCave){
                    WaterCave specialCave = (WaterCave) currentCave;
                    specialCave.notifyCave();
                }  
                //Determinar si la cueva es un Pit.
                //Si es mandar a llamar notify.
                 if(currentCave instanceof Pit){
                    Pit specialCave = (Pit) currentCave;
                    specialCave.notifyCave();
                }
                //Determinar si la cueva es un GiantBat.
                //Si es mandar a llamar notify.
                if(currentCave instanceof GiantBat){
                    GiantBat specialCave = (GiantBat) currentCave;
                    specialCave.notifyCave();
                }
                //Determinar si la cueva es un Wumpus.
                //Si es mandar a llamar notify.
                if(currentCave instanceof Wumpus){
                    Wumpus specialCave = (Wumpus) currentCave;
                    specialCave.notifyCave();
                }
            }
            //Darle las opciones de salidas conectadas al jugador.
            System.out.println("Hay salidas hacia:" + maze.get(player.caveID).toString());
            //Turno de escoger al jugador
            playTurn();
        }
    }
    /**
     * Aquí se juega el turno del jugador, escoge a que salida se dirige, y 
     * cambia al jugador dependiendo de su elección.
     */
    public static void playTurn(){
        //Turno donde escoge el jugador a donde se quiere dirigir.
        System.out.println("¿A que salida te quieres dirigir?");
        //Try catch para que el jugador no pueda insertar algo que 
        //no sea un número.
        try
        {
            //El usuario introduce su salida.
            int selectedCave = input.nextInt();
            Cave currentCave = maze.get(player.caveID);
            //Limpia la consola cada turno
            clearScreen();
            //Si la salida elegida esta entre las opciones de salida
            // el jugador se mueve a la casilla elegida.
            if(currentCave.myExits.contains(maze.get(selectedCave))){
                player.movesPlayer(selectedCave);
                //Enseñar el estatus despues de moverse de casilla.
                showStatus();
            //Si no, pedirle que ingrese una opcion válida
            } else {
                System.out.println("Seleccione una opción válida.");
                //Enseñar el estatus para que el el jugador ingrese una opción
                // valida
                showStatus();
            }
        }catch(Exception e){
            //Enseñar el estatus para que el el jugador ingrese una opción
            // validar.
            System.out.println("Seleccione una opción válida.");
            showStatus();
        }
    }
    /**
     * Define si el jugador ha ganado o perdido y le avisa.
     * @param winner 
     */
    public static void endGame(boolean winner){
        //Se imprime el final del juego.
        //Si el jugador logro atrapar a Wumpus y regresar lo felicita.
        if(winner){
           System.out.println("¡Felicidades!"); 
           System.out.println("Atrapaste a Wumpus.");
        }else{
            //Si el jugador pierde se le avisa que perdió.
            System.out.println("Perdiste.");
            System.out.println("Intenta conseguir a Wumpus nuevamente.");
        }
        //Preguntarle al jugador si quiere volver a jugar.
        System.out.println("¿Quieres volver a jugar?");
        System.out.println("1. Si");
        System.out.println("2. No");
        try{
            int answer = input.nextInt();
            //Si la respuesta es si, regresarlo a la pagina de inicio.
            switch(answer){
                case 1 -> {
                    startGame();
                }
                case 2 -> {
                    //Si no, sacarlo del juego.
                    System.out.println("Gracias por jugar.");
                }
                default -> {
                    //Si la respuesta no es valida, avisarle al jugador
                    //y se vuelve a imprimir la pregunta.
                  System.out.println();
                System.out.println("Selecciona una opción válida.");
                endGame(winner);  
                }
            }
        }catch(Exception e){
            //Si el jugador ha insertado una opción inválida, se le avisa
            //y se le vuelve a preguntar.
            input.next();
            System.out.println();
            System.out.println("Inserta una opción válida.");
            endGame(winner);
        }
    }
    /**
     * Aquí se limpia la pantalla cada que se acaba un turno.
     */
    public static void clearScreen(){
        //Limpia la pantalla cuando se acaba el turno.
        for (int i = 0; i < 50; ++i) 
            System.out.println();
    }
}