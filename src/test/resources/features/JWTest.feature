Feature: JW Test

  Scenario: Alter JW Player properties
    Given I am on the JW Player Dashboard Page
    When I log in using the email axl2807@gmail.com and the password JWTest123
    And I click on the Players link
    And I click on the player named 16:9 Example Player
    And I rename the player to Test Player
    And I save my changes
    And I close the player builder page
    Then the name of the player should be Test Player
    And I click on the player named Test Player
    And I rename the player to 16:9 Example Player
    And I save my changes
    And I close the player builder page
    Then the name of the player should be 16:9 Example Player