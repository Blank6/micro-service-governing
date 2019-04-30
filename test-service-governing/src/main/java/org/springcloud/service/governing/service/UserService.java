package org.springcloud.service.governing.service;


import org.springcloud.service.governing.dao.UserDao;
import org.springcloud.service.governing.entity.request.UserEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:18
*/

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public List<UserEntity> getUser() throws BusinessException {
        return userDao.getUser();
    }

    public UserEntity getUserById(Integer userId) throws BusinessException {
        return userDao.getUserById(userId);
    }
}
