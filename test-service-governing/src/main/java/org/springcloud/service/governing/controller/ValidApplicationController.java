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
        Integer ret = 0;
        try {
            ret = validApplicationService.validApplication(applicationEntity);
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable throwable) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        return new ResponseEntity(ConstantResultCode.ERROR, ret);
    }
}
