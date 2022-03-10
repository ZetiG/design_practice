package com.example.demo.data_structure.tree;

import java.util.List;

/**
 * Description: 树节点父类，所有需要使用{@linkplain TreeUtils}工具类形成树形结构等操作的节点都需要实现该接口
 *
 * @author Zeti
 * @date 2020/11/27 下午4:01
 */
public interface TreeNode<T> {

    /**
     * 获取节点id
     *
     * @return 树节点id
     */
    T id();

    /**
     * 获取该节点的父节点id
     *
     * @return 父节点id
     */
    T parentId();

    /**
     * 是否是根节点
     *
     * @return true：根节点
     */
    boolean root();

    /**
     * 获取所有子节点
     *
     * @return 子节点列表
     */
    List<? extends TreeNode<T>> getChildren();

    /**
     * 设置节点的子节点列表
     *
     * @param children 子节点
     */
    void setChildren(List<? extends TreeNode<T>> children);


}
