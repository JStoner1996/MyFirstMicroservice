Feature: Display a film using buttons
  Scenario Outline: Verifying each category button works
    Given The application is running
    When the "<page>" page is open
    And The "<button>" button is clicked
    Then display a film title and description

    Examples:
      | page      | button      |
      | category  | Action      |
      | category  | Animation   |
      | category  | Children    |
      | category  | Classics    |
      | category  | Comedy      |
      | category  | Documentary |
      | category  | Drama       |
      | category  | Family      |
      | category  | Foreign     |
      | category  | Games       |
      | category  | Horror      |
      | category  | Music       |
      | category  | New         |
      | category  | Sci-Fi      |
      | category  | Sports      |
      | category  | Travel      |
      | language  | English     |
      | language  | French      |
      | language  | German      |
      | language  | Italian     |
      | language  | Japanese    |
      | language  | Mandarin    |

  # Will open the application,
  # will navigate to category / language page
  # will click all buttons that return a film
  # It will then check that the text container for the film has changed
  # If the text changes, it means the buttons work
