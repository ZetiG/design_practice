package com.example.demo.java_api;

import java.lang.reflect.Field;

/**
 * Description:  if (a == 1 && a == 2 && a== 3) 成立
 *
 * @author Zeti
 * @date 2021/6/4 上午9:46
 */
public class IFTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
            Class cache = Integer.class.getDeclaredClasses()[0];
            Field c = cache.getDeclaredField("cache");
            c.setAccessible(true);
            Integer[] array = (Integer[]) c.get(cache);

            // set 1
            array[130] = array[129];

            // set 2
            array[131] = array[129];

            // set 3
            Integer a = 1;

            if (a == (Integer) 1 && a == (Integer) 2 && a == (Integer) 3) {
                System.out.println("a == 1 && a == 2 && a == 3 is true");
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
