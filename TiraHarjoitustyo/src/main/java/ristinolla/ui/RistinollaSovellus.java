/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ristinolla.domain.Sijainti;
import ristinolla.domain.Vuoro;
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
    Logiikka logiikka = new Logiikka();
    
    // vuoro-objektin alustaminen
    Vuoro peliVuoro = new Vuoro();
        
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
                "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"));
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
        Label teksti = new Label("Vuoro: X");
        
        VBox tekstiPaneeli = new VBox();
        
        tekstiPaneeli.getChildren().add(teksti);
        tekstiPaneeli.setAlignment(Pos.CENTER);
        tekstiPaneeli.setPadding(new Insets(58, 20, 30, 20));
        
        List <Button> napit = new ArrayList<>();

	GridPane ruudukko = new GridPane();
	for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                Button nappi = new Button();
                nappi.setFont(Font.font("Monospaced", 20));
                nappi.setText(" ");
                nappi.setUserData(new Sijainti(x, y));
                napit.add(nappi);
                ruudukko.add(nappi, x, y);
            }
        }
        ruudukko.setPrefSize(60, 60);
        ruudukko.setAlignment(Pos.CENTER);
        
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
	asetteluPeli.setCenter(ruudukko);
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
                //luoRuudukko(koko, napit, asetteluPeli);
                ikkuna.setScene(nakymaPeli);
            } 
        });
        
        tyhjennaNappi.setOnAction((event) -> {
            tyhjenna(teksti, napit);
            logiikka.tyhjennäPeliruudukko();
            ikkuna.setScene(nakymaPeli);
        });
        
        uusiPeliNappi.setOnAction((event) -> {
            tyhjenna(teksti, napit);
            logiikka.tyhjennäPeliruudukko();
            merkkiValinta.setValue(null);
            kokoValinta.setValue(null);
            pelimuoto.setValue(null);
            error1.setText("");
            error2.setText("");
            error3.setText("");
            ikkuna.setScene(nakymaAlku);
        });
        
        // pelivuoron alustaminen
        peliVuoro.seuraava = Vuoro.SeuraavaSiirto.O;
        
        // pelin eteneminen ai
        for(int n = 0; n < napit.size(); n++) {
            Button nappi = napit.get(n);
            nappi.setOnAction((event) -> {
            
                Sijainti paikka = (Sijainti) nappi.getUserData();
                int x = paikka.getX();
                int y = paikka.getY();
            
                if (!nappi.getText().equals(" ")) {
            
                /*} else if (teksti.getText().equals("Vuoro: X")) {
                    nappi.setText("X");
                    //nappi.setBackground(Background.EMPTY);
                    nappi.setMouseTransparent(true);
                    teksti.setText("Vuoro: O");*/
            
                } else {
                    nappi.setText("O");
                    //nappi.setBackground(Background.EMPTY);
                    nappi.setMouseTransparent(true);
                    //teksti.setText("Vuoro: X");
                    logiikka.asetaSiirto(x-1, y-1, 2);
                    logiikka.näytäPeliruudukko();
                    System.out.println("Asetettiin siirto: " + x + ", " + y);
                    int seuraava = logiikka.pelaaIlmanVuoroa();
                            
                    if (seuraava != -1) {
                        Button pelattavaNappi = napit.get(seuraava);
                        Sijainti pelattavanPaikka = (Sijainti) pelattavaNappi.getUserData();
                        int pelattavaX = pelattavanPaikka.getX();
                        int pelattavaY = pelattavanPaikka.getY();
                        
                        pelattavaNappi.setText("X");
                        pelattavaNappi.setMouseTransparent(true);
                        logiikka.asetaSiirto(pelattavaX-1, pelattavaY-1, 1);
                        logiikka.näytäPeliruudukko();
                        System.out.println("Tekoäly pelasi: " + seuraava);
                    }
                    
                    if (logiikka.peliOhi()) {
                       for(int i = 0; i < napit.size(); i++) {
                            napit.get(i).setDisable(true);
                        } 
                    }
                }
            
                /*long taydet = napit.stream()
                    .filter(p -> !p.getText().equals(" "))
                    .count();
            
                if(voitto(napit)) {
                    if(teksti.getText().equals("Vuoro: X")) {
                        teksti.setText("Pelaaja O voitti!");
                    } else {
                        teksti.setText("Pelaaja X voitti!");
                    }
                    for(int i = 0; i < napit.size(); i++) {
                        napit.get(i).setDisable(true);
                    }
                } else if(taydet == napit.size()) {
                    teksti.setText("Peli päättyi!");
                    for(int i = 0; i < napit.size(); i++) {
                        napit.get(i).setDisable(true);
                    }
                }*/
            });
        }
        
        /* pelin eteneminen
        for(int n = 0; n < napit.size(); n++) {
            Button nappi = napit.get(n);
            nappi.setOnAction((event) -> {
            
                Sijainti paikka = (Sijainti) nappi.getUserData();
                int x = paikka.getX();
                int y = paikka.getY();
            
                if (!nappi.getText().equals(" ")) {
            
                } else if (teksti.getText().equals("Vuoro: X")) {
                    nappi.setText("X");
                    //nappi.setBackground(Background.EMPTY);
                    nappi.setMouseTransparent(true);
                    teksti.setText("Vuoro: O");
            
                } else {
                    nappi.setText("O");
                    //nappi.setBackground(Background.EMPTY);
                    nappi.setMouseTransparent(true);
                    teksti.setText("Vuoro: X");
                }
            
                long taydet = napit.stream()
                    .filter(p -> !p.getText().equals(" "))
                    .count();
            
                if(voitto(napit)) {
                    if(teksti.getText().equals("Vuoro: X")) {
                        teksti.setText("Pelaaja O voitti!");
                    } else {
                        teksti.setText("Pelaaja X voitti!");
                    }
                    for(int i = 0; i < napit.size(); i++) {
                        napit.get(i).setDisable(true);
                    }
                } else if(taydet == napit.size()) {
                    teksti.setText("Peli päättyi!");
                    for(int i = 0; i < napit.size(); i++) {
                        napit.get(i).setDisable(true);
                    }
                }
            });
        }*/
        
	ikkuna.show();
    }
    
    /**
     * Metodi luo uuden peliruudukon käyttäjän ilmoittaman koon perusteella.
     * 
     * @param koko kokonaisluku, joka kertoo uuden peliruudukon rivin pituuden
     * @param napit peliruudukon ruutuja edustavista napeista koostuva lista
     * @param asetteluPeli pelinäkymän asettelusta vastaava BorderPane-olio
     * 
     * @see ristinolla.domain.Sijainti
     * 
     */
    private void luoRuudukko(int koko, List <Button> napit, BorderPane asetteluPeli) {
        napit.clear();
        GridPane ruudukko = new GridPane();
        for (int x = 1; x <= koko; x++) {
            for (int y = 1; y <= koko; y++) {
                Button nappi = new Button();
                nappi.setFont(Font.font("Monospaced", 20));
                nappi.setText(" ");
                nappi.setUserData(new Sijainti(x, y));
                napit.add(nappi);
                ruudukko.add(nappi, x, y);
            }
        }
        ruudukko.setAlignment(Pos.CENTER);
        asetteluPeli.setCenter(ruudukko);
    }
    
    /**
     * Metodi tyhjentää peliruudukon uutta pelikierrosta varten.
     * 
     * @param teksti vuorossa olevasta pelaajasta ilmoittava teksti
     * @param napit peliruudukon ruutuja edustavista napeista koostuva lista
     * 
     */
    private void tyhjenna(Label teksti, List <Button> napit) {
        teksti.setText("Vuoro: X");
        for (int i = 0; i < napit.size(); i++) {
            /*Position paikka = (Position) napit.get(i).getUserData();
            //Button nappi = napit.get(i);
            int x = paikka.getX();
            int y = paikka.getY();
            Button nappi = new Button();
            nappi.setFont(Font.font("Monospaced", 20));
            nappi.setText(" ");
            nappi.setUserData(new Position(x, y));
            napit.set(i, nappi);*/
            
            
            napit.get(i).setDisable(false);
            napit.get(i).setMouseTransparent(false);
            napit.get(i).setText(" ");
        }
    }
    
    /**
     * Metodi tarkistaa, onko jollakin rivillä (vaakasuora, pystysuora, viisto) kolme samaa merkkiä.
     * 
     * @param napit peliruudukon ruutuja edustavista napeista koostuva lista
     * 
     * @return true, mikäli kolmen suora löytyy
     */
    public boolean voitto(List <Button> napit) {
        for(int i = 0; i < 3; i++) {
            if(napit.get(i*3).getText().equals(napit.get(i*3+1).getText()) && 
                    napit.get(i*3+1).getText().equals(napit.get(i*3+2).getText()) &&
                    !napit.get(i*3).getText().equals(" ")) {
                return true;
            }
            if(napit.get(i).getText().equals(napit.get(i+3).getText()) &&
                    napit.get(i+3).getText().equals(napit.get(i+6).getText()) &&
                    !napit.get(i).getText().equals(" ")) {
                return true;
            }
        
        }
        if(napit.get(0).getText().equals(napit.get(4).getText()) &&
                napit.get(4).getText().equals(napit.get(8).getText()) &&
                !napit.get(0).getText().equals(" ") ||
                napit.get(2).getText().equals(napit.get(4).getText()) &&
                napit.get(4).getText().equals(napit.get(6).getText()) &&
                !napit.get(2).getText().equals(" ")) {
            return true;
        }
        return false;
    }
}
