/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

/**
 *
 * @author Heidi
 */
/**
 * Luokka kuvaa napin sijaintia peliruudukossa ja pitää tallessa tietyn napin koordinaatit.
 */
public class Sijainti {
    
    private int x;
    private int y;
    
    public Sijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
}
