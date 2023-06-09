package services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import interfaces.Reader;
import lombok.NoArgsConstructor;
import models.entity.DynamicData;
import models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class CsvReader implements Reader
{
    private FileReader fileReader;

    @Override
    public void displayFileReader() throws IOException
    {
        if (this.fileReader != null)
        {
            BufferedReader bufferedReader = new BufferedReader(this.fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
        } else
        {
            System.out.println("FileReader object is null");
        }
    }

    @Override
    public boolean readCsvFile(String path)
    {
        try
        {
            File file = new File(path);
            if (file.isFile() && file.exists() && path.endsWith(".csv"))
            {
                fileReader = new FileReader(file);
                return true;
            } else
            {
                System.out.println("Is not .csv file");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        } catch (SecurityException e)
        {
            System.out.println("Security exception!");
        }
        return false;
    }

    @Override
    public List<Person> convertCsv() throws IOException, CsvException
    {
        List<Person> persons = new ArrayList<>();

        if (this.fileReader != null)
        {
            CSVReader csvReader = new CSVReader(this.fileReader);
            List<String[]> rows = csvReader.readAll();

            for (int i = 1; i < rows.size(); i++)
            {
                int id = Integer.parseInt(rows.get(i)[0]);
                Person person = new Person(id, rows.get(i)[1], rows.get(i)[2]);
                persons.add(person);
            }
        } else
        {
            System.out.println("File not found in convertCsv method");
        }
        return persons;
    }

    @Override
    public List<DynamicData> dynamicConvert() throws IOException, CsvException
    {
        List<DynamicData> dynamicDataList = new ArrayList<>();

        if (this.fileReader != null)
        {
            CSVReader csvReader = new CSVReader(this.fileReader);
            List<String[]> rows = csvReader.readAll();
            List<String> header = new ArrayList<>();

            for (int i = 0; i < rows.get(0).length; i++)
            {
                header.add(rows.get(0)[i]);
            }

            for (int i = 1; i < rows.size(); i++)
            {
                DynamicData dynamicData = new DynamicData();

                Map<String, String> data = new HashMap<>();

                for (int j = 0; j < header.size(); j++)
                {
                    data.put(header.get(j), rows.get(i)[j]);
                }
                dynamicData.setData(data);

                dynamicDataList.add(dynamicData);
            }
        } else
        {
            System.out.println("File not found in dynamicConvert method");
        }
        return dynamicDataList;
    }
}
