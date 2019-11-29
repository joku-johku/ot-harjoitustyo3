# Käyttöohje  

Lataa tiedosto tictactoe.jar  

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

## Ristinollan pelaaminen  

Onnistuneen kirjautumisen myötä siirrytään peli näkumään, jossa on tyhjä 3x3 ruudukko. Ensimmäisenä vuorossa  
oleva pelaaja on X ja toinen O. Merkki lisätään näkymään klikkaamalla ruutua.

Tässä muutamia mahdollisia lopputuloksia.





Ohjelma sulkeutuu painamalla raksia oikeasta yläkulmasta.

