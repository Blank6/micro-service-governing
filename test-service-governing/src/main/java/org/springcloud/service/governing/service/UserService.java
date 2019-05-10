package org.springcloud.service.governing.service;


import org.springcloud.service.governing.dao.UserDao;
import org.springcloud.service.governing.entity.request.UserEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.execption.ConstantResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:18
*/

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public List<UserEntity> getUsers() throws BusinessException {
        return userDao.getUsers();
    }

    public UserEntity getUserById(Integer userId) throws BusinessException {
        return userDao.getUserById(userId);
    }

    public UserEntity userLogin(UserEntity userLoginParam) throws BusinessException {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("userId", userLoginParam.getUserId());
        condition.put("userName", userLoginParam.getUserName());
        condition.put("password", userLoginParam.getPassword());
        //	condition.put("token", userLoginParam.getToken());
//        if(userLoginParam.getCheckType().equals("L")){
//            Integer ret = adminMngtDao.updateUserToken(condition);
//            if (ret != 1) {
//                throw new BusinessException(ConstantResultCode.LOGIN_FAIL);
//            }
//        }
//        if(userLoginParam.getCheckType().equals("Q")) {
//            Integer ret = adminMngtDao.userQuit(condition);
//            if (ret != 1) {
//                throw new BusinessException(ConstantResultCode.LOGIN_FAIL);
//            }
//        }
        UserEntity userDbInfo = userDao.getUserDbInfo(condition).get(0);
        if (userDbInfo == null) {
            throw new BusinessException(ConstantResultCode.ERROR, "用户不存在");
        }
        return new UserEntity(userDbInfo.getUserId(), userDbInfo.getUserName(),userDbInfo.getToken());
    }
}
