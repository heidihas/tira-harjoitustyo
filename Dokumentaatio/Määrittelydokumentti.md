# Määrittelydokumentti

Työssä toteutetaan laajennettu ristinollapeli ja sen tekoäly. Javalla ohjelmoitavan sovelluksen on tarkoitus tarjota käyttäjälle mahdollisuus haastaa tietokone ristinollapelissä, ja peliin kehitetyn tekoälyn on kyettävä pelaamaan myös itse itseään vastaan.

Koska ristinollapeli on laajennettu eli pelialueen koon voi valita perinteistä 3x3-ruudukkoa isommaksi, on optimaalisen suoritusajan taatakseen sovelluksen hyödynnettävä läpikäyntialgoritmia eri tavoin peliruudukon koosta riippuen. Sovelluksella siis verrataan myös erilaisia ratkaisutapoja.

## Käytettävät algoritmit
Tyyppiesimerkki ristinollapelin tekoälyn toteuttamiseksi on käyttää min-max-algoritmia, jonka aikavaativuus on eksponentiaalinen eli O(s^n), missä s kuvaa siirtomahdollisuuksia ja n hakupuun syvyyttä. Vastaavasti algoritmin tilavaativuus on O(sn). Min-max-algoritmin hyödyntäminen sellaisenaan on perusteltua pienillä peliruudukoilla.

Min-max-algoritmia voidaan nopeuttaa käyttämällä alfa-beta-karsintaa, joka vähentää läpikäytävien hakupuun haarojen määrää. Vaikka alfa-beeta-karsinta nopeuttaa käytännössä huomattavasti algoritmin suoritusta, se ei poista kokonaisaikavaativuuden eksponentiaalisuutta.

Nopeampien ratkaisualgoritmien löytämiseksi on harjoitustyökurssin aikana toteutettava lisää tutkimusta. Tällä hetkellä Monte Carlo Tree Search -menetelmä näyttää lupaavalta - nettilähteiden mukaan algoritmin käyttäminen nopeuttaa ohjelman suoritusta jopa enemmän kuin alfa-beeta-karsinta.

## Käytettävät tietorakenteet
Sovellus tarvitsee ainakin kahdenlaisia tietorakenteita. Yhtäältä käytössä on oltava taulukko, johon jokaista peliruutua vastaavaan kohtaan täytetään pelin edetessä ruudussa oleva merkki. Toisaalta läpikäynnin helpottamiseksi tarvitaan listoista koostuva taulukko, jonka jokainen lista-alkio kuvaa peliruudukon riviä, saraketta tai viistosuuntaista linjaa. Jos valitun peliruudukon sivun pituus on m ruutua, vie koko ruudukkoa vastaava taulukko tilaa O(mm)=O(m^2), rivilista O(m) ja listoista koostuva taulukko O((2m + 2)m)=O(m^2).

Ohjelman suorituksessa näiden aputietorakenteiden läpikäynnillä ei ole merkittävää vaikutusta kokonaisaikavaativuuteen, kun min-max-algoritmin aikavaativuus on eksponentiaalinen.

## Syötteet
Ennen peliä sovellus saa syötteenä käyttäjän määrittelemän pelitavan ja peliruudukon koon. Valittu pelitapa määrittelee, pelaako käyttäjä tietokonetta vastaan vai katsooko hän tekoälyn pelaavan itse itseään vastaan. Peliruudukon koko puolestaan vaikuttaa siihen, miten tekoäly pyrkii ratkaisemaan siirrot.

Pelin aikana sovellus saa syötteenä käyttäjän kulloinkin tekemän siirron (tekoälyn pelatessa itse itseään vastaan jokaisen pelivuoron siirron). Tämän tiedon pohjalta tekoäly laskee algoritmia hyödyntäen, mikä siirto olisi tietokoneelle edullisin, ja suorittaa ratkaisuksi saamansa siirron.

## Lähteet
[Wikipedia](https://en.wikipedia.org/wiki/Tic-tac-toe) sisältää tietoa ristinollapelin ratkaisustrategioista

Tira-kurssin luentomateriaali (sivut 394-400, Pelipuu)

https://courses.cs.washington.edu/courses/cse573/12au/slides/04-minmax.pdf

[Monte Carlo Tree Search, Wikipedia](https://en.wikipedia.org/wiki/Monte_Carlo_tree_search)
