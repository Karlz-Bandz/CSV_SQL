import com.opencsv.exceptions.CsvException;
import models.DynamicData;
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

        csvReader.readCsvFile("C:\\Users\\km250542\\Downloads\\MOCK_DATA2.csv");
        List<DynamicData> list = csvReader.dynamicConvert();
        // csvReader.displayFileReader();
//        List<Person> persons = csvReader.convertCsv();
//
        for (DynamicData p: list)
        {
            System.out.println(p);
        }
    }
}
