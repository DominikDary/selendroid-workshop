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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserValidationPage extends BasePage {
  public UserValidationPage(WebDriver webdriver) {
    super(webdriver);
  }

  public boolean areTermsAndAconditionsAccepted() {
    return Boolean.parseBoolean(driver.findElement(By.id("label_acceptAdds_data")).getText());
  }

  public String getEmail() {
    return driver.findElement(By.id("label_email_data")).getText();
  }

  public String getName() {
    return driver.findElement(By.id("label_name_data")).getText();
  }

  public String getPassword() {
    return driver.findElement(By.id("label_password_data")).getText();
  }

  public String getPreferredProgrammingLanguage() {
    return driver.findElement(By.id("label_preferedProgrammingLanguage_data")).getText();
  }

  public String getUserName() {
    return driver.findElement(By.id("label_username_data")).getText();
  }
}
