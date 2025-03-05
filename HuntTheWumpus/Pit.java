/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class Pit extends SpecialCave implements Alertable{

    /**
     * Determina ciertas especificaciones de la caverna.
     */
    public Pit() {
        //Esta caverna si es especial.
        isSpecial=true;
        //Esta caverna si tiene notificación
        hasNotify=true;
    }
    /**
     * Realiza la acción especial de la caverna.
     * Baja todo el oxígeno al jugador, por lo cual muere.
     * @param player 
     */
    @Override
    public void doSpecialAction(Player player){
        //Avisar al jugador que murió.
        System.out.println("Caiste en un pozo.");
        System.out.println("Que mala suerte.");
        //Sobrecarga de LowerOxygen
        //Bajar todo el oxígeno que tiene el jugador en ese momento.
        player.lowerOxygen(player.getOxygen());
        System.out.println();
    }
    /**
     * Interfaz de notificacion al usuario.
     */
    @Override
    public void notifyCave(){
        System.out.println("Se siente frío.");
    }
}
