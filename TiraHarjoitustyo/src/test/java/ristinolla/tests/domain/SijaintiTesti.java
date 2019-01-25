/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.Sijainti;

/**
 *
 * @author Heidi
 */
public class SijaintiTesti {
    
    Sijainti sijainti;
    
    @Before
    public void setUp() {
        sijainti = new Sijainti(2, 1);
    }
    
    @Test
    public void luotuSijaintiOnOlemassa() {
        assertTrue(sijainti!=null);      
    }
    
    @Test
    public void getSijaintiX() {
        assertEquals(2.0, sijainti.getX(), 0);
    }
    
    @Test
    public void getSijaintiY() {
        assertEquals(1.0, sijainti.getY(), 0);
    }
}
