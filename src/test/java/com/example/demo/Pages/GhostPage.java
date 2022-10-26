package com.example.demo.Pages;

import com.example.demo.Utils.BaseUiTest;
import com.example.demo.Utils.Util;
import org.openqa.selenium.By;

public class GhostPage extends BaseUiTest {
    public static void clickResourcesButton() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Resources')]")).click();
        Util.waitForPageToLoad();
    }
    public static void clickStartHereButton() {
        getDriver().findElement(By.xpath("//p[contains(text(), 'Start here')]")).click();
        Util.waitForPageToLoad();
    }

    public static void navigateToGhostPage(){
        getDriver().navigate().to("https://ghost.org");
        Util.waitForPageToLoad();
    }
}
