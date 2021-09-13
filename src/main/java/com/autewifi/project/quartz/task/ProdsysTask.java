package com.autewifi.project.quartz.task;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.log.Log;
import com.autewifi.framework.aspectj.lang.annotation.DataSource;
import com.autewifi.framework.aspectj.lang.enums.DataSourceType;
import com.autewifi.project.quartz.domain.*;
import com.autewifi.project.quartz.service.KkOrderService;
import com.autewifi.project.quartz.service.OrderService;
import com.autewifi.project.quartz.service.ProdsystemService;
import com.autewifi.project.quartz.service.YxOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务调度测试
 *
 * @author Autewifi
 */
@DataSource(DataSourceType.SLAVE)
@Component("prodsysTask")
@RequiredArgsConstructor
public class ProdsysTask {

	private final ProdsystemService baseService;
	private final OrderService orderService;
	private final KkOrderService kkorderService;
	private final YxOrderService yxorderService;

	/**
	 * 订单分配
	 */
	public void orderAllot() {
		Log.get().info("订单分配: " + LocalDateTime.now());
		List<OrderAllotDto> kds = orderService.selectAllot();
		kds.forEach( o ->{
			UserAllotDTO u = baseService.selectUserAllot(o);
			if(u != null){
				if (ApiConstants.ACTIVITY_TYPE_KD.equalsIgnoreCase(o.getType())) {
					orderService.autoAllot(o,u);
				} else if (ApiConstants.ACTIVITY_TYPE_KK.equalsIgnoreCase(o.getType())) {
					kkorderService.autoAllot(o,u);
				} else if (ApiConstants.ACTIVITY_TYPE_YX.equalsIgnoreCase(o.getType())) {
					yxorderService.autoAllot(o,u);
				}
			}
		});
	}

	/**
	 * 超时回退
	 */
	public void overTime() {

		List<Order> list = orderService.selectTimeOver(LocalDateTime.now());
		Log.get().info("超时回退: " + list.size());
		if (CollectionUtil.isEmpty(list)) {
			return;
		}
		list.forEach(u -> {
			if (ApiConstants.ACTIVITY_TYPE_KD.equalsIgnoreCase(u.getType())) {
				orderService.overTime(u);
			}
			if (ApiConstants.ACTIVITY_TYPE_KK.equalsIgnoreCase(u.getType())) {
				KkOrder kk = new KkOrder();
				BeanUtil.copyProperties(u, kk);
				kkorderService.overTime(kk);
			}
			if (ApiConstants.ACTIVITY_TYPE_YX.equalsIgnoreCase(u.getType())) {
				YxOrder yx = new YxOrder();
				BeanUtil.copyProperties(u, yx);
				yxorderService.overTime(yx);
			}
		});
	}
}
