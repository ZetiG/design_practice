package com.example.demo.sliding_window;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description: 自定义-通用滑动窗口
 *
 * @author Zeti
 * @date 2023/12/19 15:34
 */
public class GenericSlidingWindow<T> {

    private List<T> elements;
    private int windowSize;
    private int step;

    public GenericSlidingWindow(List<T> elements, int windowSize, int step) {
        this.elements = elements;
        this.windowSize = windowSize;
        this.step = step;
    }


    public List<List<T>> getWindows() {
        List<List<T>> result = new ArrayList<>();
        int n = elements.size();

        if (windowSize > n) {
            return result; // Window size is larger than the list, no valid windows
        }

        for (int i = 0; i <= n - windowSize; i += step) {
            List<T> window = new ArrayList<>(elements.subList(i, i + windowSize));
            window.sort(Comparator.comparingInt(a -> Integer.parseInt(a.toString())));
            result.add(window);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(4,3,6,2,7,9,10,1,0,5,8);

        GenericSlidingWindow<Integer> slidingWindow = new GenericSlidingWindow<>(integerList, 4, 3);
        List<List<Integer>> windows = slidingWindow.getWindows();

        System.out.println("Sliding Windows:");
        for (List<Integer> window : windows) {
            System.out.println(window);
        }
    }

}
