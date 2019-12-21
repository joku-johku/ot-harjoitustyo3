# Arkkitehtuurikuvaus  

## Rakenne  

Ohjelman rakenne noudattaa kaksitasoista kerrosarkkitehtuuria, ja sillä on seuraavanlainen pakkausrakenne:

![Pakkauskaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)  

Pakkaus ui sisältää JFrame:lla toteutetun käyttöliittymän ja domain sovelluslogiikan ja tietojen pysyväistallennuksesta vastaavan koodin. Pakkausten viralliset nimet ovat tictactoe.tictactoe.ui ja tictactoe.tictactoe.domain. Kuvien selvyyde takia jätin tictactoe.tictactoe osan pois.

## Käyttöliittymä  

Käyttöliittymä sisältää kolme erillistä näkymää  

* Päänäytön, jossa on peli ruudukko ja nappi-valikoima.
* Asetukset näytön 
* sekä painaessa new game nappia ohjelma kysyy pelaajien nimiä, jotka pitää olla vähintään neljä merkkiä pitkä.   

Jokainen näistä on toteutettu käyttämällä JFrame:a. Pelaajien nimen kysymiseen on käytetty apuna JOptionPane:a. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa tictactoe.tictactoe.ui.

Käyttöliittymä on yritetty luoda täysin eristyksiin sovelluslogiikasta, se vain kutsuu sopivilla parametreilla sovelluslogiikan toteuttavan olion Logics metodeja.

Kun sovellukseen kirjautuu uusi pelaaja, pelaajan voitot kerätään wins.txt tiedostoon, jossa on pelien voittajien nimet sekä tasapelit.

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostaa luokka Logics, jossa suoritetaan peli vuorot ja tarkistetaan onko voitto tapahtunut. FileHandler luokassa tehdään tietojen pysyväistalletus.  

![Luokkakaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/luokkakaavio.png)  

Toiminnallisista kokonaisuuksista vastaa luokan Logics ainoa olio. Luokka tarjoaa kaikille käyttäliittymän toiminnoille oman metodin. Näitä ovat esim.  

* startGame()  
* playTurn(int who, int row, int col), joka saa parametrina kumman vuoro on, rivi ja sarake kordinaatit.

Logics pääsee käsiksi voittoihin tietojen tallennuksesta vastaavan luokan FileHandler kautta. Luokkien toteutuksen injektoidaan sovelluslogiikalle konstruktorikutsun yhteydessä.  

Logics ja ohjelman muiden osien suhdetta kuvaava luokka/pakkauskaavio:  

![Luokka/pakkauskaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/luokka_pakkauskaavio.png)


### Tietojen pysyväistallennus  

Pakkauksen domain luokka FileHandler huolehtivat tietojen tallettamisesta tiedostoon.

Luokka noudattaa Data Access Object -suunnittelumallia ja ne on tarvittaessa mahdollista korvata uusilla toteutuksilla, jos sovelluksen datan talletustapaa päätetään vaihtaa.  Voitot tallennetaan tiedostoon wins.txt.

 

#### Tiedostot  

Sovellus tallettaa pelien voittajat ja tasapelit yhteen tiedostoon, jonka nimi on on wins.txt.

Sovellus tallettaa voittajat seuraavassa formaatissa  

`<mikko won!>`   
`<kalle won!>`  
  
Tasapelin sattuessa formaatti on seuraava  

`<Tie!>`    
  
Ohjelma tallentaa siis voittoihin sen nimen, jonka pelaaja on syöttänyt, kun nimeä on kysytty.

 
#### Päätoiminnallisuudet  

Sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona kuvattuna.

##### Uuden pelin aloittaminen

Kun päänäytössä on painetaan new game nappia ja on annettu pelaajien nimet etenee sovelluksen kontrolli seuraavasti:  

![Sekvenssikaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/uuden_pelin_aloittaminen.png)  

Napin painaminen kutsuu luokkaa NewGameListener. Sen jälkeen paintComponent() tyhjentää ja alustaa peliruudukon pelattavaksi. Sen jälkeen kutsutaan startGame() metodia Logics-luokasta.

##### Pelaajan yksi vuoro  

Sen jälkeen kun on aloitettu uusi peli ja on pelaajan yksi vuoro etenee kontrolli seuraavasti:  


![Sekvenssikaavio2](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/pelaajan_yksi_vuoro.png)  

Sen jäkeen, kun pelaaja on klikannut ruutua johon haluaa sijoittaa merkkinsä mikä tapahtuu drawCanvasListenerin avulla. Sen jälkeen kutsutaan Logics-luokan metodia startGame(). Tämän jälkeen piirretään risti merkki kutsumalla drawCross- metodia drawCanvas. Aina kun merkki on piirretty tarkistetaan tuliko voitto, joka tapahtuu luokan Logics metodin cheackWin(1) avulla. Se saa parametrina 1 tai 2 viitaten pelaajaan yksi tai kaksi. Pelaaja yksi merkki on aina risti ja pelajaan kahden merkki on nolla.  


##### Vuoro, jossa ei voiteta  

Sen jälkeen kun on aloitettu uusi peli ja on pelaajan yksi vuoro etenee kontrolli seuraavasti:

![Sekvenssikaavio2](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/vuoro_jossa_ei_voiteta.png)  

Sen jäkeen, kun pelaaja on klikannut ruutua johon haluaa sijoittaa merkkinsä mikä tapahtuu drawCanvasListenerin avulla. Sen jälkeen kutsutaan Logics-luokan metodia startGame(). Tämän jälkeen piirretään risti merkki kutsumalla drawCross- metodia drawCanvas. Aina kun merkki on piirretty tarkistetaan tuliko voitto, joka tapahtuu luokan Logics metodin cheackWin(1) avulla. Jos se palauttaa, että voittoa ei tullut tarkistetaan onko peli loppunut hasGameEnded()- metodin avulla ja pelilauta on täynnä eikä voittoa ole tullut peli on päättynyt tasapeliin.  

##### Muut toiminnallisuudet  

Sama periaate toistoo sovelluksen kaikissa toiminnallisuuksissa, käyttöliittymän tapahtumakäsittelijä kutsuu sopivaa sovelluslogiikan metodia. Settings-asetuksista pääsee valitsemaan haluaako pelata tavallisilla merkeillä vai latinalaisella ristillä ja hymynaamalla tai sekaisin. Merkin valinnan jälkeen vuoron suorittaminen tapahtuu samoin kuin edellä, mutta drawCross()-metodin sijaan kutsutaan merkkiä vastaavaa piirto metodia. Pelin päättyessä päivitetään voittajien listaa.

### Ohjelman rakenteeseen jääneet heikkoudet  

#### Sovelluslogiikka  

Logics-luokkaa voisi selkiyttää. Sekä FileHandlerin voisi laitta omaan pakkaukseen, mutta en pitänyt sitä kovin isona asiana että olisin lähtenyt vielä muuttamaan documentointia.

#### Käyttöliittymä

Luokat jaettu mielestäni hyvin ja niissä tehdään vain välttämättömät asiat.

