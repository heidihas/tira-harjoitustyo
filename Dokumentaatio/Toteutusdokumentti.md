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

Ohessa eritellään sovelluksen eri osien aika- ja tilavaativuuksia.

### ArrayList

Add-metodin aikavaativuus on yleensä vakio eli O(1), mutta tapauksissa, joissa listaa pitää kasvattaa, aikavaativuus on O(n). Kasvatuksen yhteydessä listan tilavaativuus kaksinkertaistuu.

Replace-, clear-, get-, size-, isEmpty ja getCapacity-metodit ovat vakioaikaisia eli O(1).

Metodit remove, get ja contains ovat aikavaativuuksiltaan O(n), sillä kunkin kohdalla pahimmassa tapauksessa joudutaan käymään for-loopilla läpi kaikki listan alkiot.

Merge-sort-järjestelymenetelmä eli lomitusjärjestäminen on aikavaativuudeltaan O(nlog n), sillä sen merge-osa saa for-loopin osalta aikavaativuudekseen O(n) ja sen rekursiosyvyys on log n, kuten Tira-kurssin materiaalissa todetaan. Tällöin kokonaisaikavaativuudeksi saadaan O(nlog n). Lomitusjärjestämisen tilavaativuus on puolestaan O(n), joka saadaan sen merge-osasta.

ArrayList-luokan tilavaativuus on O(n), sillä se riippuu listan kapasiteetista.

### Ruudukko

Lähes kaikki Ruudukko-luokan metodit ovat vakioaikaisia eli aikavaativuudella O(1). Metodit tyhjenna ja tulosta käyvät läpi koko tallennettavan ruudukon, joten niiden aikavaativuudeksi saadaan O(n) ruudukkoon tallennettujen alkioiden määrän mukaan.

Ruudukko-luokan tilavaativuus on O(n), sillä se riippuu ruudukkoon mahtuvista ruuduista.

### Sijainti

Sekä Sijainti-luokan tila- että aikavaativuus on vakio O(1).

### Algoritmi

Metodien xVoitti ja oVoitti aikavaativuudet ovat muotoa O(2n+2) eli O(n), missä n kuvaa peliruudukon sivun pituutta. Samoin metodin peliOhi aikavaativuudeksi saadaan O(n), koska siinä on samankokoinen for-looppi kuin metodissa xVoitti tai oVoitti ja koska tämän for-loopin jälkeen vasta peräkkäin suoritetaan metodit xVoitti ja oVoitti mahdollisen voittajan selvittämiseksi. Metodin peliOhi tilavaativuus on O(n), sillä se riippuu voittomahdollisuuksien eli mahdollisten voittavien rivien määrästä.

Metodin getVapaat aikavaativuus voidaan ilmaista joko O(nn), missä n kuvaa peliruudukon sivun pituutta, tai O(m), missä m kuvaa peliruudukon ruutujen määrää. Metodin tilavaativuus on myös O(nn) tai O(m).

Metodit asetaSiirtoMinMax ja poistaSiirtoMinMax ovat sekä aika- että tilavaativuuksiltaan vakioita O(1), sillä metodit koostuvat vain ehtolauseista ja vakioaikaisista tallennustoimituksista sekä säilövät vain muutaman muuttujan verran tietoa.

Metodit score ja arvioi ovat aikavaativuudeltaan O(n). Metodi score koostuu lähinnä vakioaikaisista komennoista, mutta metodin arvioi kutsuminen vaikuttaa merkittävästi sen kokonaisaikavaativuuteen. Metodin arvioi aikavaativuus on for-loopin vuoksi O(n).

Kuten Määrittelydokumentissa todettiin, min-max-algoritmin toteuttaminen alfa-beta-karsinnalla on aikavaativuudeltaan edelleen eksponentiaalinen riippumatta siitä, että käytännössä suoritus nopeutuu. Aikavaativuus O(s^n), missä s kuvaa siirtomahdollisuuksia ja n hakupuun syvyyttä, nähdään toteutetusta koodista. Min-max-algoritmi on metodeista minmaxAlfaBeeta, max ja min koostuva kokonaisuus. Koodin selkeyden vuoksi ne on pilkottu omiksi osikseen. Jokaisen mahdollisen siirron osalta käydään hakupuuta läpi syvyyteen n asti. Syvyys n on tässä rajattu maxSyvyydeksi. Jos siirron muistiin tallentamiseen oletetaan kuluvan vakiomäärä aikaa v ja tiedetään, että pahimmassa tapauksessa alimmalla hakusyvyydellä siirtoja eli hakupuun lehtiä on määrä s^n, aikaa kuluu yhteensä v x s^n. Tällöin pahimman tapauksen aikavaativuus on O(v x s^n), joka saadaan muotoon O(s^n) v:n ollessa vakio. 

