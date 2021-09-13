package com.autewifi.project.quartz.mapper;

import com.autewifi.project.quartz.domain.OrderAllotDto;
import com.autewifi.project.quartz.domain.UserAllotDTO;
import org.apache.ibatis.annotations.Select;

public interface ProdsystemMapper {

	UserAllotDTO selectUserAllot(OrderAllotDto order);

}
