package org.springcloud.service.governing.service;


import org.springcloud.service.governing.dao.ValidApplicationDao;
import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidApplicationServcie {

    @Autowired
    private ValidApplicationDao validApplicationDao;



    public Integer validApplication(ApplicationEntity applicationEntity) throws BusinessException {
        return validApplicationDao.validApplication();
    }
}
