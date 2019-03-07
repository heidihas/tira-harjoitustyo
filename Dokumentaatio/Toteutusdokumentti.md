# Toteutusdokumentti

## Sovelluksen yleisrakenne

Sovelluksen rakenne käsittää kolme osaa: pelilogiikan, tietorakenteet ja käyttöliittymän. Kyseiset kolme osaa on toteutettu omiin hakemistoihinsa - _logics_, _domain_ ja _ui_. 

Näistä ensimmäisessä on pelin etenemisestä vastaava luokka [Logiikka](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/logics/Logiikka.java), joka muun muassa seuraa, onko pelin päättävä tapahtuma jo toteutunut, sekä kokoaa pelin etenemiseen tarvittavat aputietorakenteet ja hakualgoritmin yhteen. Luokka [Algoritmi](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/logics/Algoritmi.java) puolestaan sisältää tietokonepelaajan siirron selvittämiseen tarvittavan min-max-algoritmin ja sen apumetodit. Hakemistossa _domain_ puolestaan on toteutettuna sovelluskoodissa hyödynnettävät tietorakenteet [ArrayList](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/ArrayList.java), [Ruudukko](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/Ruudukko.java) ja [Sijainti](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/domain/Sijainti.java). Tietorakenteista ArrayList vastaa Javan valmista ArrayList-luokkaa, Ruudukko ja Sijainti ovat puolestaan ristinollapeliä varten luodut omat tietorakenteet. Hakemistossa _ui_ on sovelluksen käyttöliittymästä vastaava luokka [RistinollaSovellus](https://github.com/heidihas/tira-harjoitustyo/blob/master/TiraHarjoitustyo/src/main/java/ristinolla/ui/RistinollaSovellus.java), joka muodostaa JavaFX:llä graafisen käyttöliittymän.

## Saavutetut aika- ja tilavaativuudet

Tulossa kurssin lopussa...

## Saavutettu suorituskyky

Tulossa kurssin lopussa...

## Työn puutteet ja parannusehdotukset

Tulossa kurssin lopussa...

## Lähteet
