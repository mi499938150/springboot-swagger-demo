package com.mi.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : Rong
 * @date : 2019/12/9
 * @Desc:
 */
@Data
@Table(name = "wechat_user")
@ApiModel(value = "UserInfo",description = "用户信息")
public class WeChatUser implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true) //回显
    private String openId;
    @ApiModelProperty(name = "nickName",value = "名称" )
    private String nickName;
    @ApiModelProperty(name = "sexDesc",value = "性别" )
    private String sexDesc;
    @ApiModelProperty(name = "sex",value = "性别状态" )
    private Integer sex;
    @ApiModelProperty(name = "language",value = "语言" )
    private String language;
    @ApiModelProperty(name = "city",value = "城市" )
    private String city;
    @ApiModelProperty(name = "province",value = "省份" )
    private String province;
    @ApiModelProperty(name = "country",value = "国家" )
    private String country;
    @ApiModelProperty(name = "headImgUrl",value = "头像" )
    private String headImgUrl;

}