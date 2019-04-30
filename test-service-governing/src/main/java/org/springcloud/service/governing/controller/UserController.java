package org.springcloud.service.governing.controller;


import org.springcloud.service.governing.entity.request.UserEntity;
import org.springcloud.service.governing.entity.response.ResponseEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.execption.ConstantResultCode;
import org.springcloud.service.governing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:16
*/



@RestController
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity getUser() {
        List<UserEntity> userInfo = new ArrayList<UserEntity>();
        try {
            userInfo = userService.getUser();
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable t) {
           return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        return new ResponseEntity(ConstantResultCode.OK, userInfo);
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public ResponseEntity getUserById(UserEntity userEntity) {
        UserEntity userInfo = null;
        try {
            userInfo = userService.getUserById(userEntity.getUserId());
        } catch (BusinessException exp) {
            return new ResponseEntity(exp.getCode(), exp.getMessage());
        } catch (Throwable t) {
            return new ResponseEntity(ConstantResultCode.ERROR, null);
        }
        return new ResponseEntity(ConstantResultCode.OK, userInfo);
    }
}
