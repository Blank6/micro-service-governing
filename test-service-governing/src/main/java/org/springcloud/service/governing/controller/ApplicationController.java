package org.springcloud.service.governing.controller;


import com.github.pagehelper.Page;
import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.entity.request.BaseParamEntity;
import org.springcloud.service.governing.entity.request.PageEntity;
import org.springcloud.service.governing.entity.response.ResponseEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.execption.ConstantResultCode;
import org.springcloud.service.governing.service.ApplicationService;
import org.springcloud.service.governing.util.IPUtil;
import org.springcloud.service.governing.util.PortUtil;
import org.springcloud.service.governing.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/23 13:36
*/

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "/createApp", method = RequestMethod.POST)
    public ResponseEntity getApp(@RequestBody BaseParamEntity BaseParamEntity) {
        String app = "MICRO-SERVICE-" + StringUtil.getRandomChar(5);
        return new ResponseEntity(ConstantResultCode.OK, app);
    }
    @RequestMapping(value = "/createRegistryUrl", method = RequestMethod.POST)
    public ResponseEntity createRegistryUrl(@RequestBody BaseParamEntity baseParamEntity) {
        String registryUrl = "";
        if (baseParamEntity.getRegion().equals("上海") || baseParamEntity.getRegion().equals("合肥")) {
            registryUrl = "http://localhost:8761/eureka/";
        } else {
            registryUrl = "http://" + IPUtil.getRandomIp() + ":" + PortUtil.RandomPort() + "/eureka";
        }
        return new ResponseEntity(ConstantResultCode.OK, registryUrl);
    }


    @RequestMapping(value = "/createApplication", method = RequestMethod.POST)
    public ResponseEntity createApplication(@RequestBody ApplicationEntity applicationEntity) {
        Integer ret = 0;
        try {
            ret = applicationService.createApplication(applicationEntity);
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        }catch (Throwable throwable) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        System.out.println("************" + ret);
        if (ret == 1) {
            return new ResponseEntity(ConstantResultCode.OK, ret);
        } else {
            return new ResponseEntity(ConstantResultCode.ERROR, ret);
        }
    }

    @RequestMapping(value = "/getApplicationInfo", method = RequestMethod.POST)
    public ResponseEntity getApplicationInfo(@RequestBody ApplicationEntity applicationEntity) {
        PageEntity<ApplicationEntity> appInfo = new PageEntity();
        System.out.println(applicationEntity.getApp());
        try {
            appInfo = applicationService.getApplicationInfo(applicationEntity);
            System.out.println(appInfo.toString());
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable t) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        return new ResponseEntity(ConstantResultCode.OK, appInfo);
    }

    @RequestMapping(value = "/deleteApplication", method = RequestMethod.POST)
    public ResponseEntity deleteApplication (@RequestBody ApplicationEntity applicationEntity) {
        Integer ret = 0;
        try {
            ret = applicationService.deleteApplication(applicationEntity);
            System.out.println(ret);
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable t) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        return new ResponseEntity(ConstantResultCode.OK, ret);
    }
}
