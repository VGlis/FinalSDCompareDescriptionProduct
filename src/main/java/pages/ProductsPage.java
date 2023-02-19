package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductsPage {

    public WebDriver driver;

    public ProductsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        String url = driver.getCurrentUrl();

        if(url.equals("https://www.saucedemo.com/inventory.html")) {
            return true;
        }
        else {
            return false;
        }

    }

    public void close() {
        driver.close();
        driver.quit();
    }



    public Integer productCountInCart() {

        List<WebElement> listCartBadge = driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"));
        if(listCartBadge.size() == 0) {
            return 0;
        }
        else {
            return Integer.parseInt(listCartBadge.get(0).getText());
        }
    }

    public WebElement getCart() {
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }

    public void openCart() {
        //driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        getCart().click();
    }


    public String getNameProductInProduct() {
        WebElement NameProductInProduct = driver.findElement(By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[1]"));
        String NameProductInProductText = NameProductInProduct.getText();
        return NameProductInProductText;
    }

    public String getDescriptionProductInProduct() {
        WebElement DescriptionProductInProduct = driver.findElement(By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[2]"));
        String DescriptionProductInProductText = DescriptionProductInProduct.getText();
        return DescriptionProductInProductText;
    }

    public Double getPriceProductInProduct() {
        WebElement PriceProductInProduct = driver.findElement(By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[3]"));
        String PriceProductInProductText = PriceProductInProduct.getText();
        return Double.parseDouble(PriceProductInProductText.substring(1));
    }

    public WebElement getButtonCartFromSingleProduct() {
        return driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
    }

    public void clickAddCartFromSingleProduct() {
        getButtonCartFromSingleProduct().click();

    }

    public void addProductToCartByName(String productName) {
        WebElement container = driver.findElement(By.id("inventory_container"));

        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemName = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String itemNameText = itemName.getText();

            if(itemNameText.equals(productName)) {
                WebElement addButton = listInventoryItems.get(i).findElement(By.xpath(".//button"));
                addButton.click();
                break;
            }
        }
    }

    public String getNameProductInventoryPage(String productName) {
        String itemNameText = " ";
        WebElement container = driver.findElement(By.id("inventory_container"));
        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemName = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            itemNameText = itemName.getText();

            if(itemNameText.equals(productName)) {
                return itemNameText;
            }
        }
        return itemNameText;
    }

    public String getDescriptionProductInventoryPage(String productName) {
        String itemDescriptionText = " ";
        WebElement container = driver.findElement(By.id("inventory_container"));
        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemName = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String itemNameText = itemName.getText();

            if(itemNameText.equals(productName)) {
                for(int j = 0; j < listInventoryItems.size(); j++) {
                    WebElement itemDescription = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_desc']"));
                    itemDescriptionText = itemDescription.getText();

                }
            }
        }
        return itemDescriptionText;
    }

    public Double getPriceProductInventoryPage(String productName) {
        String itemPriceText = " ";
        WebElement container = driver.findElement(By.id("inventory_container"));
        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < listInventoryItems.size(); i++) {
            WebElement itemName = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            String itemNameText = itemName.getText();

            if(itemNameText.equals(productName)) {
                for(int j = 0; j < listInventoryItems.size(); j++) {
                    WebElement itemDescription = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
                    itemPriceText = itemDescription.getText();

                }
            }
        }
        return Double.parseDouble(itemPriceText.substring(1));
    }



}
