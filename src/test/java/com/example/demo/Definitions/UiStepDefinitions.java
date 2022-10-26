package com.example.demo.Definitions;

import com.example.demo.Pages.*;
import com.example.demo.Utils.Context;
import com.example.demo.Utils.ScenarioContext;
import com.example.demo.Utils.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;


@CucumberContextConfiguration
@SpringBootTest
public class UiStepDefinitions {

    private ScenarioContext context = new ScenarioContext();

    @Given("I navigate to ghost.org site")
    public void iNavigateToGhostSite() {
        GhostPage.navigateToGhostPage();
        Util.waitForPageToLoad();
    }

    @When("I navigate to resources section")
    public void iNavigateResourcesSection() {GhostPage.clickResourcesButton();
    }

    @And("I click on start here section")
    public void iClickOnStartHereSection() {
        GhostPage.clickStartHereButton();
    }

    @And("I type 'create new blog'")
    public void iTypeText() {
        ResourcesPage.getSearchInput().sendKeys("create new blog");
    }

    @And("I select the 10th result from the search")
    public void iSelect10thResult() throws InterruptedException {
        Thread.sleep(4000);
        ResourcesPage.select10thResult();
    }

    @And("I click on pricing section")
    public void iNavigateToPricingSection() {
        FosteringCommunityThroughCommentsPage.clickOnPricingButton();
    }

    protected HashMap<String, Integer> basePrice;

    @And("I increased audience slider")
    public void iIncreasedSlider() throws InterruptedException {
        basePrice = PricingPage.getPrices();
        Thread.sleep(3000);
        PricingPage.increaseAudienceSlider();
    }

    @Then("The prices will increase")
    public void pricesIncrease(){
        HashMap<String, Integer> pricesAfterUpdate = PricingPage.getPrices();
        assertThat( pricesAfterUpdate.get("starterPrice"), is(greaterThan(basePrice.get("starterPrice"))));
        assertThat( pricesAfterUpdate.get("creatorPrice"), is(greaterThan(basePrice.get("creatorPrice"))));
        assertThat( pricesAfterUpdate.get("teamPrice"), is(greaterThan(basePrice.get("teamPrice"))));
        assertThat( pricesAfterUpdate.get("businessPrice"), is(greaterThan(basePrice.get("businessPrice"))));
    }
}
