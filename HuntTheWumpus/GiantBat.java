/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class GiantBat extends SpecialCave implements Alertable{

    /**
     * Determina ciertas especificaciones de la caverna.
     */
    public GiantBat() {
        //Esta caverna si es especial.
        isSpecial = true;
        //Esta caverna si tiene notificación.
        hasNotify=true;
    }
    /**
     * Realiza la acción especial de la caverna.
     * Mueve de una caverna a otra de manera random al jugador.
     * @param player 
     */
     @Override
    public void doSpecialAction(Player player){
        //Avisar la acción que hará la casilla.
        System.out.println("Te encontraste un murcielago gigante.");
        System.out.println("Te agarra con sus garras y te lleva a "
                + "una casilla aleatoria.");
        int ID;
        //Generar otra cueva con número random mientras el ID sea el mismo que
        // donde se encuentra el usuario.
        do{
            //Generar un número random entre el número de cavernas por nivel.
            ID=(int)(Math.random()*player.level.getCaves());
        }while(ID == player.caveID);
        //Se cambia el número de caverna al nuevo ID.
        player.caveID=ID;
    }
    /**
     * Interfaz de notificacion al usuario.
     */
    @Override
    public void notifyCave(){
        System.out.println("Se escucha el aleteo de un animal.");
    }
}
