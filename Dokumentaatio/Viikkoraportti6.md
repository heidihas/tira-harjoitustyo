# Viikkoraportti 6

[Tuntiraportti](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Tuntiraportti.md)

Tunteja yhteensä tällä viikolla: 15

## Viikolla tehtyä
- ArrayList-tietorakenteen luominen
- Hakusyvyyden rajoittaminen algoritmissa
- Suorituskyvyn ja sovelluksen toiminnan testaaminen suurilla peliruudukoilla
- Tehokkaamman toteutuksen (st. heurestiikan hyödyntäminen pelikierroksen alussa) pohtiminen suurilla peliruudukoilla, aiheesta lukeminen
- Yksikkötestien laajentaminen (testikattavuus >90%)
- Toteutusdokumentin jatkaminen
- Testausdokumentin päivittäminen
- Vertaisarvio
- Omaa työtä koskeviin vertaisarvioihin tutustuminen

## Mitä opin tällä viikolla
Opin tällä viikolla toteuttamaan ArrayList-tietorakenteen itse. Lisäksi pohdin sovelluksen tehokkaampaa toteutusta suurilla peliruudukoilla, luin lisää aiheesta ja selvitin ohjaajan edellisestä vastauksesta, että ristinollapelin kannalta parhaimmat keinot ovat algoritmin läpikäyntisyvyyden rajoittaminen ja jonkinlaisen heurestiikan lisääminen pelin alkuun. Ensimmäisestä työtäni koskevasta vertaisarviosta opin, että koodissa usein toistuvat kokonaisluvut (esim. X-merkki = 1, O-merkki = 2) on parempi korvata enumilla, jotta ulkopuolisen lukijan olisi helpompi hahmottaa koodia.

## Mikä oli haastavaa
Koin hankalaksi algoritmin tehostamisen suuremmilla peliruudukoilla. Tähän mennessä sain sovelluksen toimimaan suuremmilla peliruudukoilla rajoittamalla algoritmin hakusyvyyttä. Tällä muutoksella peli pyörii jopa 8x8-peliruudukolla. Kuitenkin pelin eteneminen suuremmilla peliruudukoilla vaikuttaa tökeröltä: ennen kuin vastustaja ei ole lähestymässä ratkaisevaa siirtoaan, tekoälyllä toimiva tietokonepelaaja asettelee merkkejään vaakasuorasti vasemmalta oikealle, ylhäältä alas vieriviereen kaikkiin tyhjiin ruutuihin. Tällä tavoin käyttäjän ei ole mielekästä pelata hyvin ennalta arvattavaa tietokonepelaajaa vastaan. Käytin paljon aikaa mahdollisen heurestiikan pohtimiseen, esimerkiksi tietokonepelaajan ensimmäisten siirtojen sijoittaminen suhteessa edelliseen käyttäjän suorittamaan siirtoon, mutta en onnistunut vielä hahmottelemaan hyvää toteutustapaa. Minmax-algoritmin hyödyntäminen aliruudukoilla voisi toimia, mutta tällaisella toteutuksella on puolestaan omat rajoitteensa.

## Seuraavan viikon tavoitteet
Tulevilla viikoilla aion hioa ohjelman koodia vertaisarvioista saamieni kommentien osalta. Mahdollisesti teen peliruudukon riveistä vastaavasta taulukosta ja minmax-algoritmista omat luokkansa. Pyrin saamaan sovelluksen tehokkaammaksi suuremmilla peliruudukoilla lisäämällä jonkinlaisen heurestiikan ja hiomalla algoritmin hakusyvyyden rajaamista. Koitan myös saada JavaFX:llä mallipelin siirrot näkyviin vaiheittain (tällä hetkellä näytetään vain lopputulos). Lisäksi viimeistelen dokumentaation kirjoittamalla Käyttöohjeet ja viimeistemällä jo aloittamani Testaus- ja Toteutusdokumentin.

## Kysymyksiä ja palautetta ohjaajalle
