Feature: Display a random film by Category
  Scenario Outline: Verifying each button works
    Given The application is running
    When the category page is open
    And The "<category>" button is clicked
    Then display a random film title and description

    Examples:
      | category    |
      | Action      |
      | Animation   |
      | Children    |
      | Classics    |
      | Comedy      |
      | Documentary |
      | Drama       |
      | Family      |
      | Foreign     |
      | Games       |
      | Horror      |
      | Music       |
      | New         |
      | Sci-Fi      |
      | Sports      |
      | Travel      |

#
#Feature: Display a random film by Actor
#  Scenario: Verifying each button works
#    Given The application is running
#    When the category page is open
#    Then A button is clicked to display a random film title and description