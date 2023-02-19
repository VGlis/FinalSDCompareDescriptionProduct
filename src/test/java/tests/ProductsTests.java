package tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;


public class ProductsTests {

    /* Checking if the basket is empty
    // Then
    // Product setting in individual view (Single Product Page), adding to cart By BUTTON, and checking
    // compare in cart: name, description, and price of product
    */
    @Test
    public void verifyProductDescriptionIndividualView() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Vladan\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        loginPage.clickProductLinkTextSauceLabsBackpack();

        ProductsPage productsPage = new ProductsPage(driver);

        System.out.println("Number of Items in Cart before add: " + productsPage.productCountInCart());
        Assert.assertEquals(productsPage.productCountInCart(), 0, "Product count is not equals");
        System.out.println("***************************************************************************************");

        String NameProductInProductText = productsPage.getNameProductInProduct();
        String DescriptionProductInProductText = productsPage.getDescriptionProductInProduct();
        Double getPriceProductInProduct = productsPage.getPriceProductInProduct();

        System.out.println("Name of Product in Single Item:         " + NameProductInProductText);
        System.out.println("Description of Product in Single Item:  " + DescriptionProductInProductText);
        System.out.println("Price of Product in Single Item:        $" + getPriceProductInProduct);

        productsPage.clickAddCartFromSingleProduct();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        System.out.println("***************************************************************************************");

        String NameProductInCartText = cartPage.getNameProductInCart();
        String DescriptionProductInCartText = cartPage.getDescriptionProductInCart();
        Double getPriceProductInCart = cartPage.getPriceProductInCart();

        System.out.println("Name of single Product in Cart Page:         " + NameProductInCartText);
        System.out.println("Description of single Product in Cart Page:  " + DescriptionProductInCartText);
        System.out.println("Price of single Product in Cart Page:        $" + getPriceProductInCart);

        System.out.println("***************************************************************************************");
        System.out.println("Number of Items in Cart after add: " + productsPage.productCountInCart());
        Assert.assertEquals(productsPage.productCountInCart(), 1, "Product count is not equals");


        Assert.assertEquals(NameProductInCartText, NameProductInProductText, "Product Name is not equals");
        Assert.assertEquals(DescriptionProductInProductText, DescriptionProductInCartText, "Product Description is not equals");
        Assert.assertEquals(getPriceProductInProduct, getPriceProductInCart, "Product Price is not equals");


        cartPage.close();
    }


     /* Checking if the basket is empty
     // Then
     // Product setting in inventory view (All Product Page), adding to cart by PRODUCT NAME, and checking
     // compare in cart: name, description, and price of product
     */
    @Test
    public void verifyProductDescriptionInventoryView() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Vladan\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);

        System.out.println("Number of Items in Cart before add: " + productsPage.productCountInCart());
        Assert.assertEquals(productsPage.productCountInCart(), 0, "Product count is not equals");
        System.out.println("***************************************************************************************");

        String singleProductName = "Sauce Labs Bolt T-Shirt";
        String NameProductInProductText =  productsPage.getNameProductInventoryPage(singleProductName);
        String DescriptionProductInProductText = productsPage.getDescriptionProductInventoryPage(singleProductName);
        Double getPriceProductInProduct = productsPage.getPriceProductInventoryPage(singleProductName);

        System.out.println("Name of Product take from inventory page:         " + NameProductInProductText);
        System.out.println("Description of take from inventory page:          " + DescriptionProductInProductText);
        System.out.println("Price of Product take from inventory page:       $" + getPriceProductInProduct);
        System.out.println("***************************************************************************************");

        productsPage.addProductToCartByName(singleProductName);
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);


        String NameProductInCartText = cartPage.getNameProductInCart();
        String DescriptionProductInCartText = cartPage.getDescriptionProductInCart();
        Double getPriceProductInCart = cartPage.getPriceProductInCart();

        System.out.println("Name of single Product in Cart Page:         " + NameProductInCartText);
        System.out.println("Description of single Product in Cart Page:  " + DescriptionProductInCartText);
        System.out.println("Price of single Product in Cart Page:        $" + getPriceProductInCart);

        System.out.println("***************************************************************************************");
        System.out.println("Number of Items in Cart after add: " + productsPage.productCountInCart());
        Assert.assertEquals(productsPage.productCountInCart(), 1, "Product count is not equals");

        Assert.assertEquals(NameProductInCartText, NameProductInProductText, "Product Name is not equals");
        Assert.assertEquals(DescriptionProductInProductText, DescriptionProductInCartText, "Product Description is not equals");
        Assert.assertEquals(getPriceProductInProduct, getPriceProductInCart, "Product Price is not equals");


        cartPage.close();
    }
}
