/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class Cave0 extends SpecialCave{

    /**
     * Determina si la caverna es especial.
     */
    public Cave0() {
        //Esta caverna si es especial.
        isSpecial=true;
    }
    /**
     * Realiza la accion especial de la caverna.
     * Le da al jugador el wumpus, por lo que puede regresar al campamento
     * y ganar.
     * @param player 
     */
    @Override
    public void doSpecialAction(Player player){
        //Si el jugador no tiene a Wumpus.
        if(!player.hasWumpus){
            //Avisarle que tiene que regresar con Wumpus para ganar.
            System.out.println("Regresa con Wumpus para poder salir de"
                    + " las cuevas.");
            //Resetear el oxígeno del jugador cada que pase por el campamento.
            player.setOxygen(player.level.getOxygen());
        }
    }
}
