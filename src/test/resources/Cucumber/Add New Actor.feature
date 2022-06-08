Feature: Add a new Actor to the repository
  As a user, I want to add a new Actor to my table

  Scenario: I successfully added an Actor to my table
    Given I have Actor information
    When The information is inputted
    Then I get a return string, confirming the success

