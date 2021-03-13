package com.lizza.dao.orders;

import com.lizza.entity.Orders;
import org.springframework.stereotype.Repository;

@Repository("OrdersDao")
public interface OrdersDao {
    Orders select(int id);
}
