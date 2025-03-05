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
     		 this.dashes = this.dashes+".";}
    }

    @Override
    public String toString() {
        return "Word{" + "dashes=" + dashes +
                ", secretWord=" + secretWord + '}';
    }
    /**
     * Nos dice si un caracter esta en la palabra secreta
     * @param c caracter a bsucar
     * @return true si esta la palabra
     */
    /*public boolean containsChar(char c){
        boolean result = false;
        if (this.secretWord.contains(String.valueOf(c))){
            result = true;
        }
        return result;
    }*/
    public boolean containsChar(char c){
        return this.secretWord.contains(c+"");
    }
    /**
     * remplaza los dashes por su caracter
     * @param c caracter a remplazar
     * @return dashes
     */
    
    public String replaceDash(char c){
        String result = "";
        if(this.containsChar(c)){
            for(int i = 0; i < secretWord.length(); i++)
                if(this.secretWord.charAt(i) == c){
                    this.dashes = this.dashes.substring(0,1)+
                            c + this.dashes.substring(i+1);
                }
        }
        result = this.dashes;
        return result;
    }
    /**
     * Nos dice si esta completa la palabra
     * @return true si esta completo 
     */
    public boolean isComplete(){
        return !this.dashes.contains(".");
    }
        
    
}
