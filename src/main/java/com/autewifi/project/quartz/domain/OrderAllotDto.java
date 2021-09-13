package com.autewifi.project.quartz.domain;

import lombok.Data;

@Data
public class OrderAllotDto {
	private  Integer id;
	private String ordecode;
	private String schocode;
	private String oper;
	private String city;
	private String type;
	private String tag;
}
