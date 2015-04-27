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

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage extends BasePage {
  private By nameLocator = By.xpath("//EditText[@id='inputName']");

  public UserRegistrationPage(WebDriver webdriver) {
    super(webdriver);
  }

  public UserRegistrationPage acceptTermsAndConditions() {
    driver.findElement(By.className("android.widget.CheckBox")).click();
    return this;
  }

  public UserRegistrationPage enterEmail(String email) {
    driver.findElement(By.name("email of the customer")).sendKeys(email);
    return this;
  }

  /**
   * Clears the name input field and enters the #name.
   * @param name The name to enter
   * @return The {@link #UserRegistrationPage(WebDriver)}
   */
  public UserRegistrationPage setName(String name) {
    WebElement nameInput = driver.findElement(nameLocator);
    nameInput.clear();
    nameInput.sendKeys(name);
    return this;
  }

  public UserRegistrationPage enterPassword(String password) {
    driver.findElement(By.id("inputPassword")).sendKeys(password);
    return this;
  }

  public UserRegistrationPage enterUserName(String userNameValue) {
    WebElement username = driver.findElement(By.id("inputUsername"));
    username.sendKeys(userNameValue);
    return this;
  }

  public String getDisplayedName() {
    WebElement nameInput = driver.findElement(nameLocator);
    return nameInput.getText();
  }

  public UserValidationPage registerUser() {
    driver.findElement(By.linkText("Register User (verify)")).click();
    return new UserValidationPage(driver);
  }

  public UserRegistrationPage selectPreferedProgrammingLanguage(String programmingLanguage) {
    driver.findElement(By.tagName("Spinner")).click();
    driver.findElement(By.linkText(programmingLanguage)).click();
    return this;
  }

}
