@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter his first name
    And user enter his  last name
    And user enter his birth date
    And user enter his email
    And user enter his password
    And user press on Register button
    Then Success Msg is displayed