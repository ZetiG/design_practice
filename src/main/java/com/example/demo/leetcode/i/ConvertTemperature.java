package com.example.demo.leetcode.i;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * Description: 2469. 温度转换
 * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
 * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
 * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
 *
 * 注意：
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 *
 * @author Zeti
 * @date 2023/3/21 09:34
 */
public class ConvertTemperature {

    //输入：celsius = 36.50
    //输出：[309.65000,97.70000]
    //解释：36.50 摄氏度：转换为开氏度是 309.65 ，转换为华氏度是 97.70 。
    //示例 2 ：
    //
    //输入：celsius = 122.11
    //输出：[395.26000,251.79800]
    //解释：122.11 摄氏度：转换为开氏度是 395.26 ，转换为华氏度是 251.798 。

    public static void main(String[] args) {
        double c1 = 36.50;
        // [309.65000,97.70000]
        System.err.println(Arrays.toString(convertTemperature(c1)));

        double c2 = 122.11;
        // [395.26000,251.79800]
        System.err.println(Arrays.toString(convertTemperature(c2)));

    }

    // CV题目即可
    public static double[] convertTemperature(double celsius) {
        double[] doubles = new double[2];
        doubles[0] = celsius + 273.15;
        doubles[1] = celsius * 1.80 + 32.00;
        return doubles;
    }

    // 复杂化，未通过。。
    public static double[] convertTemperature2(double celsius) {
        double[] doubles = new double[2];
        BigDecimal k = new BigDecimal("273.15");
        BigDecimal f1 = new BigDecimal("1.80");
        BigDecimal f2 = new BigDecimal("32.00");


        BigDecimal cs1 = new BigDecimal(String.valueOf(celsius));
        BigDecimal kelvin = cs1.add(k).setScale(5, RoundingMode.HALF_UP).setScale(5, RoundingMode.HALF_UP);
        doubles[0] = kelvin.doubleValue();

        BigDecimal cs2 = new BigDecimal(String.valueOf(celsius));
        BigDecimal fahrenheit = cs2.multiply(f1).setScale(5, RoundingMode.HALF_UP).add(f2);
        doubles[1] = fahrenheit.doubleValue();

        return doubles;
    }
}
