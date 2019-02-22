/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logics;

import ristinolla.domain.ArrayList;
import ristinolla.domain.Ruudukko;

/**
 *
 * @author Heidi
 */
/**
 * Luokka vastaa pelilogiikasta, pelin etenemisen seurannasta sekä tekoälyn siirroista.
 */
public class Logiikka {
    
    private int koko;
    private int[] rivit;
    private Ruudukko ruudukko;
    
    public Logiikka(int koko) {
        this.koko = koko;
        this.rivit = new int[2*koko + 2];
        this.ruudukko = new Ruudukko(koko);
    }
    
    /**
     * Metodi palauttaa peliruudukosta vastaavan Ruudukko-objektin.
     *
     * @return palauttaa Ruudukko-objektin eli peliruudukon
     */
    public Ruudukko getRuudukko() {
        return ruudukko;
    }
    
    /**
     * Metodi palauttaa peliruudukon riveistä vastaavan taulukon.
     *
     * @return palauttaa int[]-muotoisen taulukon eli peliruudukon rivit
     */
    public int[] getRivit() {
        return rivit;
    }
    
    /**
     * Metodi tallentaa tehdyn siirron.
     *
     * @param x joko käyttäjän toiminnan tai sovelluslogiikan määrittelemä sijainnin x-koordinaatti
     * @param y joko käyttäjän toiminnan tai sovelluslogiikan määrittelemä sijainnin y-koordinaatti
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void asetaSiirto(int x, int y, int pelaaja) {
        this.ruudukko.aseta(x, y, pelaaja);
        
        int lisattava;
        if (pelaaja == 1) {
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
    }
    
    /**
     * Metodi tyhjentää peliruudukon uutta peliä varten.
     *
     */
    public void tyhjennaPeliruudukko() {
        this.ruudukko.tyhjenna();
        for (int i = 0; i < (koko*2 + 2); i++) {
            rivit[i] = 0;
        }
    }
    
    /**
     * Metodi tarkistaa, onko jokin pelin päättävistä tapahtumista toteutunut.
     *
     * @return true, mikäli jompikumpi pelaajista on saanut peliruudukon rivin pituisen suoran tai peliruudukko on täysi
     */
    public boolean peliOhi() {
        return this.xVoitti() || this.oVoitti() || !this.ruudukko.onVapaita();
    }
    
