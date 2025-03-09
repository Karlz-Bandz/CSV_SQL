import com.opencsv.exceptions.CsvException;
import services.CsvService;
import services.DbSaver;
import services.impl.CsvServiceImpl;
import services.impl.DbSaverImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppDriver {
    private final CsvService csvReader;

    private final DbSaver dbSaver;

    private final Scanner scanner;

    public AppDriver() {
        this.csvReader = new CsvServiceImpl();
        this.dbSaver = new DbSaverImpl();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException, CsvException {
        System.out.println("\nWelcome to CSV_SQL\n");
        String flag = "";

        while (!flag.equals("q")) {
            String name = null;
            System.out.println("Please provide the file name...");
            name = scanner.nextLine();
            System.out.println("Please provide the path to .csv file...\n");
            String path = scanner.nextLine();
            List<String[]> result = csvReader.convertCsvToList(path);

            if (!result.isEmpty()) {


                dbSaver.saveDynamicData(name, result);

                System.out.println(".csv file added to database :)");
                for (String[] x : result) {
                    for (String c : x) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                }
            }

            System.out.println("For continue press enter, if you want quit press q...");
            flag = scanner.nextLine();
        }
    }
}
