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
    
    private int[][] ruudukko;
    private int koko;
    private List<int[]> rivit;
    private List<int[]> sarakkeet;
    private int[] diag1;
    private int[] diag2;
    private Sijainti tekoalynSiirto;
    
    public Logiikka(int koko) {
        this.koko = koko;
        this.ruudukko = new int[koko][koko];
        this.rivit = new ArrayList<>();
        this.sarakkeet = new ArrayList<>();
        for (int i = 0; i < koko; i++) {
            this.rivit.add(new int[koko]);
            this.sarakkeet.add(new int[koko]);
        }
        this.diag1 = new int[koko];
        this.diag2 = new int[koko];
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
            diag1[i] = 0;
            diag2[i] = 0;
            for (int j = 0; j < koko; j++) {
                ruudukko[i][j] = 0;
                rivit.get(i)[j] = 0;
                sarakkeet.get(i)[j] = 0;
            }
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
        if (x == y) {
            diag1[x] = pelaaja;
        } 
        if ((x + y) == (koko - 1)) {
            diag2[x] = pelaaja;
        }
        ruudukko[y][x] = pelaaja;
        sarakkeet.get(x)[y] = pelaaja;
        rivit.get(y)[x] = pelaaja;
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
     * @return true, mikäli jompikumpi pelaajista on saanut kolmen suoran tai peliruudukko on täysi
     */
    public boolean peliOhi() {
        return this.xVoitti() || this.oVoitti() || !this.onSiirtojaJaljella(ruudukko);
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     * 
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut kolme vierekkäistä merkkiä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean xVoitti() {
        int suoraDiag1 = 0;
        int suoraDiag2 = 0;
        for (int i = 0; i < koko; i++) {
            if (diag1[i] == 1) {
                suoraDiag1++;
            }
            if (diag2[i] == 1) {
                suoraDiag2++;
            }
        }
        if (suoraDiag1 == koko || suoraDiag2 == koko) {
            return true;
        }
        
        for (int i = 0; i < koko; i++) {
            int sarake = 0;
            int rivi = 0;
            for (int j = 0; j < koko; j++) {
                if (sarakkeet.get(i)[j] == 1) {
                    sarake++;
                }
                if (rivit.get(i)[j] == 1) {
                    rivi++;
                }
            }
            if (sarake == koko || rivi == koko) {
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
        int suoraDiag1 = 0;
        int suoraDiag2 = 0;
        for (int i = 0; i < koko; i++) {
            if (diag1[i] == 2) {
                suoraDiag1++;
            }
            if (diag2[i] == 2) {
                suoraDiag2++;
            }
        }
        if (suoraDiag1 == koko || suoraDiag2 == koko) {
            return true;
        }
        
        for (int i = 0; i < koko; i++) {
            int sarake = 0;
            int rivi = 0;
            for (int j = 0; j < koko; j++) {
                if (sarakkeet.get(i)[j] == 2) {
                    sarake++;
                }
                if (rivit.get(i)[j] == 2) {
                    rivi++;
                }
            }
            if (sarake == koko || rivi == koko) {
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
     * Metodi laskee sovelluksen tekoälytoteutuksella X-pelaajan seuraavan siirron.
     * 
     * @see ristinolla.domain.Sijainti
     * 
     * @return palauttaa luvun -1, mikäli peli on päättynyt, tai tekoälyn suorittaman siirron koordinaatit
     */
    public int pelaaIlmanVuoroa() {
        if (peliOhi()) {
            return -1;
        }
        
        tekoalynSiirto = new Sijainti(-1, -1);
        int[][] lahtoTilanne = ruudukko;
        int paras = Integer.MIN_VALUE;
        
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (lahtoTilanne[i][j] == 0) {
                    lahtoTilanne[i][j] = 1;
                    int valinta = minmax(lahtoTilanne, 0, 2);
                    lahtoTilanne[i][j] = 0;
                    System.out.println("Siirto: " + j + ", " + i + " saa tuloksen " + valinta);
                    if (valinta > paras) {
                        paras = valinta;
                        tekoalynSiirto = new Sijainti(j, i);
                    }
                }
            }
        }
             
        return tekoalynSiirto.getX() + tekoalynSiirto.getY() * 3;
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
                    int valinta = minmax(lahtoTilanne, 0, toinen);
                    lahtoTilanne[i][j] = 0;
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
             
        return tekoalynSiirto.getX() + tekoalynSiirto.getY() * 3;
    }
}
