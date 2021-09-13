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
@ApiModel(description = "营销活动数据权限规则")
@TableName("yx_datapermissrules")
public class YxDatapermissrules implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "dpru_id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "规则编号")
    @TableField("dpru_code")
    private String code;


    @ApiModelProperty(value = "组编号")
    @TableField("dpru_digrcode")
    private String digrcode;


    @ApiModelProperty(value = "组名称")
    @TableField("dpru_digrname")
    private String digrname;


    @ApiModelProperty(value = "学校名称集合 格式:河南大学-明伦校区,河南大学-龙子湖校区")
    @TableField("dpru_schcodes")
    private String schcodes;


    @ApiModelProperty(value = "学校编号集合 格式: schoolid,schoolid")
    @TableField("dpru_schnames")
    private String schnames;


    @ApiModelProperty(value = "运营商名称集合 中国移动,中国联通")
    @TableField("dpru_opers")
    private String opers;


    @ApiModelProperty(value = "运营商集合 CMCC,CUCC")
    @TableField("dpru_opername")
    private String opername;


    @ApiModelProperty(value = "创建时间")
    @TableField("dpru_ctime")
    private Date ctime;


    @ApiModelProperty(value = "创建人ID")
    @TableField("dpru_uid")
    private String uid;


    @ApiModelProperty(value = "修改时间")
    @TableField("dpru_mtime")
    private Date mtime;


    @ApiModelProperty(value = "修改人ID")
    @TableField("dpru_muid")
    private String muid;



}
