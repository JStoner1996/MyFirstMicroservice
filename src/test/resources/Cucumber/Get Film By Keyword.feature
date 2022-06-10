Feature: User wants to receive a random movie by keyword
  As a User, I want to input a word
  So that, a random film that contains that word will be shown.

  Scenario 1: Random movie is selected
    Given The chosen word is valid
    And The chosen word exists in either title or description
    When I run the method
    Then I will be shown a list of movies that contain the keyword