package interfaces;

import com.opencsv.exceptions.CsvException;
import models.Person;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public interface Reader
{
    void displayFileReader() throws IOException;

    void readCsvFile(String path);

    List<Person> convertCsv() throws IOException, CsvException;
}
