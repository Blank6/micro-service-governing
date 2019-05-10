package org.springcloud.service.governing.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/23 13:36
*/

@Repository
public interface ApplicationDao {

    Integer createApplication(@Param(value = "applicationEntity") ApplicationEntity applicationEntity);

    Page<ApplicationEntity> getApplicationInfo(ApplicationEntity applicationEntity);

    Integer deleteApplication(ApplicationEntity applicationEntity);
}

