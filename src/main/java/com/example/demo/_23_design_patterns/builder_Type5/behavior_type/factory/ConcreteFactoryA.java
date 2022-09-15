package com.example.demo._23_design_patterns.builder_Type5.behavior_type.factory;

/**
 * Description: 具体工厂A
 *
 * @author Zeti
 * @date 2021/3/3 上午11:04
 */
public class ConcreteFactoryA extends AbstractFactory {


    @Override
    AbstractProduct factoryMethod() {
        return new ConcreteProductA();
    }
}
