package services;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface CsvService {
    List<String[]> convertCsvToList(String path) throws IOException, CsvException;
}
