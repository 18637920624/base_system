package com.autewifi.project.quartz.mapper;

import com.autewifi.project.quartz.domain.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 宽带活动订单表Mapper接口
 * Created by AutoGenerator on 2021-07-16 09:56:27
 */
public interface OrderMapper extends BaseMapper<Order> {


/*	Order selectByRules(@Param("user") UserAllotDTO user,
						@Param("rules") List<Datapermissrules> list,
						@Param("group") Datajurigroup dg);*/


	/**
	 * 查询过期回退订单
	 * @param date
	 * @return
	 */
	List<Order> selectTimeOver(LocalDateTime date);

	boolean overTime(Date date);


	List<OrderAllotDto> selectAllot();
}
