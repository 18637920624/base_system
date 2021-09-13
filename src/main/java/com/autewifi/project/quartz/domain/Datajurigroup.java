package com.autewifi.project.quartz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(description = "数据权限组")
@TableName("kd_datajurigroup")
public class Datajurigroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "djgr_id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "组编号")
    @TableField("digr_code")
    private String digrCode;

    @ApiModelProperty(value = "组名称")
    @TableField("digr_name")
    private String digrName;

    @ApiModelProperty(value = "所属组织ID")
    @TableField("digr_orgcode")
    private String digrOrgcode;

    @ApiModelProperty(value = "状态 1正常0禁用")
    @TableField("digr_state")
    private Integer digrState;

    @ApiModelProperty(value = "组描述")
    @TableField("digr_desc")
    private String digrDesc;

    @ApiModelProperty(value = "超出时间回收订单 单位：小时")
    @TableField("digr_beyotimerecy")
    private BigDecimal digrBeyotimerecy;

    @ApiModelProperty(value = "是否开启当日每人分配订单最大限制 1开启0关闭")
    @TableField("digr_isdistmaxlimit")
    private Integer digrIsdistmaxlimit;

    @ApiModelProperty(value = "当日每人分配订单最大限制数")
    @TableField("digr_distmaxlimit")
    private Integer digrDistmaxlimit;

    @ApiModelProperty(value = "订单管理时间范围开始时间 限制只能查询一定时间内的订单")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("digr_orderscopestime")
    private Date digrOrderscopestime;

    @ApiModelProperty(value = "订单管理时间范围结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("digr_orderscopeetime")
    private Date digrOrderscopeetime;

    @ApiModelProperty(value = "标记过滤 格式：标记ID,标记ID")
    @TableField("digr_tagfilter")
    private String digrTagfilter;

    @ApiModelProperty(value = "创建时间")
    @TableField("digr_ctime")
    private Date digrCtime;

    @ApiModelProperty(value = "创建人ID")
    @TableField("digr_cuid")
    private String digrCuid;

    @ApiModelProperty(value = "修改时间")
    @TableField("digr_mtime")
    private Date digrMtime;

    @ApiModelProperty(value = "修改人ID")
    @TableField("digr_muid")
    private String digrMuid;

    @ApiModelProperty(value = "组织名称")
    @TableField(exist = false)
    private String orgName;

    @ApiModelProperty(value = "创建人名称")
    @TableField(exist = false)
    private String cname;

    @ApiModelProperty(value = "修改人名称")
    @TableField(exist = false)
    private String mname;

    @ApiModelProperty(value = "组成员个数")
    @TableField(exist = false)
    private Integer memberNum;

}
