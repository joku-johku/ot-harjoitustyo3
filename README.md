 # <h1> Ristinolla  
Sovellus on tavallinen ristinolla peli, jonka tarkoituksena on saada kolme omaa merkkiä vierekkäin joko pysty-, vaaka-, vinosuuntaan. Jokaisella pelaajalla on oma käyttäjätunnuksensa ja salasanansa, jonka avulla kerätään voittojon määrää. Jos sattuu tasapeli kumpikaan pelaaja ei saa pistettä.

## Dokumentaatio  
[arkkitehtuurikuvaus](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/arkkitehtuuri.md)  

[vaatimusmäärittely](http://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/vaatimusmaarittely.md)  

[työaikakirjanpito](http://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/tuntikirjanpito.md)  

[käyttöohje](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/kayttoohje.md)  

[testausdokumentti](https://github.com/joku-johku/ot-harjoitustyo3/blob/master/dokumentaatio/testausdokumentti.md)

## Releaset  
[Viikko 6](https://github.com/joku-johku/ot-harjoitustyo3/releases)

## Komentorivitoiminnot  

### Ohjelmansuorittaminen  
Ohjelman suorittaminen komentoriviltä tapahtuu komennolla  

```
mvn compile exec:java -Dexec.mainClass=tictactoeui.TicTacToe  
```

### Testaus  
Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Ristinolla-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml]() määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

