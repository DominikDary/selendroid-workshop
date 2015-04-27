/*
 * Copyright 2015 Dominik Dary
 * 
 * Selendroid Workshop is licensed under a Creative Commons Attribution 4.0 International License.
 * 
 * You may obtain a copy of the License at
 * 
 * http://creativecommons.org/licenses/by/4.0/
 */
package io.selendroid.testapp;

public class User {
  public String username;
  public String email;
  public String password;
  public String name;
  public String programmingLanguage;

  public User(String username, String email, String password, String name,
      String programmingLanguage) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.name = name;
    this.programmingLanguage = programmingLanguage;
  }
}
