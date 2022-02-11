package tests.Chanel;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Guru99Page;
import utilities.ConfigReader;
import utilities.Driver;

public class Guru99com {





    @Test
    public void surukleBirak(){



//http://demo.guru99.com/test/drag_drop.html url e git
        Guru99Page guru99Page=new Guru99Page();
        Driver.getDriver().get(ConfigReader.getProperty("DemoGuruUrl"));
        Driver.getDriver().switchTo().frame(guru99Page.iframe1);
        guru99Page.cookiesAcceptButton.click();
        Driver.getDriver().switchTo().parentFrame();
//DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
// CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
//////DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
////CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
////Perfect butonun goruntulendigini dogrulayin
////
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(guru99Page.bankButton,guru99Page.debitSideAccontBox)
                .dragAndDrop(guru99Page.salesButton,guru99Page.creditSideAccontBox)
                .dragAndDrop(guru99Page.second5000Button,guru99Page.debitSideAmountBox)
                .dragAndDrop(guru99Page.second5000Button,guru99Page.creditSideAmountBox)
                .perform();

        Assert.assertTrue(guru99Page.perfektButton.isDisplayed());
Driver.closeDriver();

    }


}
//● Exact Text Belirli bir text) ile element bulma:
//○ //tagname[.='text name'] Belirli bir tagname , herhangi bir attribute, belirli bir text
//○ //*[.='text name'] Herhangi bir tag, belirli bir text.
//○ //*[(text()='exact text with extra space and all')] Herhangi bir tag, belirli bir text
//● Belirli bir metni içeren bir öğeyi bulmak için şunları kullanabiliriz:
//○ //*[contains(text(),'piece of text')]