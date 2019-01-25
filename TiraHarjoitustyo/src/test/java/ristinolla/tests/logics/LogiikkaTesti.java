/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.logics;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.Sijainti;
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
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(0, 1);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(0, 2);
        logiikka.asetaSiirto(sijainti3, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiPysty() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti3, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiViisto() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(2, 2);
        logiikka.asetaSiirto(sijainti3, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xEiVoittanut() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(1, 2);
        logiikka.asetaSiirto(sijainti3, 1);
        assertFalse(logiikka.xVoitti());
    }
    
    @Test 
    public void oVoittiVaaka() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(0, 1);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(0, 2);
        logiikka.asetaSiirto(sijainti3, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiPysty() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti3, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiViisto() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 2);
        logiikka.asetaSiirto(sijainti3, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oEiVoittanut() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(1, 2);
        logiikka.asetaSiirto(sijainti3, 2);
        assertFalse(logiikka.oVoitti());
    }
    
    @Test 
    public void etsiVapaatSijainnit1() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        assertTrue(logiikka.etsiVapaatSijainnit().size() == 7);
    }
    
    @Test 
    public void etsiVapaatSijainnit2() {
        assertTrue(logiikka.etsiVapaatSijainnit().size() == 9);
    }
    
    @Test 
    public void tyhjennaPeliruudukko1() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        logiikka.tyhjennäPeliruudukko();
        assertTrue(logiikka.etsiVapaatSijainnit().size() == 9);
    }
    
    @Test 
    public void tyhjennaPeliruudukko2() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 2);
        logiikka.asetaSiirto(sijainti3, 2);
        logiikka.tyhjennäPeliruudukko();
        assertFalse(logiikka.oVoitti());
    }
    
    @Test 
    public void tyhjennaPeliruudukko3() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(0, 1);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(0, 2);
        logiikka.asetaSiirto(sijainti3, 1);
        logiikka.tyhjennäPeliruudukko();
        assertFalse(logiikka.xVoitti());
    }
    
    @Test 
    public void peliOhiX() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti3, 1);
        assertTrue(logiikka.peliOhi());
    }
    
    @Test 
    public void peliEiOhiX() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 1);
        Sijainti sijainti3 = new Sijainti(2, 1);
        logiikka.asetaSiirto(sijainti3, 1);
        assertFalse(logiikka.peliOhi());
    }
    
    @Test 
    public void peliOhiO() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti3, 2);
        assertTrue(logiikka.peliOhi());
    }
    
    @Test 
    public void peliEiOhiO() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 1);
        logiikka.asetaSiirto(sijainti3, 2);
        assertFalse(logiikka.peliOhi());
    }
    
    @Test 
    public void peliOhiTaynna() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti3, 1);
        Sijainti sijainti4 = new Sijainti(0, 1);
        logiikka.asetaSiirto(sijainti4, 2);
        Sijainti sijainti5 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti5, 2);
        Sijainti sijainti6 = new Sijainti(2, 1);
        logiikka.asetaSiirto(sijainti6, 1);
        Sijainti sijainti7 = new Sijainti(0, 2);
        logiikka.asetaSiirto(sijainti7, 1);
        Sijainti sijainti8 = new Sijainti(1, 2);
        logiikka.asetaSiirto(sijainti8, 1);
        Sijainti sijainti9 = new Sijainti(2, 2);
        logiikka.asetaSiirto(sijainti9, 2);
        assertTrue(logiikka.peliOhi() && !logiikka.oVoitti() && !logiikka.xVoitti());
    }
    
    @Test 
    public void peliEiOhi() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 2);
        assertFalse(logiikka.peliOhi());
    }
    
    @Test 
    public void pelataan() {
        assertTrue(logiikka.pelaa(1) != -1);
    }
    
    @Test 
    public void eiPelata() {
        Sijainti sijainti1 = new Sijainti(0, 0);
        logiikka.asetaSiirto(sijainti1, 1);
        Sijainti sijainti2 = new Sijainti(1, 0);
        logiikka.asetaSiirto(sijainti2, 2);
        Sijainti sijainti3 = new Sijainti(2, 0);
        logiikka.asetaSiirto(sijainti3, 1);
        Sijainti sijainti4 = new Sijainti(0, 1);
        logiikka.asetaSiirto(sijainti4, 2);
        Sijainti sijainti5 = new Sijainti(1, 1);
        logiikka.asetaSiirto(sijainti5, 2);
        Sijainti sijainti6 = new Sijainti(2, 1);
        logiikka.asetaSiirto(sijainti6, 1);
        Sijainti sijainti7 = new Sijainti(0, 2);
        logiikka.asetaSiirto(sijainti7, 1);
        Sijainti sijainti8 = new Sijainti(1, 2);
        logiikka.asetaSiirto(sijainti8, 1);
        Sijainti sijainti9 = new Sijainti(2, 2);
        logiikka.asetaSiirto(sijainti9, 2);
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
