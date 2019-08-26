Feature: Codility Test

  Scenario: Validate Fields and Buttons
    Given I am on the Codility Login Page
    Then the email, password, and login button should be displayed

  Scenario: Login With Valid Credentials
    Given I am on the Codility Login Page
    When login is attempted using the email jack.sparrow@thepiratebay.se and the password blackpearl
    Then the login should be considered successful and the text Welcome to The Pirate Bay! should be displayed

  Scenario: Login With Invalid Credentials
    Given I am on the Codility Login Page
    When login is attempted using the email axl2807@gmail.com and the password abc
    Then the login should be considered incorrect and the text You shall not pass! Arr! should be displayed

  Scenario: Login With Email Missing
    Given I am on the Codility Login Page
    When login is attempted using the email axl2807@gmail.com and no password
    Then the login should be considered invalid and the text Password is required should be displayed

  Scenario: Login With Password Missing
    Given I am on the Codility Login Page
    When login is attempted using no email and the password abc
    Then the login should be considered invalid and the text Email is required should be displayed

  Scenario: Login With Invalid Email
    Given I am on the Codility Login Page
    When login is attempted using the email abc and the password abc
    Then the login should be considered invalid and the text Enter a valid email should be displayed