/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

import static huntthewumpus.HuntTheWumpus.input;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author danae
 */
public class ExtraOxygen extends SpecialCave{
    //String de la respuesta dada por el jugador.
    String answer = new String();
    //El jugador paso.
    boolean passed = true;
    //Esta casilla ya fue ejecutada
    boolean executed = false;
    
    //Timer para definir el tiempo que tiene el jugador para introducir la
    // respuesta.
    TimerTask task = new TimerTask()
        {
            /**
             * Determina si el jugador realizó la tarea dentro del tiempo.
             */
            @Override
            public void run()
            {
                //Si el jugador se paso del tiempo y no introdució una respuesta.
                if( answer.equals("") )
                {
                    System.out.println( "Te tardaste mucho." );
                    System.out.println( "Presiona enter para continuar." );
                    //Se marca como que no paso la respuesta.
                    passed = false;
                }
            }    
        };
    /**
     * Determina si la casilla se marca como especial.
     */
    public ExtraOxygen() {
        isSpecial=true;
    }
    /**
     * Realiza la accion especial de la caverna.
     * Le da una multiplicación al jugador y si este la realiza a tiempo
     * se le otorga una recompensa regenerandole su oxígeno.
     * @param player 
     */
    @Override
    public void doSpecialAction(Player player){
        //Solo hacer esta accion si no se ha realizado antes.
        if(!executed){
            int num1;
            int num2;
            //Cada numero se define como un numero random entre 1 y 100.
            num1= (int)(Math.random()*100);
            num2= (int)(Math.random()*100);

            //Se inicializa el timer con una duracion de 30 segundos.
            Timer timer = new Timer();
            timer.schedule( task, 30000 );

            //Se le avisa al jugador lo que tiene que hacer.
            System.out.println("Caíste en un bonus.");
            System.out.println("Para recuperar todo tu oxigeno responde "
                    + "correctamente la siguiente multiplicación:");
            System.out.println("Tienes 30 segundos.");
            //Se le muestra al jugador la ecuación a realizar.
            System.out.println(num1 + " * " + num2);
            //Try catch error para el input de la respuesta.
            try{
                //El usuario introduce su respuesta.
                answer = input.next();
                //En el momento en el que se introduce una respuesta se acaba 
                // el timer.
                timer.cancel();
                //Si la respuesta es correcta se le avisa al jugador.
                if(passed && Integer.parseInt(answer) == num1 * num2){
                    System.out.println("Respuesta correcta. Disfruta de tu"
                            + " oxígeno.");
                    //Y se le reinicia el oxígeno.
                    player.setOxygen(player.level.getOxygen());
                    System.out.println();
                }else{
                    //Si la respuesta es incorrecta se le avisa al jugador.
                    System.out.println();
                    System.out.println("Respuesta incorrecta.");
                    System.out.println("Más suerte la proxima.");
                    System.out.println();
                }
            }catch(Exception e){
                //Si la respuesta es incorrecta se le avisa al jugador.
                input.next();
                System.out.println();
                System.out.println("Respuesta incorrecta.");
                System.out.println("Más suerte la proxima.");
                System.out.println();
            }finally{
                //Cualquier resultado que haya dado esta casilla no volvera a
                // repetirse.
                executed = true;
            }
    }
   }
}
