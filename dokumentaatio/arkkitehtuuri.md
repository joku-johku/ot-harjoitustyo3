# Arkkitehtuurikuvaus  

## Rakenne

![Pakkauskaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)  

Pakkaus tictactoeui sisältää JFrame:lla toteutetun käyttöliittymän tictactoe.domain sovelluslogiikan ja tictactoe.dao tietojen pysyväistallennuksesta vastaavan koodin.  

## Käyttöliittymä  

Käyttöliittymä sisältää kolme erillistä näkymää  

* Kirjautumisen  
* Uuden käyttäjän luomisen  
* Ristinolla peli  

Jokainen näistä on toteutettu käyttämällä JPanelFrame:a. Kirjautumiseen ja uuden käyttäjän luomiseen on käytetty apuna JOptionPane:a. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa tictactoeui.TicTacToe.

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion TicTacToeServicen metodeja.

Kun sovelluksen käyttäjä listan tilanne muuttuu, eli uusi pelaaja kirjautuu, kutsutaan sovelluksen metodia redrawPointslist joka renderöi pistelistanäkymän uudelleen sovelluslogiikalta saamansa näytettävien käyttäjien listan perusteella.  

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat Player ja TicTacToe, jotka kuvaavat pelaajia ja pelaajien pisteitä pelissä:  
![Luokkakaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/kuva.png)  

Toiminnallisista kokonaisuuksista vastaa luokkan TicTacToeService ainoa olio. Luokka tarjoaa kaikille käyttäliittymän toiminnoille oman metodin. Näitä on esim.  

* boolean login(String playername)  

TicTacToeService pääsee käsiksi käyttäjiin ja pisteihin tietojen tallennuksesta vastaavan pakkauksessa tictactoe.dao sijaitsevien rajapinnat TicTacToeDao ja PlayerDao toteuttavien luokkien kautta. Luokkien toteutuksen injektoidaan sovelluslogiikalle konstruktorikutsun yhteydessä.  

TicTacToeServicen ja ohjelman muiden osien suhdetta kuvaava luokka/pakkauskaavio:  

![Luokka/pakkauskaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/luokka_pakkauskaavio.png)


### Tietojen pysyväistallennus  

Pakkauksen dao luokat FileTicTacToeDao ja FilePlayerDao huolehtivat tietojen tallettamisesta tiedostoihin.

Luokat noudattavat Data Access Object -suunnittelumallia ja ne on tarvittaessa mahdollista korvata uusilla toteutuksilla, jos sovelluksen datan talletustapaa päätetään vaihtaa. Luokat onkin eristetty rajapintojen TicTacToeDao ja PlayerDao taakse ja sovelluslogiikka ei käytä luokkia suoraan.

Sovelluslogiikan testauksessa hyödynnetäänkin tätä siten, että testeissä käytetään tiedostoon tallentavien DAO-olioiden sijaan keskusmuistiin tallentavia toteutuksia.  

#### Tiedostot  

Sovellus tallettaa pelaajien ja pisteiden tiedot erillisiin tiedostoihin.

Sovelluksen juureen sijoitettu konfiguraatiotiedosto config.properties määrittelee tiedostojen nimet.

Sovellus tallettaa käyttäjät seuraavassa formaatissa  

`<mattimikko>`   
`<kallematti>`  
  
Pelaajien pisteet tallettavan tiedoston formaatti on seuraava  

`<1; mattimikko; 10>`    
`< 2; kallematti; 12>`  
  
Kentät on eroteltu puolipistein. Ensimmäisenä käyttäjän tunniste eli id, toisena pisteiden määrä ja viimeisenä pisteiden omaavan käyttäjän käyttäjätunnus.

 
#### Päätoiminnallisuudet  

Kuvataan seuraavaksi sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona.

##### Käyttäjän kirjautuminen

Kun kirjautumisnäkymässä on syötekenttään kirjoitettu käyttäjätunnus ja klikataan painiketta loginButton etenee sovelluksen kontrolli seuraavasti:  

![Sekvenssikaavio](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png)  

Painikkeen painamiseen reagoiva tapahtumankäsittelijä kutsuu sovelluslogiikan appService metodia login antaen parametriksi kirjautuneen pelaajan käyttäjätunnuksen. Sovelluslogiikka selvittää playerDao:n avulla onko käyttäjätunnus olemassa. Jos on, eli kirjautuminen onnistuu, on seurauksena se että käyttöliittymä vaihtaa näkymäksi TicTacToe-sovelluksen, eli sovelluksen varsinaisen päänäkymän ja renderöi näkymään kirjautuneen käyttäjän pisteet.  

##### Uuden käyttäjän luominen  

Kun uuden käyttäjän luomisnäkymässä on syötetty käyttäjätunnus joka ei ole jo käytössä ja klikataan painiketta createPlayer etenee sovelluksen kontrolli seuraavasti:  

Tapahtumakäsittelijä kutsuu sovelluslogiikan metodia createPlayer antaen parametriksi luotavan käyttäjän tiedot. Sovelluslogiikka selvittää playerDao:n avulla onko käyttäjätunnus olemassa. Jos ei, eli uuden käyttäjän luominen on mahdollista, luo sovelluslogiikka Player-olion ja tallettaa sen kutsumalla playerDao:n metodia create. Tästä seurauksena on se, että käyttöliittymä vaihtaa näkymäksi loginScenen eli kirjautumisnäkymän.  

##### Muut toiminnallisuudet  

Sama periaate toistoo sovelluksen kaikissa toiminnallisuuksissa, käyttöliittymän tapahtumakäsittelijä kutsuu sopivaa sovelluslogiikan metodia, sovelluslogiikka päivittää kirjautuneen käyttäjän tilaa. Kontrollin palatessa käyttäliittymään, päivitetään tarvittaessa todojen lista sekä aktiivinen näkyvä. Samat tapahtumat tapahtuu myös toisen pelaajan kirjautuessa sisään.  

### Ohjelman rakenteeseen jääneet heikkoudet  

#### Käyttöliittymä  

Käyttöliittymässä on vähän toisteista koodia varsinkin voittoa ja tasapelia tarkistaessa.  

#### DAO-luokat  

Myös täällä on jonkin verran toisteista koodia.

