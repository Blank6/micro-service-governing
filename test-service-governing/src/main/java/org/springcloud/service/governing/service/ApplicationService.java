package org.springcloud.service.governing.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springcloud.service.governing.dao.ApplicationDao;
import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springcloud.service.governing.entity.request.PageEntity;
import org.springcloud.service.governing.execption.BusinessException;
import org.springcloud.service.governing.util.IPUtil;
import org.springcloud.service.governing.util.PortUtil;
import org.springcloud.service.governing.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (applicationEntity.getServiceName() == null) {
            String serviceName = StringUtil.getRandomChar(5);
            applicationEntity.setServiceName(serviceName);
        }
        if (applicationEntity.getServiceRegistryUrl() == null) {
            String registryUrl = "http://" + IPUtil.getRandomIp() + ":" + PortUtil.RandomPort() + "/eureka";
            applicationEntity.setServiceRegistryUrl(registryUrl);
        }
        System.out.printf(applicationEntity.toString());
        return applicationDao.createApplication(applicationEntity);
    }

    public PageEntity getApplicationInfo(ApplicationEntity applicationEntity) throws BusinessException {
        Integer pageNum = applicationEntity.getPageNum();
        Integer pageSize = applicationEntity.getPageSize();
        Integer tatalPage =  applicationDao.getApplicationInfo(applicationEntity).size();
        //使用Mybatis分页插件
        PageHelper.startPage(pageNum, pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<ApplicationEntity> appInfos = applicationDao.getApplicationInfo(applicationEntity);
        System.out.println("ApplicationService" + appInfos.toString());
        return new PageEntity<ApplicationEntity>(appInfos.getTotal(), appInfos.getResult());
    }

    public Integer deleteApplication(ApplicationEntity applicationEntity) throws BusinessException{
        return applicationDao.deleteApplication(applicationEntity);
    }
}
