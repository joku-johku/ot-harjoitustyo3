# Testausdokumentti  

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.  

## Yksikkö- ja integraatiotestaus  

### sovelluslogiikka  

Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen domain luokkia testaavat integraatiotestit
TicTacToeServicePlayerTest ja TicTacToeServiceTicTacToeTest joiden määrittelevät testitapaukset simuloivat käyttöliittymän 
TicTacToeService-olin avulla suorittamia toiminnallisuuksia.

Integraatiotestit käyttävät datan pysyväistallennukseen DAO-rajapintojen keskusmuistitoteutuksia FakeTicTacToeDao ja FakePlayerDao

Sovelluslogiikkakerroksen luokille Player ja TicTacToe on tehty muutama yksikkötesti kattamaan tapaukset, joita integraatiotestit eivät
kata (mm. olioiden equals-metodit).  

### DAO-luokat  

Molempien DAO-luokkien toiminnallisuus on testattu luomalla testeissä tilapäinen tiedosto hyödyntäen JUnitin TemporaryFolder-ruleja.  

## TicTacToe  

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 60% ja haarautumakattavuus 100 %.  

![testikattavuus](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/oikea_testikattavuus.PNG)

Testaamatta jäivät tilanteet, joissa käyttäjät tai pisteet tallettavia tiedostoja ei ole, tai niihin ei ole luku- ja kirjoitusoikeutta.  

## Järjestelmätestaus  

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.  

### Asennus ja konfigurointi  

Sovellus on haettu ja sitä on testattu käyttöohjeen kuvaamalla tavalla sekä OSX- että Linux-ympäristöön siten, että sovelluksen 
käynnistyshakemistossa on ollut käyttöohjeen kuvauksen mukainen config.properties-tiedosto.

Sovellusta on testattu sekä tilanteissa, joissa käyttäjät ja pisteet tallettavat tiedostot ovat olleet olemassa ja joissa niitä ei
ole ollut jolloin ohjelma on luonut ne itse.  

### Toiminnallisuudet  

Kaikki määrittelydokumentin ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Kaikkien toiminnallisuuksien yhteydessä on
syötekentät yritetty täyttää myös virheellisillä arvoilla kuten tyhjillä.  

## Sovellukseen jääneet laatuongelmat  

Sovellus ei anna tällä hetkellä järkeviä virheilmoituksia, seuraavissa tilanteissa  
* konfiguraation määrittelemiin tiedostoihin ei ole luku/kirjoitusoikeuksia
