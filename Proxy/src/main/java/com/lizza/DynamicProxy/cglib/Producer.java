package com.lizza.DynamicProxy.cglib;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-23
 */
public class Producer {

    public void sale(float money) {
        System.out.println("销售产品，售价：" + money);
    }

    public void service(float money) {
        System.out.println("提供售后服务！服务费：" + money);
    }
}
