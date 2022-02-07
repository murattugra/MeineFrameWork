package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ReactshoppingPage {


    public  ReactshoppingPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//p[@class='shelf-item__title']")
    public List<WebElement> tumUrunlerIsimleriListesi;

    @FindBy(xpath = "(//div[.='Add to cart'])[1]")
    public WebElement addToCartButonu;



    public void rastgeleUrunSecmeVeAdlariniYazma(int sayi) throws InterruptedException {
        Faker faker=new Faker();
        List<Integer> secilenSayilarListesi=new ArrayList<>();
        List<String> secilenUrunleriFiyatlariListesi=new ArrayList<>();
        JavascriptExecutor jse;

        for (int j = 1; j <= sayi; j++) {
            int rastgelesayi=faker.random().nextInt(1,16);
            if (!secilenSayilarListesi.contains(rastgelesayi)) {
                String xPathRastgeleaddButonlari="(//div[.='Add to cart'])["+rastgelesayi+"]";
                WebElement rastgeleAddButonelement=Driver.getDriver().findElement(By.xpath(xPathRastgeleaddButonlari));
                jse=(JavascriptExecutor) Driver.getDriver();
                jse.executeScript("arguments[0].scrollIntoView();",rastgeleAddButonelement);
                String xPathRastgeleUrunadlari="(//p[@class='shelf-item__title'])["+rastgelesayi+"]";
                WebElement rastgeleUrunAdlari=Driver.getDriver().findElement(By.xpath(xPathRastgeleUrunadlari));
                String xPathSecilenUrunFiyati="(//div[@class='val'])["+rastgelesayi+"]";
                WebElement secilenUrunFiyatElement=Driver.getDriver().findElement(By.xpath(xPathSecilenUrunFiyati));
                secilenUrunleriFiyatlariListesi.add(secilenUrunFiyatElement.getText());

                rastgeleAddButonelement.click();
                System.out.println(rastgeleUrunAdlari.getText());
                secilenSayilarListesi.add(rastgelesayi);
            }else {
                j--;

            }

        }

        secilenUrunlerinFiyatlariniTopla(secilenUrunleriFiyatlariListesi);

    }



    public void secilenUrunlerinFiyatlariniTopla(List<String> liste){
                String fiyatSt;
                double fiyatDb;
                double fiyatlaToplam;
        for (String each: liste
             ) {
            fiyatSt=each;
            System.out.println(fiyatSt);
           fiyatSt=fiyatSt.replace("$","");

            System.out.println(fiyatSt);
            fiyatDb=Double.parseDouble(fiyatSt);

            System.out.println(fiyatDb);

        }

    }
}
