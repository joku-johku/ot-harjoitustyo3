# Käyttöohje  

Lataa tiedosto [tictactoe.jar](https://github.com/joku-johku/ot-harjoitustyo3/releases)  

## Ohjelman käynnistäminen  

Ohjelma käynnistetään komennolla  

`<java -jar TicTacToe.jar>`  

## Kirjautuminen  

Sovellus käynnistyy päänäyttöön:  

![päänäkymä](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/paanakyma.PNG)

Pelaamisen aloittaminen onnistuu painamalla oikealla olevaa ylintä nappia new game

Tämän jälkeen pelaaminen aloitetaan, siten että kumpikin pelaajat syöttävät peräkkäin käyttäjätunnuksensa.  
Käyttäjätunnus pitää olla vähintään neljä merkkiä pitkä. Muuten ohjema lähettää ilmoituksen player name too short.

![pelaajan_nimi](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/pelaajannimi.png)


## Ristinollan pelaaminen  

Onnistuneen kirjautumisen myötä siirrytään pelaamaan ja ruudukko kertoo kumpi pelaaja aloittaa.  

![kalle_aloitta](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/kalle_aloittaa.PNG)  

Kumpikin pelaa lisää oman merkkinsä vuoronperää ja yrittää saada kolme omaa merkiiään vierekkäin.  Jos kumpikaan pelaaja ei onnistu tässä tavoitteessa syntyy tasapeli.

Tässä muutamia mahdollisia lopputuloksia.  

Matti voittaa:  

![mattivoittaa](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/mattivoittaa.PNG)  

Kalle voittaa:  

![kallevoittaa](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/kallevoittaa.PNG)  

Tasapeli:  

![kallevoittaa](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/tasapeli.PNG)  

Aina kun yksi peli päättyy voidaan painaa, joko new game nappia, jonka jälkeen ohjelma kysyy jälleen pelaajien nimiä tai painaa reset nappia, mikä tyhjentää taulun ja aloittaa uuden pelin samoilla pelaajien nimillä.  

![reset](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/reset.PNG)  

Ohjelma arpoo pelin aloittajan ilmoittaa sen tees ruudussa.  

![kalle_aloitta](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/kalle_aloittaa.PNG)  

## Merkkien valinta  

Stteings-nappia painamalla pelaaja pääsee valitsemaan oman merkkinsä.  

![settings](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/punainen_ympyra.PNG)  

Sen jälkeen avautuu tämä näkymä:  

![settings](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/settings.PNG)  

Tämän valinnan jälkeen merkit näyttävät tältä:  

![muut_merkit](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/muut_merkit.PNG)  

## Pelin lopettaminen

Pelin voi lopettaa, joko exit-nappia painamalla tai oikeata yläkulmasta rastista.  

![exit](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/exit.PNG)  

##  Pysyväistallennus  

Pelin voittajat tallenetaan wins.txt tiedostoon, joka näyttää tältä:  

![wins](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/wins.PNG)  

