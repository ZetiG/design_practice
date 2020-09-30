package com.example.demo.algorithm;


/**
 * Description: 快排算法
 *
 * @author Zeti
 * @date 2020/9/28 6:29 下午
 */
public class QuickSort {


//    public static void main(String[] args) {
//
//        int[] arr = {4, 2, 6, 4, 1, 8, 0, 4, 1};
//
//    }


    /**
     * 快排实现
     *
     * @param arr
     * @return
     */
    private static int[] quickSortDemo(int[] arr) {

        if (arr == null || arr.length <= 0) {
            return new int[]{};
        }

        if (arr.length == 1) {
            return arr;
        }

        // 取第一个值为基数
        int base = arr[0];

        // 遍历数组，和基数做对比，小的放左边，大的放右边
        for (int i : arr) {


        }


        return null;
    }




    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // 采用三数中值分割法
        int mid = left + (right - left) / 2;
        // 保证左端较小
        if (arr[left] > arr[right])
            swap(arr, left, right);
        // 保证中间较小
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        // 保证中间最小，左右最大
        if (arr[mid] > arr[left])
            swap(arr, left, mid);
        int pivot = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (pivot <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (pivot >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = pivot;
        return left;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;

        int mid = partition(arr, left, right);

        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }


    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 4, 1, 8, 0, 4, 1};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

}
