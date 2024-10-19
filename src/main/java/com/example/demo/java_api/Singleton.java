package com.example.demo.java_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/20 18:14
 */
public class Singleton {

    public static void main(String[] args)
    {
        String str = "GeeksFor";
        // A new string will be returned, but the actual String will remain the same
        String geeks = str.concat("Geeks");
        // Prints initial value "GeeksFor"
        System.out.println(str);
        System.out.println(geeks);
        System.out.println(str == geeks);
        // Now we change the reference of "str" to point to the new String returned
        str = str.concat("Geeks");
        // Prints the new concatenated String
        System.out.println(str);
    }
}
