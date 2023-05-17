import services.CsvReader;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        CsvReader csvReader = new CsvReader();

        csvReader.readCsvFile("C:\\Users\\km250542\\Downloads\\MOCK_DATA.csv");
        csvReader.displayFileReader();
    }
}
