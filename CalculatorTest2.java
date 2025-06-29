package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest2 {

    private Calculator calculator;

    // Setup – runs before each test
    @Before
    public void setUp() {
        calculator = new Calculator();  // Arrange
        System.out.println("Setup complete.");
    }

    // Teardown – runs after each test
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown complete.");
    }

    @Test
    public void testAddition() {
        // Arrange is done in setUp()

        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        // Act
        int result = calculator.subtract(20, 8);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testAddNegative() {
        // Act
        int result = calculator.add(-5, -7);

        // Assert
        assertEquals(-12, result);
    }
}
