package tictactoe.tictactoe.domain;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/** Tiedoston käsittelijän avulla kirjataan voitot kahteen tiedostoon,
 * joista ne saadaan luettua.
 */
public class FileHandler {
    private final File points; //pelaajan pisteet
    private final File latestWins; // voitot
    private Scanner scanner; // lukija
    /** Alustaa oliomuuttujat pisteet ja viimeismmatVoitot.
     * @param points Tiedoston pisteet polku.
     * @param latestWins Tiedoston viimeisimmatVoitot polku.
     */
    public FileHandler(String points, String latestWins) {
        this.points = new File(points);
        this.latestWins = new File(latestWins);
    }
    
    /** Etsii ja palauttaa pisteet-tiedostosta ristin pisteiden määrän.
     * @return Palauttaa ristin pisteiden määrän.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public int readCrossPoints() throws Exception {
        scanner = new Scanner(points);
        String row = "";
        if (scanner.hasNextLine()) {
            row = scanner.nextLine();
        }
        String[] splits = row.split(":");
        String cross = splits[0];
        return Integer.parseInt(cross);
    }
    /** Etsii ja palauttaa pisteet-tiedostosta nollan pisteiden määrän.
     * @return Palauttaa nollan pisteiden määrän.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public int readZeroPoints() throws Exception {
        scanner = new Scanner(points);
        String row = "";
        if (scanner.hasNextLine()) {
            row = scanner.nextLine();
        }
        String[] splits = row.split(":");
        String zero = splits[1];
        return Integer.parseInt(zero);
    }
    
    /** Etsii ja palauttaa Stringinä kaikkien aikaisempien pelien tulokset.
     * @return Palauttaa Stringinä kaikkien aikaisempien pelien tulokset.
     * @throws Exception Heittää poikksuksen, mikäli tiedostoa ei löydy.
     */
    public String readWins() throws Exception {
        this.scanner = new Scanner(this.latestWins);
        String wins = "";
        while (scanner.hasNextLine()) {
            wins += scanner.nextLine();
            wins += "\n";
        }
        scanner.close();
        return wins;
    }
    
    /** Päivittää ristin ja nollan pisteet.
     * @param written Uudet pisteet.
     * @throws Exception Heittää poikksuksen, mikäli tiedostoa ei löydy.
     */
    public void writeIntoPoints(String written) throws Exception {
        FileWriter writer = new FileWriter(points, false);
        writer.write(written);
        writer.close();
    }
    
    /** Tyhjentää viimeisimmatVoitot-tiedoston.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public void resetLatestWins() throws Exception {
        FileWriter writer = new FileWriter(latestWins);
        writer.write("");
        writer.close();
    }
    
    /** Lisää voiton tai tasapelin viimeisimmatVoitot-tiedostoon.
     * @param written Tapahtunut tilanne.
     * @throws Exception Heittää poikkeuksen, mikäli tiedostoa ei löydy.
     */
    public void writeIntoWins(String written) throws Exception {
        FileWriter writer = new FileWriter(latestWins, true);
        writer.append(written);
        writer.close();
    }
}