/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4;

/**
 *guarda la palabra secreta
 * @author danae
 */
public class Word {
    //declarar variables
    private String dashes;
    private String secretWord;

    public Word() {
    }
    
    public Word (String secretWord){
        this.setSecretword(secretWord);
        //this.secretWord = secretWord;
    }
    
    public String getDashes() {
        return dashes;
    }

    public String getSecretword() {
        return secretWord;
    }

    public void setSecretword(String secretword) {
        this.secretWord = secretword;
        this.dashes = "";
        for(int x = 0; x < secretWord.length(); x++){
     		 this.dashes = this.dashes+"_ ";}
    }

    @Override
    public String toString() {
        return "Word{" + "dashes=" + dashes +
                ", secretWord=" + secretWord + '}';
    }
    /**
     * Nos dice si un caracter esta en la palabra secreta
     * @param a caracter a bsucar
     * @return true si esta la palabra
     */
    public boolean containsChar(char a){
        boolean result = false;
        return result;
    }
    /**
     * remplaza los dashes por su caracter
     * @param a caracter a remplazar
     * @return dashes
     */
    
    public String replaceDash(char a){
        char[] word1 = getSecretword().toCharArray();
        char[] dashesChar = dashes.toCharArray();
        for (int i = 0; i < ((getSecretword().length()*2)-1); i = i + 2){
            if(a == word1[(i/2)]){
                dashesChar[i] = a;
            }
        }
        dashes = String.valueOf(dashesChar);
        return dashes;
    }
    /**
     * Nos dice si esta completos los dashes
     * @return true si esta completo 
     */
    public boolean isComplete(){
        boolean result = false;
        return result;
    }
    
}
