import org.example.demotdd.FizzBuzz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest(name = "should return {1} casted to string when {0}")
    @CsvSource({
            "1, 1",
            "2, 2"
    })
    //@DisplayName("Should return string argument if argument 1 is not multiple of 3 or 5")
    public void testFizz1(int number, String expected) {

        String result = fizzBuzz.say(number);
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("Should return Fizz if argument is multiple of 3")
    public void testFizz3() {


        String result = fizzBuzz.say(3);

        assertEquals("Fizz", result);
    }

    @Test
    @DisplayName("Should return Buzz if argument is multiple of 5")
    public void testFizz4() {


        String result = fizzBuzz.say(5);

        assertEquals("Buzz", result);
    }

    @Test
    @DisplayName("Should return FizzBuzz if argument is multiple of 5 and 3")
    public void testFizz5() {


        String result = fizzBuzz.say(15);

        assertEquals("FizzBuzz", result);
    }
}
