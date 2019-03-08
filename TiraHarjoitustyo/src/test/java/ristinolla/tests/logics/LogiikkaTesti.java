/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.logics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    Class logi;
    Method[] metodit;
    
    @Before
    public void setUp() {
        logiikka = new Logiikka(3);
        logi = logiikka.getClass();
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
    public void luotuRiviMaaraTaulukkoOnOlemassa() {
        assertTrue(logiikka.getRiviMaarat()!=null);      
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
    public void asetaSiirto1() {
        logiikka.asetaSiirto(0, 0, 1);
        assertTrue(logiikka.getRiviMaarat()[6] == 1);
    }
    
    @Test 
    public void asetaSiirto2() {
        logiikka.asetaSiirto(0, 0, 1);
        assertTrue(logiikka.getRiviMaarat()[0] == 1);
    }
    
    @Test 
    public void asetaSiirto3() {
        logiikka.asetaSiirto(0, 0, 1);
        assertTrue(logiikka.getRiviMaarat()[3] == 1);
    }
    
    @Test 
    public void asetaSiirto4() {
        logiikka.asetaSiirto(2, 0, 1);
        assertTrue(logiikka.getRiviMaarat()[7] == 1);
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
    public void peliOhiEiVoittomahdollisuutta1() {
        Logiikka log = new Logiikka(4);
        log.asetaSiirto(0, 0, 1);
        log.asetaSiirto(1, 0, 2);
        log.asetaSiirto(2, 0, 1);
        log.asetaSiirto(3, 0, 2);
        log.asetaSiirto(1, 1, 2);
        log.asetaSiirto(2, 1, 1);
        log.asetaSiirto(3, 1, 1);
        log.asetaSiirto(1, 2, 1);
        log.asetaSiirto(2, 2, 2);
        log.asetaSiirto(0, 3, 2);
        log.asetaSiirto(3, 3, 1);
        assertTrue(log.peliOhi());
    }
    
    @Test 
    public void peliOhiEiVoittomahdollisuutta2() {
        logiikka.asetaSiirto(0, 0, 2);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(1, 1, 2);
        logiikka.asetaSiirto(2, 1, 2);
        logiikka.asetaSiirto(1, 2, 2);
        logiikka.asetaSiirto(2, 2, 1);
        assertTrue(logiikka.peliOhi());
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
    public void pelataan1() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(0, 1, 1);
        logiikka.asetaSiirto(0, 2, 1);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(2, 2, 1);
        logiikka.asetaSiirto(0, 0, 1);
        assertTrue(logiikka.pelaa(2) != -1);
    }
    
    @Test 
    public void pelataan2() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(3, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        logiikka.asetaSiirto(2, 1, 1);
        logiikka.asetaSiirto(1, 2, 1);
        logiikka.asetaSiirto(2, 2, 1);
        logiikka.asetaSiirto(3, 2, 1);
        logiikka.asetaSiirto(3, 1, 1);
        assertTrue(logiikka.pelaa(1) == 0);
    }
    
    @Test 
    public void pelataan3() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(3, 0, 1);
        assertTrue(logiikka.pelaa(2) == 1);
    }
    
    @Test 
    public void pelataan4() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(3, 0, 1);
        logiikka.asetaSiirto(3, 1, 1);
        assertTrue(logiikka.pelaa(1) == 11);
    }
    
    @Test 
    public void pelataan5() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(1, 3, 1);
        logiikka.asetaSiirto(0, 3, 1);
        assertTrue(logiikka.pelaa(1) == 14);
    }
    
    @Test 
    public void pelataan6() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(2, 0, 1);
        logiikka.asetaSiirto(1, 0, 1);
        assertTrue(logiikka.pelaa(2) == 0);
    }
    
    @Test 
    public void pelataan7() {
        logiikka = new Logiikka(4);
        logiikka.asetaSiirto(2, 2, 1);
        logiikka.asetaSiirto(1, 2, 1);
        assertTrue(logiikka.pelaa(1) == 8);
    }
    
    @Test 
    public void pelataan8() {
        logiikka.asetaSiirto(0, 1, 1);
        assertTrue(logiikka.pelaa(2) == 0);
    }
    
    @Test 
    public void pelataanPelastavaSiirto1() {
        logiikka.asetaSiirto(1, 0, 1);
        logiikka.asetaSiirto(1, 1, 1);
        assertTrue(logiikka.pelaa(2) == 7);
    }
    
    @Test 
    public void pelataanPelastavaSiirto2() {
        logiikka.asetaSiirto(1, 0, 2);
        logiikka.asetaSiirto(1, 1, 2);
        assertTrue(logiikka.pelaa(1) == 7);
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
    public void alitaulukko() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        metodit = logi.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("alitaulukko")) {
                indeksi = i;
            }
        }
        ArrayList<Integer> paikat = (ArrayList<Integer>) metodit[indeksi].invoke(logi.getDeclaredConstructor(int.class).newInstance(3));
        assertTrue(paikat.contains(6) && paikat.contains(5) && paikat.contains(4));
    }
    
    @Test
    public void alitaulukko2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        metodit = logi.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("alitaulukko")) {
                indeksi = i;
            }
        }
        ArrayList<Integer> paikat = (ArrayList<Integer>) metodit[indeksi].invoke(logi.getDeclaredConstructor(int.class).newInstance(2));
        assertTrue(paikat.contains(-2));
    }
}
