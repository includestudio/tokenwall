package com.includestudio.tokenwall.acceptance.steps;

import com.includestudio.tokenwall.acceptance.pages.Pages;
import com.includestudio.tokenwall.acceptance.pages.RegisterPage;
import org.jbehave.core.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 5/13/12
 */
public class ICanRegisterSteps {

    private RegisterPage registerPage;
    private final Pages pages = new Pages();

    @BeforeScenario
    public void beforeScenario() {
        registerPage = pages.newRegisterPage();
    }

    @Given("I am on register page")
    public void onRegisterPage() {
        registerPage.go();
    }

    @When("I input username $username")
    public void inputUsername(String username) {
        registerPage.typeUsername(username);
    }

    @When("I input password $password")
    public void inputPassword(String password) {
        registerPage.typePassword(password);
    }

    @When("I confirm password $passwordConfirm")
    public void inputConfirmPassword(String passwordConfirm) {
        registerPage.confirmPassword(passwordConfirm);
    }

    @When("I submit")
    public void submit() {
        registerPage.submitRegisterForm();
    }

    @Then("I am on page with title '$title'")
    public void onPageWithTile(String title) {
        assertThat(registerPage.isOnPageWithTitle(title), is(true));
    }

    @Then("I am redirected to '$page' page after $timeout seconds")
    public void redirectToHomePageAuto(String page, int timeout) throws InterruptedException {
        int tolerance = 2;
        TimeUnit.SECONDS.sleep(timeout + tolerance);
        assertThat(registerPage.isOnPageWithTitle("Home"), is(true));
    }


    @Then("I am still on register page")
    public void stillOnRegisterPage() {
        assertThat(registerPage.isOnPageWithTitle("Register"), is(true));
    }

    @Then("a error message shows ’$error‘")
    public void errorShown(String error) {
        assertThat(registerPage.hasError(error), is(true));
    }

    @AfterScenario
    public void afterScenario() {
        registerPage.close();
    }

}
