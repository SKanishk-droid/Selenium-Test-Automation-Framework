package com.utility;

import com.ui.pojo.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String filename){

        //XLSX File
        File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + filename);
        FileInputStream fis = null;
        XSSFWorkbook xssfWorkbook = null;

        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;
        List<User> userList = null;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;

        try {
            fis = new FileInputStream(xlsxFile);
            xssfWorkbook = new XSSFWorkbook(fis);
            userList = new ArrayList<>();
            xssfSheet =xssfWorkbook.getSheet("LoginTestData");
            rowIterator = xssfSheet.iterator();
            rowIterator.next();
            while(rowIterator.hasNext()){
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            xssfWorkbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return userList.iterator();
    }
}
