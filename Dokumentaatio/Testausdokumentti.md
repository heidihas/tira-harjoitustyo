# Testausdokumentti

Sovellusta testataan niin automatisoiduin yksikkö- ja integraatiotestein JUnitilla kuin manuaalisesti järjestelmätason testeillä. Lisäksi testataan sovelluksen suorituskykyä.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Huomattava enemmistö luoduista automatisoiduista testeistä koskee sovelluslogiikkaa edustavia pakkauksia _pong.domain_ ja _pong.logics_. Testiluokat [BallTest](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/test/java/pong/tests/domain/BallTest.java), [MovementTest](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/test/java/pong/tests/domain/MovementTest.java), [PaddleTest](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/test/java/pong/tests/domain/PaddleTest.java), [PlayerTest](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/test/java/pong/tests/domain/PlayerTest.java) ja [ScoreTest](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/test/java/pong/tests/domain/ScoreTest.java) käsittävät kukin nimensä osoittaman pelielementtiluokan yksikkötestejä, joiden tarkoituksena on varmistaa yksikkötason testien läpäisy. Sen sijaan pakkaukseen _pong.logics_ liittyvä testiluokka [PongLogicsTest](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/test/java/pong/tests/logics/PongLogicsTest.java) toimii kokoavana integraatiotestinä: testiluokka yhdistää eri pelielementtejä monimutkaisemmiksi toimintayksiköiksi ja seuraa niiden yhteistoiminnan onnistumista. Koska nimenomaan sovelluksen luokka [PongLogics](https://github.com/heidihas/otm-harjoitustyo/blob/master/Pong/src/main/java/pong/logics/PongLogics.java) vastaa pelin sovelluslogiikan toimivuudesta ja tapahtumien yhdistämisestä, on menettelytapa mielekäs.

### Testikattavuus

Sovelluksen käyttöliittymäpakkausta ja siihen kuuluvaa RistinollaSovellus-luokkaa lukuun ottamatta testauksen rivi- ja haarautumakattavuus on vastaavanlainen:

<img src="https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Kuvia/Testikattavuus_8_2.png">

## Järjestelmätestaus

Sovelluksen järjestelmätestaus suoritetaan manuaalisesti seuraamalla sovelluksen asennus- ja käyttöohjeita sekä ?? tietoja ohjelman tarjoamasta sovelluslogiikasta.

### Asennus ja konfigurointi

Sovelluksen käyttöönottoa testataan sekä OSX- että Linux-pohjaisessa ympäristössä noudattamalla sovelluksesta esitettyjä asennus- ja käyttöohjeita.

### Toiminnallisuudet

Vaatimusmäärittelyssä ilmoitetut ja sovellukseen toteutetut toiminnallisuudet rakennettiin ohessa aktiivisesti kaikkea luotavaa testaten. Aloitussivulta käytiin läpi kaikki mieleen tulleet tilanteet ja syötevaihtoehdot. Samalla varmistettiin, ettei virheellistä syötettä - kuten tyhjää, vain välilyönneistä koostuvaa tai merkkimäärällisesti liian pitkää käyttäjänimeä - ole mahdollista tarjota ja päästä onnistuneesti jatkamaan pelinäkymään. Virheellisille syötteille luotiin kolme virheviestiä: _Maximum 8 characters_, _Choose different names_ ja _Choose level_. Vastaavasti pelinäkymässä testattiin, että kaikki pelin säännöt pallon kimpoamisesta pelin voittamiseen toimivat moitteettomasti. Lopetussivun osalta tarkistettiin, että kolme nappia _Re-start_, _New game_ ja _End game_ toimivat kukin oletetusti. Esimerkiksi siten, että uuden pelikierroksen alkaessa pallon etenemisnopeus on taas alustettu valitun vaikeustason mukaisesti eikä pallo jatka sillä nopeudella, jonka se edellisellä pelikierroksella ehti saavuttaa.

## Suorituskyvyn testaus

Tulossa...

## Testauksen tulos jatkokehittelystä

Tulossa...
