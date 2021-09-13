package com.autewifi.project.quartz.service;

import com.autewifi.project.quartz.domain.Order;
import com.autewifi.project.quartz.domain.OrderAllotDto;
import com.autewifi.project.quartz.domain.UserAllotDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 宽带活动订单表服务类
 * Created by AutoGenerator on 2021-07-15 15:05:32
 */
public interface OrderService extends IService<Order> {
	/**
	 * 分配订单
	 *
	 * @return
	 */
	boolean autoAllot(OrderAllotDto o, UserAllotDTO u);

	List<OrderAllotDto> selectAllot();

	/**
	 * 查询过期回退订单
	 * @param date
	 * @return
	 */
	List<Order> selectTimeOver(LocalDateTime date);

	/**
	 * 超时回退
	 * @param dto
	 */
	boolean overTime(Order dto);


}
