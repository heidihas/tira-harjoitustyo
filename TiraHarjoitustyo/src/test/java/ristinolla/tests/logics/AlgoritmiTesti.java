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
import ristinolla.logics.Algoritmi;

/**
 *
 * @author Heidi
 */
public class AlgoritmiTesti {
    
    Algoritmi algoritmi;
    Class algo;
    Method[] metodit;
    
    @Before
    public void setUp() {
        algoritmi = new Algoritmi();
        algo = algoritmi.getClass();
    }

    @Test
    public void luotuAlgoritmiOnOlemassa() {
        assertTrue(algoritmi!=null);      
    }
     
    @Test
    public void score1() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("score")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[0] = 3;
        Object[] param = {rivit, 3, 1};
        int score = (int) metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(score == 9);
    }
    
    @Test
    public void score2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("score")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[0] = -3;
        Object[] param = {rivit, 3, 1};
        int score = (int) metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(score == -9);
    }
    
    @Test
    public void score3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("score")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        Object[] param = {rivit, 3, 1};
        int score = (int) metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(score == 0);
    }
    
    @Test
    public void arvioiEiVoittoa() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("arvioi")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        Object[] param = {rivit, 3};
        int luku = (int) metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(luku == 0);
    }
    
    @Test
    public void asetaSiirtoMinMaxViisto() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("asetaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 2, 1};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(rivit[7] == 1);
    }
    
    @Test
    public void asetaSiirtoMinMaxMaarat1() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("asetaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 0, 1};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[0] == 1);
    }
    
    @Test
    public void asetaSiirtoMinMaxMaarat2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("asetaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 0, 1};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[3] == 1);
    }
    
    @Test
    public void asetaSiirtoMinMaxMaarat3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("asetaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 0, 1};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[6] == 1);
    }
    
    @Test
    public void asetaSiirtoMinMaxMaarat4() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("asetaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 2, 1};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[7] == 1);
    }
    
    @Test
    public void poistaSiirtoMinMaxViisto() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("asetaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 2, 2};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(rivit[7] == -1);
    }
    
    @Test
    public void poistaSiirtoMinMaxMaarat1() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("poistaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 0, 2};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[0] == -1);
    }
    
    @Test
    public void poistaSiirtoMinMaxMaarat2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("poistaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 0, 2};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[3] == -1);
    }
    
    @Test
    public void poistaSiirtoMinMaxMaarat3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("poistaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 0, 2};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[6] == -1);
    }
    
    @Test
    public void poistaSiirtoMinMaxMaarat4() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("poistaSiirtoMinMax")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        int[] riviMaarat = new int[8];
        Object[] param = {rivit, riviMaarat, 3, 2, 2};
        metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(riviMaarat[7] == -1);
    }
    
    @Test
    public void vapaat() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("getVapaat")) {
                indeksi = i;
            }
        }
        int[] ruudukko = new int[9];
        ruudukko[0] = 1;
        Object[] param = {ruudukko, 3};
        ArrayList<Integer> vapaat = (ArrayList<Integer>) metodit[indeksi].invoke(algo.newInstance(), param);
        assertTrue(vapaat.size() == 8);
    }
    
    @Test
    public void peliOhiVoittomahdollisuus() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("peliOhi")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[0] = 1;
        rivit[1] = -1;
        rivit[2] = 0;
        rivit[3] = 0;
        rivit[4] = -1;
        rivit[5] = 1;
        rivit[6] = -1;
        rivit[7] = 0;
        int[] riviMaarat = new int[8];
        riviMaarat[0] = 3;
        riviMaarat[1] = 3;
        riviMaarat[2] = 2;
        riviMaarat[3] = 2;
        riviMaarat[4] = 3;
        riviMaarat[5] = 3;
        riviMaarat[6] = 3;
        riviMaarat[7] = 2;
        ArrayList<Integer> siirrot = new ArrayList<>();
        siirrot.add(6);
        Object[] param = {rivit, riviMaarat, 3, siirrot};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test
    public void peliEiOhiVoittomahdollisuus() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("peliOhi")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[0] = 1;
        rivit[1] = -2;
        rivit[2] = 0;
        rivit[3] = -1;
        rivit[4] = -1;
        rivit[5] = 1;
        rivit[6] = -1;
        rivit[7] = 0;
        int[] riviMaarat = new int[8];
        riviMaarat[0] = 3;
        riviMaarat[1] = 2;
        riviMaarat[2] = 2;
        riviMaarat[3] = 1;
        riviMaarat[4] = 3;
        riviMaarat[5] = 3;
        riviMaarat[6] = 3;
        riviMaarat[7] = 2;
        ArrayList<Integer> siirrot = new ArrayList<>();
        siirrot.add(3);
        siirrot.add(6);
        Object[] param = {rivit, riviMaarat, 3, siirrot};
        assertFalse((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test
    public void xVoittiPystyRivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("xVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[3] = 3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void xVoittiVaakaRivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("xVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[0] = 3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void xVoittiViisto1Rivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("xVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[6] = 3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void xVoittiViisto2Rivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("xVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[7] = 3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void xEiVoittanutRivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("xVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[6] = 1;
        Object[] param = {rivit, 3};
        assertFalse((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void oVoittiPystyRivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("oVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[3] = -3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void oVoittiVaakaRivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("oVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[0] = -3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void oVoittiViisto1Rivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("oVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[6] = -3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void oVoittiViisto2Rivit() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("oVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[7] = -3;
        Object[] param = {rivit, 3};
        assertTrue((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
    
    @Test 
    public void oEiVoittanutRivit() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        metodit = algo.getDeclaredMethods();
        int indeksi = -1;
        for (int i = 0; i < metodit.length; i++) {
            metodit[i].setAccessible(true);
            if (metodit[i].getName().equals("oVoitti")) {
                indeksi = i;
            }
        }
        int[] rivit = new int[8];
        rivit[3] = -2;
        Object[] param = {rivit, 3};
        assertFalse((boolean) metodit[indeksi].invoke(algo.newInstance(), param));
    }
}
