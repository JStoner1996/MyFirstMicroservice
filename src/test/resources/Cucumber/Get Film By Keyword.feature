Feature: User wants to receive a random movie by keyword

  Scenario: Random movie is selected
    Given I have a repository
    When The inputted word exists in title or description of a movie
    Then A list of films that contain the keyword will be returned
