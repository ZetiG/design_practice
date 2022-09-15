package com.example.demo._23_design_patterns.builder_Type5.behavior_type.factory;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2021/3/3 上午11:06
 */
public class Test {


    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactoryA();
        AbstractProduct abstractProduct = abstractFactory.factoryMethod();
        abstractProduct.show();
    }

}
