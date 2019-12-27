package com.atguigu.scw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.scw.order.bean.TOrder;
import com.atguigu.scw.order.bean.TOrderExample;
import com.atguigu.scw.order.mapper.TOrderMapper;
import com.atguigu.scw.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	TOrderMapper orderMapper;
	
	@Override
	public void saveOrder(TOrder order) {
		orderMapper.insertSelective(order);
	}

	@Override
	public void updateOrderStatus(String orderNum, String status) {
		TOrder record = new TOrder();//存储需要更新的数据
		record.setStatus(status);
		TOrderExample example = new TOrderExample();//存储查找需要修改数据的条件
		example.createCriteria().andOrdernumEqualTo(orderNum);
		orderMapper.updateByExampleSelective(record, example);
	}

}
