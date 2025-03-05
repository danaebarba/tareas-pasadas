/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class WaterCave extends SpecialCave implements Alertable{

    /**
     * Determina especificaciones de esta caverna.
     */
    public WaterCave() {
        //Esta caverna si es especial.
        isSpecial=true;
        //Esta caverna si tiene notificación.
        hasNotify=true;
    }
    /**
     * Hace la acción especial de la caverna.
     * Reducirle tres puntos al oxígeno del jugador.
     * @param player 
     */
    @Override
    public void doSpecialAction(Player player){
        //Avisar la acción que hará la casilla. 
        System.out.println("Caíste en lago.");
        System.out.println("Se te bajara 3 puntos de oxígeno.");
        //Sobrecarga de LowerOxygen
        //Reducirle tres puntos al oxígeno del jugador.
        player.lowerOxygen(3);
    }
    /**
     * Interfaz de notificacion al usuario.
     */
    @Override
    public void notifyCave(){
        System.out.println("Se escucha el sonido de un río.");
    }
}
