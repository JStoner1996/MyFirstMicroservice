Feature: User wants to receive a random movie by keyword

  Scenario Random movie is selected
    Given I have inputted a word
    When I search for film
    And The inputted word exists in title or description of a movie
    Then I will be shown a list of movies that contain the keyword
