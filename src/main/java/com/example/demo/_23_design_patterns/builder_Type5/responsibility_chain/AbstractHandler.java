package com.example.demo._23_design_patterns.builder_Type5.responsibility_chain;

/**
 * Description: 责任链模式-抽象处理类
 *
 * @author Zeti
 * @date 2022/9/15 15:18
 */
public abstract class AbstractHandler {

    private AbstractHandler handler;

    /**
     * 需要子类实现的请求处理方法
     *
     * @param condition
     */
    public abstract void handleRequest(String condition);


    public AbstractHandler getHandler() {
        return handler;
    }

    public void setHandler(AbstractHandler handler) {
        this.handler = handler;
    }

}
