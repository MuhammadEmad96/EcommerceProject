@smoke
  Feature: Searching for a product in home page
    Scenario Outline: Searching functionality for different objects by name
      Given navigate to home page2
      When Entering product name in search box as "<Object>"
      And press on search
      Then search shows relevant results as inserted word "<Object>"
      And navigate to correct URL
      Examples:
        | Object |
        | book |
        | laptop |
        | nike |

    Scenario Outline: Searching functionality for different objects by sku
      Given navigate to home page2
      When Entering product sku in search box as "<sku>"
      And press on search
      Then sku shown in page must be the same as one used for search "<sku>"
      Examples:
        | sku |
        | SCI_FAITH |
        | AP_MBP_13 |
        | APPLE_CAM |
