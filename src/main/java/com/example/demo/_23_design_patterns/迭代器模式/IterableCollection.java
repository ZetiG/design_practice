package com.example.demo._23_design_patterns.迭代器模式;

/**
 * Description: 聚合对象接口
 *
 * @author Zeti
 * @date 2023/12/4 15:57
 */
public interface IterableCollection<T> {

    Iterator<T> iterator();

}
