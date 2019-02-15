/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logics;

import ristinolla.domain.RuudukkoAlfaBeeta;

/**
 *
 * @author Heidi
 */
public class AlfaBeeta {
    
    private AlfaBeeta() {}
    
    static void aja(int pelaaja, RuudukkoAlfaBeeta ruudukko) {
        alfaBeetaPruning(pelaaja, ruudukko, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
    
    private static int alfaBeetaPruning(int pelaaja, RuudukkoAlfaBeeta ruudukko, int alfa, int beeta, int syvyys) {
        if (ruudukko.peliOhi()) {
            return score(ruudukko, syvyys);
        }
        
        if (pelaaja == 1) {
            return max(ruudukko, alfa, beeta, syvyys);
        } else {
            return min(ruudukko, alfa, beeta, syvyys);
        }
    }
    
    private static int max(RuudukkoAlfaBeeta ruudukko, int alfa, int beeta, int syvyys) {
        int parasIndeksi = -1;
        
        for (Integer siirto : ruudukko.vapaat()) {
            RuudukkoAlfaBeeta muutettu = ruudukko.kopio();
            muutettu.aseta(siirto, 1);
            int score = alfaBeetaPruning(2, muutettu, alfa, beeta, syvyys+1);
            
            if (score > alfa) {
                alfa = score;
                parasIndeksi = siirto;
            }
            
            if (alfa >= beeta) {
                break;
            }
        }
        
        if (parasIndeksi != -1) {
            ruudukko.aseta(parasIndeksi, 1);
        }
        return alfa;
    }
    
    private static int min(RuudukkoAlfaBeeta ruudukko, int alfa, int beeta, int syvyys) {
        int parasIndeksi = -1;
        
        for (Integer siirto : ruudukko.vapaat()) {
            RuudukkoAlfaBeeta muutettu = ruudukko.kopio();
            muutettu.aseta(siirto, 2);
            int score = alfaBeetaPruning(1, muutettu, alfa, beeta, syvyys+1);
            
            if (score < beeta) {
                beeta = score;
                parasIndeksi = siirto;
            }
            
            if (alfa >= beeta) {
                break;
            }
        }
        
        if (parasIndeksi != -1) {
            ruudukko.aseta(parasIndeksi, 2);
        }
        return beeta;
    }
    
    private static int score(RuudukkoAlfaBeeta ruudukko, int syvyys) {
        if (!ruudukko.onVapaita() && ruudukko.voittaja() == 1) {
            return 10 - syvyys;
        } else if (!ruudukko.onVapaita() && ruudukko.voittaja() == 2) {
            return -10 + syvyys;
        }
        
        return 0;
    }
    
}
