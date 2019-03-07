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
 * Luokka vastaa pelilogiikasta ja pelin etenemisen seurannasta.
 */
public class Logiikka {
    
    private int koko;
    private int[] rivit;
    private int[] riviMaarat;
    private Ruudukko ruudukko;
    private int viimeisin;
    private Algoritmi algoritmi;
    
    public Logiikka(int koko) {
        this.koko = koko;
        this.rivit = new int[2 * koko + 2];
        this.riviMaarat = new int[2 * koko + 2];
        this.ruudukko = new Ruudukko(koko);
        this.viimeisin = -1;
        this.algoritmi = new Algoritmi();
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
     * Metodi palauttaa taulukon, joka kertoo peliruudukon riveillä olevien merkkien määrän.
     *
     * @return palauttaa int[]-muotoisen taulukon eli peliruudukon rivien merkkimäärät
     */
    public int[] getRiviMaarat() {
        return riviMaarat;
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
        if (pelaaja == Pelimerkki.X.value) {
            viimeisin = x + (koko * y);
        }
        
        int lisattava = -1;
        if (pelaaja == Pelimerkki.X.value) {
            lisattava = 1;
        }
        
        rivit[y] = rivit[y] + lisattava;
        rivit[x + koko] = rivit[x + koko] + lisattava;
        riviMaarat[y]++;
        riviMaarat[x + koko]++;
        
        if (x == y) {
            rivit[koko * 2] = rivit[koko * 2] + lisattava;
            riviMaarat[koko * 2]++;
        } 
        if ((x + y) == (koko - 1)) {
            rivit[koko * 2 + 1] = rivit[koko * 2 + 1] + lisattava;
            riviMaarat[koko * 2 + 1]++;
        }
    }
    
    /**
     * Metodi tyhjentää peliruudukon uutta peliä varten.
     *
     */
    public void tyhjennaPeliruudukko() {
        this.ruudukko.tyhjenna();
        for (int i = 0; i < (koko * 2 + 2); i++) {
            rivit[i] = 0;
            riviMaarat[i] = 0;
        }
        viimeisin = -1;
    }
    
    /**
     * Metodi tarkistaa, onko jokin pelin päättävistä tapahtumista toteutunut.
     *
     * @return true, mikäli jompikumpi pelaajista on saanut peliruudukon rivin pituisen suoran, peliruudukko on täysi tai peliruudukossa ei ole enää mahdollisuutta voittaa
     */
    public boolean peliOhi() {
        int voittoMahdollisuus = 0;
        for (int i = 0; i < koko * 2 + 2; i++) {
            if ((this.riviMaarat[i] == this.rivit[i]) || (this.riviMaarat[i] == -this.rivit[i])) {
                voittoMahdollisuus++;
            }
        }
        return this.xVoitti() || this.oVoitti() || !this.ruudukko.onVapaita() || voittoMahdollisuus == 0;
    }
    
    /**
     * Metodi tarkistaa, onko merkillä X pelannut pelaaja voittanut pelikierroksen.
     * 
     * @return true, mikäli X-merkin pelaaja (nro 1) on saanut peliruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean xVoitti() {
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
     * @return true, mikäli O-merkin pelaaja (nro 2) on saanut peliruudukon rivin verran vierekkäisiä merkkejä joko pystysuoraan, vaakasuoraan tai viistosti
     */
    public boolean oVoitti() {
        for (int i = 0; i < (koko * 2 + 2); i++) {
            if (rivit[i] == -koko) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi laskee sovelluksen tekoälytoteutuksella seuraavan siirron annetulle pelivuorolle.
     * 
     * @param pelivuoro kokonaisluku, joka kertoo siirtovuorossa olevan pelaajan
     * 
     * @see ristinolla.domain.ArrayList
     * @see ristinolla.domain.Ruudukko
     * @see ristinolla.logics.Algoritmi
     * 
     * @return palauttaa luvun -1, mikäli peli on päättynyt, tai tekoälyn suorittaman siirron
     */
    public int pelaa(int pelivuoro) {
        if (peliOhi()) {
            return -1;
        }
        
        int[] lahtoTilanne = ruudukko.getRuudukko();
        int[] lahtoRivit = rivit;
        int[] lahtoRiviMaarat = riviMaarat;
        
        for (int i = 0; i < koko * 2 + 2; i++) {
            if ((rivit[i] == koko - 1 && pelivuoro == 2) || (rivit[i] == -(koko - 1) && pelivuoro == 1)) {
                return algoritmi.minmaxAlfaBeeta(lahtoTilanne, lahtoRivit, lahtoRiviMaarat, koko, 0, 4, pelivuoro, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
            }
        }
        
        ArrayList<Integer> paikat = alitaulukko();
        
        int[] valittuRuudukko = new int[9];
        int[] valitutRivit = new int[8];
        int[] valitutRiviMaarat = new int[8];
        
        alustaAlitaulukko(valittuRuudukko, valitutRivit, valitutRiviMaarat, lahtoTilanne, paikat);
        
        int siirto = algoritmi.minmaxAlfaBeeta(valittuRuudukko, valitutRivit, valitutRiviMaarat, 3, 0, 9, pelivuoro, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
        
        if (siirto == -1) {
            return algoritmi.minmaxAlfaBeeta(lahtoTilanne, lahtoRivit, lahtoRiviMaarat, koko, 0, 4, pelivuoro, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
        }
        return paikat.get(siirto);
    }
    
    /**
     * Metodi muodostaa viimeisimmän tallennetun siirron perusteella alitaulukon.
     * 
     * @see ristinolla.domain.ArrayList
     * 
     * @return palauttaa peliruudukon indekseistä muodostetun järjestetyn alitaulukon 
     */
    private ArrayList<Integer> alitaulukko() {
        ArrayList<Integer> paikat = new ArrayList<>();
        int sijainti = viimeisin % koko;
        paikat.add(viimeisin);
        
        if (sijainti == 0) {
            paikat.add(viimeisin + 1);
            paikat.add(viimeisin + 2);
        } else if (sijainti == koko - 1) {
            paikat.add(viimeisin - 1);
            paikat.add(viimeisin - 2);
        } else {
            paikat.add(viimeisin - 1);
            paikat.add(viimeisin + 1);
        }
        
        if (viimeisin < koko) {
            paikat.add(paikat.get(0) + koko);
            paikat.add(paikat.get(1) + koko);
            paikat.add(paikat.get(2) + koko);
            paikat.add(paikat.get(0) + 2 * koko);
            paikat.add(paikat.get(1) + 2 * koko);
            paikat.add(paikat.get(2) + 2 * koko);
        } else if (viimeisin >= koko * (koko - 1)) {
            paikat.add(paikat.get(0) - koko);
            paikat.add(paikat.get(1) - koko);
            paikat.add(paikat.get(2) - koko);
            paikat.add(paikat.get(0) - 2 * koko);
            paikat.add(paikat.get(1) - 2 * koko);
            paikat.add(paikat.get(2) - 2 * koko);
        } else {
            paikat.add(paikat.get(0) - koko);
            paikat.add(paikat.get(1) - koko);
            paikat.add(paikat.get(2) - koko);
            paikat.add(paikat.get(0) + koko);
            paikat.add(paikat.get(1) + koko);
            paikat.add(paikat.get(2) + koko);
        }
        
        paikat.sort(0, paikat.size() - 1);
        return paikat;
    }
    
    /**
     * Metodi muodostaa viimeisimmän tallennetun siirron perusteella alitaulukon.
     * 
     * @param valittuRuudukko taulukko, joka kuvaa ruudukon osaa
     * @param valitutRivit taulukko, joka käsittää aliruudukon rivit
     * @param valitutRiviMaarat taulukko, joka käsittää aliruudukon riveillä olevien merkkien määrät
     * @param lahtoTilanne taulukko, joka kuvaa peliruudukkoa siirtohetkenä
     * @param paikat aliruudukkoon asetettavista peliruudukon ruuduista muodostuva lista
     * 
     * @see ristinolla.domain.ArrayList
     * @see ristinolla.logics.Algoritmi
     * 
     */
    private void alustaAlitaulukko(int[] valittuRuudukko, int[] valitutRivit, int[] valitutRiviMaarat, int[] lahtoTilanne, ArrayList<Integer> paikat) {
        for (int i = 0; i < 9; i++) {
            int merkki = lahtoTilanne[paikat.get(i)];
            if (merkki != 0) {
                valittuRuudukko[i] = merkki;
                algoritmi.asetaSiirtoMinMax(valitutRivit, valitutRiviMaarat, 3, i, merkki);
            }
        }
    }
}
