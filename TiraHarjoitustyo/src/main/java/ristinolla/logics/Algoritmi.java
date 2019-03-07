/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logics;

import ristinolla.domain.ArrayList;

/**
 *
 * @author Heidi
 */
/**
 * Luokka käsittää minmax-algoritmin alfa-beta-karsinnalla ja sen toiminnalle oleelliset metodit.
 */
public class Algoritmi {
    
    public Algoritmi() {
    }
    
    // pelimerkkien alustaminen
    public enum Pelimerkki {
        X (1),
        O (2);
        private final int value;
        private Pelimerkki(final int value) {
            this.value = value;
        }
    }
    
    /**
     * Metodi toteuttaa tekoälyn siirron valitsemisesta vastaavan minmax-algoritmin alfa-beeta-karsinnalla.
     * 
     * @param ruudukko taulukko, joka koostuu ruudukon ruuduista
     * @param rivit taulukko, joka kuvaa ruudukon rivejä
     * @param maarat taulukko, joka koostuu ruudukon riveillä olevien merkkien määristä
     * @param koko kokonaisluku, joka kuvaa ruudukon kokoa
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param maxSyvyys kokonaisluku, joka kuvaa syvyyshaun rajaa
     * @param vuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @see ristinolla.domain.ArrayList
     * 
     * @return palauttaa parhaasta pistetilanteesta ja sitä vastaavasta siirrosta koostuvan taulukon
     */
    public int[] minmaxAlfaBeeta(int[] ruudukko, int[] rivit, int[] maarat, int koko, int syvyys, int maxSyvyys, int vuoro, int a, int b) {
        ArrayList<Integer> siirrot = getVapaat(ruudukko, koko);
        int parasSiirto = -1;
        
        if (peliOhi(rivit, maarat, koko, siirrot) || syvyys == maxSyvyys) {
            return new int[] {score(rivit, koko, syvyys), parasSiirto};
        }
        
        if (vuoro == Pelimerkki.X.value) {
            return max(siirrot, parasSiirto, ruudukko, rivit, maarat, koko, syvyys, maxSyvyys, a, b);
        } else {
            return min(siirrot, parasSiirto, ruudukko, rivit, maarat, koko, syvyys, maxSyvyys, a, b);
        }
    }
    
