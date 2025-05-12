package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String fileName)  {

        File csvFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        User user;
        List<User> userList;
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
//            line = csvReader.readNext();
             userList = new ArrayList<>();
            while ((line = csvReader.readNext()) != null){
                user = new User(line[0], line[1]);
                userList.add(user);
            }

            for (User userData : userList){
                System.out.println(userData);
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();
    }
    }

