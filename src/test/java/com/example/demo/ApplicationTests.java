package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {

    }


    public static void main(String[] args) {

        //        int x = (i / 3) * 3 + j / 3;
        //        int y = (i % 3) * 3 + j % 3;
        //
        //        int x = j / 3;
        //        int y = j % 3;

        System.err.println(0 / 3);
        System.err.println(1 / 3);
        System.err.println(2 / 3);
        System.err.println(3 / 3);


        System.err.println("------");

//        System.err.println(4 % 3);

    }

    public void arr2List(Integer[] arr, List<Integer> list) {
        List<Integer> ints = Arrays.asList(new Integer[]{});
        List<String> strings = Arrays.asList(new String[]{"aa", "bb"});



    }

}
