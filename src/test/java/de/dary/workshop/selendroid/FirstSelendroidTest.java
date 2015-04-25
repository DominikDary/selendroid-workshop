/*
 * Copyright 2015 Dominik Dary
 * 
 * Selendroid Workshop is licensed under a Creative Commons Attribution 4.0 International License.
 * 
 * You may obtain a copy of the License at
 * 
 * http://creativecommons.org/licenses/by/4.0/
 */
package de.dary.workshop.selendroid;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstSelendroidTest {
  private static SelendroidLauncher selendroidServer = null;
  private static WebDriver driver = null;

  @Test
  public void shouldBeAbleToEnterText() throws Exception {
    SelendroidCapabilities caps =
        new SelendroidCapabilities("io.selendroid.testapp:0.16.0-SNAPSHOT");

    driver = new SelendroidDriver(caps);
    WebElement inputField = driver.findElement(By.id("my_text_field"));
    inputField.sendKeys("Selendroid");
    Assert.assertEquals("Selendroid", inputField.getText());
  }

  @BeforeClass
  public static void startSelendroidServer() throws Exception {
    if (selendroidServer != null) {
      selendroidServer.stopSelendroid();
    }
    SelendroidConfiguration config = new SelendroidConfiguration();

    config.addSupportedApp("third-party/selendroid-test-app-0.16.0-SNAPSHOT.apk");
    selendroidServer = new SelendroidLauncher(config);
    selendroidServer.launchSelendroid();
  }

  @AfterClass
  public static void stopSelendroidServer() {
    if (driver != null) {
      driver.quit();
    }
    if (selendroidServer != null) {
      selendroidServer.stopSelendroid();
    }
  }
}
