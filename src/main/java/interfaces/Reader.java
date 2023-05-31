package interfaces;

import com.opencsv.exceptions.CsvException;
import models.entity.DynamicData;
import models.Person;

import java.io.IOException;
import java.util.List;

public interface Reader
{
    void displayFileReader() throws IOException;

    boolean readCsvFile(String path);

    List<Person> convertCsv() throws IOException, CsvException;

    List<DynamicData> dynamicConvert() throws IOException, CsvException;
}
