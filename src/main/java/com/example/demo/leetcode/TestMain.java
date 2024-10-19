package com.example.demo.leetcode;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/3/11 14:08
 */
public class TestMain {

    @Test
    public void t1() {
        // 64, 32, 32
//        String[] s = {"42","10","O", "CopyRandomList", "y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81"};
        String[] s = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        //            [1,  0,  1,  2,  3,  2,  1,  0,  1,  0,  1,  2,  1,  0,  1,  2,  3,  4,  5,  6]

        int[] ints = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            int i1 = (byte) s[i].charAt(0) >= 65 ? 1 : -1;
            if (i == 0) {
                ints[i] = i1;
                continue;
            }
            ints[i] = ints[i-1] + i1;
        }

        System.err.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }

    @Test
    public void tt() {
//        String[] s = {"36","86","w","17","81","W","64","97","S","s","32","61","W","I","99","X","W","l","33","L","17","G","27","70","37","5","62","W","x","39","58","16","Z","46","X","o","45","G","63","q","16","C","E","n","w","93","35","J","L","62","11","95","11","7","89","c","0","41","J","X","w","41","d","62","8","65","m","K","85","A","V","16","92","48","35","91","18","F","13","18","p","0","88","8","5","75","62","83","34","27","15","79","52","r","CopyRandomList","49","w","G","S","18"};
//        String[] s = {"36","86","w","17","81","W","64","97","S","s","32","61","W","I","99","X","W","l","33","L","17","G","27","70","37","5","62","W","x","39","58","16","Z","46","X","o","45","G","63","q","16","C","E","n","w","93","35","J"};
        String[] s = {"86","w","17","81","W","64","97","S","s","32","61","W","I","99","X","W","l","33","L","17","G","27","70","37","5","62","W","x","39","58","16","Z","46","X","o","45","G","63","q","16","C","E","n","w","93","35","J","L"};
        int nSum = 0;
        int cSum = 0;
        for (int i = 0; i < s.length; i++) {
            if ((byte) s[i].charAt(0) >= 65) {
                cSum++;
            } else {
                nSum++;
            }
        }

        System.err.println(s.length);
        System.err.println(cSum);
        System.err.println(nSum);

    }

    @Test
    public void t2() {

        // x=2 的 y=3 次方
        double pow = Math.pow(2, 3);
        System.err.println(pow);

        // 开根号
        double sqrt = Math.sqrt(64);
        System.err.println(sqrt);

        System.err.println(pow == sqrt);
    }

    @Test
    public void t3() {
        int[] h1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.err.println(trap(h1));   // 6

        int[] h2 = {4,2,0,3,2,5};
        System.err.println(trap(h2));   // 9

    }

    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        // 正向遍历，得到数组左边leftMax的最大值
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[0] = height[0];
                continue;
            }
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[height.length];
        for (int i = height.length-1; i >= 0; i--) {
            if (i == height.length-1) {
                rightMax[i] = height[i];
                continue;
            }
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        // 取最小的围墙 min（leftMax, rightMax） - 当前的墙高 = 当前墙可存水量
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    //               |
    //       |       | |   |
    // _ | _ | | _ | | | | | |
    // 0,1,0,2,1,0,1,3,2,1,2,1
    // 0 1 2 3 4 5 6 7 8 9 10 11
    public int trap2(int[] height) {
        int res = 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                res += leftMax - height[left];
                ++left;

            } else {

                res += rightMax - height[right];
                --right;
            }
        }
        return res;
    }

    @Test
    public void t4() {
        String[] s1 = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        System.err.println(groupAnagrams(s1));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    @Test
    public void t5() {
        ListNode h5 = new ListNode(5);
        ListNode h4 = new ListNode(4, h5);
        ListNode h3 = new ListNode(3, h4);
        ListNode h2 = new ListNode(2, h3);
        ListNode h1 = new ListNode(1, h2);

        getKthFromEnd(h1, 2);
    }
    // 1, 2, 3, 4, 5
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            k--;
            fast = fast.next;
            if (k <= 0) {
                slow = slow.next;
            }

        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void t6() {
        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 3;
        rotate(nums, k);

        System.err.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }

    }

    // 场景应用：求最大和的子数组
    // 数仓-商品生命周期-计算引入期-成长期-成熟期-衰退期 阀值
    @Test
    public void t7() {
        int[] n1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.err.println(Arrays.toString(maxSubarraySum(n1)));

        int[] n3 = {2, -3, 1, 5, -6, 3};
        System.err.println(Arrays.toString(maxSubarraySum(n3)));

        int[] n2 = {12470,68374,85241,127602,114779,121505,114089,122635,70432,46435,44651,40527,58898,33202,30492,45389,43198,42307,42095,44485,55739,27720,39699,46998,54709,31050};
        System.err.println(Arrays.toString(maxSubarraySum(n2)));

        // [0.0, 448.3, 24.7, 49.7, -10.0, 5.9, -6.1, 7.5, -42.6, -34.1, -3.8, -9.2, 45.3, -43.6, -8.2, 48.9, -4.8, -2.1, -0.5, 5.7, 25.3, -50.3, 43.2, 18.4, 16.4, -43.2]
        // [12470, 68374, 85241, 127602, 114779, 121505, 114089, 122635, 70432, 46435, 44651, 40527, 58898, 33202, 30492, 45389, 43198, 42307, 42095, 44485, 55739, 27720, 39699, 46998]

    }

    public static int[] maxSubarraySum(int[] nums) {
        double[] rates = new double[nums.length];
        rates[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            BigDecimal multiply = new BigDecimal(nums[i] - nums[i - 1]).divide(new BigDecimal(nums[i - 1]),3,  RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
            rates[i] = multiply.doubleValue();
        }

        double maxSum = rates[0];
        double currentSum = rates[0];
        int startIdx = 0;
        int endIdx = 0;

        for (int i = 1; i < rates.length; i++) {
            if (rates[i] > currentSum + rates[i]) {
                currentSum = rates[i];
                startIdx = i;
            } else {
                currentSum += rates[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                endIdx = i;
            }
        }
        return Arrays.copyOfRange(nums, startIdx, endIdx);
    }


    public static class Main1 {
        public static int[] findMaxDifferenceSubarray(int[] arr) {
            int n = arr.length;

            // 用于记录前后差值的数组
            int[] diff = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                diff[i] = arr[i + 1] - arr[i];
            }

            // 使用动态规划求解最大子数组和
            int maxSum = diff[0];
            int currentSum = diff[0];
            int start = 0;
            int end = 0;
            int currentStart = 0;

            for (int i = 1; i < n - 1; i++) {
                if (currentSum > 0) {
                    currentSum += diff[i];
                } else {
                    currentSum = diff[i];
                    currentStart = i;
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = currentStart;
                    end = i;
                }
            }

            // 返回原始数组中对应的子数组
            return Arrays.copyOfRange(arr, start, end + 2);
        }

        public static void main(String[] args) {
            int[] arr = {2, 5, 1, 9, 9, 3, 7, 6, 8};
            System.out.println("Max Difference Subarray: " + Arrays.toString(findMaxDifferenceSubarray(arr)));

            int[] arr2 = {2, 5, 1, 9, 9, 1, 7, 6, 8};
            System.out.println("Max Difference Subarray: " + Arrays.toString(findMaxDifferenceSubarray(arr2)));

            int[] a2 = {12470,68374,85241,127602,114779,121505,114089,122635,70432,46435,44651,40527,58898,33202,30492,45389,43198,42307,42095,44485,55739,27720,39699,46998,54709,31050};
            System.out.println("Max Difference Subarray: " + Arrays.toString(findMaxDifferenceSubarray(a2)));

            int[] a3 = {156,216,460,408,979,912,841,1455,755,1399,716,850,262};
            System.out.println("Max Difference Subarray: " + Arrays.toString(findMaxDifferenceSubarray(a3)));

            int[] a4 = {12,71,55,119,70,94,102,110,71,72,132,113,117,74,55,52,64,50,50,78,35,12,65,182,56,38};
            System.out.println("Max Difference Subarray: " + Arrays.toString(findMaxDifferenceSubarray(a4)));


        }
    }


    public static class LotteryNumberGenerator {
        public static void main(String[] args) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Arrays.toString(generateLotteryNumbers()));
//            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Arrays.toString(generateDoubleColorBallNumbers()));
            }

        }

        public static int[] generateLotteryNumbers() {
            int[] lotteryNumbers = new int[7]; // 大乐透彩票一共选择7个号码

            // 选择前5个号码（1-35之间的号码）
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                int number = random.nextInt(35) + 1;
                lotteryNumbers[i] = number;
            }

            // 选择后2个号码（1-12之间的号码）
            for (int i = 5; i < 7; i++) {
                int number = random.nextInt(12) + 1;
                lotteryNumbers[i] = number;
            }

            return lotteryNumbers;
        }

        public static int[] generateDoubleColorBallNumbers() {
            int[] lotteryNumbers = new int[7]; // 双色球彩票一共选择7个号码

            // 选择红色球号码（1-33之间的号码）
            Random random = new Random();
            Set<Integer> redBallSet = new HashSet<>();
            while (redBallSet.size() < 6) {
                int number = random.nextInt(33) + 1;
                if (!redBallSet.contains(number)) {
                    redBallSet.add(number);
                }
            }

            // 将红色球号码放入数组，并进行排序
            int index = 0;
            for (int number : redBallSet) {
                lotteryNumbers[index++] = number;
            }
            Arrays.sort(lotteryNumbers, 0, index);

            // 选择蓝色球号码（1-16之间的号码）
            int blueBall = random.nextInt(16) + 1;
            lotteryNumbers[6] = blueBall;

            return lotteryNumbers;
        }
    }

    @Test
    public void t8() {
        int[] a1 = {3,5,2,6,5,6};
        int max = getMax(a1, 0, a1.length - 1);
        System.err.println(max);

    }

    //              |       |
    //      |       |   |   |
    //      |       |   |   |
    //  |   |       |   |   |
    //  |   |   |   |   |   |
    //  |   |   |   |   |   |
    private int getMax(int[] arr, int start, int end) {
        int res = 0;
        int idx = 0;

        for (int i = start; i <= end; i++) {
            if (i == start) {
                res = arr[start];
                idx = i;
                continue;
            }
            if (arr[i] >= arr[i-1]) {
                if (arr[i] > res*(i-idx+1)) {
                    idx = i;
                }
                res = Math.max(arr[i], res*(i-idx+1));

            } else {
                if (arr[i] * (i-idx) > res) {
                    idx = i;
                }
                res = Math.max(res, arr[i] * (i-idx));
            }
        }
        return res;
    }

    @Test
    public void testisw() {
        int[] p1 = {5,6,1,10};  // 22
        int[] p2 = {5,1,10,5};  // 26

        System.err.println(isWinner(p1, p2));
    }

    public int isWinner(int[] player1, int[] player2) {
        int len = player1.length;

        int ps1 = 0, ps2 = 0;
        for (int i = 0; i < len; i++) {
            if ((i >= 1 && player1[i-1] == 10) || (i >= 2 && player1[i-2] == 10)) {
                ps1 += player1[i]*2;
            } else {
                ps1 += player1[i];
            }

            if ((i >= 1 && player2[i-1] == 10) || (i >= 2 && player2[i-2] == 10)) {
                ps2 += player2[i]*2;
            } else {
                ps2 += player2[i];
            }
        }

        return ps1 > ps2 ? 1 : ps1 < ps2 ? 2 : 0;
    }


    @Test
    public void test() {


    }


}
