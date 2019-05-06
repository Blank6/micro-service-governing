package org.springcloud.service.governing.controller;


import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.entity.response.ResponseEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.execption.ConstantResultCode;
import org.springcloud.service.governing.service.ValidApplicationServcie;
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
* @CreateDate:     2019/4/23 16:48
*/

@RestController
public class ValidApplicationController {

    @Autowired
    private ValidApplicationServcie validApplicationService;
    @RequestMapping(value = "/validApplication", method = RequestMethod.POST)
    public ResponseEntity validApplication(@RequestBody ApplicationEntity applicationEntity) {
        List<ApplicationEntity> ret = new ArrayList<ApplicationEntity>();
        try {
            ret = validApplicationService.validApplication(applicationEntity);
            if (ret.size() != 0) {
                validApplicationService.updateStatus(applicationEntity);
                return new ResponseEntity(ConstantResultCode.OK, ret);
            } else {
                return new ResponseEntity(ConstantResultCode.ERROR, ret);
            }
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable throwable) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
    }
}
