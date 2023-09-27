package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 1333. 餐厅过滤器
 *
 * @author Zeti
 * @date 2023/9/27 15:15
 */
public class FilterRestaurants {

    // 输入：restaurants = [[1,4,1,40,10],
    //                     [2,8,0,50,5],
    //                     [3,8,1,30,4],
    //                     [4,10,0,10,3],
    //                     [5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
    //输出：[3,1,5]
    //
    //解释： id、rating评分、veganFriendly素食主义者、price价格、distance距离
    //餐馆 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
    //餐馆 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
    //餐馆 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1]
    //
    //在按照 veganFriendly = 1, maxPrice = 50 和 maxDistance = 10 进行过滤后，我们得到了餐馆 3, 餐馆 1 和 餐馆 5（按评分从高到低排序）。
    // 要求：
    //      1.veganFriendly=? 素食主义者只去素食店
    //      2.maxPrice=? 不能超预算
    //      3.maxDistance=? 不想跑太远
    public static void main(String[] args) {
        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;
        System.err.println(filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));   // [3,1,5]

    }

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(arr -> arr[2] == 1 || veganFriendly == 0)
                .filter(arr -> arr[3] <= maxPrice && arr[4] <= maxDistance)
                .sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1])
                .map(arr -> arr[0]).collect(Collectors.toList());

        // 另一种写法
        //        return Arrays.stream(restaurants).filter(arr -> {
        //            if (veganFriendly == 1) {
        //                return arr[2] == 1;
        //            }
        //            return true;
        //        })
        //                .filter(arr -> arr[3] <= maxPrice)
        //                .filter(arr -> arr[4] <= maxDistance)
        //                .sorted(Comparator.<int[], Integer>comparing(arr -> arr[1], Comparator.reverseOrder()) // 指定泛型类型
        //                        .thenComparing(arr -> arr[0], Comparator.reverseOrder())) // 按照fieldValue降序排序
        //                .map(obj -> obj[0])
        //                .collect(Collectors.toList());

    }

}
