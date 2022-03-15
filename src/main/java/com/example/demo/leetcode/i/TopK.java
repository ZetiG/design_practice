package com.example.demo.leetcode.i;

import java.util.PriorityQueue;

/**
 * Description: TopK问题，从海量数据中寻找最大的前k个数据；比如从1亿个数据中，寻找前1万个最大的数。
 *
 *  使用优先队列，能够很好的解决这个问题。先使用前 1万个数构建最小优先队列，以后每取一个数，都与队头元素进行比较，
 *  若大于队头元素，就将队头元素删除，并将该元素添加到优先队列中；
 *  若小于队头元素，则将该元素丢弃掉。
 *  如此往复，直至所有元素都访问完。最后优先队列中的1万个元素就是最大的1万个元素。
 *
 * @author Zeti
 * @date 2022/3/15 2:55 PM
 */
public class TopK {

    public static void main(String[] args) {
        int[] a1 = {6,4,7,3,9,8,1,2,5,0};
        int k1 = 5;
        
        int[] a2 = {6,4,7,3,9,8,1,2,5,0};
        int k2 = 8;

        System.err.println(topK(a1, k1));
        System.err.println(topK(a2, k2));
        
    }


    public static Object[] topK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();

        // 
        for (int i = 0; i < arr.length; i++) {
            
            // 如果堆大小刚好满足条件，后续的数字再想进来，则需要和堆顶元素进行比较，大的留下
            if (queue.size() >= k) {
                if (arr[i] > queue.peek()) {
                    queue.remove();
                } else {
                    continue;
                }
            }
            queue.add(arr[i]);
        }

        return queue.toArray();
    }


}
