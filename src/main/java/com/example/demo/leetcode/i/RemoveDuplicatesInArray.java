package com.example.demo.leetcode.i;

/**
 * Description: 删除有序数组中的重复项 返回去重后的数组长度，不使用额外的数组空间
 *
 * @author Zeti
 * @date 2022/1/13 5:11 PM
 */
public class RemoveDuplicatesInArray {


    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 2, 3, 5, 6, 6, 9};
        int[] arr2 = {1, 1, 1, 1, 1};

        // d1
        System.err.println(tt(arr1));

        // d2
        System.err.println(removeDuplicates(arr1));

    }

    // d1 双指针，当左右相等， 左指针不动，右指针右移；如果左右不等，则左指针右移一位，并将右指针的值赋值给左指针，同时，右指针再向右移一位；
    // 核心：保证左指针所在的左边永远是最新且不重复的数据
    public static int tt(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int pointer1 = 0;
        int pointer2 = 1;
        int arrLen = arr.length;

        while (arrLen > pointer2) {
            if (arr[pointer1] == arr[pointer2]) {
                pointer2++;

                if (arrLen > pointer2) {
                    if (arr[pointer1] != arr[pointer2]) {
                        pointer1++;
                        arr[pointer1] = arr[pointer2];
                    }
                }
            }
        }
        return pointer1 + 1;
    }

    //双指针解决
    public static int removeDuplicates(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;

        int left = 0;
        for (int right = 1; right < A.length; right++) {
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩
            //指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right])
                A[++left] = A[right];
        }

        return ++left;
    }


}
