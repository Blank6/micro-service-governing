package org.springcloud.service.governing.controller;


import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.entity.response.ResponseEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.execption.ConstantResultCode;
import org.springcloud.service.governing.service.ApplicationService;
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

        if (ret == 1) {
            return new ResponseEntity(ConstantResultCode.OK, ret);
        } else {
            return new ResponseEntity(ConstantResultCode.ERROR, ret);
        }
    }

    @RequestMapping(value = "/getApplicationInfo", method = RequestMethod.GET)
    public ResponseEntity getApplicationInfo() {
        List<ApplicationEntity> appInfo = new ArrayList<>();
        try {
            appInfo = applicationService.getApplicationInfo();
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable t) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        return new ResponseEntity(ConstantResultCode.OK, appInfo);
    }
}
