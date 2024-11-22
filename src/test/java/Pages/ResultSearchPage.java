package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultSearchPage extends BasePage{
    public ResultSearchPage(WebDriver driver){
        super(driver);
    }
    private String product_results = "div[data-cy=\"title-recipe\"] h2";
    private String img_products = "div img.s-image";
    @FindBy(css = "input[data-action-type=\"DISMISS\"]")
    private WebElement close_toater_button;
    public List listp_results(){
    getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(product_results)));
    List<WebElement> list_results = driver.findElements(By.cssSelector(product_results));
    System.out.println(list_results.size());
    return list_results;
    }
    public String validate_results(){
        WebElement product_selected;
        String title_product_selected = null;
        if(listp_results().size()>1) {
            product_selected = (WebElement) listp_results().get(2);
            title_product_selected = product_selected.getText().toLowerCase();
        }
        else{
            System.out.println("No funciono la lista");
        }
        System.out.println(title_product_selected);
        return title_product_selected;
    }
    public ProductPage open_product(){
        List<WebElement> results = driver.findElements(By.cssSelector(img_products));
        if (results.size() > 3) {
            WebElement select_product = results.get(2);
            System.out.println(select_product.getText());
            wait.until(ExpectedConditions.visibilityOf(select_product));

            // Enfocar el elemento usando JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", select_product);

            // Esperar a que el elemento sea clicable
            wait.until(ExpectedConditions.elementToBeClickable(select_product));
            //getWait().until(ExpectedConditions.elementToBeClickable(select_product));
            try {
                select_product.click();
                System.out.println("hace click");
            } catch (Exception e) {
                System.out.println("Error al hacer clic: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo seleccionar el producto");
        }
        return new ProductPage(super.getDriver());
    }
    public void close_toaster(){
        close_toater_button.click();
    }
}
