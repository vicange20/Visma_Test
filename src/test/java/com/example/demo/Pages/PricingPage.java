package com.example.demo.Pages;

import com.example.demo.Utils.BaseUiTest;
import com.example.demo.Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;

public class PricingPage extends BaseUiTest {

    public static HashMap<String, Integer> getPrices() {
        HashMap<String, Integer> prices = new HashMap<>();

        WebElement starterPrice = getDriver().findElement(By.xpath("//p[@data-price='starter']"));
        prices.put("starterPrice", Integer.valueOf(starterPrice.getText()));
        WebElement creatorPrice = getDriver().findElement(By.xpath("//p[@data-price='creator']"));
        prices.put("creatorPrice", Integer.valueOf(creatorPrice.getText()));
        WebElement teamPrice = getDriver().findElement(By.xpath("//p[@data-price='team']"));
        prices.put("teamPrice", Integer.valueOf(teamPrice.getText()));
        WebElement businessPrice = getDriver().findElement(By.xpath("//p[@data-price='business']"));
        prices.put("businessPrice", Integer.valueOf(businessPrice.getText()));
        return prices;
    }

    public static void increaseAudienceSlider() throws InterruptedException {
            WebElement e = driver.findElement(By.id("members"));
//            e.click();
//            for (int i = 0; i < 8; i++){
//                e.sendKeys(Keys.ARROW_RIGHT);
//            Thread.sleep(100);}
            Actions move = new Actions(driver);
            move.moveToElement(e).clickAndHold().moveByOffset(0,5).release().perform();
            Util.waitForPageToLoad();
        }
}
