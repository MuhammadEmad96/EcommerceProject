@smoke
Feature:hoverCategories Feature

  Scenario: Selecting 1 main category randomly then select sub  category
    Given navigate to home page2
    When Select a category and a sub category
    Then compare the selected category with header title