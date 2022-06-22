Feature: Display a film buttons
  Scenario Outline: Verifying each category button works
    Given The application is running
    When the "<page>" page is open
    And The "<button>" button is clicked
    Then display a random film title and description

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

#
#  Scenario Outline: Verifying each language button works
#    Given The application is running
#    When the language page is open
#    And The "<language>" button is clicked
#    Then display a random film title and description
#
#    Examples:
#      | language  |
#      | English   |
#      | French    |
#      | German    |
#      | Italian   |
#      | Japanese  |
#      | Mandarin  |
#
#Feature: Display a random film by Actor
#  Scenario: Verifying each button works
#    Given The application is running
#    When the category page is open
#    Then A button is clicked to display a random film title and description