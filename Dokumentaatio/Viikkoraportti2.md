# Viikkoraportti 2

[Tuntiraportti](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Tuntiraportti.md)

Tunteja yhteensä tällä viikolla: 38

## Viikolla tehtyä
- Käyttöliittymän valikko ja pelinäkymä
- 3x3-peliruudukon nappien toiminnallisuus
- Toimiva 3x3-ristinolla
- JavaFX:llä aloitettu toiminnallisuus laajennetun peliruudukon tuottamiseen
- Minmax-algoritmi
- Pelilogiikka erillisessä tiedostossa
- Sijainti-luokka
- JavaDoc-kommentit luoduista luokista ja metodeista
- Yksikkötestit muusta kuin pelinäkymän luomisesta vastaavasta luokasta

## Mitä opin tällä viikolla
Opin tällä viikolla lisää JavaFX:llä käyttöliittymän rakentamisesta. Koska kohtasin tältä osin haasteita (lue alla olevasta kohdasta), jouduin tutustumaan perusteellisemmin JavaFX:stä kirjoitettuihin materiaaleihin. Lisäksi käytin paljon aikaa minmax-algoritmin ensimmäisen version toteuttamiseen ja minmax-algoritmista opiskeluun. En vielä osaa sanoa, toimiiko koodi, sillä aikani loppui minmax-algoritmin osalta kesken. Tiedän siis kurssimateriaalista lukemani perusteella, että periaatteessa koodin pitäisi johtaa haluttuun lopputulokseen.

## Mikä oli haastavaa
Koin haastavaksi JavaFX:llä toteuttamani käyttöliittymän muokkaamisen laajennetun ristinollan tapaukseen. Kovakoodatun 3x3-peliruudukon toiminnallisuus toimii, mutta käyttäjän syöttäessä haluamansa peliruudukon koon peliruudukkoon piirtyy toivottu määrä nappeja (tällä hetkellä ei toiminnassa, sillä kommentoin pois tarvittavan metodin), jotka eivät toimi. Napit eivät reagoi eikä niihin välity tieto pelattavasta merkistä. Koska tällä hetkellä käyttöliittymään ei ole yhdistetty erilliseen tiedostoon luotua pelilogiikkaa, en vielä tiedä, toimiiko minmax-algoritmi tavoitteellisesti luodussa käyttöliittymässä.

## Seuraavan viikon tavoitteet
Seuraavalla viikolla pyrin yhdistämään luomani käyttöliittymän ja pelilogiikan. Koitan saada tekoälyn toimimaan osana käyttöliittymässä kuvattua peliä. Lisäksi koitan uudemman kerran saada toimimaan sen, että käyttäjän valitsema peliruudukon koko toteutuu ongelmitta.

## Kysymyksiä ja palautetta ohjaajalle
Haluaisin tiedustella, millainen käyttöliittymä on harjoitustyön osalta tavoitteellinen. Mistä voisin saada lisätietoa siitä, miten JavaFX:ssä käyttäjältä saatua syötettä käytetään osana peliruudukon toteuttamista (valittu koko)? Olisiko käytettävä jonkinlaista AnimationTimeriin rinnastuvaa menetelmää?
