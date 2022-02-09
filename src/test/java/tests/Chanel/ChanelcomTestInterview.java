package tests.Chanel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ChanelcomPage;
import utilities.Driver;

import java.util.List;

public class ChanelcomTestInterview{

    // https://www.chanel.com/us/
    //1st test:
    //    1- Accessing the site --> OK if the site is displayed
    //    2- Click on the search bar (on the top menu)
    //    3- Search for "ROUGE ALLURE"
    //    3- Check if the items of the displayed list contain the searched word
    //    4- Select the second item of the list
    //    5- Make sure that the displayed product name is the same as the previously selected name.
    //2nd test:
    //    1- Access to the site
    //    2- Access to Makeup => Lipstick category (on top menu)
    //    3- Click on ROUGE ALLURE product
    //    4- Add the product to the cart
    //    5- View Cart --> OK, if there is a "ROUGE ALLURE" product in the cart, the quantity=1 and the total cart is equal to the product price.

    ChanelcomPage chanelcomPage;

    @BeforeMethod
    public void setup(){
        chanelcomPage=new ChanelcomPage();

    }
    @Test
    public void test01(){
        //https://www.chanel.com/us/
        //1. test:
        Driver.getDriver().get("https://www.chanel.com/us/");
        //     1- Siteye erişim --> Site görüntüleniyorsa tamam
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.chanel.com/us/";
        Assert.assertEquals(actualUrl,expectedUrl," Siteye erisim testi Faield");
        //     2- Arama çubuğuna tıklayın (üst menüde)
            chanelcomPage.chanelAramaKutusu.click();
        //     3- "ROUGE ALLURE" için arama yapın
        chanelcomPage.chanelAramaKutusuInput.sendKeys("ROUGE ALLURE"+ Keys.ENTER);
        //     3- Görüntülenen listedeki öğelerin aranan kelimeyi içerip içermediğini kontrol edin
        String expectedResult="ROUGE ALLURE";
     //   List<WebElement> chanelArananUrunlerListesi=Driver.getDriver().findElements(By.xpath("//h4[@class='product-item__title heading is-7 is-cropped false']"));
        System.out.println(chanelcomPage.chanelArananUrunler.size());
        SoftAssert softAssert=new SoftAssert();
        for (WebElement each: chanelcomPage.chanelArananUrunler
             ) {
            System.out.println(each.getText());
            softAssert.assertTrue(each.getText().contains(expectedResult),"Urunler kelime icerme Testi Failed");

        }

        //     4- Listenin ikinci öğesini seçin
                    String ikiciUrunIsim=chanelcomPage.ikiciUrun.getText();

                  chanelcomPage.ikiciUrun.click();
        //     5- Görüntülenen ürün adının daha önce seçilen adla aynı olduğundan emin olun.
                  String seciliIkinciUrun=chanelcomPage.ikinciUrunSecildiktenSonraBaslik.getText();
                  softAssert.assertEquals(ikiciUrunIsim,seciliIkinciUrun,"secili urun ad kiyaslamasi Failed");
        softAssert.assertAll();

        Driver.closeDriver();

    }
   @Test(groups = "deneme")
    public void test02(){
       //2. test:
       //     1- Siteye erişim
       Driver.getDriver().get("https://www.chanel.com/us/");
       //     2- Makyaja Erişim => Ruj kategorisi (üst menüde)
       chanelcomPage.makeUpButton.click();
       chanelcomPage.lipsctickElment.click();
       //     3- ROUGE ALLURE ürününe tıklayın

       //     4- Ürünü sepete ekleyin
       chanelcomPage.rougeAallureUrun.click();
       chanelcomPage.addButon.click();
       chanelcomPage.xIsareti.click();

       //     5- Sepeti Görüntüle --> Tamam, eğer sepette "ROUGE ALLURE" ürünü varsa adet=1 ve toplam sepet ürün fiyatına eşittir.
       chanelcomPage.sepetButton.click();
       SoftAssert softAssert=new SoftAssert();

       softAssert.assertTrue(chanelcomPage.sepettekiUrun.isDisplayed());
       softAssert.assertEquals(chanelcomPage.urunFiyat,chanelcomPage.totaLPrice);

   }






}
