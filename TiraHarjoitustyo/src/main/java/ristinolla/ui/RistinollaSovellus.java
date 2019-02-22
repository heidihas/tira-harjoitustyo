/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ristinolla.domain.ArrayList;
import ristinolla.domain.Sijainti;
import ristinolla.logics.Logiikka;

/**
 *
 * @author Heidi
 */
/**
 * Luokka vastaa pelisovelluksen käyttöliittymästä, sen tapahtumista ja näkymistä.
 */
public class RistinollaSovellus extends Application {
    
    // pelilogiikan alustaminen
    Logiikka logiikka;
        
    /**
     * Sovelluksen käynnistävä komento.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

    /**
     * Metodi koostaa sovelluksen näkymät, vastaa eri näkymien välillä liikkumisesta sekä kokoaa kaikki pelin palaset ja tapahtumat yhteen. 
     * 
     * @param ikkuna Stage-objekti joka määrittelee sovelluksen tämänhetkisen näkymän
     * 
     * @see ristinolla.domain.Sijainti
     */
    @Override
    public void start(Stage ikkuna) {
        
        // pelin nimi
        ikkuna.setTitle("Ristinolla");
        
        // ikkunan koko
        final int pelinLeveys = 640;
        final int pelinKorkeus = 480;
        
        // aloitusnäkymä
        Label otsikko = new Label("Pelaa ristinollaa!");
        
        Label valinta1 = new Label("Pelimerkki: ");
        ChoiceBox merkkiValinta = new ChoiceBox(FXCollections.observableArrayList("X", 
                "O"));
        Label error1 = new Label("");
        error1.setTextFill(Color.INDIANRED);
        
        Label valinta2 = new Label("Ruudukon koko: ");
        ChoiceBox kokoValinta = new ChoiceBox(FXCollections.observableArrayList("3", 
                "4", "5", "6", "7", "8"));
        Label error2 = new Label("");
        error2.setTextFill(Color.INDIANRED);
        
        Label valinta3 = new Label("Pelimuoto: ");
        ChoiceBox pelimuoto = new ChoiceBox(FXCollections.observableArrayList("Yksinpeli", 
                "Mallipeli"));
        Label error3 = new Label("");
        error3.setTextFill(Color.INDIANRED);
        
        Button aloitusNappi = new Button("Aloita");
        
        GridPane grid = new GridPane();
        
        grid.add(otsikko, 0, 0);
        grid.add(valinta1, 0, 1);
        grid.add(merkkiValinta, 1, 1);
        grid.add(error1, 2, 1);
        grid.add(valinta2, 0, 2);
        grid.add(kokoValinta, 1, 2);
        grid.add(error2, 2, 2);
        grid.add(valinta3, 0, 3);
        grid.add(pelimuoto, 1, 3);
        grid.add(error3, 2, 3);
        grid.add(aloitusNappi, 1, 5);
        
        grid.setPrefSize(640, 80);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(6);
        grid.setHgap(10);
        grid.setPadding(new Insets(0, 20, 20, 20));
        
        BorderPane asetteluAlku = new BorderPane();
        
        asetteluAlku.prefHeight(pelinKorkeus);
        asetteluAlku.prefWidth(pelinLeveys);
        asetteluAlku.setCenter(grid);
        
        Scene nakymaAlku = new Scene(asetteluAlku, 640, 480);
        ikkuna.setScene(nakymaAlku);
        
        // pelinäkymä
        Label teksti = new Label("");
        
        VBox tekstiPaneeli = new VBox();
        
        tekstiPaneeli.getChildren().add(teksti);
        tekstiPaneeli.setAlignment(Pos.CENTER);
        tekstiPaneeli.setPadding(new Insets(58, 20, 30, 20));
        
        ArrayList <Button> napit = new ArrayList<>();
        
        Button tyhjennaNappi = new Button("Tyhjennä");
        Button uusiPeliNappi = new Button("Uusi peli");
        
        VBox paneeli = new VBox();
        
        paneeli.getChildren().add(tyhjennaNappi);
        paneeli.getChildren().add(uusiPeliNappi);
        
        paneeli.setSpacing(10);
        paneeli.setAlignment(Pos.CENTER);
        paneeli.setPadding(new Insets(58, 20, 30, 20));
         
        BorderPane asetteluPeli = new BorderPane();
        
        asetteluPeli.prefHeight(pelinLeveys);
        asetteluPeli.prefWidth(pelinKorkeus);
	asetteluPeli.setTop(tekstiPaneeli);
        asetteluPeli.setBottom(paneeli);

	Scene nakymaPeli = new Scene(asetteluPeli, 640, 480);
        
        // nappien toiminta
        aloitusNappi.setOnAction((event) -> {    
            // tulostaa error-viestit
            if ((merkkiValinta.getValue() == null && pelimuoto.getValue() != "Mallipeli") 
                    || kokoValinta.getValue() == null 
                    || pelimuoto.getValue() == null ) {
                error1.setText("");
                error2.setText("");
                error3.setText("");
                String errorMerkki = "Valitse pelattava merkki";
                String errorKoko = "Valitse peliruudukon koko";
                String errorMuoto = "Valitse pelimuoto";
                
                if (merkkiValinta.getValue() == null && (pelimuoto.getValue() == null
                        || pelimuoto.getValue() == "Yksinpeli")) {
                    error1.setText(errorMerkki); 
                } 
                
                if (kokoValinta.getValue() == null) {
                    error2.setText(errorKoko); 
                } 
                
                if (pelimuoto.getValue() == null){
                    error3.setText(errorMuoto);
                }
                
            } else {
                int koko = Integer.parseInt(kokoValinta.getValue().toString());
                int valittuVuoro;
                int valittuPelimuoto;
                if (merkkiValinta.getValue() == null) {
                    valittuVuoro = 0;
                } else if (merkkiValinta.getValue().toString().equals("X")) {
                    valittuVuoro = 1;
                } else {
                    valittuVuoro = 2;
                }
                if (pelimuoto.getValue().toString().equals("Yksinpeli")) {
                    valittuPelimuoto = 1;
                } else {
                    valittuPelimuoto = 2;
                }
                ajaPeli(koko, valittuVuoro, valittuPelimuoto, napit, asetteluPeli, teksti);
                ikkuna.setScene(nakymaPeli);
            } 
        });
        
        tyhjennaNappi.setOnAction((event) -> {
            tyhjenna(teksti, napit);
            logiikka.tyhjennaPeliruudukko();
            int koko = Integer.parseInt(kokoValinta.getValue().toString());
                int valittuVuoro;
                int valittuPelimuoto;
                if (merkkiValinta.getValue() == null) {
                    valittuVuoro = 0;
                } else if (merkkiValinta.getValue().toString().equals("X")) {
                    valittuVuoro = 1;
                } else {
                    valittuVuoro = 2;
                }
                if (pelimuoto.getValue().toString().equals("Yksinpeli")) {
                    valittuPelimuoto = 1;
                } else {
                    valittuPelimuoto = 2;
                }
            ajaPeli(koko, valittuVuoro, valittuPelimuoto, napit, asetteluPeli, teksti);
            ikkuna.setScene(nakymaPeli);
        });
        
        uusiPeliNappi.setOnAction((event) -> {
            tyhjenna(teksti, napit);
            logiikka.tyhjennaPeliruudukko();
            merkkiValinta.setValue(null);
            kokoValinta.setValue(null);
            pelimuoto.setValue(null);
            error1.setText("");
            error2.setText("");
            error3.setText("");
            ikkuna.setScene(nakymaAlku);
        });
	ikkuna.show();
    }
    
