package com.example.demo.transaction.ts_2pc;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * <p>
 * AT 模式下，把每个数据库被当做是一个 Resource，Seata 里称为 DataSource Resource。业务通过 JDBC 标准接口访问数据库资源时，Seata
 * 框架会对所有请求进行拦截，做一些操作。每个本地事务提交时，Seata RM（Resource Manager，资源管理器） 都会向 TC（Transaction Coordinator，事务协调器）
 * 注册一个分支事务。当请求链路调用完成后，发起方通知 TC 提交或回滚分布式事务，进入二阶段调用流程。此时，TC 会根据之前注册的分支事务回调到对应参与者去执行对应资源的第二阶段。TC
 * 是怎么找到分支事务与资源的对应关系呢？每个资源都有一个全局唯一的资源 ID，并且在初始化时用该 ID 向 TC 注册资源。在运行时，每个分支事务的注册都会带上其资源 ID。这样 TC 就能在二阶段调用时正确找到对应的资源。
 * </p>
 *
 * @author Zeti
 * @date 2021/6/30 下午2:43
 */
public class AT_2pc {


}
