# Testausdokumentti  

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.  

## Yksikkö- ja integraatiotestaus  

### sovelluslogiikka  

Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen domain luokkia testaavat integraatiotestit
Luokka logicsTest testaa sovelluslogiikkaa.
 

## TicTacToe  

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 72% ja haarautumakattavuus 75 %.  

![testikattavuus](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kuvat/testikattavuus.PNG)

Testaamatta jäi FileHandler-luokka.

## Järjestelmätestaus  

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.  

### Asennus ja konfigurointi  

Sovellus on haettu ja sitä on testattu käyttöohjeen kuvaamalla tavalla sekä OSX- että Linux-ympäristöön.

Sovellusta on testattu sekä tilanteissa, joissa on käytetty reset nappia sekä muita merkki mahdollisuuksia.  

### Toiminnallisuudet  

Kaikki määrittelydokumentin ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Kaikkien toiminnallisuuksien yhteydessä on
syötekentät yritetty täyttää myös virheellisillä arvoilla kuten tyhjillä.  

## Sovellukseen jääneet laatuongelmat  

Jos painaa reset nappulaa ennen kuin painaa new game nappulaa ohjelma antaa aloittaa pelin vaikka pelaajien nimiä ei ole kysytty, jolloin pelaajien niminä toimivat null.

En myöskään checkstylesta poistanut käyttöliittymä-luokkia, mutta virheitä on vain neljä ja ne kaikki ovat liian pitkiä metodien nimiä.
