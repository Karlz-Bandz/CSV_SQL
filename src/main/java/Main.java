import com.opencsv.exceptions.CsvException;
import models.Person;
import org.apache.commons.collections4.iterators.PeekingIterator;
import services.CsvReader;

import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, CsvException
    {
        CsvReader csvReader = new CsvReader();

        csvReader.readCsvFile("C:\\Users\\km250542\\Downloads\\MOCK_DATA.csv");
       // csvReader.displayFileReader();
        List<Person> persons = csvReader.convertCsv();

        for (Person p: persons)
        {
            System.out.println(p.getId());
        }
    }
}
