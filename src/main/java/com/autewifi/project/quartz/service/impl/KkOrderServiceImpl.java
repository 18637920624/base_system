package com.autewifi.project.quartz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.autewifi.common.exception.base.BaseException;
import com.autewifi.project.quartz.domain.*;
import com.autewifi.project.quartz.mapper.KkOrderMapper;
import com.autewifi.project.quartz.service.KkDatajurigroupService;
import com.autewifi.project.quartz.service.KkDatapermissrulesService;
import com.autewifi.project.quartz.service.KkOrallocationlogService;
import com.autewifi.project.quartz.service.KkOrderService;
import com.autewifi.project.quartz.task.ApiConstants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 宽带活动订单表服务实现类
 * Created by AutoGenerator on 2021-07-15 15:05:32
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KkOrderServiceImpl extends ServiceImpl<KkOrderMapper, KkOrder> implements KkOrderService {

    private  final KkOrallocationlogService orallocationlogService;


    @Override
    public boolean autoAllot(OrderAllotDto o,UserAllotDTO u) {

        KkOrder order = new KkOrder();

        Date nowdate = new Date();
        order.setId(o.getId());
        order.setAllostate(ApiConstants.ALLOCATION_ASSIGNED);
        order.setAllodate(nowdate);
        order.setDealwithuid(u.getUsercode());
        order.setDealwithuname(u.getNickname());
        if(u.getBeyotimerecy() != null ){
			order.setTimeoutbackdate(DateUtil.offsetHour(nowdate,u.getBeyotimerecy()));
		}
        int orow = baseMapper.updateById(order);
        if(orow <= 0 ){
            throw new BaseException("订单: "+o.getOrdecode()+" 状态处理失败");
        }
        KkOrallocationlog log = new KkOrallocationlog();
        log.setDealuid(u.getUsercode());
        log.setDealuname(u.getNickname());
		log.setUname("系统自动分配");
        log.setType(ApiConstants.TYPE_ZI_DONG);
        log.setBrorcode(order.getCode());
        log.setCtime(new Date());
        boolean result = orallocationlogService.save(log);
        if(! result){
            throw new BaseException("订单: "+o.getOrdecode()+" 分配记录生成失败");
        }
        return true;
    }

	@Override
	public List<KkOrderDTO> selectTimeOver(LocalDateTime date) {
		return baseMapper.selectTimeOver(date);
	}

	@Override
	public boolean overTime(KkOrder order) {
		order.setAllostate(ApiConstants.ALLOCATION_WITHDRAW);
		order.setAllodate(new Date());
		order.setDealwithuid(" ");
		order.setDealwithuname(" ");

		KkOrallocationlog log = new KkOrallocationlog();
		log.setUid(order.getDealwithuid());
		log.setUname(order.getDealwithuname());
		log.setType(ApiConstants.TYPE_CSHT);
		log.setBrorcode(order.getCode());
		log.setCtime(new Date());
		boolean result = orallocationlogService.save(log);
		if(! result){
			throw new BaseException("订单: "+order.getCode()+" 超时回退记录生成失败");
		}

		int orow = baseMapper.updateById(order);
		if(orow <= 0 ){
			throw new BaseException("订单: "+order.getCode()+" 状态处理失败");
		}
		return true;
	}


}
