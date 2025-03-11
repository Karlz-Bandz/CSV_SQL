package services.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import services.CsvService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvServiceImpl implements CsvService {
    @Override
    public List<String[]> convertCsvToList(String path) throws IOException, CsvException {
        List<String[]> rows = new ArrayList<>();

        try (FileReader fileReader = readCsvFile(path)) {
            CSVReader csvReader = new CSVReader(fileReader);
            rows = csvReader.readAll();
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        }

        return rows;
    }

    private FileReader readCsvFile(String path) throws FileNotFoundException {
        File file = new File(path);

        if (!path.endsWith(".csv"))
            throw new IllegalArgumentException("Wrong file format!");

        return new FileReader(file);
    }
}
