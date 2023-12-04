package com.example.demo._23_design_patterns.迭代器模式;

/**
 * Description: 迭代器接口
 *
 * @author Zeti
 * @date 2023/12/4 15:55
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();

}
