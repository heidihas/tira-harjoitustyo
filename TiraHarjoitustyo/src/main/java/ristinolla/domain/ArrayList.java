/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

import java.util.Iterator;

/**
 *
 * @author Heidi
 */
/**
 * Luokka vastaa tietorakenteen ArrayList toteutuksesta.
 * @param <A> kuvaa listarakenteeseen kulloinkin tallennettavaa tietotyyppiä
 * 
 */
public class ArrayList<A> implements Iterable<A> {
    private Object lista[];
    private final int oletusKoko = 10;
    private int koko = 0;
    private int kapasiteetti = 0;
    
    public ArrayList() {
        this.lista = new Object[this.oletusKoko];
        this.kapasiteetti = this.oletusKoko;
    }
    
    /**
     * Metodi lisää parametrina annetun objektin listalle.
     *
     * @param objekti listaan tallennettavaa tietotyyppiä noudattava uusi tieto
     * 
     */
    public void add(A objekti) {
        if (this.koko == this.kapasiteetti) {
            kasvata();
        }
        this.lista[this.koko] = objekti;
        this.koko++;
    }
    
    /**
     * Metodi korvaa listalla olevan tiedon annetulla tiedolla.
     *
     * @param i korvattavan tiedon indeksi listalla
     * @param objekti listaan tallennettavaa tietotyyppiä noudattava uusi tieto
     * 
     */
    public void replace(int i, A objekti) {
        this.lista[i] = objekti;
    }
    
    /**
     * Metodi poistaa annetussa indeksissä olevan tiedon.
     *
     * @param i poistettavan tiedon indeksi listalla
     * 
     */
    public void remove(int i) {
        this.lista[i] = null;
        for (int indeksi = i + 1; indeksi < this.koko; indeksi++) {
            this.lista[indeksi - 1] = this.lista[indeksi];
        }
        this.koko--;
    }
    
    /**
     * Metodi tyhjentää listan.
     *
     */
    public void clear() {
        this.lista = new Object[this.oletusKoko];
        this.kapasiteetti = this.oletusKoko;
        this.koko = 0;
    }
    
    /**
     * Metodi palauttaa annetussa indeksissä olevan tiedon.
     * 
     * @param i kokonaisluku, joka kuvaa toivottua tietoa listalla
     *
     * @return palauttaa toivotun tiedon listalta
     */
    public A get(int i) {
        return (A) this.lista[i];
    }
    
    /**
     * Metodi tarkistaa, löytyykö parametrina annettu tieto listalta.
     * 
     * @param objekti listaan tallennettavaa tietotyyppiä noudattava tieto, jota etsitään listalta 
     *
     * @return true, mikäli annettu tieto on listalla
     */
    public boolean contains(A objekti) {
        for (int i = 0; i < this.koko; i++) {
            A obj = (A) this.lista[i];        
            if (obj.equals(objekti)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi palauttaa listan koon.
     *
     * @return palauttaa kokonaisluvun, joka kuvaa listan kokoa
     */
    public int size() {
        return this.koko;
    }
    
    /**
     * Metodi tarkistaa, onko lista tyhjä.
     *
     * @return true, mikäli listan koko on 0 eli lista on tyhjä
     */
    public boolean isEmpty() {
        return (this.koko == 0);
    }
    
    /**
     * Metodi palauttaa listan kapasiteetin.
     *
     * @return palauttaa kokonaisluvun, joka kuvaa listan kapasiteettia eli suurinta mahdollista kokoa
     */
    public int getCapacity() {
        return this.kapasiteetti;
    }
    
    /**
     * Metodi kasvattaa listaa seuraavaksi lisättäviä tietoja varten.
     * 
     */
    public void kasvata() {
        Object uusiLista[] = new Object[this.kapasiteetti * 2];
        
        for (int i = 0; i < this.koko; i++) {
            uusiLista[i] = this.lista[i];
        }
        
        this.lista = uusiLista;
        this.kapasiteetti = this.kapasiteetti * 2;
    }
    
    @Override
    public Iterator<A> iterator() {
        Iterator it = new Iterator<A>() {
            private int indeksi = 0;
            
            @Override
            public boolean hasNext() {
                return indeksi < koko;
            }
            
            @Override
            public A next() {
                return (A) lista[indeksi++];
            }
        };
        return it;
    }
}
