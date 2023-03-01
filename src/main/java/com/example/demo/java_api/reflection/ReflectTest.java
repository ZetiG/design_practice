package com.example.demo.java_api.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Description: 反射可以获取类、父类的私有方法和私有构造方法
 *  反射能破坏单例模式，通过获取私有构造函数，创建一个新的对象； 可通过构造函数内判断是否实例化过，但是懒汉式单例依然无法避免；
 *  Enum类创建的单例模式不能被反射破坏，原因：1.不含构造方法 2.反序列化有单独的处理逻辑；
 *
 * @author Zeti
 * @date 2023/3/1 19:28
 */
public class ReflectTest {

    public static void main(String[] args) {
        // 测试通过new获取父类私有方法和私有构造方法
//        ChildrenObj childrenObj = new ChildrenObj(1);
//        childrenObj.pubT1();
//        childrenObj.pubT2();

        // 测试通过反射获取父类私有方法和私有构造方法
        Class<ChildrenObj> aClass = ChildrenObj.class;

        // 能获取自己的私有方法、私有构造方法
        Constructor<?>[] constructors = aClass.getDeclaredConstructors();
        System.err.println(constructors.length);

        Method[] methods = aClass.getDeclaredMethods();
        System.err.println(methods.length);

        // 能获取父类的私有方法、私有构造方法
        Class<? super ChildrenObj> superclass = aClass.getSuperclass();
        Constructor<?>[] superclassConstructors = superclass.getDeclaredConstructors();
        System.err.println(superclassConstructors.length);

        Method[] superclassMethods = superclass.getDeclaredMethods();
        System.err.println(superclassMethods.length);

    }

}
