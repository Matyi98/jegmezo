package reader;

import javafx.geometry.Point2D;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LayoutReader {
    private BufferedReader reader;
    public LayoutReader(InputStream inputStream) {
        this.reader =
                new BufferedReader(new InputStreamReader(inputStream));
    }


    public ArrayList<Point2D> readCoords() {
        return new ArrayList<>();
    }
}
