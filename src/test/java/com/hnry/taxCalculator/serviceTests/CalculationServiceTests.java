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
        BigDecimal actual = testSubject.calculateIncomeTax("10000");

        assertEquals(new BigDecimal("1050.00"), actual);
    }

    @Test
    void testIncome35000()
    {
        BigDecimal actual = testSubject.calculateIncomeTax("35000");

        assertEquals(new BigDecimal("5033.00"), actual);
    }

    @Test
    void testIncome100000()
    {
        BigDecimal actual = testSubject.calculateIncomeTax("100000");

        assertEquals(new BigDecimal("22877.50"), actual);
    }

    @Test
    void testIncome220000()
    {
        BigDecimal actual = testSubject.calculateIncomeTax("220000");

        assertEquals(new BigDecimal("64877.50"), actual);
    }

}
