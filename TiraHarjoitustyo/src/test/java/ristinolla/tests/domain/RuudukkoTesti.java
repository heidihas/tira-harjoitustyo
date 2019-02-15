/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.Ruudukko;

/**
 *
 * @author Heidi
 */
public class RuudukkoTesti {
    
    Ruudukko ruudukko;
    
    @Before
    public void setUp() {
        ruudukko = new Ruudukko(3);
    }
    
    @Test
    public void luotuRuudukkoOnOlemassa() {
        assertTrue(ruudukko!=null);      
    }
    
    @Test
    public void ruudukkoOnOlemassa() {
        assertTrue(ruudukko.getRuudukko()!=null);      
    }
    
    @Test
    public void ruudukkoOnOikeanKokoinen() {
        assertTrue(ruudukko.getRuudukko().length == 9);      
    }
    
    @Test
    public void ruudukkoOnTyhja() {
        assertTrue(ruudukko.getVapaita() == 9);      
    }
    
    @Test
    public void ruudukossaOnVapaita() {
        assertTrue(ruudukko.onVapaita());      
    }
    
    @Test
    public void ruudukkoAseta1() {
        ruudukko.aseta(0, 0, 1);
        assertTrue(ruudukko.getVapaita() == 8);      
    }
    
    @Test
    public void ruudukkoAseta2() {
        ruudukko.aseta(0, 0, 1);
        assertTrue(ruudukko.getRuudukko()[0] == 1);      
    }
    
    @Test
    public void ruudukossaEiVapaita() {
        ruudukko.aseta(0, 0, 1);
        ruudukko.aseta(0, 1, 1);
        ruudukko.aseta(0, 2, 1);
        ruudukko.aseta(1, 0, 1);
        ruudukko.aseta(1, 1, 1);
        ruudukko.aseta(1, 2, 1);
        ruudukko.aseta(2, 0, 1);
        ruudukko.aseta(2, 1, 1);
        ruudukko.aseta(2, 2, 1);
        assertFalse(ruudukko.onVapaita());      
    }
    
    @Test
    public void ruudukkoTyhjennetaan() {
        ruudukko.aseta(0, 0, 1);
        ruudukko.aseta(0, 1, 1);
        ruudukko.aseta(0, 2, 1);
        ruudukko.aseta(1, 0, 1);
        ruudukko.aseta(1, 1, 1);
        ruudukko.aseta(1, 2, 1);
        ruudukko.aseta(2, 0, 1);
        ruudukko.aseta(2, 1, 1);
        ruudukko.aseta(2, 2, 1);
        ruudukko.tyhjenna();
        assertTrue(ruudukko.getVapaita() == 9);      
    }
}
