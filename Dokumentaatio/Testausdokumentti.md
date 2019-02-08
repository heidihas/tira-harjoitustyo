# Testausdokumentti

Sovellusta testataan niin automatisoiduin yksikkö- ja integraatiotestein JUnitilla kuin manuaalisesti järjestelmätason testeillä. Lisäksi testataan sovelluksen suorituskykyä ja koodin laatua.

Miten testit voidaan toistaa???

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoidut testit koskevat sovelluslogiikkaa edustavia pakkauksia _ristinolla.domain_ ja _ristinolla.logics_. Testiluokka [SijaintiTesti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/test/java/ristinolla/tests/domain/SijaintiTesti.java) koskee peliruutujen ja merkkien sijainteja tallentavan Sijainti-luokan yksikkötestejä, joiden tarkoituksena on varmistaa yksikkötason testien läpäisy. Sen sijaan pakkaukseen _ristinolla.logics_ liittyvä testiluokka [LogiikkaTesti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/test/java/ristinolla/tests/logics/LogiikkaTesti.java) toimii kokoavana integraatiotestinä siinä suhteessa, että testiluokka yhdistää eri tietorakenteita monimutkaisemmiksi toimintayksiköiksi ja seuraa niiden yhteistoiminnan onnistumista pelilogiikan taustalla.

### Testikattavuus

Sovelluksen käyttöliittymäpakkausta ja siihen kuuluvaa [RistinollaSovellus](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/ui/RistinollaSovellus.java)-luokkaa lukuun ottamatta testauksen rivi- ja haarautumakattavuus on vastaavanlainen:

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Testikattavuus_8_2.png" width="600">

Testikattavuusraportti voidaan luoda komennolla

```
mvn org.pitest:pitest-maven:mutationCoverage
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston _target/pit-reports/201902081251/index.html_

## Järjestelmätestaus

Sovelluksen järjestelmätestaus suoritetaan manuaalisesti seuraamalla sovelluksen asennus- ja käyttöohjeita sekä [Määrittelydokumentin](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md) tietoja suunnitellusta ohjelman tarjoamasta sovelluslogiikasta.

### Asennus ja konfigurointi

Sovelluksen käyttöönottoa testataan sekä OSX- että Linux-pohjaisessa ympäristössä noudattamalla sovelluksesta esitettyjä asennus- ja käyttöohjeita.

### Toiminnallisuudet

Määrittelydokumentissa ilmoitetut ja sovellukseen toteutetut toiminnallisuudet rakennetaan ohessa aktiivisesti kaikkea luotavaa testaten. Aloitussivulta käydään läpi kaikki mieleen tulevat tilanteet ja syötevaihtoehdot. Samalla varmistetaan, ettei virheellistä syötettä - kuten peliruudukon valitun koon puuttumista - ole mahdollista tarjota ja päästä onnistuneesti jatkamaan pelinäkymään. Virheellisille syötteille luodaan kolme virheviestiä: _Valitse pelattava merkki_, _Valitse peliruudukon koko_ ja _Valitse pelimuoto_. Ainoa poikkeus on tilanne, jossa käyttäjä valitsee pelimuodoksi tietokoneen ohjaaman mallipelin, jolloin pelattavaa merkkiä ei vaadita valittavaksi. 
Vastaavasti pelinäkymässä testataan, että kaikki pelin säännöt pelin etenemisestä tai päättymisestä toimivat moitteettomasti. Lisäksi tarkistetaan, että pelinäkymän napit _Tyhjennä_ ja _Uusi peli_ toimivat oletetusti. Esimerkiksi siten, että käyttäjän tyhjentäessä peliruudukon uusi pelikierros alkaa käyttäjän pelivuorolla vain, jos aiemmin aloitussivulla käyttäjä valitsi pelimerkikseen X.

## Suorituskyvyn testaus

Tulossa...

(Miten? Mitkä syötteet? Graafinen kuvaus?)

## Koodin laadun testaus

Tulossa...

## Testauksen tulos jatkokehittelystä

Tulossa...
