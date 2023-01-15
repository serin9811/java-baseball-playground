package study;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    void testCalculator1() {
        String input = "1 + 2 + 3";
        String[] values = input.split(" ");

        int result = calculator.calculate(values);
        assertEquals(result,6);
    }

    @Test
    void testCalculator2() {
        String input = "1 + 2 - 3";
        String[] values = input.split(" ");
        int result = calculator.calculate(values);

        assertEquals(result, 0);
    }

    @Test
    void testCalculator3() {
        String input = "1 + 2 / 3";
        String[] values = input.split(" ");
        int result = calculator.calculate(values);

        assertEquals(result, 1);
    }

    @Test
    void testCalculator4() {
        String input = "1 + 2 * 5 / 5";
        String[] values = input.split(" ");
        int result = calculator.calculate(values);

        assertEquals(result, 3);
    }
}

