/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huntthewumpus;

/**
 *
 * @author danae
 */
public class Level {
    //Caracteristicas que contiene cada nivel.
    private int oxygen;
    private int caves;
    private int waterCave;
    private int tank;
    private int pit;
    private int bat;
    private int extraOxygen;

    /**
     * Constructor vacío de Level.
     */
    public Level() {
    }

    /**
     * Constructor lleno.
     * @param oxygen
     * @param caves
     * @param waterCave
     * @param tank
     * @param pit
     * @param bat
     * @param extraOxygen 
     */
    public Level(int oxygen, int caves, int waterCave, int tank, int pit, 
            int bat, int extraOxygen) {
        this.oxygen = oxygen;
        this.caves = caves;
        this.waterCave = waterCave;
        this.tank = tank;
        this.pit = pit;
        this.bat = bat;
        this.extraOxygen = extraOxygen;
    }

    /**
     * Define la cantidad de oxígeno que recibe el jugador dependiendo del nivel.
     * @return 
     */
    public int getOxygen() {
        return oxygen;
    }

    /**
     * Define la cantidad de cavernas que se crean dependiendo del nivel.
     * @return 
     */
    public int getCaves() {
        return caves;
    }

    /**
     * Define la cantidad de WaterCaves que se crean dependiendo del nivel.
     * @return 
     */
    public int getWaterCave() {
        return waterCave;
    }

    /**
     * Define la cantidad de OxygenCaves que se crean dependiendo del nivel.
     * @return 
     */
    public int getTank() {
        return tank;
    }

    /**
     * Define la cantidad de Pits que se crean dependiendo del nivel.
     * @return 
     */
    public int getPit() {
        return pit;
    }

    /**
     * Define la cantidad de GiantBats que se crean dependiendo del nivel.
     * @return 
     */
    public int getBat() {
        return bat;
    }

    /**
     * Define la cantidad de ExtraOxygen que se crean dependiendo del nivel.
     * @return 
     */
    public int getExtraOxygen() {
        return extraOxygen;
    }

    
}
