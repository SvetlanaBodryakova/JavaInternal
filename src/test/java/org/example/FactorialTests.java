package org.example;

import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTests {

    @Test(dataProvider = "provideData")
    public void testFactorial(int number, long expResult) {
        long result = Factorial.countFactorial(number);
        assertEquals(result, expResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @Description("Факториал отрицательного числа")
    public void testFactorialOfNegativeNumber() {
        Factorial.countFactorial(-2);
    }

    @DataProvider
    public Object[][] provideData() {
        return new Object[][] {
                {7,5040},
                {0,1,}};
    }
}
