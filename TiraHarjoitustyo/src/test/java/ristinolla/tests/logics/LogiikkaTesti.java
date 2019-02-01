/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.logics;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.logics.Logiikka;

/**
 *
 * @author Heidi
 */
public class LogiikkaTesti {
    
    Logiikka logiikka;
    
    @Before
    public void setUp() {
        logiikka = new Logiikka();
    }
    
    @Test
    public void luotuLogiikkaOnOlemassa() {
        assertTrue(logiikka!=null);      
    }
    
    @Test 
    public void xVoittiVaaka() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiPysty() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiViisto() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 2, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xEiVoittanut() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(1, 2, 1);
        assertFalse(logiikka.xVoitti());
    }
    
    @Test 
    public void oVoittiVaaka() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(0, 2, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiPysty() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiViisto() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oEiVoittanut() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(1, 2, 2);
        assertFalse(logiikka.oVoitti());
    }
    
    @Test 
    public void etsiVapaatSijainnit1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.etsiVapaatSijainnit().size() == 7);
    }
    
    @Test 
    public void etsiVapaatSijainnit2() {
        assertTrue(logiikka.etsiVapaatSijainnit().size() == 9);
    }
    
    @Test 
    public void tyhjennaPeliruudukko1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(2, 0, 2);
        logiikka.tyhjennäPeliruudukko();
        assertTrue(logiikka.etsiVapaatSijainnit().size() == 9);
    }
    
    @Test 
    public void tyhjennaPeliruudukko2() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 2, 2);
        logiikka.tyhjennäPeliruudukko();
        assertFalse(logiikka.oVoitti());
    }
    
    @Test 
    public void tyhjennaPeliruudukko3() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.tyhjennäPeliruudukko();
        assertFalse(logiikka.xVoitti());
    }
    
    @Test 
    public void peliOhiX() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.peliOhi());
    }
    
    @Test 
    public void peliEiOhiX() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 1, 1);
        assertFalse(logiikka.peliOhi());
    }
    
    @Test 
    public void peliOhiO() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.peliOhi());
    }
    
    @Test 
    public void peliEiOhiO() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 1, 2);
        assertFalse(logiikka.peliOhi());
    }
    
    @Test 
    public void peliOhiTaynna() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.peliOhi() && !logiikka.oVoitti() && !logiikka.xVoitti());
    }
    
    @Test 
    public void peliEiOhi() {
        logiikka.asetaSiirto(0, 0, 2);
        assertFalse(logiikka.peliOhi());
    }
    
    @Test 
    public void pelataan() {
        assertTrue(logiikka.pelaa(1) != -1);
    }
    
    @Test 
    public void eiPelata() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.pelaa(1) == -1);
    }
    
    @Test 
    public void minmax() {
        int luku = logiikka.minMax(0, 2);
        assertTrue(luku == -1 || luku == 0 || luku == 1);
    }
    
    @Test 
    public void eiMinmax() {
        assertTrue(logiikka.minMax(0, 1) != 2);
    }
}
