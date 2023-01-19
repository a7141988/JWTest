@selenium

Feature: JW Login Tests

  Scenario: Invalid password
    Given I am on the JW Player Dashboard Page
    When I log in using the email axl2807@gmail.com and the password abc
    Then The correct login error text should appear

  Scenario: Invalid email
    Given I am on the JW Player Dashboard Page
    When I use the email abc to log in and do not enter a password
    Then The correct invalid email text should appear
