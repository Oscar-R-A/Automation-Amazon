package Pages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "productTitle")
    private WebElement product_title;
    @FindBy(id = "add-to-cart-button")
    private WebElement add_to_cart_button;
    public void validate_product_page_opened(){
        if(product_title.isDisplayed()){
            System.out.println("Pagina abierta correctamente");
        }
        else {
            System.out.println("No se abrio el producto");
        }
    }
    public CartPage add_product(){
        if(add_to_cart_button.isDisplayed()){
            add_to_cart_button.click();
        }
        else {
            System.out.println("Este producto no esta para colombia");
        }
        return new CartPage(super.getDriver());
    }
}
