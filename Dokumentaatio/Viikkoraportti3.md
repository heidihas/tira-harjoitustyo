# Viikkoraportti 3

[Tuntiraportti](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Tuntiraportti.md)

Tunteja yhteensä tällä viikolla: 15

## Viikolla tehtyä
- JavaFX:stä lukeminen
- Minmax-algoritmin toimintaan ja toteuttamiseen tarkempi perehtyminen
- Pelilogiikan ja käyttöliittymän yhdistäminen
- Minmax-algoritmin muokkaaminen
- Virheiden etsiminen
- Yksikkötestien muokkaaminen

## Mitä opin tällä viikolla
Opin pelilogiikan ja käyttöliittymän yhdistämisestä. Sovelluksen toiminnassa havaitsemani virheellisen toiminnan vuoksi jouduin perehtymään vielä tarkemmin minmax-algoritmin toimintaan. Tutustuin tapahtuvaan lisäämällä monia tulostuksia koodiin ja onnistuin löytämään virheen. Opin lisää toteuttamastani minmax-algoritmista, vaikka en onnistunut vielä selvittämään virheitä.

## Mikä oli haastavaa
Minmax-algoritmissa olevien virheiden löytäminen osoittautui hankalaksi. Yhdistin tällä viikolla pelilogiikan aiemmin luomaani 3x3-peliruudun tuottavaan käyttöliittymään. Huomasin peliä testatessani, ettei tekoäly toimi halutulla tavalla: tietokone ei valitse parasta mahdollista peliruutua, ei estä käyttäjää voittamasta ja joissain tapauksissa laittaa merkin samaan ruutuun peliruudukossa jo olemassa olevan merkin kanssa. Lisäsin monia tulostuksia ja huomasin, ettei minmax-algoritmi käy läpi kaikkia mahdollisia siirtoja. Yritin selvittää virheen korjaamista, mutta en saanut koodia toimimaan.

## Seuraavan viikon tavoitteet
Minmax-algoritmin parantaminen, laajennetun ristinollan toteuttamisen jatkaminen (käyttäjän valitsema koko), alfa-beeta-karsinnan toteuttamiseen tarkempi tutustuminen.

## Kysymyksiä ja palautetta ohjaajalle
Mistä voisin saada lisätietoa siitä, miten JavaFX:ssä käyttäjältä saatua syötettä käytetään osana peliruudukon toteuttamista (ensimmäisessä näkymässä valittu koko toteutuu nappien lisäämisen osalta mutta napit eivät reagoi - start-metodissa pelinäkymälle valmiiksi määritelty nappien toiminta ei toimi, kun nappien määrä muuttuu)? Olisiko käytettävä jonkinlaista AnimationTimeriin rinnastuvaa menetelmää? Millä vinkillä voisin lähestyä minmax-algoritmia? Tällä hetkellä kaikkia mahdollisia siirtoja ei käydä läpi ja toisaalta tekoäly laittaa merkin ruutuun, jossa on jo jokin pelimerkki, vaikka tämän tulisi olla mahdotonta.