MinmaxAlfaBeeta-metodin tilavaativuus on O(sn). Tämä nähdään siitä, että eri rekursiotasanteella siirtojen määrä on s. Jos yhden siirron oletettu tilavaativuus on vakio v, vievät mahdolliset siirrot yhdellä rekursiotasanteella tilaa sv. Tämä pitää vielä kertoa rekursioiden määrällä eli hakusyvyydellä n. Saadaan O(svn) = O(v x (sn)) mikä supistuu muotoon O(sn) v:n ollessa vakio.

### Logiikka

Metodien asetaSiirto, alitaulukko ja eli gettereiden aikavaativuus on vakio O(1). Näistä alitaulukko-metodin tilavaativuus on O(n) riippuen alitaulukkoon tallennettavien alkioiden määrästä (nyt määrä on vakio 9).

Metodit peliOhi, xVoitti ja oVoitti vastaavat yllä käsitellyn Algoritmi-luokan vastaavannimisiä metodeja, jolloin ne saavat samat aika- ja tilavaativuudet. Myös metodin alustaAlitaulukko aikavaativuudeksi tulee for-loopin johdosta O(n).

Pelaa-metodi hyödyntää monia Logiikka-luokan metodeja sekä sovelluksen tietorakenteita. Kuitenkin näistä eniten aikaa vievä ja raskain on yllä käsitelty Algoritmi-luokan metodi minmaxAlfaBeeta, jolloin pelaa-metodin kokonaisaikavaativuudeksi saadaan minmaxAlfaBeeta-metodin aikavaativuus. Metodin tilavaativuus riippuu ruudukkoa ja rivejä mallintavien tietorakenteiden ko'oista sekä minmaxAlfaBeeta-algoritmin vaatimasta tilavaativuudesta.

_Käyttöliittymän eli luokan RistinollaSovellus metodit jätetään käsittelemättä._

Koska kaikista suurin aikavaativuus on min-max-algoritmin suorituksella, on koko sovelluksen pyörittämisen aikavaativuus riippuvainen min-max-algoritmin aikavaativuudesta.

## Saavutettu suorituskyky

[Testausdokumentissa](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Testausdokumentti.md) kuvaillaan saavutettua suorituskykyä perusteellisesti. Dokumentissa todetaan, että sovelluksen toiminta ja min-max-algoritmin laskenta on hyvin tehokasta: tietokonepelaaja ei anna koskaan käyttäjän voittaa, pelikierros päättyy joko tietokonepelaajan voittoon tai tasapeliin ja mallipelin tapauksessa jokainen lopputulema on tasapeli (tietokone pelaa mahdollisimman hyvin itseään vastaan). 

Lisäksi testausdokumentissa todetaan, että hakualgoritmin suoritusaikaa mitattaessa keskiarvoksi jokaiselle tekoälyn suorittamalle siirrolle saadaan luku välillä 0-1ms, kun min-max-algoritmi ajetaan peliruudukosta muodostetulle 3x3-kokoiselle aliruudukolle. Isolla peliruudukolla hakemista vältellään, sillä peliruudukon kasvaessa algoritmin suoritusaika kasvaa merkittävästi. Toisaalta min-max-algoritmin ajaminen hakusyvyysrajoituksella aivan pelin alusta lähtien todettiin tällaista ratkaisua testatessa puutteelliseksi - menetelmä ei johtanut mielekkäisiin pelitilanteisiin.

