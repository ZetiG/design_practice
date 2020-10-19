package com.example.demo.spring.IScope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 注册自定义的scope (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/10/17 2:06 下午
 */
@Configuration
public class RegisterIScopeConfig extends CustomScopeConfigurer {

    @Override
    public void addScope(String scopeName, Scope scope) {
        super.addScope("iScope", getScope());
    }

    private IScope getScope() {
        return new IScope();
    }

}
