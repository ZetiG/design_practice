package com.example.demo._23_design_patterns.观察者模式;

/**
 * Description: 测试程序
 * <>观察者模式是一种行为设计模式，其中一个对象（主题）维护其依赖对象（观察者）的列表，并在状态改变时通知它们。
 * 下面是一个简单的Java观察者模式的示例，假设我们有一个气象站，需要通知观察者当天的温度变化：</>
 *
 * @author Zeti
 * @date 2023/12/4 14:25
 */
public class Main {

    public static void main(String[] args) {
        // 创建主题
        WeatherStation ws1 = new WeatherStation();

        // 向主题添加具体的观察者
        ws1.addObserver(new TemperatureObserver());
        ws1.addObserver(new Temperature2Observer());

        // 主题变化，并通知到该主题下所有观察者
        ws1.setTemperature(37);

        ws1.setTemperature(38);

    }

}
