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

public abstract class BasePage {
  protected WebDriver driver;

  public BasePage(WebDriver webdriver) {
    driver = webdriver;
  }
}
