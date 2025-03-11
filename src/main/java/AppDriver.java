import com.opencsv.exceptions.CsvException;
import services.CsvService;
import services.DbService;
import services.impl.CsvServiceImpl;
import services.impl.DbServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppDriver {
    private final CsvService csvReader;

    private final DbService dbSaver;

    private final Scanner scanner;

    public AppDriver() {
        this.csvReader = new CsvServiceImpl();
        this.dbSaver = new DbServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException, CsvException {
        System.out.println("\nWelcome to CSV_SQL\n");
        String flag = "";

        while (!flag.equals("q")) {
            String name = null;
            String choseProgram = null;
            System.out.println("If you want to read/delete file provide 1 and click enter else just click enter...");
            choseProgram = scanner.nextLine();

            if (choseProgram.equals("1")) {
                System.out.println("Delete press d and enter/Read press enter...");
                String program = scanner.nextLine();

                if (program.toLowerCase().equals("d")) {
                    System.out.println("Please provide the filename to delete...");
                    String fileNameToDelete = scanner.nextLine();

                    dbSaver.deleteDynamicDataByFileName(fileNameToDelete);

                    System.out.println("File deleted!");

                } else {
                    String fileName = null;
                    System.out.println("Please provide the file name...");
                    fileName = scanner.nextLine();

                    List<Object[]> rows = dbSaver.getDynamicDataByFileName(fileName);

                    if (rows != null) {
                        for (Object[] obj : rows) {
                            System.out.println(obj[2]);
                        }
                    } else {
                        System.out.println("Dynamic data not exists!");
                    }
                }
            } else {
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
            }

            System.out.println("For continue press enter, if you want quit press q...");
            flag = scanner.nextLine();
        }
    }
}
