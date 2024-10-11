package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTests {

    @Test(dataProvider = "{0}")
    public void testFactorial(String caseName, int number, long expResult) {
        long result = Factorial.countFactorial(number);
        assertEquals(result, expResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Факториал отрицательного числа")
    public void testFactorialOfNegativeNumber() {
        Factorial.countFactorial(-2);
    }

    @DataProvider(name = "{0}")
    public Object[][] provideData() {
        return new Object[][]{
                {"Факториал положительного числа", 7, 5040},
                {"Факториал нуля", 0, 1}};
    }
}
