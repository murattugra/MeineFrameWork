package tests.Chanel;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ReactshoppingPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Reactshopping {


    @Test(groups = "deneme")
    public void test01() throws InterruptedException {

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("ReactshoppingUrl"));

    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        ReactshoppingPage reactshoppingPage=new ReactshoppingPage();
        int sayac=1;
        for (WebElement each : reactshoppingPage.tumUrunlerIsimleriListesi
             ) {
            System.out.println(sayac+". urun  :"+each.getText());
            sayac++;
        }

// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> urunAdlariListesi=new ArrayList<>();
        for (WebElement each : reactshoppingPage.tumUrunlerIsimleriListesi
             ) {
            urunAdlariListesi.add(each.getText());
        }

    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        reactshoppingPage.rastgeleUrunSecmeVeAdlariniYazma(5);
        // (Her ürün 1 defadan fazla eklenemez!)

    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın

    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
    // 7.Checkout'a tıklayın
    Thread.sleep(500);
Driver.closeDriver();
    }
}
