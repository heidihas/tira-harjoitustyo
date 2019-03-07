/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

/**
 *
 * @author Heidi
 */
/**
 * Luokka kuvaa tietorakennetta ruudukko.
 */
public class Ruudukko {
    
    private int koko;
    private int[] ruudukko;
    private int vapaana;
    
    public Ruudukko(int koko) {
        this.koko = koko;
        this.ruudukko = new int[koko * koko];
        this.vapaana = koko * koko;
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
    
    /**
     * Metodi kertoo, onko ruudukossa vapaita ruutuja.
     * 
     * @return true, mikäli ruudukossa on vielä vapaita ruutuja
     */
    public boolean onVapaita() {
        return (vapaana != 0);
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
        vapaana--;
    }
    
    /**
     * Metodi tyhjentää ruudukon.
     *
     */
    public void tyhjenna() {
        for (int i = 0; i < koko * koko; i++) {
            ruudukko[i] = 0;
        }
        vapaana = koko * koko;
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
                    System.out.print(ruudukko[koko * i + j] + "\n");
                } else {
                    System.out.print(ruudukko[koko * i + j] + " ");
                }  
            }
        }
        System.out.println();
    }
}
