# Viikkoraportti 4

[Tuntiraportti](https://github.com/heidihas/tira-harjoitustyo/blob/master/Dokumentaatio/Tuntiraportti.md)

Tunteja yhteensä tällä viikolla: 20

## Viikolla tehtyä
- Minmax-algoritmin 4 versiota ja toimivan löytäminen
- Parhaimman polun laskeminen voittosyvyyden perusteella
- Sijainti-olioita sisältävistä listoista luopuminen
- Onnistunut laajennetun ristinollan käyttöönotto
- Logiikka-luokan muokkaaminen erikokoisilla peliruudukoilla toimivaksi
- Logiikka-luokan selkeyttäminen
- Mahdollisuus valita pelimerkki ja logiikan toimiminen valinnan perusteella
- Mahdollisuus valita tietokone pelaamassa tietokonetta vastaan
- JavaFX:n delayhin perehtyminen
- Koodin siivoaminen ja kommentointi
- Yksikkötestien muokkaaminen

## Mitä opin tällä viikolla
Koska jouduin laatimaan useamman version minmax-algoritmista, opin eri tapoja lähestyä samaa ongelmaa. Aloin hahmottaa paremmin algoritmin toimintaa erityisesti välitulostuksia seuraamalla. Vaikka edellisen viikon palautuksessa ollut toimintavirhe johtui luultavasti havaitsemistani ja korjaamistani indeksointiongelmista, minmax-algoritmin perinpohjainen tarkastelu oli hyvin opettavaista. Sain toteutettua algoritmiin tekoälyn "älykkyyttä" lisäävän tavan laskea paras polku mahdollisen voiton syvyyden perusteella. Opin myös JavaFX:n menettelytavoista reagoida käyttäjän syötteenä antamiin arvoihin peliruudukon ja -kierroksen tuottamista varten. Pelilogiikan muokkaaminen erikokoisilla peliruudukoilla toimivaksi sai havahtumaan siihen, miten merkittävästi enemmän aikaa kuluu jo 4x4-peliruudukon laskentaan verrattuna tyypilliseen (ja aiemmin kovakoodattuun) 3x3-peliruudukkoon.

## Mikä oli haastavaa
Aluksi minmax-algoritmin korjaaminen tuntui haastavalta, sillä painin saman ongelman kanssa lukuisia tunteja. Laajennetun ristinollan käyttöönotto oli siinä mielessä haastavaa, että jouduin tekemään aiemmin laatimaani koodiin paljon muutoksia myös pelilogiikan osalta. Olin aiemmin kovakoodannut 3x3-peliruudukon tapauksen esimerkiksi metodiin xVoitti(). Tällä hetkellä pelilogiikan toimiminen erikokoisilla peliruudukoilla tuntuu haastavalta, sillä tämänhetkinen minmax-toteutus ei ole riittävän tehokas ja nopea. Lisäksi tietokoneen pelatessa tietokonetta vastaan en jostain syystä saa konsoliin tulostuvia pelivaiheita näkyviin käyttöliittymään, vaan peliruudukkoon piirtyy ainoastaan pelikierroksen lopputulos.

## Seuraavan viikon tavoitteet
Seuraavalla viikolla tavoitteenani on muokata pelilogiikkaa ja minmax-algoritmin toimintaa tehokkaammaksi niin, ettei 3x3-peliruudukkoa suuremmalla ruudukolla pelattaessa laskentaan kuluisi niin paljon aikaa. Mahdollisesti alfa-beeta-karsinnan mukaan ottaminen. Koitan lisätä tietokone vastaan tietokone -peliin viiveen, jotta jokaisen napin painaminen nähtäisiin erillisenä tapahtumana. Valmiiden tietorakenteiden korvaaminen omilla ja dokumentoinnin jatkaminen.

## Kysymyksiä ja palautetta ohjaajalle
