package tictactoe.tictactoe.domain;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/** Tiedoston käsittelijän avulla kirjataan voitot kahteen tiedostoon,
 * joista ne saadaan luettua.
 */
public class FileHandler {
    private final File latestWins; // voitot
    private Scanner scanner; // lukija
    /** Alustaa oliomuuttujan viimeismmatVoitot.
     * @param latestWins Tiedoston viimeisimmatVoitot polku.
     */
    public FileHandler(String latestWins) {
        this.latestWins = new File(latestWins);
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
    
    /** Tyhjentää latestWins-tiedoston.
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