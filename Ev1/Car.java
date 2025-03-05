/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evidencia1;

import java.util.ArrayList;

/**
 *
 * @author danae
 */
public class Car {
    //Se crea id de cada carro.
    private int id;
    //Se define el color que tendra.
    private String color;
    //Se define la marca que sera.
    private String brand;

    /**
     * Constructor vacío
     */
    public Car() {
        //Utiliza la función que genera el carro de manera random.
        generateRandomCar();
    }

    /**
     * Constructor lleno
     * @param color
     * @param brand 
     */
    public Car(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    /**
     * Obtiene el color del carro
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtiene la marca del carro
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Muestra el color y la marca de los carros
     * @return 
     */
    @Override
    public String toString() {
        return brand + " " + color;
    }
    
    /**
     * Genera el carro random entre las opciones.
     */
    public void generateRandomCar(){
        //Array con las opciones de marcas de carros.
        String[] brands = {"Mazda", "Mercedes", "BMW", "KIA", "Honda", "Toyota",
            "Hyundai", "Chevrolet", "GMC", "Ford", "Audi", "Volkswagen", "Nissan", 
            "Jeep", "MG", "Dodge", "Jaguar", "Volvo", "Fiat", "Suzuki", 
            "Porsche", "Mini Cooper", "Renault"};
        //Array con las opciones de colores para carros.
        String[] colors = {"Negro", "Blanco", "Azul Electrico", "Gris Claro", 
            "Rojo", "Naranja", "Verde", "Gris Oscuro", "Azul Marino"};
        
        //Saca número random que decide que posicion del array se escogerá 
        //para la marca y el color del carro.
        this.brand = brands[(int) (Math.floor(Math.random()*(23)))];
        this.color = colors[(int) (Math.floor(Math.random()*(9)))];
    }
}
