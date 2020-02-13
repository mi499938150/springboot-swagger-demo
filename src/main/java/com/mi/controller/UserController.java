package com.mi.controller;

import com.mi.Vo.ResultVo;
import com.mi.domain.WeChatUser;
import com.mi.mapper.WechatUserMapper;
import com.mi.util.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/11
 * @Desc:
 */

@Api(tags = "用户业务处理控制类")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WechatUserMapper userMapper;


    /**
     * 查询用户所有信息
     * @return
     */
    @ApiOperation(value = "获取所有用户信息",notes = "根据url来获取所有用户信息")
    @ApiImplicitParam(paramType = "path")
    @RequestMapping(value = "/getByUserList",method = RequestMethod.GET)
    public ResultVo getByUserList(){
        List<WeChatUser> weChatUsers = userMapper.selectAll();
        return ResultVoUtil.success(weChatUsers);
    }

    /**
     * 用户登录  这里只简单的描述一下
     * @param openId
     * @param nickname
     * @return
     */
    @ApiOperation(value = "添加用户",notes = "注册格式参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickname",value = "用户账号",required = true,dataType = "String"),
            @ApiImplicitParam(name = "openId",value = "用户密码",required = true,dataType = "String")
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultVo login(String openId,String nickname ){
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setOpenId(openId);
        weChatUser.setNickName(nickname);
        WeChatUser select = userMapper.selectOne(weChatUser);
        return ResultVoUtil.success();
    }


}