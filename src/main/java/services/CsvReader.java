package services;

import interfaces.Reader;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@NoArgsConstructor
public class CsvReader implements Reader
{
    private FileReader fileReader;


    @Override
    public void displayFileReader() throws IOException
    {
        if(this.fileReader != null)
        {
            BufferedReader bufferedReader = new BufferedReader(this.fileReader);


            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }else{
            System.out.println("FileReader object is null");
        }
    }

    @Override
    public void readCsvFile(String path)
    {
        try{
            fileReader = new FileReader(path);
        }catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}
