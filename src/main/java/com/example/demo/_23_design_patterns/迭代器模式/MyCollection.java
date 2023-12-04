package com.example.demo._23_design_patterns.迭代器模式;

/**
 * Description: 具体的聚合对象
 *
 * @author Zeti
 * @date 2023/12/4 15:58
 */
public class MyCollection<T> implements IterableCollection<T> {
    private T[] items;
    private int size = 0;

    public MyCollection(int capacity) {
        this.items = (T[]) new Object[capacity];
    }

    public void add(T item) {
        if (size < items.length) {
            items[size++] = item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(items);
    }
}
