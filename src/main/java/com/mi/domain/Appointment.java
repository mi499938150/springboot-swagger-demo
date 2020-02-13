package com.mi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : Rong
 * @date : 2019/2/12
 * @Desc: 预约实体类
 */
@Data
@Accessors(chain = true)
@Table(name = "appoint_ment")
@ApiModel(value = "appointmentInfo",description = "用于预约服务模块")
public class Appointment implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true) //回显
    private String appointId;

    /**名字*/
    @ApiModelProperty(name = "appointName",value = "预约服务名",required = true)
    private String appointName;

    /**日期*/
    @ApiModelProperty(name = "appointWeek",value = "预约星期",required = true)
    private Date appointWeek;

    /**时间 08:00*/
    @ApiModelProperty(name = "appointTime",value = "预约时间",required = true)
    private String appointTime;

    /**单价*/
    @ApiModelProperty(name = "appointPrice",value = "服务价格",required = true)
    private BigDecimal appointPrice;

    /** 状态，0正常 1下架*/
    @ApiModelProperty(name = "appointStatus",value = "服务状态: 0-正常 1-伪删除")
    private Integer appointStatus;

    /**类目编号*/
    @ApiModelProperty(name = "categoryType",value = "服务类型",required = true)
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}