    /**
     * Metodi tarkistaa, onko jokin pelin päättävistä tapahtumista toteutunut.
     *
     * @param rivit peliruudukon riveistä koostuva taulukko
     * @param siirrot jäljellä olevista siirroista koostuva lista
     * 
     * @return true, mikäli jompikumpi pelaajista on saanut peliruudukon rivin pituisen suoran tai peliruudukko on täysi
     */
    public boolean peliOhi(int[] rivit, ArrayList<Integer> siirrot) {
        return this.xVoitti(rivit) || this.oVoitti(rivit) || siirrot.isEmpty();
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     * 
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut peliruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean xVoitti() {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (rivit[i] == koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     * 
     * @param rivit peliruudukon riveistä koostuva taulukko
     * 
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut peliruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean xVoitti(int[] rivit) {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (rivit[i] == koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä O pelannut pelaaja voittanut pelikierroksen.
     * 
     * @return true, mikäli O-merkin pelaaja (nro 2) on saanut peliruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean oVoitti() {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (rivit[i] == -koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä O pelannut pelaaja voittanut pelikierroksen.
     * 
     * @param rivit peliruudukon riveistä koostuva taulukko
     * 
     * @return true, mikäli O-merkin pelaaja (nro 2) on saanut peliruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean oVoitti(int[] rivit) {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (rivit[i] == -koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi laskee sovelluksen tekoälytoteutuksella annetun pelivuoron seuraavan siirron.
     * 
     * @param pelivuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * 
     * @return palauttaa luvun -1, mikäli peli on päättynyt, tai tekoälyn suorittaman siirron
     */
    public int pelaa(int pelivuoro) {
        if (peliOhi()) {
            return -1;
        }
        int[] lahtoTilanne = ruudukko.getRuudukko();
        int[] lahtoRivit = rivit;
        
        int maxSyvyys = 6;
        
        return minmaxAlfaBeeta(lahtoTilanne, lahtoRivit, 0, maxSyvyys, pelivuoro, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
    }
    
    /**
     * Metodi toteuttaa tekoälyn siirron valitsemisesta vastaavan minmax-algoritmin.
     * 
     * @param r taulukko, joka koostuu peliruudukon ruuduista
     * @param rivit taulukko, joka koostuu peliruudukon riveistä
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param vuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * 
     * @return palauttaa kunkin polun pistetilannetta kuvaavan kokonaislukuarvon
     */
    /*public int minmax(int[] r, int[] rivit, int syvyys, int vuoro) {
        int tilanne = arvioi(rivit);
        
        if (tilanne == 10) {
            return 10 - syvyys;
        } else if (tilanne == -10) {
            return tilanne + syvyys;
        }
        if (getVapaat(r).isEmpty()) {
            return 0;
        }
        int[] ruudukko = r;
        if (vuoro == 1) {
            int paras = Integer.MIN_VALUE;
            
            for (int i = 0; i < koko*koko; i++) {
                if (ruudukko[i] == 0) {
                    ruudukko[i] = 1;
                    asetaSiirtoMinMax(rivit, i, 1);
                    paras = Math.max(paras, minmax(ruudukko, rivit, syvyys + 1, 2));
                    ruudukko[i] = 0;
                    poistaSiirtoMinMax(rivit, i, 1);
                }
            }
            return paras;
        } else {
            int paras = Integer.MAX_VALUE;
            
            for (int i = 0; i < koko*koko; i++) {
                if (ruudukko[i] == 0) {
                    ruudukko[i] = 2;
                    asetaSiirtoMinMax(rivit, i, 2);
                    paras = Math.min(paras, minmax(ruudukko, rivit, syvyys + 1, 1));
                    ruudukko[i] = 0;
                    poistaSiirtoMinMax(rivit, i, 2);
                }
            }
            return paras;
        }
    }*/
    
    /**
     * Metodi toteuttaa tekoälyn siirron valitsemisesta vastaavan minmax-algoritmin alfa-beeta-karsinnalla.
     * 
     * @param ruudukko taulukko, joka koostuu peliruudukon ruuduista
     * @param rivit taulukko, joka kuvaa peliruudukon rivejä
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param maxSyvyys kokonaisluku, joka kuvaa syvyyshaun rajaa
     * @param vuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @return palauttaa parhaasta pistetilanteesta ja sitä vastaavasta siirrosta koostuvan taulukon
     */
    public int[] minmaxAlfaBeeta(int[] ruudukko, int[] rivit, int syvyys, int maxSyvyys, int vuoro, int a, int b) {
        ArrayList<Integer> siirrot = getVapaat(ruudukko);
        int parasSiirto = -1;
        
        if (peliOhi(rivit, siirrot) || syvyys == maxSyvyys) {
            return new int[] {score(rivit, syvyys), parasSiirto};
        }
        
        if (vuoro == 1) {
            return max(siirrot, parasSiirto, ruudukko, rivit, syvyys, maxSyvyys, a, b);
        } else {
            return min(siirrot, parasSiirto, ruudukko, rivit, syvyys, maxSyvyys, a, b);
        }
    }
    
    /**
     * Metodi toteuttaa alfa-beeta-karsinnan max-haaran.
     * 
     * @param siirrot lista mahdollisista siirroista
     * @param paras kokonaisluku, joka kuvaa tähän mennessä parasta löydettyä siirtoa
     * @param ruudukko taulukko, joka koostuu peliruudukon ruuduista
     * @param rivit taulukko, joka kuvaa peliruudukon rivejä
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param maxSyvyys kokonaisluku, joka kuvaa syvyyshaun rajaa
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @return palauttaa parhaasta pistetilanteesta ja sitä vastaavasta siirrosta koostuvan taulukon
     */
    private int[] max(ArrayList<Integer> siirrot, int paras, int[] ruudukko, int[] rivit, int syvyys, int maxSyvyys, int a, int b) {    
        for (int siirto : siirrot) {
            ruudukko[siirto] = 1;
            asetaSiirtoMinMax(rivit, siirto, 1);
                    
            int score = minmaxAlfaBeeta(ruudukko, rivit, syvyys + 1, maxSyvyys, 2, a, b)[0];
                    
            ruudukko[siirto] = 0;
            poistaSiirtoMinMax(rivit, siirto, 1);
                    
            if (score > a) {
                a = score;
                paras = siirto;
            }
            if (a >= b) {
                break;
            }  
        }
        return new int[] {a, paras};
    }
    
    /**
     * Metodi toteuttaa alfa-beeta-karsinnan min-haaran.
     * 
     * @param siirrot lista mahdollisista siirroista
     * @param paras kokonaisluku, joka kuvaa tähän mennessä parasta löydettyä siirtoa
     * @param ruudukko taulukko, joka koostuu peliruudukon ruuduista
     * @param rivit taulukko, joka kuvaa peliruudukon rivejä
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param maxSyvyys kokonaisluku, joka kuvaa syvyyshaun rajaa
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @return palauttaa parhaasta pistetilanteesta ja sitä vastaavasta siirrosta koostuvan taulukon
     */
    private int[] min(ArrayList<Integer> siirrot, int paras, int[] ruudukko, int[] rivit, int syvyys, int maxSyvyys, int a, int b) {   
        for (int siirto : siirrot) {
            ruudukko[siirto] = 2;
            asetaSiirtoMinMax(rivit, siirto, 2);
                 
            int score = minmaxAlfaBeeta(ruudukko, rivit, syvyys + 1, maxSyvyys, 1, a, b)[0];
                    
            ruudukko[siirto] = 0;
            poistaSiirtoMinMax(rivit, siirto, 2);
                 
            if (score < b) {
                b = score;
                paras = siirto;
            }
            if (a >= b) {
                break;
            }
        }
        return new int [] {b, paras};
    }
    
    /**
     * Metodi laskee pistetilanteen pelin päättyessä.
     * 
     * @param rivit taulukko, joka kuvaa peliruudukon rivejä
     * @param syvyys kokonaisluku, joka kuvaa suoritettujen uudelleenkutsujen määrän
     * 
     * @return palauttaa pistetilannetta kuvaavan kokonaislukuarvon
     */
    public int score(int[] rivit, int syvyys) {
        int tilanne = arvioi(rivit);
        
        if (tilanne == (koko*koko + 1)) {
            return (koko*koko + 1) - syvyys;
        } else if (tilanne == -(koko*koko + 1)) {
            return -(koko*koko + 1) + syvyys;
        }
        return 0;
    }
    
    /**
     * Metodi arvioi, onko jompikumpi pelaajista voittanut pelin.
     * 
     * @param riv taulukko, joka kuvaa peliruudukon rivejä
     * 
     * @return palauttaa pistetilannetta kuvaavan kokonaislukuarvon
     */
    public int arvioi(int[] riv) {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (riv[i] == koko) {
                return (koko*koko + 1);
            } else if (riv[i] == -koko) {
                return -(koko*koko + 1);
            }
        }
        return 0;
    }
    
    /**
     * Metodi tallentaa riveistä vastaavaan taulukkoon minmax-toteutuksessa tehdyn siirron.
     *
     * @param riv taulukko, joka kuvaa peliruudukon rivejä
     * @param siirto kokonaisluku, joka kuvaa tehtävää siirtoa
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void asetaSiirtoMinMax(int[] riv, int siirto, int pelaaja) {
        int x = siirto % koko;
        int y = (int) Math.floor(siirto/koko);
        
        int lisattava;
        if (pelaaja == 1) {
            lisattava = 1;
        } else {
            lisattava = -1;
        }
        
        riv[y] = riv[y] + lisattava;
        riv[x + koko] = riv[x + koko] + lisattava;
        
        if (x == y) {
            riv[koko*2] = riv[koko*2] + lisattava;
        } 
        if ((x + y) == (koko - 1)) {
            riv[koko*2+1] = riv[koko*2+1] + lisattava;
        }
    }
    
    /**
     * Metodi poistaa riveistä vastaavaan taulukkoon minmax-toteutuksessa tehdyn siirron.
     *
     * @param riv taulukko, joka kuvaa peliruudukon rivejä
     * @param siirto kokonaisluku, joka kuvaa tehtävää siirtoa
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void poistaSiirtoMinMax(int[] riv, int siirto, int pelaaja) {
        int x = siirto % koko;
        int y = (int) Math.floor(siirto/koko);
        
        int lisattava;
        if (pelaaja == 1) {
            lisattava = -1;
        } else {
            lisattava = 1;
        }
        
        riv[y] = riv[y] + lisattava;
        riv[x + koko] = riv[x + koko] + lisattava;
        
        if (x == y) {
            riv[koko*2] = riv[koko*2] + lisattava;
        } 
        if ((x + y) == (koko - 1)) {
            riv[koko*2+1] = riv[koko*2+1] + lisattava;
        }
    }
    
    /**
     * Metodi selvittää vapaina olevat ruudut.
     * 
     * @param ruudukko taulukko, joka kuvaa peliruudukkoa
     * 
     * @return palauttaa vapaina olevista ruuduista koostuvan listan
     */
    public ArrayList<Integer> getVapaat(int[]ruudukko) {
        ArrayList<Integer> vapaat = new ArrayList<>();
        for (int i = 0; i < koko*koko; i++) {
            if (ruudukko[i] == 0) {
                vapaat.add(i);
            }
        }
        return vapaat;
    }
}
