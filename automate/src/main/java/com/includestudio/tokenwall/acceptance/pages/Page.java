package com.includestudio.tokenwall.acceptance.pages;

import org.openqa.selenium.WebDriver;

/**
 * Since: 5/15/12
 */
public class Page {
    protected final WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void close() {
        webDriver.close();
    }
}
