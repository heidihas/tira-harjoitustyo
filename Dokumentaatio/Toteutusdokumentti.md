# Toteutusdokumentti

## Sovelluksen yleisrakenne

Sovelluksen rakenne käsittää kolme osaa: pelilogiikan, tietorakenteet ja käyttöliittymän. Kyseiset kolme osaa on toteutettu omiin hakemistoihinsa - _logics_, _domain_ ja _ui_. 

Näistä ensimmäisessä on pelin etenemisestä vastaava luokka [Logiikka](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/logics/Logiikka.java), joka muun muassa seuraa, onko pelin päättävä tapahtuma jo toteutunut, sekä kokoaa pelin etenemiseen tarvittavat aputietorakenteet ja hakualgoritmin yhteen. Luokka [Algoritmi](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/logics/Algoritmi.java) puolestaan sisältää tietokonepelaajan siirron selvittämiseen tarvittavan min-max-algoritmin ja sen apumetodit. Hakemistossa _domain_ on toteutettuna sovelluskoodissa hyödynnettävät tietorakenteet [ArrayList](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/ArrayList.java), [Ruudukko](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/Ruudukko.java) ja [Sijainti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/Sijainti.java). Tietorakenteista ArrayList vastaa Javan valmista ArrayList-luokkaa, Ruudukko ja Sijainti ovat puolestaan ristinollapeliä varten luodut omat tietorakenteet. Hakemistossa _ui_ on sovelluksen käyttöliittymästä vastaava luokka [RistinollaSovellus](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/ui/RistinollaSovellus.java), joka muodostaa JavaFX:llä graafisen käyttöliittymän.

## Toteutetut tietorakenteet ja algoritmi

Työhön toteutettiin tietorakenteet ArrayList, Ruudukko ja Sijainti. ArrayList vastaa toiminnoiltaan Javan valmista vastaavaa tietorakennetta. Lisäksi toteutettu ArrayList hyödyntää merge-sort-järjestelymetodia kokonaisluvuista koostuvien listojen järjestämiseen kasvavaan järjestykseen. Tietorakenne Ruudukko käsittää sovelluksen peliruudukon toteutuksen. Ruudukkoon voidaan tallentaa pelimerkkejä, se voidaan tyhjentää tai tulostaa. Tietorakenteen avulla peliruudukko saadaan lineaariseen muotoon. Sijainti-tietorakenne puolestaan vastaa graafisessa käyttöliittymässä olevien ruutunappien koordinaattien säilömisestä.

Näiden luotujen tietorakenteiden lisäksi pelilogiikka hyödyntää taulukkoja int[] rivit ja int[] riviMaarat pelitilanteen seuraamisessa. Kyseisiin taulukoihin tallennetaan tietoja liittyen peliruudukon riveihin: ensimmäinen taulukko kuvaa kunkin rivin pistetilannetta ja toinen taulukko kertoo kullakin rivillä olevien pelimerkkien määrän. Ensimmäisen taulukon pistetilanne lasketaan niin, että tyhjä rivi vastaa lukua 0, jokainen pelimerkki X kasvattaa arvoa yhdellä ja jokainen pelimerkki O vähentää arvoa yhdellä. Taulukoissa esiintyvät rivit ovat sekä vaakasuoraan, pystysuoraan tai viistoon kulkevia peliruudukon rivejä.

Sovellukseen toteutettiin min-max-algoritmi alfa-beta-karsinnalla. Min-max-algoritmin toiminta perustuu pelin jokaisen mahdollisen lopputuloksen läpikäymiseen annetusta peliruudukon tilasta käsin. Oletuksena on, että kumpikin pelaaja pelaa mahdollisimman hyvin. Eri reittejä pitkin saadut lopputulokset pisteytetään (vaihtoehtoina X:n voitto, O:n voitto tai tasapeli) ja tekoälyn ohjaamalle tietokonepelaajalle valitaan annetussa pelitilanteessa otollisin siirto.

Alfa-beta-karsinta nopeuttaa min-max-algoritmin läpikäyntiä, sillä se leikkaa pois ne hakupuun polut, joita pitkin ei päädyttäisi jo löydettyä parasta polkua parempaan lopputulokseen.

Lisäksi sovelluksen suoritusta nopeutetaan siten, että isommilla peliruudukoilla pelatessa ison peliruudukon läpikäymisen sijaan ruudukosta valitaan 3x3-kokoinen aliruudukko läpikäytäväksi. Peliruudukkojen kasvaessa nimittäin myös peliruudukon läpikäynti ja sovelluksen suoritus hidastuisi eksponentiaalisesti. Aliruudukko valitaan viimeisimmän asetetun X-pelimerkin perusteella.