    /**
     * Metodi alustaa uuden pelin ja vastaa pelinäkymän muutoksista.
     * 
     * @param koko kokonaisluku, joka kertoo uuden peliruudukon rivin pituuden
     * @param valittuVuoro kokonaisluku, joka kertoo käyttäjä valitseman pelimerkin X (= 1) tai O (= 2)
     * @param valittuPelimuoto kokonaisluku, joka kertoo pelin olevan joko yksinpeli (=1) tai tekoälyn ohjaama mallipeli (=2)
     * @param napit peliruudukon ruutuja edustavista napeista koostuva lista
     * @param asetteluPeli pelinäkymän asettelusta vastaava BorderPane-olio
     * @param teksti voittaneesta pelaajasta ilmoittava teksti
     * 
     * @see ristinolla.domain.Sijainti
     * 
     */
    private void ajaPeli(int koko, int valittuVuoro, int valittuPelimuoto, ArrayList <Button> napit, BorderPane asetteluPeli, Label teksti) {
        // pelilogiikan alustaminen valitulla koolla
        logiikka = new Logiikka(koko);
        
        napit.clear();
        GridPane ruudukko = luoRuudukko(koko, napit);
        
        // tekoälyn ensimmäinen satunnainen siirto
        if (valittuVuoro == 2 || valittuPelimuoto == 2) {
            int seuraava = (int) (Math.random() * (koko * koko));
            
            Button pelattavaNappi = napit.get(seuraava);
            Sijainti pelattavanPaikka = (Sijainti) pelattavaNappi.getUserData();
            int pelattavaX = pelattavanPaikka.getX();
            int pelattavaY = pelattavanPaikka.getY();
                        
            pelattavaNappi.setText("X");
            pelattavaNappi.setMouseTransparent(true);
            logiikka.asetaSiirto(pelattavaX-1, pelattavaY-1, 1);
            System.out.println("Tekoäly pelasi: " + seuraava);
        }
        
        // pelin eteneminen ai
        if (valittuPelimuoto == 1) {
            // käyttäjä vastaan tietokone
            for(int n = 0; n < napit.size(); n++) {
                Button nappi = napit.get(n);
                nappi.setOnAction((event) -> {
            
                    Sijainti paikka = (Sijainti) nappi.getUserData();
                    int x = paikka.getX();
                    int y = paikka.getY();
            
                    if (nappi.getText().equals(" ")) {
                        if (valittuVuoro == 2) {
                            nappi.setText("O");
                        } else {
                            nappi.setText("X");
                        }
                        
                        nappi.setMouseTransparent(true);
                        logiikka.asetaSiirto(x-1, y-1, valittuVuoro);
                        System.out.println("Asetettiin siirto: " + x + ", " + y);
                        
                        int vastustaja = 1;
                        if (valittuVuoro == 1) {
                            vastustaja = 2;
                        }
                        long aikaAlussa = System.currentTimeMillis();
                        int seuraava = logiikka.pelaa(vastustaja);
                        long aikaLopussa = System.currentTimeMillis();
                        System.out.println("Operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
                            
                        if (seuraava != -1) {
                            Button pelattavaNappi = napit.get(seuraava);
                            Sijainti pelattavanPaikka = (Sijainti) pelattavaNappi.getUserData();
                            int pelattavaX = pelattavanPaikka.getX();
                            int pelattavaY = pelattavanPaikka.getY();
                        
                            if (vastustaja == 1) {
                                pelattavaNappi.setText("X");
                            } else {
                                pelattavaNappi.setText("O");
                            }
                            pelattavaNappi.setMouseTransparent(true);
                            logiikka.asetaSiirto(pelattavaX-1, pelattavaY-1, vastustaja);
                            System.out.println("Tekoäly pelasi: " + seuraava);
                        }
                    
                        if (logiikka.peliOhi()) {
                            for(int i = 0; i < napit.size(); i++) {
                                napit.get(i).setDisable(true);
                            } 
                            if (logiikka.xVoitti()) {
                                teksti.setText("Pelaaja X voitti!");
                            } else if (logiikka.oVoitti()) {
                                teksti.setText("Pelaaja O voitti!"); 
                            } else {
                                teksti.setText("Peli päättyi!");
                            }
                        }
                    }
                });
            }
        } else if (valittuPelimuoto == 2) {
            // tietokone vastaan tietokone
            int vuoro = 2;
            
            while (!logiikka.peliOhi()) {
                logiikka.getRuudukko().tulosta();
                
                long aikaAlussa = System.currentTimeMillis();
                int seuraava = logiikka.pelaa(vuoro);
                long aikaLopussa = System.currentTimeMillis();
                System.out.println("Operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
                
                Button pelattavaNappi = napit.get(seuraava);
                Sijainti pelattavanPaikka = (Sijainti) pelattavaNappi.getUserData();
                int pelattavaX = pelattavanPaikka.getX();
                int pelattavaY = pelattavanPaikka.getY();
                
                if (vuoro == 1) {
                    pelattavaNappi.setText("X");
                } else {
                    pelattavaNappi.setText("O");
                }
                pelattavaNappi.setMouseTransparent(true);
                
                logiikka.asetaSiirto(pelattavaX-1, pelattavaY-1, vuoro);
                System.out.println("Tekoäly pelasi: " + seuraava);
                
                if (vuoro == 1) {
                    vuoro = 2;
                } else {
                    vuoro = 1;
                }
            }
                    
            for(int i = 0; i < napit.size(); i++) {
                napit.get(i).setDisable(true);
            } 
            if (logiikka.xVoitti()) {
                teksti.setText("Pelaaja X voitti!");
            } else if (logiikka.oVoitti()) {
                teksti.setText("Pelaaja O voitti!"); 
            } else {
                teksti.setText("Peli päättyi!");
            }       
        }
        ruudukko.setAlignment(Pos.CENTER);
        asetteluPeli.setCenter(ruudukko);
    }
    
    /**
     * Metodi luo uuden peliruudukon käyttäjän ilmoittaman koon perusteella.
     * 
     * @param koko kokonaisluku, joka kertoo uuden peliruudukon rivin pituuden
     * @param napit peliruudukon ruutuja edustavista napeista koostuva lista
     * 
     * @see ristinolla.domain.Sijainti
     * 
     * @return palauttaa uuden luodun ruudukon
     * 
     */
    private GridPane luoRuudukko(int koko, ArrayList <Button> napit) {
        // nappien luominen
        GridPane ruudukko = new GridPane();
        for (int y = 1; y <= koko; y++) {
            for (int x = 1; x <= koko; x++) {
                Button nappi = new Button();
                nappi.setFont(Font.font("Monospaced", 20));
                nappi.setText(" ");
                nappi.setUserData(new Sijainti(x, y));
                napit.add(nappi);
                ruudukko.add(nappi, x, y);
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi tyhjentää peliruudukon uutta pelikierrosta varten.
     * 
     * @param teksti voittaneesta pelaajasta ilmoittava teksti
     * @param napit peliruudukon ruutuja edustavista napeista koostuva lista
     * 
     */
    private void tyhjenna(Label teksti, ArrayList <Button> napit) {
        teksti.setText("");
        for (int i = 0; i < napit.size(); i++) {
            napit.get(i).setDisable(false);
            napit.get(i).setMouseTransparent(false);
            napit.get(i).setText(" ");
        }
    }
}
