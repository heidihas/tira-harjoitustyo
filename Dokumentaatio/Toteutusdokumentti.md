# Toteutusdokumentti

## Sovelluksen yleisrakenne

Sovelluksen rakenne käsittää kolme osaa: pelilogiikan, tietorakenteet ja käyttöliittymän. Kyseiset kolme osaa on toteutettu omiin hakemistoihinsa - _logics_, _domain_ ja _ui_. 

Näistä ensimmäisessä on pelin etenemisestä vastaava luokka [Logiikka](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/logics/Logiikka.java), joka muun muassa seuraa, onko pelin päättävä tapahtuma jo toteutunut, sekä kokoaa pelin etenemiseen tarvittavat aputietorakenteet ja hakualgoritmin yhteen. Luokka [Algoritmi](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/logics/Algoritmi.java) puolestaan sisältää tietokonepelaajan siirron selvittämiseen tarvittavan min-max-algoritmin ja sen apumetodit. Hakemistossa _domain_ on toteutettuna sovelluskoodissa hyödynnettävät tietorakenteet [ArrayList](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/ArrayList.java), [Ruudukko](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/Ruudukko.java) ja [Sijainti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/Sijainti.java). Tietorakenteista ArrayList vastaa Javan valmista ArrayList-luokkaa, Ruudukko ja Sijainti ovat puolestaan ristinollapeliä varten luodut omat tietorakenteet. Hakemistossa _ui_ on sovelluksen käyttöliittymästä vastaava luokka [RistinollaSovellus](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/ui/RistinollaSovellus.java), joka muodostaa JavaFX:llä graafisen käyttöliittymän.

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
