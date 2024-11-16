package com.example.spring.proxy.cglib_proxy;

import org.junit.jupiter.api.Test;

/**
 * Description: cglib代理
 *
 * cglib特点
 *      - JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。如果想代理没有实现接口的类，就可以使用CGLIB实现。
 *      - CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。
 *      - 它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
 *      - CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
 *      - 不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
 *
 * cglib与jdk动态代理最大的区别就是
 *      - 使用jdk动态代理的对象必须实现一个或多个接口
 *      - 使用cglib代理的对象则无需实现接口，达到代理类无侵入。
 *      - 使用cglib需要引入cglib的jar包，如果你已经有spring-core的jar包，则无需引入，因为spring中包含了cglib。
 *
 * cglib 和 jdk 实现原理区别：
 * JDK 动态代理：
 *      - 基于 Java 反射机制，动态生成实现接口的代理类
 *      - 动态生成一个实现了目标对象所有接口的代理类。
 *      - 通过代理类调用目标对象的方法，将调用委托给 InvocationHandler.invoke()。
 *      - 性能低，尤其大量调用时
 * CGLIB 动态代理：
 *      - 基于ASM框架字节码生成目标类的子类
 *      - 通过生成目标类的子类（继承目标类），重写其方法实现代理。
 *      - 方法调用被拦截并委托给 MethodInterceptor 的 intercept() 方法。
 *      - 性能快，直接调用字节码
 *      - 目标类不能是 final，代理的方法不能是 final
 *
 * 方法调用性能：CGLIB 高于 JDK 动态代理（直接字节码操作）。
 * 类加载性能：JDK 动态代理速度更快，因为它只需生成接口的实现类。
 *
 * @author Zeti
 * @date 2024/11/16 16:24
 */
public class TestMain {

    @Test
    public void t1() {  // 代理实现接口的类
        ProxyFactory factory = new ProxyFactory(new UserDaoImpl());
        UserDao instance = (UserDao) factory.getProxyInstance();
        instance.getUser(44L);
    }

    @Test
    public void t2() {  // 也可以代理未实现接口的类；原理：创建一个继承了目标类的子类
        ProxyFactory factory = new ProxyFactory(new Person());
        Person instance = (Person) factory.getProxyInstance();
        instance.getUser(55L);
    }

}
