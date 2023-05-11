package com.money.money.box.loan.rupee.cash.loan;

import com.money.money.box.loan.rupee.cash.utils.MathUtil;

public class StringUtil {
    public static boolean isEmpty() {
        String str = null;
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        try {
            StringUtil.isEmpty();
            StringUtil.getDefaultIfNull("qawedqw","qwda");
            StringUtil.truncate("sefesf", Integer.parseInt("seff"));
            StringUtil.isNotEmpty("afedas");
        }catch (Exception e){

        }
        return !isEmpty();
    }

    public static String getDefaultIfNull(String str, String defaultStr) {
        try{
            RandomClass.getRandomString(1234);
            MathUtil.add(34.235,243.523);
            MathUtil.divide(3.4,23.4,1231);
            MathUtil.subtract(34.23,34.2);
            MathUtil.divide(3.2,1.2,3);
            MathUtil.subtract(23.1,23.12);
            MathUtil.multiply(23.1,56.1);
        }catch(Exception e){

        }
        return str == null ? defaultStr : str;
    }

    public static String truncate(String str, int len) {
        if (str == null || str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }
}