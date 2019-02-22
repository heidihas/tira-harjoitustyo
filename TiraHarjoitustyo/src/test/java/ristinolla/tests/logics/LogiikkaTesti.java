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
import ristinolla.logics.Logiikka;

/**
 *
 * @author Heidi
 */
public class LogiikkaTesti {
    
    Logiikka logiikka;
    
    @Before
    public void setUp() {
        logiikka = new Logiikka(3);
    }
    
    @Test
    public void luotuLogiikkaOnOlemassa() {
        assertTrue(logiikka!=null);      
    }
    
    @Test
    public void luotuRuudukkoOnOlemassa() {
        assertTrue(logiikka.getRuudukko()!=null);      
    }
    
    @Test
    public void luotuRiviTaulukkoOnOlemassa() {
        assertTrue(logiikka.getRivit()!=null);      
    }
    
    @Test 
    public void tyhjennaPeliruudukko1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(2, 0, 2);
        logiikka.tyhjennaPeliruudukko();
        assertTrue(logiikka.getRuudukko().getRuudukko()[0] == 0 && logiikka.getRuudukko().getRuudukko()[2] == 0);
    }
    
    @Test 
    public void tyhjennaPeliruudukko2() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 2, 2);
        logiikka.tyhjennaPeliruudukko();
        assertFalse(logiikka.oVoitti());
    }
    
    @Test 
    public void tyhjennaPeliruudukko3() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.tyhjennaPeliruudukko();
        assertFalse(logiikka.xVoitti());
    }
    
    @Test 
    public void asetaSiirtoX() {
        logiikka.asetaSiirto(0, 0, 1);
        assertTrue(logiikka.getRuudukko().getRuudukko()[0] == 1);
    }
    
    @Test 
    public void asetaSiirtoO() {
        logiikka.asetaSiirto(0, 0, 2);
        assertTrue(logiikka.getRuudukko().getRuudukko()[0] == 2);
    }
    
    @Test 
    public void eiAsetaSiirtoX() {
        logiikka.asetaSiirto(0, 1, 1);
        assertTrue(logiikka.getRuudukko().getRuudukko()[1] == 0);
    }
    
    @Test 
    public void eiAsetaSiirtoO() {
        logiikka.asetaSiirto(0, 1, 2);
        assertTrue(logiikka.getRuudukko().getRuudukko()[1] == 0);
    }
    
    @Test 
    public void siirtojaOnJaljella1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.getRuudukko().onVapaita());
    }
    
    @Test 
    public void siirtojaOnJaljella2() {
        assertTrue(logiikka.getRuudukko().onVapaita());
    }
    
    @Test 
    public void siirtojaEiOleJaljella() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 2, 2);
        assertFalse(logiikka.getRuudukko().onVapaita());
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
    public void xVoittiPysty() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiVaaka() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiViisto1() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 2, 1);
        assertTrue(logiikka.xVoitti());
    }
    
    @Test 
    public void xVoittiViisto2() {
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 0, 1);
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
    public void xVoittiPystyRivit() {
        logiikka.asetaSiirto(0, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        assertTrue(logiikka.xVoitti(logiikka.getRivit()));
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
    public void oVoittiPysty() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(0, 1, 2);
        logiikka.asetaSiirto(0, 2, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiVaaka() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(2, 0, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiViisto1() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 2, 2);
        assertTrue(logiikka.oVoitti());
    }
    
    @Test 
    public void oVoittiViisto2() {
        logiikka.asetaSiirto(0, 2, 2);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 0, 2);
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
    public void pelataan1() {
        assertTrue(logiikka.pelaa(1) != -1);
    }
    
    @Test 
    public void pelataan2() {
        assertTrue(logiikka.pelaa(1) == 0);
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
    }
}
