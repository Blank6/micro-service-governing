package org.springcloud.service.governing.dao;

import org.springcloud.service.governing.entity.request.ApplicationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidApplicationDao {
    List<ApplicationEntity> validApplication(String app);

    void updateStatus(String app);
}
