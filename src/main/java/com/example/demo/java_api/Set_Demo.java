package com.example.demo.java_api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description: Set集合操作，深入理解
 *
 * @author Zeti
 * @date 2021/3/17 上午11:17
 */
public class Set_Demo {

    public static void main(String[] args) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(1L, 1);


        // java.lang.UnsupportedOperationException
        // 操作的是hashMap的映射，新增会导致键值对不符合
        Set<Long> set = map.keySet();
        set.add(2L);
        set.add(3L);

    }


}
