package org.springcloud.service.governing.dao;

import org.springcloud.service.governing.entity.request.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/
@Repository
public interface UserDao {
    List<UserEntity> getUser();

    UserEntity getUserById(Integer userId);
}
