package com.hnry.taxCalculator.service;

import java.math.BigDecimal;

public class CalculationService {

    public BigDecimal calculateIncometax(String untaxedIncome)
    {
        BigDecimal incomeAsBigDecimal = new BigDecimal(untaxedIncome);

        return incomeAsBigDecimal.multiply(BigDecimal.valueOf(0.105));
    }
}
