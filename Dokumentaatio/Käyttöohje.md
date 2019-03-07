# Käyttöohje

## Sovelluksen käynnistäminen
Sovellus käynnistyy ajamalla git-repositorion päähakemistosta löytyvä Jar-tiedosto tai kopioimalla projekti git-repositoriosta omalle tietokoneelle ja suorittamalla siihen liittyvä koodi esimerkiksi NetBeansillä. Sovelluksen ajamista varten ei tarvita testitiedostoja.

## Pelin valitseminen
Pelin käynnistyessä avautuu aloitusnäkymän käsittävä ikkuna (katso kuva alla), jolla käyttäjä voi päättää seuraavan pelikierroksen. Valmiista valikoista käyttäjän on mahdollista valita oma pelimerkkinsä ja peliruudukon koko. Lisäksi käyttäjän on mahdollista valita joko yksinpeli eli käyttäjä vastaan tietokone -muotoinen pelikierros tai mallipeli, jossa tietokone pelaa itse itseään vastaan. Valintojen jälkeen pelaamaan pääsee klikkaamalla Aloita-nappia.

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Aloitusn%C3%A4kym%C3%A4.png" width="450">

Mikäli käyttäjä yrittää päästä pelaamaan virheellisellä syötteellä, varoittaa sovellus tästä alla olevan kuvan mukaisilla virheviesteillä. Jokaista pelikierrosta varten on valittava peliruudukon koko ja pelityyppi. Käyttäjän pelimerkin valinta vaaditaan ainoastaan silloin, kun pelityypiksi on valittu yksinpeli.

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Virheviestit.png" width="450">

## Pelikierroksen eteneminen yksinpelissä
Kun käyttäjä on klikannut Aloita-nappia onnistuneesti ja valittu pelityyppi on yksinpeli, avautuu alla olevan kuvan pelinäkymä sovellusikkunaan olettaen, että valittu peliruudukon koko on 3x3 ja käyttäjä haluaa aloittaa pelin (valittu pelimerkki on X). 

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Peliruudukko.png" width="450">

Kaikkia vapaina olevia peliruudukon ruutuja on mahdollista klikata, ja vapaiden ruutujen napit muuttuvat hennosti valkoiseksi hiiren kulkiessa niiden yli. Siirron valitakseen käyttäjän on klikattava mielivaltaista ruutunappia, jonka jälkeen ruutuun ilmestyy pelaajan pelimerkki. Kun ruutuun on asetettu joko käyttäjän tai tietokonepelaajan siirto, estää sovellus ruudun napin painamisen uudelleen.

Peli etenee käyttäjän ja tietokoneen siirtovalintoja vuorotellen. Tavoitteena on muodostaa omalla pelimerkillä ruudukon sivun pituinen vaaka- pystysuora- tai viistorivi ja estää vastustajan voittaminen. Pelikierros päättyy, mikäli jompikumpi pelaajista on saanut voittorivin, peliruudukossa ei ole enää siirtoja jäljellä tai kummallakaan pelaajalla ei ole enää mahdollisuutta voittaa. Näistä jälkimmäisimmän tapauksen muodostaa sellainen peliruudukko, johon ei ole enää mahdollista muodostaa kummallakaan pelimerkillä voittoon tarvittavaa riviä. Esimerkki tällaisesta peliruudukosta on alla olevassa kuvassa.

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Mallipeli.png" width="450">

Pelikierroksen aikana kukin suoritettu siirto tulostuu konsoliin. Tulosteista näkyvät tehdyn siirron koordinaatit ja se, suorittiko siirron käyttäjä tai tekoäly. Lisäksi tulosteessa ilmoitetaan, miten kauan aikaa kului kunkin tietokonepelaajan siirron laskemiseen.

## Pelikierroksen jälkeen
Kun pelikierros on päättynyt, ilmoittaa sovellus pelikierroksen mahdollisen voittajan tai muussa tapauksessa ainoastaan pelikierroksen päättymisestä. Pelikierroksen päätyttyä kaikkien peliruudukon nappien klikkaaminen estetään alla olevan kuvan mukaisesti.

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/O-voitti.png" width="450">

Peliruudukon alla on kaksi nappia, joiden klikkaaminen on mahdollista niin pelikierroksen aikana kuin pelikierroksen päätyttyä. Tyhjennä-nappi tyhjentää pelinäkymässä olevan peliruudukon ja aloittaa pelin alusta samoilla pelivalinnoilla (käyttäjän merkki, ruudukon koko). Uusi peli -nappi puolestaan vie käyttäjän takaisin sovelluksen aloitusnäkymään, jossa käyttäjän on mahdollista tehdä uudet valinnat seuraavaa pelikierrosta varten.

## Mallipeli
Käyttäjän on yksinpelin lisäksi mahdollista valita pelityypiksi mallipeli, jolloin tietokone pelaa itseään vastaan. Mallipelissä sovellusikkuna muistuttaa yksinpelin näkymää pelikierroksen jälkeen: kaikkien peliruudukon nappien klikkaaminen on estetty ja sovellus ilmoittaa pelikierroksen päättymisestä tai mahdollisesta voittajasta. Konsoliin tulostuu mallipeli vaiheittain. Tulosteessa näkyvät tietokoneen suorittamat siirrot mallipelin aikana (niin koordinaatein kuin tulostettavassa peliruudukossa esitettynä) sekä niiden laskemiseen kuluneet ajat.

Tyhjennä-nappia klikkaamalla käyttäjä voi laskea uuden mallipelin.
