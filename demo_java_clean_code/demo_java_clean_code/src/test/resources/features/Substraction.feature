Feature: Subtraction

  Scenario Outline: Subtraction of two numbers
    Given I have a calculator
    When I subtract <secondNumber> from <firstNumber>
    Then the result should be <result>

    Examples:
      | firstNumber | secondNumber | result |
      | 10          | 3            | 7      |
      | 20          | 5            | 15     |
      | 5           | 10           | -5     |
