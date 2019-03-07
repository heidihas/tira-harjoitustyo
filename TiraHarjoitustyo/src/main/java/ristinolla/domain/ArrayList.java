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
     * @param i kokonaisluku, joka kuvaa haettavaa tietoa listalla
     *
     * @return palauttaa toivotun tiedon listalta
     */
    public A get(int i) {
        if ((this.koko == 0) || (i > (this.koko - 1))) {
            return null;
        }
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
     * Metodi järjestää listan kasvavaan järjestykseen merge-sort-menetelmällä olettaen, että lista koostuu kokonaisluvuista. 
     *
     * @param alku kokonaisluku, joka kuvaa listan järjestettävän osan ensimmäistä indeksiä
     * @param loppu kokonaisluku, joka kuvaa listan järjestettävän osan viimeistä indeksiä
     * 
     */
    public void sort(int alku, int loppu) {
        if (alku == loppu) {
            return;
        }
        int keski = (alku + loppu) / 2;
        
        sort(alku, keski);
        sort(keski + 1, loppu);
        merge(alku, keski, loppu);
    }
    
    /**
     * Metodi käsittää merge-sort-menetelmän toteutuksen kokonaisluvuista koostuvalle listalle. 
     *
     * @param alku kokonaisluku, joka kuvaa listan järjestettävän osan ensimmäistä indeksiä
     * @param keski kokonaisluku, joka kuvaa listan järjestettävän osan keskimmäistä indeksiä
     * @param loppu kokonaisluku, joka kuvaa listan järjestettävän osan viimeistä indeksiä
     * 
     */
    private void merge(int alku, int keski, int loppu) {
        int n = loppu - alku + 1;
        int[] apu = new int[n];
        int i = alku;
        int j = 0;
        int k = keski + 1;
       
        while (i <= keski && k <= loppu) {
            if ((int) this.lista[i] < (int) this.lista[k]) {
                apu[j] = (int) this.lista[i];
                i++;
            } else {
                apu[j] = (int) this.lista[k];
                k++;
            }
            j++;
        }
        
        while (i <= keski) {
            apu[j] = (int) this.lista[i];
            i++;
            j++;
        }
        
        while (k <= loppu) {
            apu[j] = (int) this.lista[k];
            k++;
            j++;
        }
        
        for (j = 0; j < n; j++) {
            this.lista[alku + j] = apu[j];
        }
    }
    
    /**
     * Metodi kasvattaa listaa seuraavaksi lisättäviä tietoja varten.
     * 
     */
    private void kasvata() {
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
