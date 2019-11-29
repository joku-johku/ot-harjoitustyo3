# Käyttöohje  

Lataa tiedosto [tictactoe.jar](https://github.com/joku-johku/ot-harjoitustyo3/releases)  

## Konfigurointi  

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto config.properties, joka määrittelee käyttäjät ja pisteet 
tallettavien tiedostojen nimet. Tiedoston muoto on seuraava  

`<playerFile=players.txt>`  
`<tictactoeFile=points.txt>`  

## Ohjelman käynnistäminen  

Ohjelma käynnistetään komennolla  

`<java -jar tictactoe.jar>`  

## Kirjautuminen  

Sovellus käynnistyy kirjautumisnäkymään:  


Kirjautuminen onnistuu kirjoittamalla olemassaoleva käyttäjätunnus syötekenttään ja painamalla ok.  

## Uuden käyttäjän luominen  

Kirjautumisnäkymästä on mahdollista siirtyä uuden käyttäjän luomisnäkymään panikkeella create new user.  

Uusi käyttäjä luodaan syöttämällä tiedot syötekenttiin ja painamalla create  

Jos käyttäjän luominen onnistuu, palataan kirjautumisnäkymään.  

Tämän jälkeen pelaaminen aloitetaan, siten että kumpikin pelaaja syöttää käyttäjätunnuksensa.  
Käyttäjätunnus pitää olla vähintään neljä merkkiä pitkä.  

![pelaajannimi](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/pelaajannimi.png)

## Ristinollan pelaaminen  

Onnistuneen kirjautumisen myötä siirrytään peli näkumään, jossa on tyhjä 3x3 ruudukko.  

![tyhjaruutu](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/tyhjaruudukko.PNG)  

Ensimmäisenä vuorossa oleva pelaaja on X ja toinen O. Merkki lisätään näkymään klikkaamalla ruutua.  

![ruutu2](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/ruudukko2.PNG)

Tässä muutamia mahdollisia lopputuloksia.  

Matti voittaa:  

![mattivoittaa](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/mattivoittaa.PNG)  

Kalle voittaa:  

![kallevoittaa](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/kallevoittaa.PNG)  

Tasapeli:  

![kallevoittaa](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/tasapeli.PNG)  

Aina kun yksi peli päättyy ja painetaan ok-nappia peli resetoi ja tallentaa pisteen pelin voittajalle pistetaulukkoon, joka näkyy ruudukon alalaidassa. Jos tulee tasapeli kumpikaan pelaaja ei saa pistettä.





Ohjelma sulkeutuu painamalla raksia oikeasta yläkulmasta.

