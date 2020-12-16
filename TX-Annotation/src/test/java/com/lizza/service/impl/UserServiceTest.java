package com.lizza.service.impl;

import com.lizza.config.SpringConfig;
import com.lizza.entity.User;
import com.lizza.service.ServiceA;
import com.lizza.service.ServiceB;
import com.lizza.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceB serviceB;

    @Test
    public void resetUser() {
        User user = new User();
        user.setId(1).setName("lizza").setAge(20).setMoney(0d);
        userService.update(user);
    }

    /**
     * 隔离级别
     */
    @Test
    public void update1() {
        User user = new User();
        user.setId(1);
        serviceA.update(user);
    }

}
