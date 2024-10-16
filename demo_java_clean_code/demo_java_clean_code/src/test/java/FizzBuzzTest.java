import org.example.demotdd.FizzBuzz;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @ParameterizedTest(name = "should return {1} casted to string when {0}")
    @CsvSource({
            "1, 1",
            "2, 2"
    })
    //@DisplayName("Should return string argument if argument 1 is not multiple of 3 or 5")
    public void testFizz1(int number, String expected) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.say(number);
        assertEquals(expected, result);
    }

    /*@Test
    @DisplayName("Should return string argument if argument 2 is not multiple of 3 or 5")
    public void testFizz2() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.say(2);
        assertEquals("2", result);
    }*/

    @Test
    @DisplayName("Should return fizz if argument is multiple of 3")
    public void testFizz3() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.say(3);

        assertEquals("Fizz", result);
    }
}