    /**
     * Metodi toteuttaa alfa-beeta-karsinnan max-haaran.
     * 
     * @param siirrot lista mahdollisista siirroista
     * @param paras kokonaisluku, joka kuvaa tähän mennessä parasta löydettyä siirtoa
     * @param ruudukko taulukko, joka koostuu ruudukon ruuduista
     * @param rivit taulukko, joka kuvaa ruudukon rivejä
     * @param maarat taulukko, joka koostuu ruudukon riveillä olevien merkkien määristä
     * @param koko kokonaisluku, joka kuvaa ruudukon kokoa
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param maxSyvyys kokonaisluku, joka kuvaa syvyyshaun rajaa
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @return palauttaa parhaasta pistetilanteesta ja sitä vastaavasta siirrosta koostuvan taulukon
     */
    private int[] max(ArrayList<Integer> siirrot, int paras, int[] ruudukko, int[] rivit, int[] maarat, int koko, int syvyys, int maxSyvyys, int a, int b) {    
        for (int siirto : siirrot) {
            ruudukko[siirto] = Pelimerkki.X.value;
            asetaSiirtoMinMax(rivit, maarat, koko, siirto, Pelimerkki.X.value);
                    
            int score = minmaxAlfaBeeta(ruudukko, rivit, maarat, koko, syvyys + 1, maxSyvyys, Pelimerkki.O.value, a, b)[0];
                    
            ruudukko[siirto] = 0;
            poistaSiirtoMinMax(rivit, maarat, koko, siirto, Pelimerkki.X.value);
                    
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
     * @param ruudukko taulukko, joka koostuu ruudukon ruuduista
     * @param rivit taulukko, joka kuvaa ruudukon rivejä
     * @param maarat taulukko, joka koostuu ruudukon riveillä olevien merkkien määristä
     * @param koko kokonaisluku, joka kuvaa ruudukon kokoa
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param maxSyvyys kokonaisluku, joka kuvaa syvyyshaun rajaa
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @return palauttaa parhaasta pistetilanteesta ja sitä vastaavasta siirrosta koostuvan taulukon
     */
    private int[] min(ArrayList<Integer> siirrot, int paras, int[] ruudukko, int[] rivit, int[] maarat, int koko, int syvyys, int maxSyvyys, int a, int b) {   
        for (int siirto : siirrot) {
            ruudukko[siirto] = Pelimerkki.O.value;
            asetaSiirtoMinMax(rivit, maarat, koko, siirto, Pelimerkki.O.value);
                 
            int score = minmaxAlfaBeeta(ruudukko, rivit, maarat, koko, syvyys + 1, maxSyvyys, Pelimerkki.X.value, a, b)[0];
                    
            ruudukko[siirto] = 0;
            poistaSiirtoMinMax(rivit, maarat, koko, siirto, Pelimerkki.O.value);
                 
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
     * @param rivit taulukko, joka kuvaa ruudukon rivejä
     * @param koko kokonaisluku, joka kuvaa ruudukon kokoa
     * @param syvyys kokonaisluku, joka kuvaa suoritettujen uudelleenkutsujen määrän
     * 
     * @return palauttaa pistetilannetta kuvaavan kokonaislukuarvon
     */
    private int score(int[] rivit, int koko, int syvyys) {
        int tilanne = arvioi(rivit, koko);
        
        if (tilanne == (koko * koko + 1)) {
            return (koko * koko + 1) - syvyys;
        } else if (tilanne == -(koko * koko + 1)) {
            return -(koko * koko + 1) + syvyys;
        }
        return 0;
    }
    
    /**
     * Metodi arvioi, onko jompikumpi pelaajista voittanut pelin.
     * 
     * @param riv taulukko, joka kuvaa ruudukon rivejä
     * @param koko kokonaisluku, joka kuvaa ruudukon kokoa
     * 
     * @return palauttaa pistetilannetta kuvaavan kokonaislukuarvon
     */
    private int arvioi(int[] riv, int koko) {
        for (int i = 0; i < (koko * 2 + 2); i++) {
            if (riv[i] == koko) {
                return (koko * koko + 1);
            } else if (riv[i] == -koko) {
                return -(koko * koko + 1);
            }
        }
        return 0;
    }
    
    /**
     * Metodi tallentaa riveistä vastaavaan taulukkoon minmax-toteutuksessa tehdyn siirron.
     *
     * @param riv taulukko, joka kuvaa ruudukon rivejä
     * @param maarat taulukko, joka koostuu ruudukon riveillä olevien merkkien määristä
     * @param koko kokonaisluku, joka kertoo ruudukon koon
     * @param siirto kokonaisluku, joka kuvaa tehtävää siirtoa
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void asetaSiirtoMinMax(int[] riv, int[] maarat, int koko, int siirto, int pelaaja) {
        int x = siirto % koko;
        int y = (int) Math.floor(siirto / koko);
        int lisattava = -1;
        if (pelaaja == Pelimerkki.X.value) {
            lisattava = 1;
        }
        
        riv[y] = riv[y] + lisattava;
        riv[x + koko] = riv[x + koko] + lisattava;
        maarat[y]++;
        maarat[x + koko]++;
        
        if (x == y) {
            riv[koko * 2] = riv[koko * 2] + lisattava;
            maarat[koko * 2]++;
        } 
        if ((x + y) == (koko - 1)) {
            riv[koko * 2 + 1] = riv[koko * 2 + 1] + lisattava;
            maarat[koko * 2 + 1]++;
        }
    }
    
    /**
     * Metodi poistaa riveistä vastaavaan taulukkoon minmax-toteutuksessa tehdyn siirron.
     *
     * @param riv taulukko, joka kuvaa ruudukon rivejä
     * @param maarat taulukko, joka koostuu ruudukon riveillä olevien merkkien määristä
     * @param koko kokonaisluku, joka kertoo ruudukon koon
     * @param siirto kokonaisluku, joka kuvaa tehtävää siirtoa
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    private void poistaSiirtoMinMax(int[] riv, int[] maarat, int koko, int siirto, int pelaaja) {
        int x = siirto % koko;
        int y = (int) Math.floor(siirto / koko);
        int lisattava = 1;
        if (pelaaja == Pelimerkki.X.value) {
            lisattava = -1;
        }
        
        riv[y] = riv[y] + lisattava;
        riv[x + koko] = riv[x + koko] + lisattava;
        maarat[y]--;
        maarat[x + koko]--;
        
        if (x == y) {
            riv[koko * 2] = riv[koko * 2] + lisattava;
            maarat[koko * 2]--;
        } 
        if ((x + y) == (koko - 1)) {
            riv[koko * 2 + 1] = riv[koko * 2 + 1] + lisattava;
            maarat[koko * 2 + 1]--;
        }
    }
    
    /**
     * Metodi selvittää vapaina olevat ruudut.
     * 
     * @param ruudukko taulukko, joka kuvaa ruudukkoa
     * @param koko kokonaisluku, joka kuvaa ruudukon kokoa
     * 
     * @see ristinolla.domain.ArrayList
     * 
     * @return palauttaa vapaina olevista ruuduista koostuvan listan
     */
    private ArrayList<Integer> getVapaat(int[]ruudukko, int koko) {
        ArrayList<Integer> vapaat = new ArrayList<>();
        for (int i = 0; i < koko * koko; i++) {
            if (ruudukko[i] == 0) {
                vapaat.add(i);
            }
        }
        return vapaat;
    }
    
    /**
     * Metodi tarkistaa, onko jokin pelin päättävistä tapahtumista toteutunut.
     *
     * @param rivit ruudukon riveistä koostuva taulukko
     * @param riviMaarat ruudukon riveillä olevista merkkimääristä koostuva taulukko
     * @param koko kokonaisluku, joka kertoo ruudukon koon
     * @param siirrot jäljellä olevista siirroista koostuva lista
     * 
     * @see ristinolla.domain.ArrayList
     * 
     * @return true, mikäli jompikumpi pelaajista on saanut peliruudukon rivin pituisen suoran, ruudukko on täysi tai ruudukossa ei ole enää mahdollisuutta voittaa
     */
    private boolean peliOhi(int[] rivit, int[] riviMaarat, int koko, ArrayList<Integer> siirrot) {
        int voittoMahdollisuus = 0;
        for (int i = 0; i < koko * 2 + 2; i++) {
            if ((riviMaarat[i] == rivit[i]) || (riviMaarat[i] == -rivit[i])) {
                voittoMahdollisuus++;
            }
        }
        return this.xVoitti(rivit, koko) || this.oVoitti(rivit, koko) || siirrot.isEmpty() || voittoMahdollisuus == 0;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     * 
     * @param rivit ruudukon riveistä koostuva taulukko
     * @param koko kokonaisluku, joka ilmaisee ruuduko koon
     * 
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut ruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    private boolean xVoitti(int[] rivit, int koko) {
        for (int i = 0; i < (koko * 2 + 2); i++) {
            if (rivit[i] == koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä O pelannut pelaaja voittanut pelikierroksen.
     * 
     * @param rivit ruudukon riveistä koostuva taulukko
     * @param koko kokonaisluku, joka ilmaisee ruudukon koon
     * 
     * @return true, mikäli O-merkin pelaaja (nro 2) on saanut ruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    private boolean oVoitti(int[] rivit, int koko) {
        for (int i = 0; i < (koko * 2 + 2); i++) {
            if (rivit[i] == -koko) {
                return true;
            }
        }
        return false;
    }
}
