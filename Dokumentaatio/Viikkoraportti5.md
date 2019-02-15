# Viikkoraportti 5

[Tuntiraportti](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Tuntiraportti.md)

Tunteja yhteensä tällä viikolla: 19

## Viikolla tehtyä
- Alfa-beeta-karsinnan toteutus
- Peliruudukon rivien tallentaminen yhteen taulukkoon
- Nopeampi tapa tarkistaa mahdollinen voitto rivitaulukon avulla
- Peliruudukon muuttaminen lineaariseksi taulukoksi
- Oman tietorakenteen Ruudukko luominen
- Algoritmin debuggaaminen, eri versioiden laatiminen ja alfa-beeta-karsinnasta lukeminen
- Algoritmin pilkkominen ja muokkaaminen
- AlfaBeeta-luokan ja sitä vastaavan RuudukkoAlfaBeeta-luokan luominen
- Suorituskykytestauksen suorittaminen
- Testausdokumentin päivittäminen
- Testien muokkaaminen
- Koodin siistiminen ja kommentointi
- Vertaisarvio

## Mitä opin tällä viikolla
Opin tällä viikolla alfa-beeta-karsinnan toteuttamisesta ja algoritmin suorituskyvyn testaamisesta. Luin eri lähteistä alfa-beeta-karsinnan toteuttamisesta eri konteksteissa ja opin hahmottamaan, mikä ero toteutustavoilla on. Opin myös uutta tekemällä toisen opiskelijan työstä vertaisarvion. Koska arvioimani työn aihe oli hyvin erilainen kuin omani, käytin paljon aikaa siihen perehtymiseen.

## Mikä oli haastavaa
Koin haastavaksi algoritmin tehokkuuden hiomisen ja osittain myös vertaisarvion laatimisen. Käytin hyvin paljon tunteja alfa-beeta-karsinnan hiomiseen, siitä lukemiseen ja sen muokkaamiseen. Silti edelleen 4x4-ruudukkoa isommilla peliruudukoilla pelaaminen ei onnistu. Parannusideani alkavat loppua.. Vertaisarvion laatiminen puolestaan tuntui hieman haastavalta siksi, että arvioitava työ oli hyvin laaja ja tehty eri aiheesta kuin omani. Jouduin käyttämään useamman tunnin työhön perehtymiseen, jotta sain kirjoitettua tarkoituksenomaista palautetta.

## Seuraavan viikon tavoitteet
Koodia tällä viikolla muokatessani jouduin lisäämään valmiin List-tietorakenteen, josta pyrin pääsemään eroon ensi viikolla. Lisäksi aion jatkaa algoritmini tehokkuuden hiomista.

## Kysymyksiä ja palautetta ohjaajalle
Olen tähän mennessä toteuttanut minmax-algoritmin ja alfa-beeta-karsinnan laajennettuun ristinollaan. Kuitenkin 4x4-peliruudukkoja isommilla ruudukoilla pelaaminen ei onnistu, peli jumittuu laskemaan. Olisiko suuremmilla peliruudukoilla mahdollista, että tekoälyn ensimmäinen/pari ensimmäistä siirtoa olisivat satunnaisia ja vasta sitten alettaisiin käyttää algoritmia siirtojen selvittämiseen? Yksi vaihtoehto olisi myös laittaa aikaraja algoritmille ja aikarajan umpeuduttua valita siihen mennessä paras löydetty siirto. En tosin tiedä, olisiko tämä tarkoituksenomaista. Mahtaisiko laskentaa nopeuttaa se, että suuremmissa peliruudukoissa vaaditaan vain 3 vierekkäistä merkkiä voittoon? Tällä hetkellä 4x4-ruudukossa vaaditaan 4 merkkiä, 5x5-ruudukossa vaaditaan 5 merkkiä jne.
Olen muokannut läpikäytävän peliruudukkotaulukon lineaariseksi, pistetilanteen tarkistamisen peliruudukon riveistä koostuvan taulukon läpikäymiseksi ja siirtojen läpikäynnin ottamaan huomioon vain kulloinkin vapaana olevat ruudut (turhat karsittu). Silti alfa-beeta-karsinnan toteuttamisen jälkeenkin algoritmi ei toimi 4x4-peliruudukkoa isommilla ruudukoilla. Parannusideani alkavat olla vähissä, vaikka olen lukenut paljon lisätietoa aiheesta. Suurimmassa osassa lähteitä käsitellään vain tapausta 3x3-kokoinen peliruudukko.
