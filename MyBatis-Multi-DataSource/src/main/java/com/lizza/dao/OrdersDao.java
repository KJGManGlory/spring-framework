package com.lizza.dao;

import com.lizza.entity.Orders;

public interface OrdersDao {
    Orders select(int id);
}