Testausdokumentissa mainitaan, että joissain pelitilanteissa min-max-algoritmi ajetaan isolle peliruudukolle hakusyvyyttä rajoittaen. Suorituskykytestin kautta nähtiin, että näissä tapauksissa hakualgoritmin suoritusaika kasvaa eksponentiaalisesti peliruudukon koon kasvaessa. Kuitenkin hakusyvyyden rajoittaminen saa aikaan sen, että käytännössä isoillakin peliruudukoilla min-max-algoritmin suorittamiseen kuluu mielekäs määrä aikaa.

## Työn puutteet ja parannusehdotukset

Vaikka toteutetun sovelluksen tekoäly laskee tietokonepelaajan siirrot hyvin nopeassa ajassa ja pitää huolen siitä, ettei tietokonepelaaja anna käyttäjän voittaa, voitaisiin sovelluksen logiikkaa vielä parantaa. Nopean laskennan taustalla on 3x3-kokoisten aliruudukkojen avulla tietokonepelaajan seuraavan siirron selvittäminen. Nyt kullakin pelikierroksella aliruudukot muodostetaan joko käyttäjän siirtojen tai tietokonepelaajan siirtojen mukaan. Mielekkäämmässä toteutuksessa aliruudukkojen muodostaminen voisi vaihdella puolustavan ja voittoon tähtäävän pelitavan välillä tilanteen mukaan. Esimerkiksi toteutetussa sovelluksessa käyttäjän pelatessa merkillä O käyttäjällä on pelikierroksen alussa mahdollisuus vapaasti rakentaa pelimerkkiriviään ilman keskeytystä. Tietokonepelaaja suorittaa pelastavan siirron eli käyttäjän voiton estävän siirron vasta juuri viime hetkellä. Toisaalta käyttäjän pelatessa merkillä X tietokonepelaaja ei anna lähes ollenkaan käyttäjälle mahdollisuutta muodostaa pidempiä pelimerkkirivejä - tämä havaitaan selkeimmin suurilla peliruudukoilla testatessa.

Sovelluksen toteutuksessa tähdättiin siihen, että tietokonepelaaja pelaa mahdollisimman hyvin. Tästä syystä pelikierros loppuu joko tietokonepelaajan voittoon tai tasapeliin. Mikäli sovellus mukailisi laajemmin käytössä olevaa ristinollapeliä, tulisi käyttäjälle luoda mahdollisuus voittaa aina silloin tällöin, jotta sovelluksen käyttäminen tuntuisi mielekkäältä.

Mitä tulee sovelluksen graafiseen käyttöliittymään, mallipelissä olisi mukava nähdä vaiheittain etenevä pelikierros myös visuaalisesti. Tällä hetkellä sovellusikkunassa nähdään vain mallipelin lopputulos ja konsoliin tulostuu siirtojen sarja siirto kerrallaan. Koitin saada mallipelikierroksen animoitua käyttöliittymään, mutta JavaFX:n kanssa operoiminen ja viiveiden käyttö osoittautui hankalaksi. Hankaluudet JavaFX:n syntaksin kanssa aiheuttivat myös sen, että käyttäjän pelimerkin ilmestyminen valittuun ruudukon nappiin odottaa tietokonepelaajan siirtoa (siirrot ilmestyvät näkyviin yhtä aikaa). Kun laskentateho on suuri, ei tämä näy käyttäjälle ulospäin. Kuitenkin tekoälyn vaatiessa enemmän aikaa algoritmin suorittamiseen, huomataan käyttäjän siirron ilmestyvän peliruudukkoon viiveellä.

Työn yksikkötestien kattavuus on lähes täydellinen. Kuitenkin joistakin mutaatioista eroon pääseminen osoittautui hyvin hankalaksi. Tähän vaikutti se, että nämä mutaatiot liittyivät joko rekursiiviseen algoritmiin, privaattiin metodiin ja metodin sisäisiin apumuuttujiin.

## Lähteet

Tira-kurssin luentomateriaali (sivut 106-122, Lomitusjärjestäminen; sivut 394-400, Pelipuu)
https://www.geeksforgeeks.org/merge-sort/ (luettu 8.3. klo 21:24)
https://courses.cs.washington.edu/courses/cse573/12au/slides/04-minmax.pdf (luettu 8.3. klo 22:00)
https://stackoverflow.com/questions/2080050/determining-time-and-space-complexity (luettu 8.3. klo 22:40)
