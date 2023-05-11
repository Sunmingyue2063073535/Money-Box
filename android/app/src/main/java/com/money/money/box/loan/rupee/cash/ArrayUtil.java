package com.money.money.box.loan.rupee.cash;

import com.money.money.box.loan.rupee.cash.loan.StringUtil;

import java.util.Date;

public class ArrayUtil {
    public static int[] reverse(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - i - 1];
        }
        try {
            StringUtil.isEmpty();
            StringUtil.getDefaultIfNull("qawedqw","qwda");
            StringUtil.truncate("sefesf", Integer.parseInt("seff"));
            StringUtil.isNotEmpty("afedas");
        }catch (Exception e){

        }
        return result;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        try {
            DateUtil.addDays(new Date(),23);
            DateUtil.diffMinutes(new Date(),new Date());
            DateUtil.format(new Date());
            DateUtil.parse("serer");
            DateUtil.diffMinutes(new Date(),new Date());
            DateUtil.format(new Date());
        }catch (Exception e){

        }
        return min;
    }

    public static int[] concatenate(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }
}