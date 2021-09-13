package com.autewifi.project.quartz.service;

import com.autewifi.project.quartz.domain.OrderAllotDto;
import com.autewifi.project.quartz.domain.UserAllotDTO;


public interface ProdsystemService {
	UserAllotDTO selectUserAllot(OrderAllotDto order);
}
