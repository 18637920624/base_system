package com.autewifi.project.quartz.task;

public class ApiConstants {


	public static final String ACTIVITY_TYPE_KD = "KD";
	public static final String ACTIVITY_TYPE_KK = "KK";
	public static final String ACTIVITY_TYPE_YX = "YX";
	/**
	 * 分配状态 -1 超时已回退 0未分配 1已分配 2已转单未处理
	 */
	public static final int ALLOCATION_WITHDRAW = -1;
	public static final int ALLOCATION_UNASSIGNED = 0;
	public static final int ALLOCATION_ASSIGNED = 1;
	public static final int ALLOCATION_TRANSFER_UNTREATED = 2;


	/**
	 * 自动
	 */
	public static final int TYPE_ZI_DONG = 1;
	/**
	 * 转单
	 */
	public static final int TYPE_ZHUAN_DAD = 2;
	/**
	 * 手动分配
	 */
	public static final int TYPE_SDFP = 3;
	/**
	 * 超时回退
	 */
	public static final int TYPE_CSHT = 4;
}
