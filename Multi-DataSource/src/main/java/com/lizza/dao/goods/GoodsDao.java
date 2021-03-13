package com.lizza.dao.goods;

import com.lizza.entity.Goods;
import org.springframework.stereotype.Repository;

@Repository("GoodsDao")
public interface GoodsDao {
    Goods select(int id);
}
