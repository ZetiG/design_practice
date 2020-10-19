package com.example.demo.spring.IScope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 自定义scope
 *
 * @author Zeti
 * @date 2020/10/17 1:51 下午
 */
public class IScope implements Scope {

    /**
     * 作用域初始化
     */
    private final ThreadLocal threadLocalScope = ThreadLocal.withInitial(HashMap::new);

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("从自定义scope内获取");

        Map scopeMap = (Map) threadLocalScope.get();

        Object o = scopeMap.get(name);
        if (o == null) {
            Object object = objectFactory.getObject();
            scopeMap.put(name, object);
            return object;
        }
        return o;
    }

    @Override
    public Object remove(String name) {
        System.out.println("从自定义scope内删除");

        Map scopeMap = (Map) threadLocalScope.get();
        return scopeMap.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
