import com.opencsv.exceptions.CsvException;
import hibernate.SessionFactoryMaker;
import models.DynamicData;
import models.entity.MainData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import services.CsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main
{
    public static void main(String[] args) throws IOException, CsvException
    {
        CsvReader csvReader = new CsvReader();

        csvReader.readCsvFile("C:\\Users\\km250542\\Downloads\\MOCK_DATA.csv");
        List<DynamicData> list = csvReader.dynamicConvert();
        // csvReader.displayFileReader();
//        List<Person> persons = csvReader.convertCsv();
//
        for (DynamicData p: list)
        {
            System.out.println(p);
        }

        List<Map<String, String>> testList = new ArrayList<>();
        Map<String, String> testMap = new HashMap<>();
        testMap.put("name", "Karlz");
        testList.add(testMap);
        int id = 4;

        MainData dynamicDataTest = new MainData("Kdd");

        SessionFactory factory = SessionFactoryMaker.getFactory();

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(dynamicDataTest);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
