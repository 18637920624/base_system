package com.autewifi.project.quartz.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import com.autewifi.common.exception.base.BaseException;
import com.autewifi.project.quartz.domain.*;
import com.autewifi.project.quartz.mapper.OrderMapper;
import com.autewifi.project.quartz.service.DatajurigroupService;
import com.autewifi.project.quartz.service.DatapermissrulesService;
import com.autewifi.project.quartz.service.OrallocationlogService;
import com.autewifi.project.quartz.service.OrderService;
import com.autewifi.project.quartz.task.ApiConstants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 宽带活动订单表服务实现类
 * Created by AutoGenerator on 2021-07-15 15:05:32
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


	private final OrallocationlogService orallocationlogService;


	@Override
	public boolean autoAllot(OrderAllotDto o, UserAllotDTO u) {

		Order order = new Order();
		Date nowdate = new Date();
		order.setId(o.getId());
		order.setAllostate(ApiConstants.ALLOCATION_ASSIGNED);
		order.setAllodate(nowdate);
		order.setDealwithuid(u.getUsercode());
		order.setDealwithuname(u.getNickname());
		if (u.getBeyotimerecy() != null) {
			order.setTimeoutbackdate(DateUtil.offsetHour(nowdate, u.getBeyotimerecy()));
		}
		int orow = baseMapper.updateById(order);
		if (orow <= 0) {
			Log.get().error("订单: " + o.getOrdecode() + " 状态处理失败");
			throw new BaseException("订单: " + o.getOrdecode() + " 状态处理失败");
		}
		Orallocationlog log = new Orallocationlog();
		log.setDealuid(u.getUsercode());
		log.setDealuname(u.getNickname());
		log.setUname("系统自动分配");
		log.setType(ApiConstants.TYPE_ZI_DONG);
		log.setBrorcode(order.getCode());
		log.setCtime(new Date());
		boolean result = orallocationlogService.save(log);
		if (!result) {
			Log.get().error("订单: " + o.getOrdecode() + " 状态处理失败");
			throw new BaseException("订单: " + o.getOrdecode() + " 分配记录生成失败");
		}
		Log.get().info("订单: " + o.getOrdecode() + " 分配分配给：" + u.getNickname());
		return true;
	}

	@Override
	public List<OrderAllotDto> selectAllot() {
		return baseMapper.selectAllot();
	}

	@Override
	public List<Order> selectTimeOver(LocalDateTime date) {
		return baseMapper.selectTimeOver(date);
	}

	@Override
	public boolean overTime(Order order) {

		Orallocationlog log = new Orallocationlog();
		log.setUid(order.getDealwithuid());
		log.setUname(order.getDealwithuname());
		log.setType(ApiConstants.TYPE_CSHT);
		log.setBrorcode(order.getCode());
		log.setCtime(new Date());

		order.setAllostate(ApiConstants.ALLOCATION_WITHDRAW);
		order.setAllodate(new Date());
		order.setDealwithuid(" ");
		order.setDealwithuname(" ");


		boolean result = orallocationlogService.save(log);
		if (!result) {
			throw new BaseException("订单: " + order.getCode() + " 超时回退记录生成失败");
		}

		int orow = baseMapper.updateById(order);
		if (orow <= 0) {
			throw new BaseException("订单: " + order.getCode() + " 状态处理失败");
		}
		return true;
	}


}
