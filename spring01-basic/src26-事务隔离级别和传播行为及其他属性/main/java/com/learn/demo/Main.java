package com.learn.demo;

/**
 *  1. 事务隔离级别：指多个并发事务之间的隔离程度
 *  测试：多个并发事务之间对同一数据的读和写产生的问题
 *  READ_UNCOMMITTED：未提交读
 *      - 存在问题：脏读，不可重复读，幻读
 *      - 性能：最高
 *  READ_COMMITTED： 提交读
 *      - 存在问题：不可重复读，幻读
 *      - 性能：高
 *  REPEATABLE_READ （默认）：可重复读
 *      - 存在问题：幻读
 *      - 性能：中
 *  SERIALIZABLE：可序列化
 *      - 存在问题： 无
 *      - 性能：低
 *
 *  设置mysql数据库的事务隔离级别：
 *      set SESSION/Global transaction isolation level ***
 *  例如：
 *      SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
 *   查询mysql数据库的事务隔离级别：
 *      SELECT @@GLOBAL.transaction_isolation, @@transaction_isolation;
 *
 *
 * 2. 事务传播行为: 事务传播行为是为了解决业务层方法之间互相调用的事务问题。
 * 测试：存在事务的方法调用另一个存在事务的方法，当内部/外部方法抛出异常时，两个事务回滚/提交的问题
 * REQUIRED（默认）：如果当前存在事务，则加入当前事务；如果当前不存在事务，则开启一个新的事务；
 * SUPPORTS：表示如果有事务，就加入到当前事务，如果没有，那也不开启事务执行。这种传播级别可用于查询方法，因为SELECT语句既可以在事务内执行，也可以不需要事务；
 * MANDATORY：表示必须要存在当前事务并加入执行，否则将抛出异常。这种传播级别可用于核心更新逻辑，比如用户余额变更，它总是被其他事务方法调用，不能直接由非事务方法调用；
 * REQUIRES_NEW：表示不管当前有没有事务，都必须开启一个新的事务执行。如果当前已经有事务，那么当前事务会挂起，等新事务完成后，再恢复执行；
 * NOT_SUPPORTED：表示不支持事务，如果当前有事务，那么当前事务会挂起，等这个方法执行完成后，再恢复执行；
 * NEVER：和NOT_SUPPORTED相比，它不但不支持事务，而且在监测到当前有事务时，会抛出异常拒绝执行；
 * NESTED：表示如果当前有事务，则开启一个嵌套级别事务，如果当前没有事务，则开启一个新事务。
 *
 *
 * 3.事务超时行为：事务执行的超时时间，单位为秒
 *
 *
 * 4.事务只读：只读事务，一般用于select语句中，确保多次拿到相同数据
 *
 *
 * 在xml文件中配置：
 * <tx:advice id="advice">
 *      <tx:attribute>
 *          <tx:method name="methodName*" isolation="事务隔离级别" propagation="事务传播行为" timeout="5" read-only="true" />
 *      </tx:attribute>
 * </tx:advice>
 */

// 在java注解中配置：
// @Transactional(isolation = Isolation.DEFAULT， propagation = Propagation.REQUIRED, timeout = 5)
public class Main {
    public static void main(String[] args) {
    }
}
