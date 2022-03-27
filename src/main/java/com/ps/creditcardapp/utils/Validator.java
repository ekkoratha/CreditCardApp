package com.ps.creditcardapp.utils;

public class Validator {
    public static boolean isValidLuhnNumber(String valueStr){

        if(valueStr == null){ // null check?
            return false;
        }

        valueStr = valueStr.trim();

        int length = valueStr.length();

        // blank or card number less than 12 or more than 19
        if(length == 0 || length<12 || length>19){
            return false;
        }

        long total = 0;
        long checkSum = 0;

        Long value = Long.valueOf(valueStr);

        for(int counter = 0;value>0;){

            long lValue = value % 10;
            value /= 10;
            counter++;

            if(counter == 1){ // store checksum
                checkSum = lValue;
                continue;
            }

            lValue = multipleBy2AndAggregate(lValue, counter);

            total = total + lValue;
        }

        long calcValue = (10 - (total % 10)) % 10;

        return (calcValue == checkSum);
    }

    private static long multipleBy2AndAggregate(long lValue, int counter) {
        if(counter % 2==0) {
            lValue = 2 * lValue;
            if (lValue> 9) {
                long unitsValue = lValue % 10;
                lValue /= 10;
                lValue += unitsValue;
            }
        }
        return lValue;
    }


}
