/*
 * Copyright 2015 Dominik Dary
 * 
 * Selendroid Workshop is licensed under a Creative Commons Attribution 4.0 International License.
 * 
 * You may obtain a copy of the License at
 * 
 * http://creativecommons.org/licenses/by/4.0/
 */
package io.selendroid.testapp.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

  public MainPage(WebDriver webdriver) {
    super(webdriver);
  }

  public UserRegistrationPage openUserRegistration() {
    driver.get("and-activity://io.selendroid.testapp.RegisterUserActivity");
    return new UserRegistrationPage(driver);
  }
}
