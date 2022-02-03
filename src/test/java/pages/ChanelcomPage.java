package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ChanelcomPage {


    public ChanelcomPage (){

        PageFactory.initElements(Driver.getDriver(),this);
        //BU islemi yaparak driveri bu sayfadada kullanabiliyoruz

    }

    @FindBy(xpath = "(//button[@title='Search'])[2]")
    public WebElement chanelAramaKutusu;

    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement chanelAramaKutusuInput;

    @FindBy(xpath = "//h4[@class='product-item__title heading is-7 is-cropped false']")
    public List<WebElement> chanelArananUrunler;


}
