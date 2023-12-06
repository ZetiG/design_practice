package com.example.demo._23_design_patterns.迭代器模式;


/**
 * Description: 测试程序
 * <>迭代器模式是一种行为型设计模式，它提供一种顺序访问聚合对象（如列表、集合）元素的方法，而不暴露其内部实现。
 * 下面是一个简单的Java迭代器模式的示例，假设我们有一个自定义的集合类 MyCollection，需要提供一种方式来访问其中的元素：</>
 *
 * @author Zeti
 * @date 2023/12/4 15:54
 */
public class Main {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection<>(5);
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }

    }
}
