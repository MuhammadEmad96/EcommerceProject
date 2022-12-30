@smoke
Feature: F02_Login | users could use login functionality to use their accounts

#Test scenario 1
Scenario: user could login with valid email and password
  Given user go to login page
  When user login with "test01@example.com" and "P@ssw0rd"
  And user press on login button
  Then user login to the system successfully


#Test scenario 2
Scenario: user could not login with invalid email and password
  Given user go to login page
  When user login with "wrong@example.com" and "P@ssw0rd"
  And user press on login button
  Then user could not login to system