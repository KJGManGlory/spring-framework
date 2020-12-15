package com.lizza.service;

import com.lizza.dao.UserDao;
import com.lizza.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
@Service
public class ServiceB {

    @Autowired
    private UserDao userDao;

    public int insert(User user) {
        return userDao.insert(user);
    }

    public int delete(int id) {
        return userDao.delete(id);
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public User select(int id) {
        return userDao.select(id);
    }

    public List<User> list() {
        return userDao.list();
    }

    public int transferMoney(int fromId, int toId, double money) {
        // 1. 获取付款账户和收款账户
        User from_user = userDao.select(fromId);
        User to_user = userDao.select(toId);
        // 2. 付款账户付款，收款账户收款
        from_user.setMoney(from_user.getMoney() - money);
        to_user.setMoney(to_user.getMoney() + money);
        // 3. 更新账户信息
        updateAccount(from_user, to_user);
        return 0;
    }

    @Transactional
    public void updateAccount(User fromUser, User toUser) {
        userDao.update(fromUser);
        int i = 1 / 0;
        userDao.update(toUser);
    }

    /**
     * 测试 1:
     *  方法 A 事务隔离级别为REQUIRED
     *  方法 B 事务隔离级别为REQUIRES_NEW
     *  方法 A 调用方法 B, 方法 B 抛出异常, 测试方法 A 是否回滚
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int update1(User user) {
        user.setAge(1);
        update2(user);
        try {
        } catch (Exception e) {

        }
        userDao.update(user);
        return 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int update2(User user) {
        user.setAge(2);
        userDao.update(user);
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        int i = 1 / 0;
        return 0;
    }

}
