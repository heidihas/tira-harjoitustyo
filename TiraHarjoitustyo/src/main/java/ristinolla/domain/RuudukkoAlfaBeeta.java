/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

import java.util.HashSet;

/**
 *
 * @author Heidi
 */
/**
 * Luokka kuvaa tietorakennetta ruudukko.
 */
public class RuudukkoAlfaBeeta {
    
    private int koko;
    private int[] rivit;
    private int[] ruudukko;
    private int vapaana;
    private int voittaja;
    private HashSet<Integer> vapaat;
    private boolean peliOhi;
    private int uusinSiirto;
    
    public RuudukkoAlfaBeeta(int koko) {
        this.koko = koko;
        this.rivit = new int[2*koko + 2];
        this.ruudukko = new int[koko*koko];
        this.vapaana = koko*koko;
        this.vapaat = new HashSet<>();
        this.voittaja = 0;
        this.peliOhi = false;
        this.uusinSiirto = 0;
    }
    
    /**
     * Metodi palauttaa ruudukon.
     *
     * @return palauttaa int[]-muotoisen taulukon eli ruudukon
     */
    public int[] getRuudukko() {
        return ruudukko;
    }
    
    /**
     * Metodi palauttaa ruudukossa vapaina olevien ruutujen määrän.
     *
     * @return palauttaa vapaina olevista ruuduista kertovan kokonaisluvun
     */
    public int getVapaita() {
        return vapaana;
    }
    
    public int uusinSiirto() {
        return uusinSiirto;
    }
    
    /**
     * Metodi kertoo, onko ruudukossa vapaita ruutuja.
     * 
     * @return true, mikäli ruudukossa on vielä vapaita ruutuja
     */
    public boolean onVapaita() {
        return (vapaana != 0);
    }
    
    public boolean peliOhi() {
        return peliOhi;
    }
    
    public int voittaja() {
        return voittaja;
    }
    
    public HashSet<Integer> vapaat() {
        return vapaat;
    }
    
    /**
     * Metodi tallentaa ruudukkoon annetun arvon.
     *
     * @param x ruudukon x-koordinaatti
     * @param y ruudukon y-koordinaatti
     * @param luku tallennettava kokonaisluku
     * 
     */
    public void aseta(int x, int y, int luku) {
        ruudukko[x + (koko * y)] = luku;
        int lisattava;
        if (luku == 1) {
            lisattava = 1;
        } else {
            lisattava = -1;
        }
        
        rivit[y] = rivit[y] + lisattava;
        rivit[x + koko] = rivit[x + koko] + lisattava;
        
        if (x == y) {
            rivit[koko*2] = rivit[koko*2] + lisattava;
        } 
        if ((x + y) == (koko - 1)) {
            rivit[koko*2+1] = rivit[koko*2+1] + lisattava;
        }
        vapaana--; 
        vapaat.remove(x + koko * y);
        if (vapaana == 0) {
            peliOhi = true;
        }
        if (xVoitti()) {
            voittaja = 1;
            peliOhi = true;
        } else if (oVoitti()) {
            voittaja = 2;
            peliOhi = true;
        }
    }
    
    public void aseta(int i, int luku) {
        ruudukko[i] = luku;
        uusinSiirto = i;
        int lisattava;
        if (luku == 1) {
            lisattava = 1;
        } else {
            lisattava = -1;
        }
        int x = i % koko;
        int y = (int) Math.floor(i/koko);
        rivit[y] = rivit[y] + lisattava;
        rivit[x + koko] = rivit[x + koko] + lisattava;
        
        if (x == y) {
            rivit[koko*2] = rivit[koko*2] + lisattava;
        } 
        if ((x + y) == (koko - 1)) {
            rivit[koko*2+1] = rivit[koko*2+1] + lisattava;
        }
        vapaana--;
        vapaat.remove(i);
        if (vapaana == 0) {
            peliOhi = true;
        }
        if (xVoitti()) {
            voittaja = 1;
            peliOhi = true;
        } else if (oVoitti()) {
            voittaja = 2;
            peliOhi = true;
        }
    }
    
    public boolean xVoitti() {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (rivit[i] == koko) {
                return true;
            }
        }
        return false;
    }
    
    public boolean oVoitti() {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (rivit[i] == -koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi tyhjentää ruudukon.
     *
     */
    public void tyhjenna() {
        for (int i = 0; i < koko*koko; i++) {
            ruudukko[i] = 0;
        }
        vapaana = koko*koko;
    }
    
    public RuudukkoAlfaBeeta kopio() {
        RuudukkoAlfaBeeta ruudukko = new RuudukkoAlfaBeeta(koko);
        
        for (int i = 0; i < ruudukko.ruudukko.length; i++) {
            ruudukko.ruudukko[i] = this.ruudukko[i];
        }
        for (int i = 0; i < ruudukko.rivit.length; i++) {
            ruudukko.rivit[i] = this.rivit[i];
        }
        
        ruudukko.koko = this.koko;
        ruudukko.voittaja = this.voittaja;
        ruudukko.vapaana = this.vapaana;
        ruudukko.vapaat = new HashSet<>();
        ruudukko.vapaat.addAll(this.vapaat);
        ruudukko.peliOhi = this.peliOhi;
        ruudukko.uusinSiirto = this.uusinSiirto;
        
        return ruudukko;
    }
    
    /**
     * Metodi tulostaa ruudukon konsoliin. 
     *
     */
    public void tulosta() {
        System.out.println();
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (j == koko - 1) {
                    System.out.print(ruudukko[3*i+j] + "\n");
                } else {
                    System.out.print(ruudukko[3*i+j] + " ");
                }  
            }
        }
        System.out.println();
    }
}
