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

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.testapp.User;
import io.selendroid.testapp.flows.UserRegistrationFlows;
import io.selendroid.testapp.pages.UserValidationPage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FirstSelendroidTest {
  private static SelendroidLauncher selendroidServer = null;
  private static WebDriver driver = null;

  @Test
  public void shouldRegisterNewAccount() throws Exception {
    SelendroidCapabilities caps =
        new SelendroidCapabilities("io.selendroid.testapp:0.16.0-SNAPSHOT");

    driver = new SelendroidDriver(caps);

    User user = new User("u$erNAme", "me@myserver.ro", "mySecret", "Romanian Tester", "Python");
    UserRegistrationFlows userRegistrationFlows = new UserRegistrationFlows(driver);
    UserValidationPage userValidationPage = userRegistrationFlows.shouldRegisterUser(user);

    assertThat(userValidationPage.getUserName(), equalTo(user.username));
    assertThat(userValidationPage.getEmail(), equalTo(user.email));
    assertThat(userValidationPage.getPassword(), equalTo(user.password));
    assertThat(userValidationPage.getName(), equalTo(user.name));
    assertThat(userValidationPage.getPreferredProgrammingLanguage(),
        equalTo(user.programmingLanguage));
    assertThat(userValidationPage.areTermsAndAconditionsAccepted(), equalTo(true));
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
