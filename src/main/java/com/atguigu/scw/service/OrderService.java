package com.atguigu.scw.service;

import com.atguigu.scw.order.bean.TOrder;

public interface OrderService {

	void saveOrder(TOrder order);

	void updateOrderStatus(String orderNum, String status);

}
