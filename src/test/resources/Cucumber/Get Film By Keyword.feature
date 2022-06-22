Feature: User wants to receive a random movie by keyword

  Scenario Random movie is selected
    Given The chosen word exists in either title or description
    When I run the method
    Then I will be shown a list of movies that contain the keyword
