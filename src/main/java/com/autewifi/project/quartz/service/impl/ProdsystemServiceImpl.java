package com.autewifi.project.quartz.service.impl;

import com.autewifi.project.quartz.domain.OrderAllotDto;
import com.autewifi.project.quartz.domain.UserAllotDTO;
import com.autewifi.project.quartz.mapper.ProdsystemMapper;
import com.autewifi.project.quartz.service.ProdsystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * Created by wangfan on 2018-12-24 16:10
 */
@Service
public class ProdsystemServiceImpl implements ProdsystemService {
	@Autowired
	private ProdsystemMapper baseMapper;


	@Override
	public UserAllotDTO selectUserAllot(OrderAllotDto order) {
		return baseMapper.selectUserAllot(order);
	}
}
