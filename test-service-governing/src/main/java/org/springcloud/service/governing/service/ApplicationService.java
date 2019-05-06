package org.springcloud.service.governing.service;


import org.springcloud.service.governing.dao.ApplicationDao;
import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.util.IPUtil;
import org.springcloud.service.governing.util.PortUtil;
import org.springcloud.service.governing.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/23 13:36
*/

@Service
public class ApplicationService {
    
    @Autowired
    ApplicationDao applicationDao;

    public Integer createApplication(ApplicationEntity applicationEntity) throws BusinessException {

        if (applicationEntity.getApp() == null) {
            String app = StringUtil.getRandomChar(5);
            applicationEntity.setApp(app);
        }
        System.out.printf(applicationEntity.getRegistryUrl());
        if (applicationEntity.getRegistryUrl() == null) {
            String registryUrl = "http://" + IPUtil.getRandomIp() + ":" + PortUtil.RandomPort() + "/eureka";
            applicationEntity.setRegistryUrl(registryUrl);
        }
        System.out.printf(applicationEntity.toString());
        return applicationDao.createApplication(applicationEntity);
    }

    public List<ApplicationEntity> getApplicationInfo() throws BusinessException {
        return applicationDao.getApplicationInfo();
    }
}
