package com.atguigu.scw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.scw.order.bean.TOrder;
import com.atguigu.scw.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	//更新订单状态的方法
	@PostMapping("/order/updateOrderStatus")
	public ResponseVo<String> updateOrderStatus(@RequestParam("orderNum")String orderNum , @RequestParam("status")String status){
		orderService.updateOrderStatus(orderNum , status);
		
		return ResponseVo.ok("订单状态更新成功");
	}
	
	
	//创建订单保存到数据库
	@PostMapping("/order/createOrder")
	public ResponseVo<String> createOrder(@RequestBody TOrder order){
		//保存订单到数据库
		orderService.saveOrder(order);
		return ResponseVo.ok("订单创建成功");
	}
}
