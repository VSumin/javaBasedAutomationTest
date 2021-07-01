package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.pages.homePage.HomePage;

public class HomePageExactActions {
    HomePage homePage = new HomePage();

    public void NavigateToPage() {
        Selenide.open("");
    }

    public boolean isLogoVisible() {
        return homePage.logo.isVisible();
    }
}
