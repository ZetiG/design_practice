package com.example.demo.leetcode.i;

/**
 * Description: 在不排序情况下， 求数组后位减去前位最大的差值之和
 * ps1: arr = [7,1,5,3,6,4]  最大差之和= （5-1）+ （6-3） = 7
 * ps2: arr = [1,1,6,6,3,1]  最大差之和= (6-1) = 5
 * ps3: arr = [7,6,4,3,1]    最大差之和= 0
 *
 * @author Zeti
 * @date 2022/1/13 6:10 PM
 */
public class MaxArrayReduce {

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 2, 5, 3, 6, 4, 7, 1, 2, 5, 3, 6, 4, 1, 1, 6, 6, 3, 1};
        int[] arr2 = {1, 1, 6, 6, 3, 1};
        int[] arr3 = {7, 6, 4, 3, 1};
        int[] arr4 = {14,1,1,13};

        // d1
        System.err.println(tt(arr1));

        // d2
        System.err.println(t2(arr1));
    }


    public static int tt(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                sum += arr[i + 1] - arr[i];
            }
        }
        return sum;
    }

    // {7, 1, 2, 5, 3, 6, 4}
    // {7, 1, 2, 5,   3, 6,   4, 7,   1, 2, 5,   3, 6,   4, 1, 1, 6, 6,   3, 1}
    public static int t2(int[] arr) {

        int min = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            if (((i == arr.length - 1 || arr[i + 1] >= arr[i]) && i > 0 && arr[i] <= arr[i - 1] ))  {
                min = arr[i];

            } if (i > 0 && arr[i] > arr[i - 1] && (i == arr.length - 1 || arr[i] >= arr[i + 1])) {
                sum += arr[i] - min;
            }
        }

        return sum;
    }

}
