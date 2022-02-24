package com.example.demo.java_api;

/**
 * Description: java api compare
 *
 * 将值转换为ASCII码数组， 并取最短数组进行循环遍历，找到第一个不相同的ASCII值，其差值就是比较结果；
 * 如果循环完毕，依然没有满足条件的差值，则用第一个参数数组长度减去第二个参数的数组长度即为比较结果
 *
 * @author Zeti
 * @date 2022/2/24 5:40 PM
 */
public class CompareTest {


    public static void main(String[] args) {


        String s1 = "abc";
        String s2 = "abcd";
        String s3 = "abcdfg";
        String s4 = "1bcdfg";
        String s5 = "cdfg";

        System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1字符串长度小1)
        System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1字符串长度小3)
        System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48)
        System.out.println( s1.compareTo(s5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2)

        // 123  对应ASCII码数组[49, 50, 51]，
        // 1111 对应ASCII码数组[49, 49, 49, 49,]
        // 取最小数组长度(3)遍历，首次循环(49==49)，二次循环(50 != 49) 所以结果 == 50 - 49 == 1
        System.err.println("123".compareTo("1111"));


        System.err.println("abc".compareTo("abcd"));


    }

}
