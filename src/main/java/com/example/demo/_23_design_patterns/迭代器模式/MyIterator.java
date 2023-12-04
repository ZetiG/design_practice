package com.example.demo._23_design_patterns.迭代器模式;

/**
 * Description: 具体的迭代器
 *
 * @author Zeti
 * @date 2023/12/4 15:55
 */
public class MyIterator<T> implements Iterator<T> {
    private T[] items;
    private int position = 0;

    public MyIterator(T[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public T next() {
        return items[position++];
    }

}
