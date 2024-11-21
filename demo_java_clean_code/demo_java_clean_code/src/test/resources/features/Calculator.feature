Feature: Calculator

  Scenario: Addition of two numbers
    Given I have a calculator
    When I add 5 and 3
    Then the result should be 8

  Scenario Outline: Addition of two numbers
    Given I have a calculator
    When I add <firstNumber> and <secondNumber>
    Then the result should be <result>

    Examples:
      | firstNumber | secondNumber | result |
      | 5           | 3            | 8      |
      | 10          | 20           | 30     |
      | -5          | 5            | 0      |
