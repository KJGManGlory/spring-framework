package com.lizza.service;

import com.lizza.dao.UserDao;
import com.lizza.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int addOne(User user) {
        return userDao.addOne(user);
    }

    public int deleteOne(int id) {
        return userDao.deleteOne(id);
    }

    public int updateOne(User user) {
        return userDao.updateOne(user);
    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public int transferMoney(int fromId, int toId, double money) {
        // 1. 获取付款账户和收款账户
        User from_user = userDao.findOne(fromId);
        User to_user = userDao.findOne(toId);
        // 2. 付款账户付款，收款账户收款
        from_user.setMoney(from_user.getMoney() - money);
        to_user.setMoney(to_user.getMoney() + money);
        // 3. 更新账户信息
        updateAccount(from_user, to_user);
        return 0;
    }

    @Transactional
    public void updateAccount(User fromUser, User toUser) {
        userDao.updateOne(fromUser);
        int i = 1 / 0;
        userDao.updateOne(toUser);
    }

}
