package com.lizza.service.impl;

import com.lizza.config.SpringConfig;
import com.lizza.entity.User;
import com.lizza.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addOne() {
        User user = new User();
        user.setName("robert").setAge(23).setMoney(1000d);
        userService.insert(user);
    }

    @Test
    public void deleteOne() {
    }

    @Test
    public void update1() {
        User user = new User();
        user.setId(1);
        userService.update1(user);
    }

    @Test
    public void findAll() {
        List<User> list = userService.list();
        System.out.println(list);
    }

    @Test
    public void transferMoney() {
        userService.transferMoney(1, 2, 100);
        System.out.println(userService.list());
    }

}
