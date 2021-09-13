package com.autewifi.project.quartz.service;

import com.autewifi.project.quartz.domain.OrderAllotDto;
import com.autewifi.project.quartz.domain.UserAllotDTO;
import com.autewifi.project.quartz.domain.YxOrder;
import com.autewifi.project.quartz.domain.YxOrderDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 宽带活动订单表服务类
 * Created by AutoGenerator on 2021-07-15 15:05:32
 */
public interface YxOrderService extends IService<YxOrder> {
	/**
	 * 分配订单
	 *
	 * @return
	 */
	boolean autoAllot(OrderAllotDto o,UserAllotDTO u);

	/**
	 * 查询过期回退订单
	 * @param date
	 * @return
	 */
	List<YxOrderDTO> selectTimeOver(LocalDateTime date);

	/**
	 * 超时回退
	 * @param dto
	 */
	boolean overTime(YxOrder dto);


}
