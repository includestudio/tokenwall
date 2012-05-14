package com.includestudio.tokenwall.acceptance.steps;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 5/13/12
 */
public class ICanRegisterSteps {

    private WebDriver webDriver;

    @BeforeScenario
    public void beforeScenario(){
        webDriver = new HtmlUnitDriver();
    }

    @Given("I am on register page")
    public void navigateToRegisterPage(){
       webDriver.navigate().to("http://localhost:8080/tokenwall/register");
    }

    @When("I input username $username")
    public void inputUsername(String username){
       webDriver.findElement(By.id("username")).sendKeys(username);
    }

    @When("I input password $password")
    public void inputPassword(String password){
      webDriver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I confirm password $passwordConfirm")
    public void confirmPassword(String passwordConfirm){
      webDriver.findElement(By.id("confirm")).sendKeys(passwordConfirm);
    }

    @When("I submit")
    public void submit(){
      webDriver.findElement(By.id("register")).click();
    }

    @Then("I am on page with title '$title'")
    public void shouldRedirectToPage(String title){
      assertThat(webDriver.getTitle(), is(title));
    }

    @AfterScenario
    public void afterScenario(){
        webDriver.close();
    }

}
