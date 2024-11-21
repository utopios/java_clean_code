Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user is redirected to the homepage

  Scenario: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    Then an error message is displayed