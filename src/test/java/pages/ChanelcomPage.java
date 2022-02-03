package pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "(//a[@class='product-list-inline__link'])[2]")
    public WebElement ikiciUrun;

    @FindBy(xpath = "//span[@class='heading product-details__title ']")
    public WebElement ikinciUrunSecildiktenSonraBaslik;

    @FindBy(xpath = "//span[@data-test='lnkAxisCategory_makeup']")
    public WebElement makeUpButton;

    @FindBy (xpath = "//a[@data-linkname='Lipstick']")
    public WebElement lipsctickElment;

    @FindBy(xpath = "//span[@data-test='imgPdouct_AxisSearchResultPage_151107']")
    public WebElement rougeAallureUrun;

    @FindBy(xpath = "//button[@id='pos-cnc-btn']")
    public WebElement addButon;

    @FindBy(xpath = "(//button[@class='button is-icon sidepanel__close js-sidepanel-close'])[2]")
    public WebElement xIsareti;

    @FindBy(xpath = "//button[@title='Shopping Bag - 1 item']")
    public WebElement sepetButton;

    @FindBy(xpath = "//span[@class='heading is-7']")
    public WebElement sepettekiUrun;

}
