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
  public void shouldRegisterNewAccount() throws Exception {
    SelendroidCapabilities caps =
        new SelendroidCapabilities("io.selendroid.testapp:0.16.0-SNAPSHOT");

    driver = new SelendroidDriver(caps);
    driver.get("and-activity://io.selendroid.testapp.RegisterUserActivity");

    WebElement username = driver.findElement(By.id("inputUsername"));
    String userNameValue = "U$erNAme";
    username.sendKeys(userNameValue);

    String email = "me@myserver.com";
    driver.findElement(By.name("email of the customer")).sendKeys(email);

    String password = "myLittleSecret";
    driver.findElement(By.id("inputPassword")).sendKeys(password);

    WebElement nameInput = driver.findElement(By.xpath("//EditText[@id='inputName']"));
    Assert.assertEquals(nameInput.getText(), "Mr. Burns");
    nameInput.clear();
    String name = "Romanian Tester";
    nameInput.sendKeys(name);

    driver.findElement(By.tagName("Spinner")).click();
    String programmingLanguage = "Python";
    driver.findElement(By.linkText(programmingLanguage)).click();

    driver.findElement(By.className("android.widget.CheckBox")).click();

    driver.findElement(By.linkText("Register User (verify)")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "and-activity://VerifyUserActivity");

    Assert.assertEquals(driver.findElement(By.id("label_username_data")).getText(), userNameValue);
    Assert.assertEquals(driver.findElement(By.id("label_email_data")).getText(), email);
    Assert.assertEquals(driver.findElement(By.id("label_password_data")).getText(), password);
    Assert.assertEquals(driver.findElement(By.id("label_name_data")).getText(), name);
    Assert.assertEquals(driver.findElement(By.id("label_preferedProgrammingLanguage_data"))
        .getText(), programmingLanguage);
    Assert.assertEquals(driver.findElement(By.id("label_acceptAdds_data")).getText(), "true");
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
