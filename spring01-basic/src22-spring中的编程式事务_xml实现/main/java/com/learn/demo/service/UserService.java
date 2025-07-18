package com.learn.demo.service;

import com.learn.demo.dao.UserDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class UserService {
    private UserDao userDao;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager platformTransactionManager;

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 第一种，使用TransactionTemplate.execute方法
    public void transferMoney(String from, String to, Double money) {
        // 使用transactionTemplate.execute包裹事务执行的代码
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            // 这个方法用来处理事务
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    userDao.minus(from, money);
                    int i = 5 / 0;
                    userDao.add(to, money);
                } catch (Exception e) {
                    e.printStackTrace();
                    status.setRollbackOnly(); // 回滚事务
                }
            }
        });
    }

    // 第二种，使用PlatformTransactionManager的子类实现
    public void transferMoneyByManager(String from, String to, Double money) {
        // 1. 定义一个事务声明，可以设置隔离级别，传播性，只读等
        DefaultTransactionDefinition dfd = new DefaultTransactionDefinition();
        // 2. 开启事务并获取事务状态
        TransactionStatus status = platformTransactionManager.getTransaction(dfd);
        try {
            userDao.minus(from, money);
            int i = 5 / 0;
            userDao.add(to, money);
            platformTransactionManager.commit(status); // 提交事务
        } catch (Exception e) {
            platformTransactionManager.rollback(status); // 回滚事务
            e.printStackTrace();
        }
    }
}
