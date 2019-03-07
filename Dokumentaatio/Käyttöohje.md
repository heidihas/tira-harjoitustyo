# Käyttöohje

## Sovelluksen käynnistäminen
Sovellus käynnistyy ajamalla git-repositorion päähakemistosta löytyvä Jar-tiedosto tai kopioimalla projekti git-repositoriosta omalle tietokoneelle ja suorittamalla siihen liittyvä koodi esimerkiksi NetBeansillä. Sovelluksen ajamista varten ei tarvita testitiedostoja.

## Pelin valitseminen
Pelin käynnistyessä avautuu aloitusnäkymän käsittävä ikkuna (katso yllä), jolla käyttäjä voi päättää seuraavan pelikierroksen. Valmiista valikoista käyttäjän on mahdollista valita oma pelimerkkinsä ja peliruudukon koko. Lisäksi käyttäjän on mahdollista valita joko yksinpeli eli käyttäjä vastaan tietokone -muotoinen pelikierros tai mallipeli, jossa tietokone pelaa itse itseään vastaan. Valintojen jälkeen pelaamaan pääsee klikkaamalla Aloita-nappia.

Mikäli käyttäjä yrittää päästä pelaamaan virheellisellä syötteellä, varoittaa sovellus tästä yllä olevan kuvan mukaisilla virheviesteillä. Jokaista pelikierrosta varten on valittava peliruudukon koko ja pelityyppi. Käyttäjän pelimerkin valinta vaaditaan ainoastaan silloin, kun pelityypiksi on valittu yksinpeli.

## Pelikierroksen eteneminen yksinpelissä
Kun käyttäjä on klikannut Aloita-nappia onnistuneesti ja valittu pelityyppi on yksinpeli, avautuu alla olevan kuvan pelinäkymä sovellusikkunaan olettaen, että valittu peliruudukon koko on 3x3 ja käyttäjä haluaa aloittaa pelin (valittu pelimerkki on X). 

Kaikkia vapaina olevia peliruudukon ruutuja on mahdollista klikata, ja vapaiden ruutujen napit muuttuvat hennosti valkoiseksi hiiren kulkiessa niiden yli. Siirron valitakseen käyttäjän on klikattava mielivaltaista ruutunappia, jonka jälkeen ruutuun ilmestyy pelaajan pelimerkki. Kun ruutuun on asetettu joko käyttäjän tai tietokonepelaajan siirto, estää sovellus ruudun napin painamisen uudelleen.

Peli etenee käyttäjän ja tietokoneen siirtovalintoja vuorotellen. Tavoitteena on muodostaa omalla pelimerkillä ruudukon sivun pituinen vaaka- pystysuora- tai viistorivi ja estää vastustajan voittaminen. Pelikierros päättyy, mikäli jompikumpi pelaajista on saanut voittorivin, peliruudukossa ei ole enää siirtoja jäljellä tai kummallakaan pelaajalla ei ole enää mahdollisuutta voittaa. Näistä jälkimmäisimmän tapauksen muodostaa sellainen peliruudukko, johon ei ole enää mahdollista muodostaa kummallakaan pelimerkillä voittoon tarvittavaa riviä. Esimerkki tällaisesta peliruudukosta on alla olevassa kuvassa.

## Pelikierroksen jälkeen
Kun pelikierros on päättynyt, ilmoittaa sovellus pelikierroksen mahdollisen voittajan tai muussa tapauksessa ainoastaan pelikierroksen päättymisestä. Pelikierroksen päätyttyä kaikkien peliruudukon nappien klikkaaminen estetään alla olevan kuvan mukaisesti.

Peliruudukon alla on kaksi nappia, joiden klikkaaminen on mahdollista niin pelikierroksen aikana kuin pelikierroksen päätyttyä. Tyhjennä-nappi tyhjentää pelinäkymässä olevan peliruudukon ja aloittaa pelin alusta samoilla pelivalinnoilla (käyttäjän merkki, ruudukon koko). Uusi peli -nappi puolestaan vie käyttäjän takaisin sovelluksen aloitusnäkymään, jossa käyttäjän on mahdollista tehdä uudet valinnat seuraavaa pelikierrosta varten.

## Mallipeli
Käyttäjän on yksinpelin lisäksi mahdollista valita pelityypiksi mallipeli, jolloin tietokone pelaa itseään vastaan.
