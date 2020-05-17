package reader;

import javafx.geometry.Point2D;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Pálya kinézetét leíró fájlt beolvasó osztály.
 */
public class LayoutReader {
    /**
     * Ez egy pufferelt olvasó.
     */
    private BufferedReader reader;

    /**
     * Konstruktor
     * @param inputStream az a folyam amiről be kell olvasni a leíró fájlt.
     */
    public LayoutReader(InputStream inputStream) {
        this.reader =
                new BufferedReader(new InputStreamReader(inputStream));
    }


    /**
     * Beolvassa a mezők koordinátáját.
     * @return Mezők koordinátái.
     * @throws IOException File not found exception.
     */
    public ArrayList<Point2D> readCoords() throws IOException {
        String line = reader.readLine();
        String[] lineSplit = line.split(";");

        ArrayList<Point2D> points = new ArrayList<>();

        for(int i = 0; i < lineSplit.length; ++i){
            lineSplit[i] = lineSplit[i].trim();
            String[] coords = lineSplit[i].split(" ");
            points.add(new Point2D(Integer.parseInt(coords[0]), Integer.parseInt(coords[1])));
        }

        return points;
    }
}
