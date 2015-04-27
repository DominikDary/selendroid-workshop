/*
 * Copyright 2015 Dominik Dary
 * 
 * Selendroid Workshop is licensed under a Creative Commons Attribution 4.0 International License.
 * 
 * You may obtain a copy of the License at
 * 
 * http://creativecommons.org/licenses/by/4.0/
 */
package io.selendroid.testapp.flows;

import io.selendroid.testapp.User;
import io.selendroid.testapp.pages.MainPage;
import io.selendroid.testapp.pages.UserRegistrationPage;
import io.selendroid.testapp.pages.UserValidationPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class UserRegistrationFlows {
  private WebDriver driver;

  public UserRegistrationFlows(WebDriver driver) {
    this.driver = driver;
  }

  public UserValidationPage shouldRegisterUser(User user) {
    MainPage mainPage = new MainPage(driver);
    UserRegistrationPage userRegistrationPage = mainPage.openUserRegistration();
    userRegistrationPage.enterUserName(user.username);
    userRegistrationPage.enterEmail(user.email);
    userRegistrationPage.enterPassword(user.password);
    Assert.assertEquals("Mr. Burns", userRegistrationPage.getDisplayedName());
    userRegistrationPage.setName(user.name);
    userRegistrationPage.selectPreferedProgrammingLanguage(user.programmingLanguage);
    userRegistrationPage.acceptTermsAndConditions();
    return userRegistrationPage.registerUser();
  }
}
