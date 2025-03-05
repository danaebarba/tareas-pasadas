/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class Wumpus extends SpecialCave implements Alertable{
    //Bool para saber si la special cave ya fue ejecutada.
    public boolean executed=false;
    
    public Wumpus() {
        //Esta caverna si es especial.
        isSpecial=true;
        //Esta caverna si tiene notificación.
        hasNotify=true;
    }
    /**
     * 
     * @param player 
     */
    @Override
    public void doSpecialAction(Player player){
        //Si la caverna no ha sido ejecutada.
        if(!executed){
            //Avisarle al jugador que encontro a Wumpus.
            System.out.println("Encontraste a Wumpus.");
            System.out.println("Felicidades.");
            System.out.println("Ahora regresa al campamento sin "
                    + "morir en el intento.");
            //El jugador ya tiene a wumpus
            player.hasWumpus=true;
            //La caverna ya fue ejecutada.
            executed = true;
        }
    }
    @Override
    public void notifyCave(){
        //Interfaz de notificacion al usuario.
        System.out.println("Huele a Wumpus.");
    }
}
