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

Suorituskykytestaus kohdistui tekoälyn toteuttamiseen tarkoitettuun algoritmiin ja sen laskutehoon. Algoritmin toimintaa testattiin erilaisilla syötteillä, peliasetelmilla ja peliruudukon ko'oilla. Suorituskykytestaus pitää sisällään niin algoritmin oikeanlaisen toiminnan testaamisen kuin algoritmin suoritusnopeuden testaamisen. Algoritmin suoritusnopeutta testattiin Javan System.nanoTime()-komennon avulla.

Kun pelattiin niin merkillä X kuin merkillä O eli joko käyttäjä aloittaa tai tietokone aloittaa, algoritmin nähtiin toimivan oikein ja tehokkaasti. Tekoälyn ohjaama tietokonepelaaja ei anna kertaakaan käyttäjän voittaa, vaan lopputulos on joko tasapeli tai tietokoneen voitto. Algoritmin halutunlainen toiminta havaittiin myös silloin, kun valittiin mallipeli eli tietokone pelaamaan tietokonetta vastaan. Joka pelikierroksella päädyttiin tasapeliin.

Kun pelin tekoälyn toteuttavaa algoritmia testattiin eri pelitilantein, saatiin tuloksista alla oleva taulukko. Taulukossa kerrotaan käyttäjän valitsema merkki (X pelaa ensin), peliruudukon koko ja laskettu keskiarvo tietokonepelaajan ensimmäiseen siirtoon valitussa pelitilanteessa kuluvasta ajasta millisekunteina. Keskiarvo on laskettu suorittamalla tietokonepelaajan ensimmäinen siirto valitussa pelitilanteessa 10 kertaa ja vertaamalla saatuja lukuja.

Valittu pelimerkki       | Peliruudukon koko | Ensimmäisen siirron keskiarvo (ms) |
-----------|------|--------|
X | 3x3 | 2 |
O | 3x3 | 1,9 |
X | 4x4 | 10 629 |
O | 4x4 | 5470 |

Kuten taulukosta huomataan, kasvaa tietokonepelaajalta ensimmäiseen siirtoon kuluva aika merkittävästi peliruudukon kasvamisen yhteydessä. Tietokonepelaajan siirtoon kuluva aika on ilmaistu ainoastaan tietokonepelaajan ensimmäisestä siirrosta, sillä toisesta siirrosta eteenpäin kaikissa tapauksissa aikaa kuluu alle sekunti eli algoritmi toimii nopeasti. Tapauksissa, joissa tietokonepelaaja pelaa ensin eli tietokonepelaajalla on pelimerkki X, keskiarvo on laskettu tietokonepelaajan toisesta siirrosta, sillä ensimmäinen siirto tyhjään peliruudukkoon toteutetaan sattumanvaraisesti eikä algoritmilla.?????????

Yllä kuvatut testit voidaan toistaa ajamalla ohjelmakoodia. Algoritmin oikeanlainen toiminta havaitaan pelaamalla sovelluksen käyttöohjeita noudattamalla yllä kuvatuissa pelitilanteissa tietokonetta vastaan ja toteamalla, että tietokoneen voittaminen on mahdotonta. Samoin mallipelien nähdään aina johtavan tasapelitilanteeseen. Algoritmin suoritusnopeuden testaaminen voidaan toistaa seuraamalla pelikierroksen aikana konsoliin tulostuvia algoritmin suoritusaikaa kuvaavia lukuja. Voidaan esimerkiksi valita peliruudukon ko'oksi 3x3, käyttäjän pelimerkiksi X sekä pelimuodoksi yksinpeli (käyttäjä vastaan tietokone) ja testata 10 kertaa, miten paljon aikaa kuluu tietokonepelaajan ensimmäisen siirron selvittämiseen. Saaduista luvuista voidaan laskea suoritusnopeutta kuvaava keskiarvo.

(Graafinen kuvaus?)

## Koodin laadun testaus

### Checkstyle

Koodin laatua ja kirjoitusasua testattiin Checkstyle-pluginilla. Tiedostoon [checkstyle.xml](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/checkstyle.xml) määritellyt tarkistukset voidaan suorittaa komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedoston _target/site/checkstyle.html_
