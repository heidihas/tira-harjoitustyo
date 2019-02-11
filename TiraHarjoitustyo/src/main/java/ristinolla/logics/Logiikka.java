/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logics;

import ristinolla.domain.Sijainti;

/**
 *
 * @author Heidi
 */
/**
 * Luokka vastaa pelilogiikasta, pelin etenemisen seurannasta sekä tekoälyn siirroista.
 */
public class Logiikka {
    
    private int[][] ruudukko;
    private int koko;
    private int [] rivit;
    private Sijainti tekoalynSiirto;
    
    public Logiikka(int koko) {
        this.koko = koko;
        this.ruudukko = new int[koko][koko];
        this.rivit = new int[2*koko + 2];
    }
    
    /**
     * Metodi palauttaa peliruudukon.
     *
     * @return palauttaa int[][]-muotoisen taulukon eli peliruudukon
     */
    public int[][] getRuudukko() {
        return ruudukko;
    }
    
    /**
     * Metodi tulostaa peliruudukon konsoliin. 
     * 
     * @param ruudukko peliruudukon ruutuja kuvaava taulukko
     *
     */
    public void naytaPeliruudukko(int[][] ruudukko) {
        System.out.println();
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (j == koko - 1) {
                    System.out.print(ruudukko[i][j] + "\n");
                } else {
                    System.out.print(ruudukko[i][j] + " ");
                }  
            }
        }
        System.out.println();
    }
    
    /**
     * Metodi tyhjentää peliruudukon uutta peliä varten.
     *
     */
    public void tyhjennaPeliruudukko() {
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                ruudukko[i][j] = 0;
            }
        }
        for (int i = 0; i < (koko*2 + 2); i++) {
            rivit[i] = 0;
        }
    }
    
    /**
     * Metodi tallentaa ruudukosta ja riveistä vastaaviin taulukoihin tehdyn siirron.
     *
     * @param x joko käyttäjän toiminnan tai sovelluslogiikan määrittelemä sijainnin x-koordinaatti
     * @param y joko käyttäjän toiminnan tai sovelluslogiikan määrittelemä sijainnin y-koordinaatti
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void asetaSiirto(int x, int y, int pelaaja) {
        ruudukko[y][x] = pelaaja;
        
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
     * Metodi kertoo, onko peliruudukossa mahdollisia siirtoja jäljellä.
     * 
     * @param ruudukko taulukko, joka kuvaa peliruudukkoa
     * 
     * @return true, mikäli peliruudukossa on vielä vapaita ruutuja
     */
    public boolean onSiirtojaJaljella(int[][] ruudukko) {
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (ruudukko[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko jokin pelin päättävistä tapahtumista toteutunut.
     *
     * @return true, mikäli jompikumpi pelaajista on saanut peliruudukon rivin pituisen suoran tai peliruudukko on täysi
     */
    public boolean peliOhi() {
        return this.xVoitti() || this.oVoitti() || !this.onSiirtojaJaljella(ruudukko);
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     * 
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut peliruudukon rivin verran vierekkäistä merkkiä joko pystysuoraan, vaakasuoraan tai viistosti
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
     * Metodi tarkistaa, onko merkillä O pelannut pelaaja voittanut pelikierroksen.
     * 
     * @return true, mikäli O-merkin pelaaja (nro 2) on saanut peliruudukon rivin verran vierekkäistä merkkiä joko pystysuoraan, vaakasuoraan tai viistosti
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
     * Metodi arvioi, onko jompikumpi pelaajista voittanut pelin.
     * 
     * @param ruudukko taulukko, joka kuvaa peliruudukkoa
     * 
     * @return palauttaa pistetilannetta kuvaavan kokonaislukuarvon
     */
    public int arvioi(int[][] ruudukko) {
        for (int i = 0; i < koko; i++) {
            int riviX = 0;
            int riviO = 0;
            int sarakeX = 0;
            int sarakeO = 0;
            for (int j = 0; j < koko; j++) {
                if (ruudukko[i][j] == 1) {
                    riviX++;
                }
                if (ruudukko[i][j] == 2) {
                    riviO++;
                }
                if (ruudukko[j][i] == 1) {
                    sarakeX++;
                }
                if (ruudukko[j][i] == 2) {
                    sarakeO++;
                }
            }
            if (riviX == koko || sarakeX == koko) {
                return 10;
            }
            if (riviO == koko || sarakeO == koko) {
                return -10;
            }
        }
        
        int diag1X = 0;
        int diag1O = 0;
        int diag2X = 0;
        int diag2O = 0;
        for (int i = 0; i < koko; i++) {
            if (ruudukko[i][i] == 1) {
                diag1X++;
            }
            if (ruudukko[i][i] == 2) {
                diag1O++;
            }
            if (ruudukko[i][koko - 1 - i] == 1) {
                diag2X++;
            }
            if (ruudukko[i][koko - 1 - i] == 2) {
                diag2O++;
            }
        }
        if (diag1X == koko || diag2X == koko) {
            return 10;
        }
        if (diag1O == koko || diag2O == koko) {
            return -10;
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
    public int arvioiAlfaBeeta(int[] riv) {
        for (int i = 0; i < (koko*2 + 2); i++) {
            if (riv[i] == koko) {
                return 10;
            } else if (riv[i] == -koko) {
                return -10;
            }
        }
        return 0;
    }
    
    /**
     * Metodi toteuttaa tekoälyn siirron valitsemisesta vastaavan minmax-algoritmin.
     * 
     * @param r taulukko, joka koostuu peliruudukon ruuduista
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param vuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * 
     * @return palauttaa kunkin polun pistetilannetta kuvaavan kokonaislukuarvon
     */
    public int minmax(int[][] r, int syvyys, int vuoro) {
        int tilanne = arvioi(r);
        
        if (tilanne == 10) {
            return 10 - syvyys;
        } else if (tilanne == -10) {
            return tilanne + syvyys;
        }
        if (!onSiirtojaJaljella(r)) {
            return 0;
        }
        int[][] ruudukko = r;
        if (vuoro == 1) {
            int paras = Integer.MIN_VALUE;
            
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (ruudukko[i][j] == 0) {
                        ruudukko[i][j] = 1;
                        paras = Math.max(paras, minmax(ruudukko, syvyys + 1, 2));
                        ruudukko[i][j] = 0;
                    }
                }
            }
            return paras;
        } else {
            int paras = Integer.MAX_VALUE;
            
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (ruudukko[i][j] == 0) {
                        ruudukko[i][j] = 2;
                        paras = Math.min(paras, minmax(ruudukko, syvyys + 1, 1));
                        ruudukko[i][j] = 0;
                    }
                }
            }
            return paras;
        }
    }
    
    /**
     * Metodi toteuttaa tekoälyn siirron valitsemisesta vastaavan minmax-algoritmin alfa-beeta-karsinnalla.
     * 
     * @param r taulukko, joka koostuu peliruudukon ruuduista
     * @param rivit taulukko, joka kuvaa peliruudukon rivejä
     * @param syvyys kokonaisluku, joka kertoo kunkin uudelleenkutsun syvyyden
     * @param vuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * @param a kokonaisluku, joka kuvaa alfan arvoa
     * @param b kokonaisluku, joka kuvaa beetan arvoa
     * 
     * @return palauttaa kunkin polun pistetilannetta kuvaavan kokonaislukuarvon
     */
    public int minmaxAlfaBeeta(int[][] r, int[] rivit, int syvyys, int vuoro, int a, int b) {
        int tilanne = arvioiAlfaBeeta(rivit);
        
        if (tilanne == 10) {
            return 10 - syvyys;
        } else if (tilanne == -10) {
            return tilanne + syvyys;
        }
        if (!onSiirtojaJaljella(r)) {
            return 0;
        }
        
        if (vuoro == 1) {
            int paras = Integer.MIN_VALUE;
            
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (r[i][j] == 0) {
                        r[i][j] = 1;
                        asetaSiirtoMinMax(rivit, j, i, 1);
                        int seuraava = minmaxAlfaBeeta(r, rivit, syvyys + 1, 2, a, b);
                        r[i][j] = 0;
                        poistaSiirtoMinMax(rivit, j, i, 1);
                        paras = Math.max(paras, seuraava);
                        if (seuraava >= b) {
                            return paras;
                        }
                        if (seuraava > a) {
                            a = seuraava;
                        }
                    }
                }
            }
            return paras;
        } else {
            int paras = Integer.MAX_VALUE;
            
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (r[i][j] == 0) {
                        r[i][j] = 2;
                        asetaSiirtoMinMax(rivit, j, i, 2);
                        int seuraava = minmaxAlfaBeeta(r, rivit, syvyys + 1, 1, a, b);
                        r[i][j] = 0;
                        poistaSiirtoMinMax(rivit, j, i, 2);
                        paras = Math.min(paras, seuraava);
                        if (seuraava <= a) {
                            return paras;
                        }
                        if (seuraava < b) {
                            b = seuraava;
                        }
                    }
                }
            }
            return paras;
        }
    }
    
    /**
     * Metodi tallentaa ruudukosta ja riveistä vastaaviin taulukoihin tehdyn siirron minmax-toteutuksessa.
     *
     * @param riv taulukko, joka kuvaa peliruudukon rivejä
     * @param x minmax-algoritmin määrittelemä sijainnin x-koordinaatti
     * @param y minmax-algoritmin määrittelemä sijainnin y-koordinaatti
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void asetaSiirtoMinMax(int[] riv, int x, int y, int pelaaja) {
        
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
     * Metodi poistaa ruudukosta ja riveistä vastaaviin taulukoihin tehdyn siirron minmax-toteutuksessa.
     *
     * @param riv taulukko, joka kuvaa peliruudukon rivejä
     * @param x minmax-algoritmin määrittelemä sijainnin x-koordinaatti
     * @param y minmax-algoritmin määrittelemä sijainnin y-koordinaatti
     * @param pelaaja kokonaisluku, joka määrittelee siirron tehneen pelaajan
     * 
     */
    public void poistaSiirtoMinMax(int[] riv, int x, int y, int pelaaja) {
        
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
     * Metodi laskee sovelluksen tekoälytoteutuksella valitun merkin pelaajan seuraavan siirron.
     * 
     * @param pelivuoro kokonaisluku, joka kertoo siirtovuorosso olevan pelaajan
     * 
     * @see ristinolla.domain.Sijainti
     * 
     * @return palauttaa luvun -1, mikäli peli on päättynyt, tai tekoälyn suorittaman siirron koordinaatit
     */
    public int pelaa(int pelivuoro) {
        if (peliOhi()) {
            return -1;
        }
        
        tekoalynSiirto = new Sijainti(-1, -1);
        
        int[][] lahtoTilanne = ruudukko;
        int[] lahtoRivit = rivit;
  
        int paras = Integer.MIN_VALUE;
        
        int toinen;
        if (pelivuoro == 1) {
            toinen = 2;
        } else {
            toinen = 1;
            paras = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (lahtoTilanne[i][j] == 0) {
                    lahtoTilanne[i][j] = pelivuoro;
                    asetaSiirtoMinMax(lahtoRivit, j, i, pelivuoro);
                    
                    int valinta = minmaxAlfaBeeta(lahtoTilanne, lahtoRivit, 0, toinen, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    
                    lahtoTilanne[i][j] = 0;
                    poistaSiirtoMinMax(lahtoRivit, j, i, pelivuoro);
                    
                    System.out.println("Siirto: " + j + ", " + i + " saa tuloksen " + valinta);
                    
                    if (valinta > paras && pelivuoro == 1) {
                        paras = valinta;
                        tekoalynSiirto = new Sijainti(j, i);
                    }
                    if (valinta < paras && pelivuoro == 2) {
                        paras = valinta;
                        tekoalynSiirto = new Sijainti(j, i);
                    }
                }
            }
        }
             
        return tekoalynSiirto.getX() + tekoalynSiirto.getY() * koko;
    }
}
