package com.mi.controller;

import com.mi.Vo.ResultVo;
import com.mi.domain.Appointment;
import com.mi.mapper.AppointmentMapper;
import com.mi.util.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * @author : Rong
 * @date : 2020/2/11
 * @Desc:
 */
@Api(tags = "预约业务处理控制类")
@RestController
@RequestMapping("/appoint")
public class AppointController {

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 查询预约id
     * @param appointId
     * @return
     */
    @ApiOperation(value = "获取预约信息",notes = "根据url的appointId来获取预约信息")
    @ApiImplicitParam(name = "appointId",value = "预约id",dataType = "String",paramType = "path")
    @RequestMapping(value = "/getByAppoint/{appointId}",method = RequestMethod.GET)
    public ResultVo getByAppointById(@PathVariable(value = "appointId")
                                     String appointId){
        Appointment appointment = appointmentMapper.selectByPrimaryKey(appointId);
        return ResultVoUtil.success(appointment);
    }


    /**
     * 添加信息
     * @param appointment
     * @return
     */
    @ApiOperation(value = "添加预约信息",notes = "注意格式参数")
    @ApiImplicitParam(paramType = "body")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo Add( Appointment appointment){
        int i = appointmentMapper.insert(appointment);
        if (i > 0 ){
            return ResultVoUtil.success();
        }
        return null;
    }

    /**
     * 删除预约
     * @param appointId
     * @return
     */
    @ApiOperation(value ="删除预约信息",notes = "根据url的appointId带来删除预约信息")
    @ApiImplicitParam(name = "appointId",value = "预约id",dataType = "String",paramType = "path")
    @RequestMapping(value = "/deleteByAppoint/{appointId}",method = RequestMethod.DELETE)
    public ResultVo deleteByProductId(@PathVariable(value = "appointId")
                                                  String appointId){


        int i =  appointmentMapper.deleteByPrimaryKey(appointId);
        if (i > 0 ){
           return ResultVoUtil.success();
        }
        return null;
    }

    /**
     * 修改预约
     * @param appointment
     * @return
     */
    @ApiOperation(value = "修改预约信息",notes = "注意格式参数")
    @ApiImplicitParam(paramType = "body")
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultVo Update( Appointment appointment){
        int i = appointmentMapper.updateByPrimaryKey(appointment);
        if (i > 0 ){
        return     ResultVoUtil.success();
        }
        return null;
    }

}