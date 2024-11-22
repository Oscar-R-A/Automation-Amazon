package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement search_bar;
    @FindBy(id = "nav-search-submit-button")
    private WebElement search_button;
    public void type_a_product(String strProduct){
        search_bar.click();
        search_bar.sendKeys(strProduct);
    }
    public ResultSearchPage search_product(){
        search_button.click();
        return new ResultSearchPage(super.getDriver());
    }
}
