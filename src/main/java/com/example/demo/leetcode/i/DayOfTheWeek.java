package com.example.demo.leetcode.i;

import java.time.LocalDate;

/**
 * Description: 1185. 一周中的第几天 - 泰勒公式
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * @author Zeti
 * @date 2023/12/30 09:37
 */
public class DayOfTheWeek {
    private static final String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    // 给定一个日期(Y-m-d) 返回当前是星期几
    public static void main(String[] args) {
        int y = 2019, m = 8, d = 31;
//        System.err.println(dayOfTheWeek1(d, m, y));
//        System.err.println(dayOfTheWeek2(d, m, y));
//        System.err.println(dayOfTheWeek3(d, m, y));
//        System.err.println(dayOfTheWeek4(d, m, y));

        System.err.println(dayOfTheWeek3(7, 3, 2003));

    }


    // M1.API
    public static String dayOfTheWeek1(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return week[localDate.getDayOfWeek().getValue()%7];
    }

    // M2.计算
    // 通过日历得知1970的最后一天(1970-12-31)是周四，计算距今多少天，再模7
    public static String dayOfTheWeek2(int day, int month, int year) {
        // 枚举每个月多少天
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int total = 4;  // 因为1970年最后一天是周四，这里初始值为4
        // 计算中间经历的每年一共有多少天，最后累加
        for (int i = 1971; i < year; i++) {
            // 判断是否闰年
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            total += isLeap ? 366 : 365;
        }

        // 上一步是算到1970年最后一天累加到year年初的前一天，这里year不满一年，开始算月
        for(int i = 1; i < month; i++) {  // 再累加月数
            total += months[i - 1];
            // 判断闰月
            if(i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                total++;
            }
        }

        // 同上，再累计当月天数
        total += day;

        return week[total % 7];
    }

    // M3.蔡勒公式: w = (y + (y/4) + (c/4) - 2c + (26*(m+1) / 10) + d - 1) % 7
    // w：星期（计算所得的数值对应的星期：0-星期日；1-星期一；2-星期二；3-星期三；4-星期四；5-星期五；6-星期六）[注 1]
    // c：年份前两位数
    // y：年份后两位数
    // m：月（m的取值范围为3至14，即在蔡勒公式中，某年的1、2月要看作上一年的13、14月来计算，比如2003年1月1日要看作2002年的13月1日来计算）
    // d：日
    // []：称作高斯符号，代表向下取整，即，取不大于原数的最大整数。
    // mod：同余（这里代表括号里的答案除以7后的余数）
    public static String dayOfTheWeek3(int day, int month, int year) {
        int m = month <= 2 ? (month + 12) : month;  // 月, 取值范围为3至14, 1,2月要看作上一年的13,14月，对应下面的年份要减1
        int y = (month <= 2 ? (year - 1) : year) % 100; // 年份后两位数
        int c = (month <= 2 ? (year - 1) : year) / 100; //  年份前两位数
        int d = day;

        // 泰勒公式
        int w = (y + Math.round(y/4) + Math.round(c/4) - 2*c + Math.round(26*(m+1) / 10) + d - 1) % 7;
        return week[(w + 7) % 7];   // (w + 7) % 7 解决上一步w为负数的情况
    }


}
