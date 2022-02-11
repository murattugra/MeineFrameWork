package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99Page {


    public Guru99Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//iframe[@aria-label='Privacy Manager window']")
            public WebElement iframe1;

    @FindBy(xpath = "//span[contains(text(),'Accept All')]")
    public WebElement cookiesAcceptButton;

    @FindBy(xpath = "//a[contains(text(),'BANK')]")
    public WebElement bankButton;

    @FindBy(xpath = "//a[contains(text(),'SALES')]")
    public WebElement salesButton;

    @FindBy(xpath = "(//a[contains(text(),'5000')])[2]")
    public WebElement first5000Button;

    @FindBy(xpath = "(//a[contains(text(),' 5000')])[2]")
    public WebElement second5000Button;

    @FindBy(xpath = "(//a[contains(text(),'5000')])[1]")
    public WebElement firstEksi5000Button;

    @FindBy(xpath = "(//a[contains(text(),'5000')])[3]")
    public WebElement secondEksi5000Button;


    @FindBy(xpath = "(//li[@class='placeholder'])[1]")
    public WebElement debitSideAccontBox;

    @FindBy(xpath = "(//li[@class='placeholder'])[2]")
    public WebElement debitSideAmountBox;

    @FindBy(xpath = "(//li[@class='placeholder'])[3]")
    public WebElement creditSideAccontBox;
    @FindBy(xpath = "(//li[@class='placeholder'])[4]")
    public WebElement creditSideAmountBox;

    @FindBy(xpath = "//a[.='Perfect!']")
    public WebElement perfektButton;

}
