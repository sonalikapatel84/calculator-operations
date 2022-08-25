package test.java;

import main.java.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestCalculator {

    Calculator calculator;
    @BeforeTest
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void whenCalculatorInitializedThenReturnTrue() {
        assertTrue(calculator.getStatus());
    }

    @Test
    public void whenAdditionTwoNumberThenReturnCorrectAnswer() throws Exception {
        assertEquals( 210.0, calculator.calculate("105 + 105"));
    }

    @Test
    public void whenSubtractionTwoNumberThenReturnCorrectAnswer() throws Exception {
        assertEquals( 70.0, calculator.calculate("105 - 35"));
    }

    @Test
    public void whenMultiplicationTwoNumberThenReturnCorrectAnswer() throws Exception {
        assertEquals( 6.0, calculator.calculate("2 * 3"));
    }

    @Test
    public void whenDivisionTwoNumberThenReturnCorrectAnswer() throws Exception {
        assertEquals( 1.0, calculator.calculate("2 / 2"));
    }

    @Test(expectedExceptions = Exception.class)
    public void whenThousandSeparatorThenThrowException() throws Exception {
        calculator.calculate("5,000 / 1,000");
    }
}
