package tests.Chanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ResuableMethodsIlk {



    public static Cell hucreGetir(String path,String sayfaISmi,int satirIndex,int sutunIndex) {

        Cell cell=null;

        try {
            FileInputStream fis=new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(fis);
            cell=workbook.getSheet(sayfaISmi).getRow(satirIndex).getCell(sutunIndex);


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public static Map<String,String> mapOlustur(String path,String sayfaAdi){

        Map<String,String> excelMap=new TreeMap<>();
        Workbook workbook=null;

        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            workbook=WorkbookFactory.create(fileInputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }

        int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();

        String key="";
        String value="";

        for (int i = 0; i <satirSayisi ; i++) {

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                   ", "+ workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            excelMap.put(key,value);

        }




        return excelMap;
    }


}
