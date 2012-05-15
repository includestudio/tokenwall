package com.includestudio.tokenwall.acceptance.pages;

import com.includestudio.tokenwall.acceptance.steps.ICanRegisterSteps;
import org.jbehave.core.annotations.AfterScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void go() {
        webDriver.navigate().to("http://localhost:8080/tokenwall/register");
    }

    public void typeUsername(String username) {
        webDriver.findElement(By.id("username")).sendKeys(username);
    }

    public void typePassword(String password) {
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void confirmPassword(String passwordConfirm) {
        webDriver.findElement(By.id("confirm")).sendKeys(passwordConfirm);
    }

    public void submitRegisterForm() {
        webDriver.findElement(By.id("register")).click();
    }

    public boolean isOnPageWithTitle(String title) {
        return webDriver.getTitle().equals(title);
    }

    public boolean hasError(String error) {
        return webDriver.findElement(By.id("error")).getText().equals(error);
    }

}