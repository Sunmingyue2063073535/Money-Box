package com.money.money.box.loan.rupee.cash.loan;

import java.util.Random;

public class RandomClass {
    public static String getRandomString(int length) {
        // 随机生成数字、字母和特殊字符
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()+";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(r.nextInt(str.length())));
        }
        return sb.toString();
    }
}