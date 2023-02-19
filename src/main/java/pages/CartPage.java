package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.math.RoundingMode;
import java.math.BigDecimal;


import java.io.Console;
import java.util.Scanner;

import java.util.List;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getNameProductInCart() {
        WebElement NameProductInCart = driver.findElement(By.className("inventory_item_name"));
        String NameProductInCartText = NameProductInCart.getText();
        return NameProductInCartText;
    }

    public String getDescriptionProductInCart() {
        WebElement DescriptionProductInCart = driver.findElement(By.className("inventory_item_desc"));
        String DescriptionProductInCartText = DescriptionProductInCart.getText();
        return DescriptionProductInCartText;
    }

    public Double getPriceProductInCart() {
        WebElement PriceProductInCart = driver.findElement(By.className("inventory_item_price"));
        String PriceProductInCartText = PriceProductInCart.getText();
        return Double.parseDouble(PriceProductInCartText.substring(1));
    }



    public void close() {
        driver.close();
        driver.quit();
    }

}
