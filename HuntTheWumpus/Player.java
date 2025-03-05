/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class Player {
    //Oxígeno del jugador.
    private int oxygen;
    //Define si el jugador ya tiene a Wumpus o no.
    public boolean hasWumpus;
    //Define en que cave se encuentra el jugador.
    public int caveID;
    //Define el nivel en el que se encuentra el jugador.
    public Level level;

    /**
     * Constructor vacio de player.
     */
    public Player() {
    }
    /**
     * Cada que el jugador se mueve esta funcion tiene que ser llamada.
     * Reduce uno de oxígeno al jugador cada turno.
     */
    public void lowerOxygen(){
        oxygen--;
    }
    /**
     * Sobrecarga para reducir el oxígeno.
     * @param lowerOxygen 
     */
    public void lowerOxygen(int lowerOxygen){
        oxygen -= lowerOxygen;
    }
    /**
     * Obtiene el oxígeno que contiene el jugador en ese momento.
     * @return oxygen
     */
    public int getOxygen() {
        return oxygen;
    }
    /**
     * Define el oxígeno que tiene el jugador en ese momento.
     * @param oxygen 
     */
    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }
    /**
     * Mueve el jugador a la caverna seleccionada y reduce el oxígeno del 
     * jugador al hacerlo.
     * @param selectedCave 
     */
    public void movesPlayer(int selectedCave){
        caveID = selectedCave;
        lowerOxygen();
    }
    /**
     * Le agrega uno de oxígeno al jugador.
     */
    public void addOxygen(){
        oxygen++;
        //Si el jugador tiene mas del límite por nivel se reinicia el oxígeno. 
        if(oxygen > level.getOxygen()){
            oxygen = level.getOxygen();
        }
    }
    /**
     * Sobrecarga para agregarle oxígeno al jugador.
     * @param addOxygen 
     */
    public void addOxygen(int addOxygen){
        oxygen += addOxygen;
        //Si el jugador tiene mas del límite por nivel se reinicia el oxígeno.
        if(oxygen > level.getOxygen()){
            oxygen = level.getOxygen();
        }
    }
}
