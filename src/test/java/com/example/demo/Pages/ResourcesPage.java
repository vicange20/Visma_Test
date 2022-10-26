package com.example.demo.Pages;

import com.example.demo.Utils.BaseUiTest;
import com.example.demo.Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResourcesPage extends BaseUiTest {

    public static WebElement getSearchInput() {
        return getDriver().findElement(By.id("search-input"));
    }

    public static void select10thResult() {
        getDriver().findElements(By.cssSelector(".search-result-item")).get(9).click();
        Util.waitForPageToLoad();
    }
}