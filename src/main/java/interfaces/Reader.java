package interfaces;

import java.io.FileReader;
import java.io.IOException;

public interface Reader
{
    void displayFileReader() throws IOException;

    void readCsvFile(String path);
}
