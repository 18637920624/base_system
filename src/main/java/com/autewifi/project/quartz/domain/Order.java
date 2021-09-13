package com.autewifi.project.quartz.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by AutoGenerator on 2021-07-16 09:56:27
 */
@Data
@ApiModel(description = "宽带活动订单表")
@TableName("kd_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "orde_id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    @TableField("orde_code")
    private String code;

    @ApiModelProperty(value = "活动编号")
    @TableField("orde_acticode")
    private String acticode;

    @ApiModelProperty(value = "活动名称")
    @TableField("orde_actiname")
    private String actiname;

    @ApiModelProperty(value = "产品编号")
    @TableField("orde_suprcode")
    private String suprcode;

    @ApiModelProperty(value = "产品名称")
    @TableField("orde_suprname")
    private String suprname;

    @ApiModelProperty(value = "产品金额")
    @TableField("orde_suprprice")
    private BigDecimal suprprice;

    @ApiModelProperty(value = "实付金额")
    @TableField("orde_payamount")
    private BigDecimal payamount;

    @ApiModelProperty(value = "学校编号")
    @TableField("orde_schcode")
    private String schcode;

    @ApiModelProperty(value = "用户选择运营商")
    @TableField("orde_seloper")
    private String seloper;

    @ApiModelProperty(value = "是否办理携号转网 是否办理携号转网 1是 0否")
    @TableField("orde_iswithno")
    private Integer iswithno;

    @ApiModelProperty(value = "开启携号转网 1 是， 0 否")
    @TableField("order_secondon")
    private Integer secondon;

    @ApiModelProperty(value = "用户手机号")
    @TableField("orde_telephone")
    private String telephone;

    @ApiModelProperty(value = "姓名")
    @TableField("orde_username")
    private String username;

    @ApiModelProperty(value = "下单时间")
    @TableField("orde_ctime")
    private Date ctime;

    @ApiModelProperty(value = "支付方式 支付方式 1支付宝2微信")
    @TableField("orde_paytype")
    private Integer paytype;

    @ApiModelProperty(value = "支付时间")
    @TableField("orde_paytime")
    private Date paytime;

    @ApiModelProperty(value = "分配状态 -1 超时已回退 0未分配 1已分配 2已转单未处理已")
    @TableField("orde_allostate")
    private Integer allostate;

    @ApiModelProperty(value = "当前分配的处理人员组织ID")
    @TableField("orde_dealwithorgid")
    private String dealwithorgid;

    @ApiModelProperty(value = "当前分配的处理人员ID")
    @TableField("orde_dealwithuid")
    private String dealwithuid;

    @ApiModelProperty(value = "当前分配的处理人员姓名")
    @TableField("orde_dealwithuname")
    private String dealwithuname;

    @ApiModelProperty(value = "订单分配给处理人员的时间")
    @TableField("orde_allodate")
    private Date allodate;

	@ApiModelProperty(value = "订单超时回退的截止时间")
	@TableField("orde_timeoutbackdate")
	private Date timeoutbackdate;

    @ApiModelProperty(value = "订单状态 1下单 2 已支付 3通过 4拒绝")
    @TableField("orde_state")
    private Integer state;

    @ApiModelProperty(value = "是否对接认证")
    @TableField("orde_isdockingauth")
    private Integer isdockingauth;

    @ApiModelProperty(value = "失败类型ID")
    @TableField("orde_recoprobid")
    private Integer recoprobid;

    @ApiModelProperty(value = "备注")
    @TableField("orde_remark")
    private String remark;

    @ApiModelProperty(value = "操作人ID")
    @TableField("orde_manageid")
    private String manageid;

    @ApiModelProperty(value = "操作人姓名")
    @TableField("orde_managename")
    private String managename;

    @ApiModelProperty(value = "操作时间")
    @TableField("orde_managetime")
    private Date managetime;

    @ApiModelProperty(value = "稽核状态 1已稽核 0 未稽核")
    @TableField("orde_audit")
    private Integer audit;

    @ApiModelProperty(value = "删除状态 1删除 0未删除")
    @TableField("aute_deleted")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "版本号 乐观锁")
    @TableField("version")
    @Version
    private Integer version;


    @TableField(exist = false)
    private String type;

    @ApiModelProperty(value = "实际订购产品列表 订单提交时，实际订购产品的预期信息固定下来")
    @TableField(exist = false)
    private String actprolist;

    @ApiModelProperty(value = "订购产品ID")
    @TableField(exist = false)
    private String actproid;


}
