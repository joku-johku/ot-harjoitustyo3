package tictactoe.tictactoe.domain;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/** Tiedoston käsittelijän avulla kirjataan voitot kahteen tiedostoon,
 * joista ne saadaan luettua.
 */
public class TiedostonKasittelija {
    private File pisteet; //pelaajan pisteet
    private File viimeisimmatVoitot; // voitot
    private Scanner lukija; // lukija
    
    /** Alustaa oliomuuttujat pisteet ja viimeismmatVoitot.
     * @param pisteet Tiedoston pisteet polku.
     * @param viimeisimmatVoitot Tiedoston viimeisimmatVoitot polku.
     */
    public TiedostonKasittelija(String pisteet, String viimeisimmatVoitot) {
        this.pisteet = new File(pisteet);
        this.viimeisimmatVoitot = new File(viimeisimmatVoitot);
    }
    
    /** Etsii ja palauttaa pisteet-tiedostosta ristin pisteiden määrän.
     * @return Palauttaa ristin pisteiden määrän.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public int lueRistinPisteet() throws Exception {
        lukija = new Scanner(pisteet);
        String rivi = "";
        if (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
        }
        String[] osat = rivi.split(":");
        String risti = osat[0];
        return Integer.parseInt(risti);
    }
    /** Etsii ja palauttaa pisteet-tiedostosta nollan pisteiden määrän.
     * @return Palauttaa nollan pisteiden määrän.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public int lueNollanPisteet() throws Exception {
        lukija = new Scanner(pisteet);
        String rivi = "";
        if (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
        }
        String[] osat = rivi.split(":");
        String nolla = osat[1];
        return Integer.parseInt(nolla);
    }
    
    /** Etsii ja palauttaa Stringinä kaikkien aikaisempien pelien tulokset.
     * @return Palauttaa Stringinä kaikkien aikaisempien pelien tulokset.
     * @throws Exception Heittää poikksuksen, mikäli tiedostoa ei löydy.
     */
    public String lueVoitot() throws Exception {
        this.lukija = new Scanner(this.viimeisimmatVoitot);
        String voitot = "";
        while (lukija.hasNextLine()) {
            voitot += lukija.nextLine();
            voitot += "\n";
        }
        lukija.close();
        return voitot;
    }
    
    /** Päivittää ristin ja nollan pisteet.
     * @param kirjoitettava Uudet pisteet.
     * @throws Exception Heittää poikksuksen, mikäli tiedostoa ei löydy.
     */
    public void kirjoitaPisteisiin(String kirjoitettava) throws Exception {
        FileWriter kirjoittaja = new FileWriter(pisteet, false);
        kirjoittaja.write(kirjoitettava);
        kirjoittaja.close();
    }
    
    /** Tyhjentää viimeisimmatVoitot-tiedoston.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public void nollaaViimeisetVoitot() throws Exception {
        FileWriter kirjoittaja = new FileWriter(viimeisimmatVoitot);
        kirjoittaja.write("");
        kirjoittaja.close();
    }
    
    /** Lisää voiton tai tasapelin viimeisimmatVoitot-tiedostoon.
     * @param kirjoitettava Tapahtunut tilanne.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public void kirjoitaViimeisimpiinVoittoihin(String kirjoitettava) throws Exception {
        FileWriter kirjoittaja = new FileWriter(viimeisimmatVoitot, true);
        kirjoittaja.append(kirjoitettava);
        kirjoittaja.close();
    }
}