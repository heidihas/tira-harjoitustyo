/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.logics;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.ArrayList;
import ristinolla.logics.Algoritmi;

/**
 *
 * @author Heidi
 */
public class AlgoritmiTesti {
    
    Algoritmi algoritmi;
    
    @Before
    public void setUp() {
        algoritmi = new Algoritmi();
    }

    @Test
    public void luotuAlgoritmiOnOlemassa() {
        assertTrue(algoritmi!=null);      
    }
    
    /*@Test 
    public void xVoittiPystyRivit() {
        int[] rivit = new int[9];
        rivit[0] = 1;
        rivit[3] = 1;
        rivit[6] = 1;
        assertTrue(algoritmi.xVoitti(rivit, 3));
    }
    
    @Test 
    public void xVoittiVaakaRivit() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.xVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void xVoittiViisto1Rivit() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 2, 1);
        assertTrue(logiikka.xVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void xVoittiViisto2Rivit() {
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.xVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void xEiVoittanutRivit() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(1, 2, 1);
        assertFalse(logiikka.xVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void oVoittiPystyRivit() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(0, 2, 2);
        assertTrue(logiikka.oVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void oVoittiVaakaRivit() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.oVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void oVoittiViisto1Rivit() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.oVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void oVoittiViisto2Rivit() {
        logiikka.asetaSiirto(0, 2, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.oVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void oEiVoittanutRivit() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(1, 2, 2);
        assertFalse(logiikka.oVoitti(logiikka.getRivit()));
    }
    
    @Test 
    public void xVoittiPystyArvioi() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == 10);
    }
    
    @Test 
    public void xVoittiVaakaArvioi() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == 10);
    }
    
    @Test 
    public void xVoittiViistoArvioi() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 2, 1);
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == 10);
    }
    
    @Test 
    public void xEiVoittanutArvioi() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(1, 2, 1);
        assertFalse(logiikka.arvioi(logiikka.getRivit()) == 10);
    }
    
    @Test 
    public void oVoittiPystyArvioi() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(0, 2, 2);
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == -10);
    }
    
    @Test 
    public void oVoittiVaakaArvioi() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == -10);
    }
    
    @Test 
    public void oVoittiViistoArvioi() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == -10);
    }
    
    @Test 
    public void oEiVoittanutArvioi() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(1, 2, 2);
        assertFalse(logiikka.arvioi(logiikka.getRivit()) == -10);
    }
    
    @Test 
    public void kukaanEiVoittanutArvioi() {
        assertTrue(logiikka.arvioi(logiikka.getRivit()) == 0);
    }
    
    @Test 
    public void minmax1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.minmaxAlfaBeeta(logiikka.getRuudukko().getRuudukko(), logiikka.getRivit(), 0, 10, 1, Integer.MIN_VALUE, Integer.MAX_VALUE)[0] == 10);
    }
    
    @Test 
    public void minmax2() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 2, 2);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.minmaxAlfaBeeta(logiikka.getRuudukko().getRuudukko(), logiikka.getRivit(), 0, 10, 1, Integer.MIN_VALUE, Integer.MAX_VALUE)[0] == -10);
    }
    
    @Test 
    public void minmax3() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.minmaxAlfaBeeta(logiikka.getRuudukko().getRuudukko(), logiikka.getRivit(), 0, 10, 1, Integer.MIN_VALUE, Integer.MAX_VALUE)[0] == 0);
    }
    
    @Test 
    public void minmax4() {
        assertTrue(logiikka.minmaxAlfaBeeta(logiikka.getRuudukko().getRuudukko(), logiikka.getRivit(), 0, 10, 1, Integer.MIN_VALUE, Integer.MAX_VALUE)[0] != Integer.MAX_VALUE);
    }
    
    @Test 
    public void minmax5() {
        assertTrue(logiikka.minmaxAlfaBeeta(logiikka.getRuudukko().getRuudukko(), logiikka.getRivit(), 0, 10, 1, Integer.MIN_VALUE, Integer.MAX_VALUE)[0] != Integer.MIN_VALUE);
    }
    
    @Test
    public void score1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        int pisteet = logiikka.score(logiikka.getRivit(), 1);
        assertTrue(pisteet == 9);
    }
    
    @Test
    public void score2() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 2);
        int pisteet = logiikka.score(logiikka.getRivit(), 1);
        assertTrue(pisteet == -9);
    }
    
    @Test
    public void asetaSiirtoMinMaxViisto1() {
        logiikka.asetaSiirtoMinMax(logiikka.getRivit(), 0, 1);
        assertTrue(logiikka.getRivit()[6] == 1);
    }
    
    @Test
    public void asetaSiirtoMinMaxViisto2() {
        logiikka.asetaSiirtoMinMax(logiikka.getRivit(), 2, 1);
        assertTrue(logiikka.getRivit()[7] == 1);
    }
    
    @Test
    public void poistaSiirtoMinMaxViisto1() {
        logiikka.poistaSiirtoMinMax(logiikka.getRivit(), 0, 1);
        assertTrue(logiikka.getRivit()[6] == -1);
    }
    
    @Test
    public void poistaSiirtoMinMaxViisto2() {
        logiikka.poistaSiirtoMinMax(logiikka.getRivit(), 2, 1);
        assertTrue(logiikka.getRivit()[7] == -1);
    }
    
    @Test
    public void vapaat() {
        ArrayList<Integer> vapaat = logiikka.getVapaat(logiikka.getRuudukko().getRuudukko());
        assertTrue(vapaat.size() == 9);
    }*/
}
