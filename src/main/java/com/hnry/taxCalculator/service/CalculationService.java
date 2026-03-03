package com.hnry.taxCalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Service
public class CalculationService {

    private static final BigDecimal MAX_BAND_A_INCOME = BigDecimal.valueOf(15600);
    private static final BigDecimal MAX_BAND_B_INCOME = BigDecimal.valueOf(53500);
    private static final BigDecimal MAX_BAND_C_INCOME = BigDecimal.valueOf(78100);
    private static final BigDecimal MAX_BAND_D_INCOME = BigDecimal.valueOf(180000);
    private static final BigDecimal MIN_BAND_B_TAX = BigDecimal.valueOf(1638);
    private static final BigDecimal MIN_BAND_C_TAX = BigDecimal.valueOf(8270.5);
    private static final BigDecimal MIN_BAND_D_TAX = BigDecimal.valueOf(15650.5);
    private static final BigDecimal MIN_BAND_E_TAX = BigDecimal.valueOf(49277.5);

    public BigDecimal calculateIncomeTax(String untaxedIncome)
    {
        BigDecimal incomeAsBigDecimal = new BigDecimal(0);

        try
        {
            incomeAsBigDecimal = new BigDecimal(untaxedIncome);
        }

        catch (Exception e) {
            System.out.println("Please submit a value with only 0-9 and a single decimal place.");
            return null;
        }

        if (incomeAsBigDecimal.compareTo(MAX_BAND_A_INCOME) <= 0)
        {
            return calculateForTaxBandA(incomeAsBigDecimal).setScale(2, RoundingMode.HALF_UP);
        }

        if (incomeAsBigDecimal.compareTo(MAX_BAND_B_INCOME) <= 0)
        {
            return calculateForTaxBandB(incomeAsBigDecimal).setScale(2, RoundingMode.HALF_UP);
        }

        if (incomeAsBigDecimal.compareTo(MAX_BAND_C_INCOME) <= 0)
        {
            return calculateForTaxBandC(incomeAsBigDecimal).setScale(2, RoundingMode.HALF_UP);
        }

        if (incomeAsBigDecimal.compareTo(MAX_BAND_D_INCOME) <= 0)
        {
            return calculateForTaxBandD(incomeAsBigDecimal).setScale(2, RoundingMode.HALF_UP);
        }

        return calculateForTaxBandE(incomeAsBigDecimal).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateForTaxBandA(BigDecimal income)
    {
        return income.multiply(BigDecimal.valueOf(0.105));
    }

    private BigDecimal calculateForTaxBandB(BigDecimal income)
    {
        BigDecimal isolateBracket = income.subtract(MAX_BAND_A_INCOME);

        BigDecimal bracketBTax = isolateBracket.multiply(BigDecimal.valueOf(0.175));

        return bracketBTax.add(MIN_BAND_B_TAX);
    }

    private BigDecimal calculateForTaxBandC(BigDecimal income)
    {
        BigDecimal isolateBracket = income.subtract(MAX_BAND_B_INCOME);

        BigDecimal bracketCTax = isolateBracket.multiply(BigDecimal.valueOf(0.30));

        return bracketCTax.add(MIN_BAND_C_TAX);
    }

    private BigDecimal calculateForTaxBandD(BigDecimal income)
    {
        BigDecimal isolateBracket = income.subtract(MAX_BAND_C_INCOME);

        BigDecimal bracketCTax = isolateBracket.multiply(BigDecimal.valueOf(0.33));

        return bracketCTax.add(MIN_BAND_D_TAX);
    }

    private BigDecimal calculateForTaxBandE(BigDecimal income)
    {
        BigDecimal isolateBracket = income.subtract(MAX_BAND_D_INCOME);

        BigDecimal bracketCTax = isolateBracket.multiply(BigDecimal.valueOf(0.39));

        return bracketCTax.add(MIN_BAND_E_TAX);
    }
}
