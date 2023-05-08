package com.example.demo.leetcode.i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Description: 169. 多数元素 
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/8 10:56
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] n1 = {3,2,3};
        System.err.println(majorityElement(n1)); // 3

        int[] n2 = {2,2,1,1,1,2,2};
        System.err.println(majorityElement(n2)); // 2


    }

    // 4.Boyer-Moore 投票算法;  维护一个目标值target<初始为nums内任意值> 和出现次数count;
    // 后续遍历每出现一次当前值count+1，非当前值count-1；当count==0时，替换target值为当前遍历到的值；
    // 当遍历结束后，target即为目标结果值
    public static int majorityElement(int[] nums) {
        int target = nums[0];
        Integer count = null;
        for (int num : nums) {
            if (count == 0) {
                target = num;
            }
            count += (num == target) ? 1 : -1;
        }

        return target;
    }


    // 3.随机法
    public int majorityElement_random(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // 2.排序，由题目可知，目标数字出现的次数大于nums.length的一半，则排序后的n/2一定是目标数字
    public static int majorityElement_sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 1.迭代存入hash表，并统计最大value
    public int majorityElement_hash(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }



}
