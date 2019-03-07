# Testausdokumentti

Sovellusta testattiin niin automatisoiduin yksikkö- ja integraatiotestein JUnitilla kuin manuaalisesti järjestelmätason testeillä. Lisäksi testattiin sovelluksen suorituskykyä ja koodin laatua.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoidut testit koskevat sovelluslogiikkaa edustavia pakkauksia _ristinolla.domain_ ja _ristinolla.logics_. Testiluokka [SijaintiTesti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/test/java/ristinolla/tests/domain/SijaintiTesti.java) koskee käyttöliittymässä olevan peliruudukon nappien sijainteja tallentavan Sijainti-luokan yksikkötestejä, joiden tarkoituksena on varmistaa yksikkötason testien läpäisy. Vastaavasti testiluokat ArrayListTesti, RuudukkoTesti ja AlgoritmiTesti sisältävät nimensä mukaisten luokkien yksikkötestit. Sen sijaan pakkaukseen _ristinolla.logics_ liittyvä testiluokka [LogiikkaTesti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/test/java/ristinolla/tests/logics/LogiikkaTesti.java) toimii kokoavana integraatiotestinä siinä suhteessa, että testiluokka yhdistää eri tietorakenteita monimutkaisemmiksi toimintayksiköiksi ja seuraa niiden yhteistoiminnan onnistumista pelilogiikan taustalla.

Testit voidaan suorittaa komennolla

```
mvn test
```

### Testikattavuus

Sovelluksen käyttöliittymäpakkausta ja siihen kuuluvaa [RistinollaSovellus](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/ui/RistinollaSovellus.java)-luokkaa lukuun ottamatta testauksen rivi- ja haarautumakattavuus on vastaavanlainen:

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Testikattavuus_22_2.png" width="600">

Testikattavuusraportti voidaan luoda komennolla

