package com.ps.creditcardapp.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class ValidatorTest {

    @Test
    void testIsValidLuhnNumber() {
        // -ve test cases
        String invalidCardNumberLength = null;
        Assert.isTrue(!Validator.isValidLuhnNumber(invalidCardNumberLength)," Credit Card number is valid");

        invalidCardNumberLength = "";
        Assert.isTrue(!Validator.isValidLuhnNumber(invalidCardNumberLength)," Credit Card number is valid");

        invalidCardNumberLength = "1234567890";
        Assert.isTrue(!Validator.isValidLuhnNumber(invalidCardNumberLength)," Credit Card number is valid");

        invalidCardNumberLength = "12345678901234567890";
        Assert.isTrue(!Validator.isValidLuhnNumber(invalidCardNumberLength)," Credit Card number is valid");

        // +ve test cases
        List<String> values = Arrays.asList("12345678903555","5555555555554444","371449635398431",
                "6011111111111117","30569309025904","4111111111111111", "3530111333300000");
        values.forEach(e-> Assert.isTrue(Validator.isValidLuhnNumber(e)," Credit card number is not valid - LUHN check failed"));
    }

}