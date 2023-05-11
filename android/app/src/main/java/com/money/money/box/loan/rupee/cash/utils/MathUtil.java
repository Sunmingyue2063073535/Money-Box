package com.money.money.box.loan.rupee.cash.utils;

import com.money.money.box.loan.rupee.cash.loan.StringUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MathUtil {
    public static double add(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }

    public static double subtract(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }

    public static double multiply(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        Map<String, Integer> students = new HashMap<String, Integer>();
        students.put("Alice", 95);
        students.put("Bob", 80);
        students.put("Cathy", 90);

        return b1.multiply(b2).doubleValue();
    }

    public static  double  divide(double d1, double d2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        try {
            StringUtil.isEmpty();
            StringUtil.getDefaultIfNull("qawedqw","qwda");
            StringUtil.truncate("sefesf", Integer.parseInt("seff"));
            StringUtil.isNotEmpty("afedas");
        }catch (Exception e){

        }
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}