```
mvn org.pitest:pitest-maven:mutationCoverage
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston _target/pit-reports/XXXXXXXXXXXX/index.html_, missä XXXXXXXXXXXX kuvaa automaattisesti luotua kattavuusraporttiin yhdistettävää numerosarjaa (luontihetken aikaleima vuosiluvusta kellonaikaan).

## Järjestelmätestaus

Sovelluksen järjestelmätestaus suoritettiin manuaalisesti seuraamalla sovelluksen käyttöohjeita sekä [Määrittelydokumentin](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md) tietoja suunnitellusta ohjelman tarjoamasta sovelluslogiikasta.

### Asennus ja konfigurointi

Sovelluksen käyttöönottoa testattiin sekä OSX- että Linux-pohjaisessa ympäristössä noudattamalla sovelluksesta esitettyjä käyttöohjeita.

### Toiminnallisuudet

Määrittelydokumentissa ilmoitetut ja sovellukseen toteutetut toiminnallisuudet rakennettiin ohessa aktiivisesti kaikkea luotavaa testaten. 

Sovelluksen aloitusnäkymästä käytiin läpi kaikki mieleen tulevat tilanteet ja syötevaihtoehdot. Samalla varmistettiin, ettei virheellistä syötettä - kuten peliruudukon valitun koon puuttumista - ole mahdollista tarjota ja päästä onnistuneesti jatkamaan pelinäkymään. Virheellisille syötteille luotiin kolme virheviestiä: _Valitse pelattava merkki_, _Valitse peliruudukon koko_ ja _Valitse pelimuoto_. Ainoa poikkeus on tilanne, jossa käyttäjä valitsee pelimuodoksi tietokoneen ohjaaman mallipelin, jolloin pelattavaa merkkiä ei vaadita valittavaksi. 

Vastaavasti pelinäkymässä testattiin, että kaikki pelin säännöt pelin etenemisestä tai päättymisestä toimivat moitteettomasti. Lisäksi tarkistettiin, että pelinäkymän napit _Tyhjennä_ ja _Uusi peli_ toimivat oletetusti. Esimerkiksi siten, että käyttäjän tyhjentäessä peliruudukon uusi pelikierros alkaa käyttäjän pelivuorolla vain, jos aiemmin aloitussivulla käyttäjä valitsi pelimerkikseen X.

## Suorituskyvyn testaus

Suorituskykytestaus kohdistui tekoälyn toteuttamiseen tarkoitettuun algoritmiin ja sen laskutehoon. Algoritmin toimintaa testattiin erilaisilla syötteillä, peliasetelmilla ja peliruudukon ko'oilla. Suorituskykytestaus piti sisällään niin algoritmin oikeanlaisen toiminnan testaamisen kuin algoritmin suoritusnopeuden testaamisen. Algoritmin suoritusnopeutta testattiin Javan System.nanoTime()-komennon avulla.

Kun pelattiin niin merkillä X kuin merkillä O eli joko käyttäjä aloittaa tai tietokone aloittaa, algoritmin nähtiin toimivan oikein ja laskenta-ajallisesti tehokkaasti. Tekoälyn ohjaama tietokonepelaaja ei anna kertaakaan käyttäjän voittaa, vaan lopputulos on joko tasapeli tai tietokoneen voitto. Algoritmin halutunlainen toiminta havaittiin myös silloin, kun valittiin mallipeli eli tietokone pelaamaan tietokonetta vastaan. Joka pelikierroksella päädyttiin tasapeliin.

Kun pelin tekoälyn toteuttavaa algoritmia testattiin eri pelitilanteissa eli eri koko- ja pelimerkkiyhdistelmillä, nähtiin, että pääosin tekoälyn siirron laskemiseen kuluu aikaa välillä 0-1ms. Tämä johtuu siitä, että riippumatta peliruudukon todellisesta koosta laskenta suoritetaan 3x3-kokoisella aputaulukolla, mikä nopeuttaa suoritusta huomattavasti. 

Laskenta-ajan osalta tärkein kysymys on se, miten paljon aikaa kuluu niin sanotun pelastavan siirron tekemiseen. Yleisesti tekoälyn siirto lasketaan edellisen X-pelimerkin siirron perusteella muodostettavasta 3x3-aputaulukosta. Kuitenkin pelissä, jossa käyttäjällä on pelimerkki O, hyödynnetään pelastavaa siirtoa. Nimittäin kun algoritmin aputaulukot muodostetaan tässä pelitilanteessa tekoälypelaajan omien siirtojen perusteella, on käyttäjällä suurempi vapaus luoda voittorivi (kyseessä ei ole tekoälyn puolustava pelitapa). Juuri ennen käyttäjän voittorivin saavuttamista tekoälypelaaja suorittaa pelastavan siirron eli selvittää siirtonsa koko peliruudukkoa läpikäyden. Tällöin läpikäytävien ruutujen määrä kasvaa.

Oheisessa taulukossa kerrotaan peliruudukon koko ja laskettu keskiarvo millisekunteina tietokonepelaajan ensimmäiselle puolustavalle siirrolle valitussa pelitilanteessa. Keskiarvo on laskettu aiheuttamalla tietokonepelaajan ensimmäinen puolustava siirto valitussa pelitilanteessa 10 kertaa ja laskemalla saatujen lukujen avulla keskiarvo. Testauksessa ei otettu huomioon peliruudukkoja 3x3 ja 4x4, sillä niiden pieni koko sekä pienempi määrä vapaita ruutuja ennen mahdollista puolustavaa siirtoa estää suoritusajan merkittävän kasvamisen.

Peliruudukon koko | Puolustavan siirron keskiarvo (ms) |
-----------|--------|
5x5 | 14,6 |
6x6 | 144,2 |
7x7 | 474,3 |
8x8 | 1 867,9 |

Kuten taulukosta huomataan, kasvaa tietokonepelaajalta ensimmäiseen puolustavaan siirtoon kuluva aika merkittävästi peliruudukon kasvamisen yhteydessä. Tämä aiheutuu algoritmin eksponentiaalisuudesta.

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Suorituskyky_testaus_graafi.png" width="600">

Yllä kuvatut testit voidaan toistaa ajamalla ohjelmakoodia. Algoritmin oikeanlainen toiminta havaitaan pelaamalla sovelluksen käyttöohjeita noudattamalla yllä kuvatuissa pelitilanteissa tietokonetta vastaan ja toteamalla, että tietokoneen voittaminen on mahdotonta. Samoin mallipelien nähdään aina johtavan tasapelitilanteeseen. Algoritmin suoritusnopeuden testaaminen voidaan toistaa seuraamalla pelikierroksen aikana konsoliin tulostuvia algoritmin suoritusaikaa kuvaavia lukuja. Voidaan esimerkiksi valita peliruudukon ko'oksi 4x4, käyttäjän pelimerkiksi X sekä pelimuodoksi yksinpeli (käyttäjä vastaan tietokone) ja testata 10 kertaa, miten paljon aikaa kuluu tietokonepelaajan ensimmäisen siirron selvittämiseen. Saaduista luvuista voidaan laskea suoritusnopeutta kuvaava keskiarvo.

## Koodin laadun testaus

### Checkstyle

Koodin laatua ja kirjoitusasua testattiin Checkstyle-pluginilla. Tiedostoon [checkstyle.xml](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/checkstyle.xml) määritellyt tarkistukset voidaan suorittaa komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedoston _target/site/checkstyle.html_
