package org.springcloud.service.governing.service;


import org.springcloud.service.governing.dao.ValidApplicationDao;
import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidApplicationServcie {

    @Autowired
    private ValidApplicationDao validApplicationDao;

    public List<ApplicationEntity> validApplication(ApplicationEntity applicationEntity) throws BusinessException {
        List<ApplicationEntity> ret = new ArrayList<ApplicationEntity>();
        try {
             ret = validApplicationDao.validApplication(applicationEntity.getApp());
        }catch (Exception e){
//            System.out.println(ret.toString() + "---------- ValidApplicationServcie " +  ret.size());
            e.printStackTrace();
        }
        return ret;
    }

    public void updateStatus(ApplicationEntity applicationEntity) {
        validApplicationDao.updateStatus(applicationEntity.getApp());
    }
}
