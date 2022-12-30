@smoke
  Feature: adding product to wishlist
  #Scenario1
Scenario: adding product to wishlist
  Given navigate to home page
  When you press on heart button for product
  Then you will see success message "The product has been added to your wishlist"
  And Message color has green background



  #Scenario2
  Scenario: Checking Wishlist items
    Given you press on heart button for product
    And success message disappears
    When you hover on wishlist icon
    Then quantity value should be more than 0