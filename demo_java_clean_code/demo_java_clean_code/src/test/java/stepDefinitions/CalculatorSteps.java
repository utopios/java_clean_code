package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.jour4.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {
    private int total;
    private Calculator calculator;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(int a, int b) {
        total = calculator.add(a, b);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expectedTotal) {
        assertEquals(expectedTotal, total);
    }
}
