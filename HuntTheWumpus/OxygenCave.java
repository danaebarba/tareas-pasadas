/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class OxygenCave extends SpecialCave{
    //Bool para saber si la special cave ya fue ejecutada.
    public boolean executed=false;
    /**
     * Determina si la caverna es especial.
     */
    public OxygenCave() {
        //Esta caverna si es especial.
        isSpecial=true;
    }
    /**
     * Hace la acción especial.
     * Le da un tanque de oxígeno con 15 puntos al jugador.
     * @param player 
     */
    @Override
    public void doSpecialAction(Player player){
        //Hacer si esta caverna especial no ha sido ejecutada antes.
        if(!executed){
        //Avisar la acción que hará la casilla. 
        System.out.println("Encontraste un tanque de oxígeno.");
        System.out.println("Se te agregarán 15 puntos de oxígeno.");
        //Marcar como ejecutada para que no pueda ser utilizada nuevamente.
        executed = true;
        //Sobrecarga de AddOxygen.
        //Agregar 15 de oxígeno.
        player.addOxygen(15);   
        }
    }
    
}
