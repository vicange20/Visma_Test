package com.example.demo.Pages;

import com.example.demo.Utils.BaseUiTest;
import com.example.demo.Utils.Util;
import org.openqa.selenium.By;

public class FosteringCommunityThroughCommentsPage extends BaseUiTest {

    public static void clickOnPricingButton() {
        getDriver().findElement(By.linkText("Pricing")).click();
        Util.waitForPageToLoad();
    }
}
