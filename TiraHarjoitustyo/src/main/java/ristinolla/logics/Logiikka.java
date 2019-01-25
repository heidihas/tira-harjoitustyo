/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logics;

import java.util.ArrayList;
import java.util.List;
import ristinolla.domain.Sijainti;

/**
 *
 * @author Heidi
 */
/**
 * Luokka vastaa pelilogiikasta, pelin etenemisen seurannasta sekä tekoälyn siirroista.
 */
public class Logiikka {
    
    private List<Sijainti> käytössäOlevatSijainnit;
    private int[][] ruudukko;
    private Sijainti tekoälynSiirto;
    
    public Logiikka() {
        this.käytössäOlevatSijainnit = new ArrayList();
        this.ruudukko = new int[3][3];
    }
    
    /**
     * Metodi tarkistaa, onko jokin pelin päättävistä tapahtumista toteutunut.
     *
     * @return true, mikäli jompikumpi pelaajista on saanut kolmen suoran tai peliruudukko on täysi
     */
    public boolean peliOhi() {
        return this.xVoitti() || this.oVoitti() || this.etsiVapaatSijainnit().isEmpty();
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     *
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut kolme vierekkäistä merkkiä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean xVoitti() {
        if ((ruudukko[0][0] == ruudukko[1][1] && ruudukko[0][0] == ruudukko[2][2] && ruudukko[0][0] == 1) 
                || (ruudukko[0][2] == ruudukko[1][1] && ruudukko[0][2] == ruudukko[2][0] && ruudukko[0][2] == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((ruudukko[i][0] == ruudukko[i][1] && ruudukko[i][0] == ruudukko[i][2] && ruudukko[i][0] == 1)
                    || (ruudukko[0][i] == ruudukko[1][i] && ruudukko[0][i] == ruudukko[2][i] && ruudukko[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä O pelannut pelaaja voittanut pelikierroksen.
     *
     * @return true, mikäli O-merkin pelaaja (nro 2) on saanut kolme vierekkäistä merkkiä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean oVoitti() {
        if ((ruudukko[0][0] == ruudukko[1][1] && ruudukko[0][0] == ruudukko[2][2] && ruudukko[0][0] == 2) 
                || (ruudukko[0][2] == ruudukko[1][1] && ruudukko[0][2] == ruudukko[2][0] && ruudukko[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((ruudukko[i][0] == ruudukko[i][1] && ruudukko[i][0] == ruudukko[i][2] && ruudukko[i][0] == 2)
                    || (ruudukko[0][i] == ruudukko[1][i] && ruudukko[0][i] == ruudukko[2][i] && ruudukko[0][i] == 2))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi etsii peliruudukosta vapaana olevat ruudut.
     *
     * @see ristinolla.domain.Sijainti
     * 
     * @return palauttaa listan peliruutuja, joiden arvo on 0 eli tyhjä
     */
    public List<Sijainti> etsiVapaatSijainnit() {
        käytössäOlevatSijainnit.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ruudukko[i][j] == 0) {
                    käytössäOlevatSijainnit.add(new Sijainti(i, j));
                }
            }
        }
        return käytössäOlevatSijainnit;
    }
    
    /**
     * Metodi tulostaa peliruudukon konsoliin. 
     *
     */
    public void näytäPeliruudukko() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ruudukko[i][j] + " ");
            }
        }
        System.out.println();
    }
    
    /**
     * Metodi tyhjentää peliruudukon uutta peliä varten.
     *
     */
    public void tyhjennäPeliruudukko() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ruudukko[i][j] = 0;
            }
        }
    }
    
    /**
     * Metodi tallentaa ruudukosta vastaavaan taulukkoon tehdyn siirron.
     *
     * @param sijainti joko käyttäjän toiminnan tai sovelluslogiikan määrittelemä Sijainti-olio, joka kertoo tehdyn siirron koordinaatit
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     *
     * @see ristinolla.domain.Sijainti
     * 
     */
    public void asetaSiirto(Sijainti sijainti, int pelaaja) {
        ruudukko[sijainti.getX()][sijainti.getY()] = pelaaja;
    }
    
    /**
     * Metodi toteuttaa tekoälyn siirron valitsemisesta vastaavan minmax-algoritmin.
     * 
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param vuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * 
     * @see ristinolla.domain.Sijainti
     * 
     * @return palauttaa pistetilannetta kuvaavan min- tai max-arvon
     */
    public int minMax(int syvyys, int vuoro) {
        if (xVoitti()) {
            return 1;
        } else if (oVoitti()) {
            return -1;
        }
        
        List<Sijainti> sijainnit = etsiVapaatSijainnit();
        if (sijainnit.isEmpty()) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < sijainnit.size(); i++) {
            Sijainti sijainti = sijainnit.get(i);
            if (vuoro == 1) {
                asetaSiirto(sijainti, 1);
                int pistetilanne = minMax(syvyys + 1, 2);
                max = Math.max(pistetilanne, max);
                
                if (syvyys == 0) {
                    System.out.println("Sijainnin " + (i + 1) + " pistetilanne on " + pistetilanne);
                }
                if (pistetilanne >= 0) {
                    if (syvyys == 0) {
                        tekoälynSiirto = sijainti;
                    }
                } else if (pistetilanne == 1) {
                    ruudukko[sijainti.getX()][sijainti.getY()] = 0;
                    break;
                }
                if ((i == sijainnit.size() - 1) && max < 0) {
                    if (syvyys == 0) {
                        tekoälynSiirto = sijainti;
                    }
                }
            } else if (vuoro == 2) {
                asetaSiirto(sijainti, 2);
                int pistetilanne = minMax(syvyys + 1, 1);
                min = Math.min(pistetilanne, min);
                if (min == -1) {
                    ruudukko[sijainti.getX()][sijainti.getY()] = 0;
                    break;
                }
            }
            ruudukko[sijainti.getX()][sijainti.getY()] = 0;
        }
        if (vuoro == 1) {
            return max;
        }
        return min;
    }
    
    /**
     * Metodi laskee sovelluksen tekoälytoteutuksella valitun pelaajan seuraavan siirron.
     * 
     * @param pelivuoro kokonaisluku, joka kertoo siirtovuorosso olevan pelaajan
     * 
     * @return palauttaa luvun -1, mikäli peli on päättynyt, tai tekoälyn suorittaman siirron koordinaatit
     */
    public int pelaa(int pelivuoro) {
        if (peliOhi()) {
            return -1;
        }
        minMax(0, pelivuoro);
        return tekoälynSiirto.getX() * 3 + tekoälynSiirto.getY();
    }
}
