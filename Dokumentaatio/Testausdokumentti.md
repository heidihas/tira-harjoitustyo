# Testausdokumentti

Sovellusta testataan niin automatisoiduin yksikkö- ja integraatiotestein JUnitilla kuin manuaalisesti järjestelmätason testeillä. Lisäksi testataan sovelluksen suorituskykyä.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoidut testit koskevat sovelluslogiikkaa edustavia pakkauksia _ristinolla.domain_ ja _ristinolla.logics_. Testiluokka [SijaintiTesti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/test/java/ristinolla/tests/domain/SijaintiTesti.java) koskee peliruutujen ja merkkien sijainteja tallentavan Sijainti-luokan yksikkötestejä, joiden tarkoituksena on varmistaa yksikkötason testien läpäisy. Sen sijaan pakkaukseen _ristinolla.logics_ liittyvä testiluokka [LogiikkaTesti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/test/java/ristinolla/tests/logics/LogiikkaTesti.java) toimii kokoavana integraatiotestinä: testiluokka yhdistää eri pelielementtejä monimutkaisemmiksi toimintayksiköiksi ja seuraa niiden yhteistoiminnan onnistumista.

### Testikattavuus

Sovelluksen käyttöliittymäpakkausta ja siihen kuuluvaa [RistinollaSovellus](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/ui/RistinollaSovellus.java)-luokkaa lukuun ottamatta testauksen rivi- ja haarautumakattavuus on vastaavanlainen:

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Testikattavuus_8_2.png">

## Järjestelmätestaus

Sovelluksen järjestelmätestaus suoritetaan manuaalisesti seuraamalla sovelluksen asennus- ja käyttöohjeita sekä [Määrittelydokumentin](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md) tietoja suunnitellusta ohjelman tarjoamasta sovelluslogiikasta.

### Asennus ja konfigurointi

Sovelluksen käyttöönottoa testataan sekä OSX- että Linux-pohjaisessa ympäristössä noudattamalla sovelluksesta esitettyjä asennus- ja käyttöohjeita.

### Toiminnallisuudet

Vaatimusmäärittelyssä ilmoitetut ja sovellukseen toteutetut toiminnallisuudet rakennettiin ohessa aktiivisesti kaikkea luotavaa testaten. Aloitussivulta käytiin läpi kaikki mieleen tulleet tilanteet ja syötevaihtoehdot. Samalla varmistettiin, ettei virheellistä syötettä - kuten tyhjää, vain välilyönneistä koostuvaa tai merkkimäärällisesti liian pitkää käyttäjänimeä - ole mahdollista tarjota ja päästä onnistuneesti jatkamaan pelinäkymään. Virheellisille syötteille luotiin kolme virheviestiä: _Maximum 8 characters_, _Choose different names_ ja _Choose level_. Vastaavasti pelinäkymässä testattiin, että kaikki pelin säännöt pallon kimpoamisesta pelin voittamiseen toimivat moitteettomasti. Lopetussivun osalta tarkistettiin, että kolme nappia _Re-start_, _New game_ ja _End game_ toimivat kukin oletetusti. Esimerkiksi siten, että uuden pelikierroksen alkaessa pallon etenemisnopeus on taas alustettu valitun vaikeustason mukaisesti eikä pallo jatka sillä nopeudella, jonka se edellisellä pelikierroksella ehti saavuttaa.

## Suorituskyvyn testaus

Tulossa...

## Testauksen tulos jatkokehittelystä

Tulossa...
