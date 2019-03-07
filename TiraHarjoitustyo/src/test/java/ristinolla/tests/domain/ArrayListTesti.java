/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.tests.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ristinolla.domain.ArrayList;

/**
 *
 * @author Heidi
 */
public class ArrayListTesti {
    
    ArrayList lista;
    
    @Before
    public void setUp() {
        lista = new ArrayList();
    }
    
    @Test
    public void luotuListaOnOlemassa() {
        assertTrue(lista!=null);      
    }
    
    @Test
    public void luotuListaOnTyhja1() {
        assertTrue(lista.isEmpty());      
    }
    
    @Test
    public void luotuListaOnTyhja2() {
        assertTrue(lista.size() == 0);      
    }
    
    @Test
    public void luotuListaKapasiteetti() {
        assertTrue(lista.getCapacity() == 10);      
    }
    
    @Test
    public void lisaa1() {
        lista.add(1);
        assertTrue(lista.size() == 1);      
    }
    
    @Test
    public void lisaa2() {
        lista.add(1);
        assertFalse(lista.isEmpty());      
    }
    
    @Test
    public void lisaa3() {
        lista.add(1);
        assertTrue((Integer) lista.get(0) == 1);      
    }
    
    @Test
    public void lisaa4() {
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        assertTrue(lista.getCapacity() == 20);      
    }
    
    @Test
    public void lisaa5() {
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);
        assertTrue((Integer) lista.get(0) == 1);      
    }
    
    @Test
    public void korvaa() {
        lista.add(1);
        lista.replace(0, 2);
        assertTrue((Integer) lista.get(0) == 2);      
    }
    
    @Test
    public void poista1() {
        lista.add(1);
        lista.remove(0);
        assertTrue(lista.get(0) == null);      
    }
    
    @Test
    public void poista2() {
        lista.add(1);
        lista.remove(0);
        assertTrue(lista.isEmpty());      
    }
    
    @Test
    public void poista3() {
        lista.add(1);
        lista.remove(0);
        assertTrue(lista.size() == 0);      
    }
    
    @Test
    public void poista4() {
        lista.add(1);
        lista.add(2);
        lista.remove(0);
        assertTrue((Integer) lista.get(0) == 2);      
    }
    
    @Test
    public void poista5() {
        lista.add(1);
        lista.add(2);
        lista.remove(0);
        assertTrue(lista.get(1) == null);      
    }
    
    @Test
    public void poista6() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(0);
        assertTrue((Integer) lista.get(0) == 2 && (Integer) lista.get(1) == 3);      
    }
    
    @Test
    public void poista7() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(1);
        assertTrue((Integer) lista.get(0) == 1 && (Integer) lista.get(1) == 3);      
    }
    
    @Test
    public void poista8() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(2);
        assertTrue(lista.get(2) == null);      
    }
    
    @Test
    public void tyhjenna1() {
        lista.add(1);
        lista.add(2);
        lista.clear();
        assertTrue(lista.size() == 0);      
    } 
    
    @Test
    public void tyhjenna2() {
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.clear();
        assertTrue(lista.getCapacity() == 10);      
    }
    
    @Test
    public void haeOlematon() {
        lista.add(1);
        assertTrue(lista.get(1) == null);      
    }
    
    @Test
    public void sisaltaa() {
        lista.add(1);
        assertTrue(lista.contains(1));      
    }
    
    @Test
    public void eiSisalla() {
        lista.add(1);
        assertFalse(lista.contains(2));      
    }
    
    @Test
    public void jarjesta1() {
        lista.add(4);
        lista.add(0);
        lista.add(9);
        lista.add(1);
        lista.sort(0, 3);
        assertTrue((int) lista.get(0) == 0);
    }
    
    @Test
    public void jarjesta2() {
        lista.add(4);
        lista.add(0);
        lista.add(9);
        lista.add(1);
        lista.sort(0, 3);
        assertTrue((int) lista.get(3) == 9);
    }
    
    @Test
    public void jarjesta3() {
        lista.add(4);
        lista.add(0);
        lista.add(9);
        lista.add(1);
        lista.sort(0, 3);
        assertTrue((int) lista.get(1) == 1);
    }
}
