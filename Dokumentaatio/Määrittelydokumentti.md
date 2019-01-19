# Määrittelydokumentti

Työssä toteutetaan laajennettu ristinollapeli ja sen tekoäly. Javalla ohjelmoidun sovelluksen on tarkoitus tarjota käyttäjälle mahdollisuus haastaa tietokone ristinollapelissä, ja peliin kehitetyn tekoälyn on kyettävä pelaamaan myös itse itseään vastaan.

Koska ristinollapeli on laajennettu eli pelialueen koon voi valita perinteistä 3x3-ruudukkoa isommaksi, on optimaalisen suoritusajan taatakseen sovelluksen hyödynnettävä eri algoritmeja peliruudukon koosta riippuen. Sovelluksella siis verrataan myös erilaisia ratkaisutapoja ja algoritmeja.

## Käytettävät algoritmit
Tyyppiesimerkki ristinollapelin tekoälyn toteuttamiseksi on käyttää min-max-algoritmia, jonka aikavaativuus on eksponentiaalinen eli O(s^n), missä s kuvaa siirtomahdollisuuksia ja n puun hakusyvyyttä. Vastaavasti algoritmin tilavaativuus on O(sn). Min-max-algoritmin hyödyntäminen on perusteltua pienillä peliruudukoilla.

## Käytettävät tietorakenteet

Mitä algoritmeja ja tietorakenteita toteutan työssä
miksi valitsin kyseiset tietorakenteet/algoritmit

Tavoitteena olevat aika- ja tilavaativuudet

## Syötteet
Ennen peliä sovellus saa syötteenä käyttäjän määrittelemän pelitavan ja peliruudukon koon. Valittu pelitapa määrittelee, pelaako käyttäjä tietokonetta vastaan vai katsooko hän tekoälyn pelaavan itse itseään vastaan. Peliruudukon koko puolestaan vaikuttaa siihen, millaisella algoritmilla tekoäly pyrkii ratkaisemaan siirrot.

Pelin aikana sovellus saa syötteenä käyttäjän kulloinkin tekemät siirrot (tekoälyn pelatessa itse itseään vastaan jokaisen pelivuoron siirrot). Tämän tiedon pohjalta tekoäly laskee pelikierrokseen valitsemaansa algoritmia hyödyntäen, mikä siirto olisi tietokoneelle edullisin, ja suorittaa ratkaisuksi saamansa siirron.

## Lähteet
[Wikipedia](https://en.wikipedia.org/wiki/Tic-tac-toe) sisältää tietoa ristinollapelin ratkaisustrategioista

Tira-kurssin luentomateriaali (sivut 394-400, Pelipuu)
