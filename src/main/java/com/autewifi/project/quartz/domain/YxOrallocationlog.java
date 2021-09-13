package com.autewifi.project.quartz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AutoGenerator on 2021-08-06 09:42:38
 */
@Data
@ApiModel(description = "营销活动订单分配记录")
@TableName("yx_orallocationlog")
public class YxOrallocationlog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "allo_id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "营销活动订单号")
    @TableField("allo_brorcode")
    private String brorcode;


    @ApiModelProperty(value = "订单分配人ID")
    @TableField("allo_uid")
    private String uid;


    @ApiModelProperty(value = "订单分配人姓名")
    @TableField("allo_uname")
    private String uname;


    @ApiModelProperty(value = "订单处理人ID")
    @TableField("allo_dealuid")
    private String dealuid;


    @ApiModelProperty(value = "订单处理人姓名")
    @TableField("allo_dealuname")
    private String dealuname;


    @ApiModelProperty(value = "分配方式 1自动 2 转单 3手动分配4超时回退")
    @TableField("allo_type")
    private Integer type;


    @ApiModelProperty(value = "创建时间")
    @TableField("allo_ctime")
    private Date ctime;


    @ApiModelProperty(value = "转单接收状态 -1 拒绝 1接受 0 未处理")
    @TableField("allo_transrecestate")
    private Integer transrecestate;


    @ApiModelProperty(value = "转单接收时间")
    @TableField("allo_transrecetime")
    private Date transrecetime;



}
