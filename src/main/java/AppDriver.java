import com.opencsv.exceptions.CsvException;
import hibernate.SessionFactoryMaker;
import models.entity.DynamicData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import services.CsvReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppDriver
{
    private CsvReader csvReader;
    private Scanner scanner;

    public AppDriver()
    {
        this.csvReader = new CsvReader();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException, CsvException
    {
        System.out.println("\nWelcome to CSV_SQL\n");
        String flag = "";

        while (!flag.equals("q")){
            System.out.println("Please provide the path to .csv file...\n");
            boolean checkFile = false;


                String path = scanner.nextLine();
                checkFile = csvReader.readCsvFile(path);

                if(checkFile == true)
                {

                    List<DynamicData> dynamicList = csvReader.dynamicConvert();

                    SessionFactory factory = SessionFactoryMaker.getFactory();

                    try (Session session = factory.openSession())
                    {
                        Transaction transaction = session.beginTransaction();
                        for (DynamicData d : dynamicList)
                        {
                            session.persist(d);
                        }
                        transaction.commit();
                        System.out.println(".csv file added to database :)");
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }

                System.out.println("For continue press enter, if you want quit press q...");
                flag = scanner.nextLine();
        }
    }
}
