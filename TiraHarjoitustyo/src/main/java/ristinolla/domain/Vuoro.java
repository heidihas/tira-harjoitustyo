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
 * Luokka kuvaa mahdollisia siirtovuoroja.
 */
public class Vuoro {
    
    public enum SeuraavaSiirto {
        O, X, E
    }
    
    public SeuraavaSiirto seuraava;
    
}
