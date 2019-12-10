# Vaatimusmäärittely

## Sovelluksen tarkoitus  
Sovelluksen nimi on Ristinolla, joka on varmasti jokaiselle tuttu peli. Pelin tavoitteena on saada kolme omaa merkkiä samalle vaaka-, pysty- tai vinoriville. Jos kumpikaan pelaajista ei pääse tähän tavoitteeseen peli päättyy tasapeliin.

## Käyttäjät  
Sovelluksella tulee olemaan ainoastaan yksi käyttäjärooli: normaalikäyttäjä.  

## Suunnitellut toiminnallisuudet  

### Perusversio  
Perusversiossa kahden eri pelaajan pitää kirjoittaa nimensä. Kun käyttäjät ovat onnistuneesti kirjautuneet sisään, päästään pelaamaan Ristinolla-peliä 3x3 kokoisella ruudukolla. Perusversiossa ensimmäinen pelaaja on aina risti. Jos peli päättyy tasan lähettää sovellusviestin :"It's a tie !". Taas voiton sattuessa sovellus lähettää viestin: "Player -käyttäjätunnus- won!".  

### Tehty

Viikon 4 palautuksessa toimivat ominaisuudet: Peli huomioi tasapelin ja resetoi pelin jos jompi kumpi pelaajista voittaa tai sattuu tasapelin. Myös pisteiden tallennus onnistuu. Peliruudussa kerrotaan kumman pelaajan vuoro on seuraavaksi. Käyttäjätunnuksen kysyminen puuttuu vielä.  

Viikon 5 palautuksessa toimivat ominaisuudet: ohjelma kysyy pelaajien nimiä. Nimen pitää olla vähintään neljä merkkiä pitkä. Jos näin ei ole nimeä kysytään uudelleen. Pelaajien nimet näkyvät nyt myös pistelaskussa ja vuoronannossa. Näiden kahden toiminnallisuuden lisäksi tehty TicTacToeService luokka.

Viikon 6 palautuksessa peli toimii kuten pitääkin. Aloitin PlayerDao ja PointsDao luokkien luomisen, jotta pelaajien nimien ja pisteiden tallentaminen tiedostoihin onnistuu. Testikattavuus hyvä. Lisäsin myös testiluokkia. Samoin loin fakePlayer luokan. Aloitin myös käyttäjätunnuksen luomis näytön koodaamista, mutta en saanut sitä vielä toimimaan kunnolla joten en sitä vielä pushannut. Aika ei roottänyt tällä viikolla sovelluslogiikan eriyttämiseen käyttöliittymästä.

### Jatkokehitysideoita
* Luoda oma käyttäjätunnus, jonka pitää olla uniikki ja vähintään neljä merkkiä pitkä.
* Käyttäjätunnuksen lisäksi jokaisella käyttäjällä olisi salasana.
* Highscore-taulu johon kerättäisiin jokaisen käyttäjän voitettujen pelien määrä.
* Mahdollisuus valita peliruudukon koko.
* Mahdollisuus päättää itse oma merkkinsä.
* Mahdollisuus poistaa käyttäjätunnus, jolloin myös hänen voitto määränsä poistuu.
* Peliruudussa kerrotaan kumman pelaajan vuoro on seuraavaksi.
