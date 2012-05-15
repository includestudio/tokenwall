package com.includestudio.tokenwall.acceptance.pages;

import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Pages {

    public Pages() {
    }

    public RegisterPage newRegisterPage() {
        return new RegisterPage(new HtmlUnitDriver() {
            @Override
            protected WebClient modifyWebClient(WebClient client) {
                WebClient webClient = super.modifyWebClient(client);
                webClient.setRefreshHandler(new ThreadedRefreshHandler());
                return webClient;
            }
        });
    }
}