Pelissä on myös tilanteita, jolloin yllä esitetty aliruudukkomenetelmä ei ole toimiva ratkaisu. Esimerkiksi aliruudukon ollessa täysi tai aliruudukon sisältäessä kolmen merkin pituisen "voittorivin" tekoäly ei antaisi tietokonepelaajalle uutta siirtoa, vaikka varsinaisessa isossa peliruudukossa olisi vielä mahdollisia siirtoja jäljellä. Toisaalta aliruudukkomenetelmä todettiin pulmalliseksi sellaisissa pelitilanteissa, joissa pelimerkillä O pelaava käyttäjä on yhtä merkkiä vaille voittamassa. 

Koska kuvatut pelitilanteet eivät voi tapahtua heti pelin alussa, on vastaaviin pelitilanteisiin pääsemiseksi suoritettu jo jonkin verran siirtoja. Kun vapaina olevien siirtojen määrä on pienentynyt, voidaan min-max-algoritmi suorittaa isolle peliruudukolle. Siirtojen väheneminen nimittäin laskee min-max-algoritmin suoritukseen kuluvaa aikaa. Min-max-algoritmi suoritetaan isolle peliruudukolle kuitenkin rajoittaen hakusyvyys lukuun 4, jotta esimerkiksi 8x8-kokoisilla peliruudukoilla algoritmin suoritukseen kuluisi mielekäs määrä aikaa.

## Saavutetut aika- ja tilavaativuudet

Tulossa kurssin lopussa...

## Saavutettu suorituskyky

Kuten [Testausdokumentissa](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Testausdokumentti.md) kuvaillaan, 

## Työn puutteet ja parannusehdotukset

Vaikka toteutetun sovelluksen tekoäly laskee tietokonepelaajan siirrot hyvin nopeassa ajassa ja pitää huolen siitä, ettei tietokonepelaaja anna käyttäjän voittaa, voitaisiin sovelluksen logiikkaa vielä parantaa. Nopean laskennan taustalla on 3x3-kokoisten aliruudukkojen avulla tietokonepelaajan seuraavan siirron selvittäminen. Nyt kullakin pelikierroksella aliruudukot muodostetaan joko käyttäjän siirtojen tai tietokonepelaajan siirtojen mukaan. Mielekkäämmässä toteutuksessa aliruudukkojen muodostaminen voisi vaihdella puolustavan ja voittoon tähtäävän pelitavan välillä tilanteen mukaan. Esimerkiksi toteutetussa sovelluksessa käyttäjän pelatessa merkillä O käyttäjällä on pelikierroksen alussa mahdollisuus vapaasti rakentaa pelimerkkiriviään ilman keskeytystä. Tietokonepelaaja suorittaa pelastavan siirron eli käyttäjän voiton estävän siirron vasta juuri viime hetkellä. Toisaalta käyttäjän pelatessa merkillä X tietokonepelaaja ei anna lähes ollenkaan käyttäjälle mahdollisuutta muodostaa pidempiä pelimerkkirivejä - tämä havaitaan selkeimmin suurilla peliruudukoilla testatessa.

Sovelluksen toteutuksessa tähdättiin siihen, että tietokonepelaaja pelaa mahdollisimman hyvin. Tästä syystä pelikierros loppuu joko tietokonepelaajan voittoon tai tasapeliin. Mikäli sovellus mukailisi laajemmin käytössä olevaa ristinollapeliä, tulisi käyttäjälle luoda mahdollisuus voittaa aina silloin tällöin, jotta sovelluksen käyttäminen tuntuisi mielekkäältä.

Mitä tulee sovelluksen graafiseen käyttöliittymään, mallipelissä olisi mukava nähdä vaiheittain etenevä pelikierros myös visuaalisesti. Tällä hetkellä sovellusikkunassa nähdään vain mallipelin lopputulos ja konsoliin tulostuu siirtojen sarja siirto kerrallaan. Koitin saada mallipelikierroksen animoitua käyttöliittymään, mutta JavaFX:n kanssa operoiminen ja viiveiden käyttö osoittautui hankalaksi. Hankaluudet JavaFX:n syntaksin kanssa aiheuttivat myös sen, että käyttäjän pelimerkin ilmestyminen valittuun ruudukon nappiin odottaa tietokonepelaajan siirtoa (siirrot ilmestyvät näkyviin yhtä aikaa). Kun laskentateho on suuri, ei tämä näy käyttäjälle ulospäin. Kuitenkin tekoälyn vaatiessa enemmän aikaa algoritmin suorittamiseen, huomataan käyttäjän siirron ilmestyvän peliruudukkoon viiveellä.

Työn yksikkötestien kattavuus on lähes täydellinen. Kuitenkin joistakin mutaatioista eroon pääseminen osoittautui hyvin hankalaksi. Tähän vaikutti se, että nämä mutaatiot liittyivät joko rekursiiviseen algoritmiin, privaattiin metodiin ja metodin sisäisiin apumuuttujiin.

## Lähteet
