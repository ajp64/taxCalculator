package com.hnry.taxCalculator.serviceTests;

import com.hnry.taxCalculator.service.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationServiceTests {

    private CalculationService testSubject;

    @BeforeEach
    void setUp() {
        testSubject = new CalculationService();
    }

    @Test
    void testIncome10000()
    {
        BigDecimal actual = testSubject.calculateIncometax("10000");

        assertEquals(new BigDecimal("1050.000"), actual);
    }

    @Test
    void testIncome35000()
    {
        BigDecimal actual = testSubject.calculateIncometax("35000");

        assertEquals(new BigDecimal("5033.000"), actual);
    }

    @Test
    void testIncome100000()
    {
        BigDecimal actual = testSubject.calculateIncometax("100000");

        assertEquals(new BigDecimal("22877.500"), actual);
    }

    @Test
    void testIncome220000()
    {
        BigDecimal actual = testSubject.calculateIncometax("220000");

        assertEquals(new BigDecimal("64877.500"), actual);
    }

}
