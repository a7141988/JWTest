Feature: JW Test

  Scenario: Alter JW Player properties
    Given I am on the JW Player Dashboard Page
    And I log in using the email axl2807@gmail.com and the password JWTest123
    And I click on the Players link
    And I click on the player named 16:9 Example Player
    When I rename the player to Test Player
    And I change the aspect ratio to 4:3
    And I save my changes
    And I close the player builder page
    Then the name and size of the player should be correct