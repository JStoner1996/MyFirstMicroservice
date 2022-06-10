Feature: Add a new Actor
  As a user, I want to add a new Actor to my table
  So that I can update the table

  Scenario: Adding an actor
    Given I have Actor information
    When The information is inputted
    Then I get a return string, confirming the success

