package tests.Chanel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class ReadExcel {


    @Test
    public void excelTest() throws IOException {
        // indexi 4 olan satirdaki, indexi 2 olan hucrenin Andorra oldugunu test ediniz

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);
        String expextedResult1="Andorra";
        String actualResult1=workbook.getSheet("Sayfa1").getRow(4).getCell(2).toString();
        Assert.assertEquals(actualResult1,expextedResult1);
        // ulkeler excelinin 3. satirini yazdirin

        for (int i = 0; i <4 ; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(2).getCell(i));
            
        }
        
        // ilk 20 ulkenin baskentlerini yazdirin turkce isimerini yazdirin
        for (int i = 0; i <20 ; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(3));
        }
        // Ulkeler excelin deki Sayfa1 de
        // 11. index deki satirin , 2. indexteki hcresinin Azerbaycan oldugunu test edin
        String expextedresult2="Azerbaycan";
        String actualResul2=workbook.getSheet("Sayfa1").getRow(11).getCell(2).toString();
        Assert.assertEquals(actualResul2,expextedresult2);
        // ulkeler excelindeki sayfa1 ve Sayfa2 deki satir sayilarini
        // ve kullanilan satir sayilarini bulun
       int kullanilanSatirsayisi1= workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
       int kullanilanSatirsayisi2= workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
       int sayfa1SatirSayisi1=workbook.getSheet("Sayfa1").getLastRowNum();
       int sayfa1SatirSayisi2=workbook.getSheet("Sayfa2").getLastRowNum();

        //dosya yolu ve sayfa ismi verilen bir excel sheet i map olarak kaydeden
        // reusable bir method olusturalim
        Map<String,String> excelMap=ResuableMethods.mapOlustur(path,"Sayfa1");
        // turkiye nin bilgilerii getirin

        System.out.println(excelMap.get("Turkey"));
        // Listede Netherlands oldugunu testedin

        Assert.assertTrue(excelMap.containsKey("Netherlands"));


        // ulkeler exceline 5. sutun olarak NUFUS sutunu ekleyelim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        // 3- dosyada yapmak istedigiiz degisiklikleri
        // 4/ kopyada yaptigimiz degisiklikleri ana dosyaya kaydedelim
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);




    }



}
