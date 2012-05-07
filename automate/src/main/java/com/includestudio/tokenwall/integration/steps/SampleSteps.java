package com.includestudio.tokenwall.integration.steps;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Since: 5/4/12
 */
public class SampleSteps {

    private WebDriver webDriver;
    private String url;

    @BeforeScenario
    public void beforeScenario(){
        webDriver = new HtmlUnitDriver();
    }

    @AfterScenario
    public void afterScenario(){
        webDriver.close();
    }

    @Given("URL '$url'")
    public void givenUrl(String url){
        this.url = url;
    }

    @When("I open it")
    public void openTheUrl(){
        webDriver.navigate().to(url);
    }

    @Then("I am on welcome page")
    public void onWelcomePage() {
        assertThat(webDriver.getTitle(), is("Welcome"));
    }

    @Then("It says '$msg'")
    public void thePageSay(String msg) {
        WebElement h3 = webDriver.findElement(By.tagName("h3"));
        assertThat(h3.getText(), is(msg));
    }
}
