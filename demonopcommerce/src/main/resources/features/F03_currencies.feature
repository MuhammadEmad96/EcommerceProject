@smoke
  Feature: Select euro currency and verify that products appear with euro symbol
  Scenario: verify Euro Symbol (€) is shown on the 4 products displayed in Home page
  Given navigate to home page
    When select euro currency
    Then all 4 products appear with euro sign