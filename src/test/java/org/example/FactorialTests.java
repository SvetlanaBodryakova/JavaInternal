package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTests {

    @ParameterizedTest(name = "{2}")
    @MethodSource("provideData")
    public void testFactorial(int number, long expResult, String caseName) {
        long result = Factorial.countFactorial(number);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    public void testFactorialWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.countFactorial(-2));
    }

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(7, 5040, "Факториал положительного числа"),
                Arguments.of(0, 1, "Факториал нуля")
        );
    }
}