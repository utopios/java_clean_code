Feature: Calculator

  Scenario: Addition of two numbers
    Given I have a calculator
    When I add 5 and 3
    Then the result should be 8
