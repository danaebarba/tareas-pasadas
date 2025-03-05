/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

import java.util.ArrayList;

/**
 *
 * @author danae
 */
public class Cave {
    //Número de caverna
    protected int caveID;
    //Bool para determinar si la caverna es especial
    protected boolean isSpecial=false;
    //Bool para determinar si tiene notificación.
    protected boolean hasNotify=false;
    //Número de cavernas en el laberinto
    private static int numCaverns=0;
    //Array list con las diferentes salidas de cada caverna.
    public ArrayList<Cave> myExits = new ArrayList<>();
    
    /**
     * Cada que se crea una caverna se agrega al número de cavernas.
     */
    public Cave() {
        this.caveID = numCaverns++;
    }
    /**
     * Reiniciar el numero de cavernas cada que se inicia un juego nuevo.
     * @param caveId 
     */
    public Cave(int caveId) {
        this.caveID = caveId++;
        numCaverns = this.caveID;
    }
    /**
     * Obtener el numero de caverna en la que esta el jugador.
     * @return caveID
     */
    public int getCaveID() {
        return caveID;
    } 
    /**
     *Imprime mis diferentes salidas. 
     * @return Conexiones de cavernas
     */
    @Override
    public String toString() {
        String result = "";
        // For para imprimir todas las salidas que existen para 
        // la caverna actual.
        for(int i=0; i<myExits.size();i++){
            //Sacar cada una de las salidas que existen en el Array de esa
            //caverna.
            Cave currentExit= myExits.get(i);
            //Sacar esa caverna, e ir agregando las siguientes.
            result += currentExit.getCaveID()+",";
        }
        //Imprimir cada salida que existe para la caverna actual.
        result = result.substring(0, result.length()-1);
        return result;
    }
    /**
     *Conectar la caverna escogida con la otra caverna 
     *escogida de manera bidirecciona. 
     * @param c 
     */
    public void connectCaves(Cave c){
        this.myExits.add(c);
        c.myExits.add(this);
    }
}
