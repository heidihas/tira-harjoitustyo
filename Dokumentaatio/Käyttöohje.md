# Käyttöohje

## Sovelluksen käynnistäminen
Sovellus käynnistyy ajamalla git-repositorion päähakemistosta löytyvä Jar-tiedosto tai kopioimalla projekti git-repositoriosta omalle tietokoneelle ja suorittamalla siihen liittyvä koodi esimerkiksi NetBeansillä. Sovelluksen ajamista varten ei tarvita testitiedostoja.

## Pelin valitseminen
Pelin käynnistyessä avautuu aloitusnäkymän käsittävä ikkuna (katso yllä), jolla käyttäjä voi päättää seuraavan pelikierroksen. Valmiista valikoista käyttäjän on mahdollista valita oma pelimerkkinsä ja peliruudukon koko. Lisäksi käyttäjän on mahdollista valita joko yksinpeli eli käyttäjä vastaan tietokone -muotoinen pelikierros tai mallipeli, jossa tietokone pelaa itse itseään vastaan. Valintojen jälkeen pelaamaan pääsee klikkaamalla Aloita-nappia.

Mikäli käyttäjä yrittää päästä pelaamaan virheellisellä syötteellä, varoittaa sovellus tästä yllä olevan kuvan mukaisilla virheviesteillä. Jokaista pelikierrosta varten on valittava peliruudukon koko ja pelityyppi. Käyttäjän pelimerkin valinta vaaditaan ainoastaan silloin, kun pelityypiksi on valittu yksinpeli.

## Pelikierroksen eteneminen
Kun käyttäjä on klikannut Aloita-nappia onnistuneesti ja valittu pelityyppi on yksinpeli, avautuu alla olevan kuvan pelinäkymä sovellusikkunaan olettaen, että valittu peliruudukon koko on 3x3 ja käyttäjä haluaa aloittaa pelin (valittu pelimerkki on X). 

Kaikkia vapaina olevia peliruudukon ruutuja on mahdollista klikata, ja vapaiden ruutujen napit muuttuvat hennosti valkoiseksi hiiren kulkiessa niiden yli. Siirron valitakseen käyttäjän on klikattava mielivaltaista ruutunappia, jonka jälkeen ruutuun ilmestyy pelaajan pelimerkki. Kun ruutuun on asetettu joko käyttäjän tai tietokonepelaajan siirto, estää sovellus ruudun napin painamisen uudelleen.  

## Pelikierroksen jälkeen
