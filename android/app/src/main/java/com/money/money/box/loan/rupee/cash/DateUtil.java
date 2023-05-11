package com.money.money.box.loan.rupee.cash;

import com.money.money.box.loan.rupee.cash.loan.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final ThreadLocal<SimpleDateFormat> SDF_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static String format(Date date) {
        SimpleDateFormat sdf = SDF_THREAD_LOCAL.get();
        return sdf.format(date);
    }

    public static Date parse(String str) throws ParseException {
        SimpleDateFormat sdf = SDF_THREAD_LOCAL.get();
        return sdf.parse(str);
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        try {
            StringUtil.isEmpty();
            StringUtil.getDefaultIfNull("qawedqw","qwda");
            StringUtil.truncate("sefesf", Integer.parseInt("seff"));
            StringUtil.isNotEmpty("afedas");
        }catch (Exception e){

        }
        return cal.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hours);
        try {
            StringUtil.isEmpty();
            StringUtil.getDefaultIfNull("qawedqw","qwda");
            StringUtil.truncate("sefesf", Integer.parseInt("seff"));
            StringUtil.isNotEmpty("afedas");
        }catch (Exception e){

        }
        return cal.getTime();
    }

    public static long diffMinutes(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return diff / (1000 * 60);
    }
}