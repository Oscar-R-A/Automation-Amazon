package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTests extends BaseTest{
    HomePage homePage;
    ResultSearchPage resultSearchPage;
    ProductPage productPage;
    CartPage cartPage;
    String product = "Asus";
    @Test
    public void searchProduct(){
        this.homePage =loadFirstPage();
        this.homePage.type_a_product(product);
        this.resultSearchPage = homePage.search_product();
        Assert.assertTrue(resultSearchPage.validate_results().contains("asus"));
        this.resultSearchPage.close_toaster();
        this.productPage = resultSearchPage.open_product();
        this.productPage.validate_product_page_opened();
        this.cartPage = productPage.add_product();

    }
}
