package org.springcloud.eureka.server.Service;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springcloud.eureka.server.bean.ApplicationEntity;
import org.springcloud.eureka.server.entity.response.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidService {
    private static final Logger logger = LoggerFactory.getLogger(ValidService.class);
    /**
     * 发送验证请求到治理中心
     * @param url
     * @return
     */
    public RespEntity validClient(String url, InstanceInfo info) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setApp(info.getAppName());
        applicationEntity.setToken("token");
        HttpEntity<ApplicationEntity> fromEntity = new HttpEntity(applicationEntity, headers);
        logger.info("ValidService ********** validClient :" + info.getAppName());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RespEntity> resp = restTemplate.postForEntity(url, fromEntity, RespEntity.class);
        logger.info("ValidService ********** resp.getBody().getErrorCode(): " + resp.getBody().getErrorCode());
        logger.info("ValidService ********** resp.getBody().getErrorMsg() :" +  resp.getBody().getErrorMsg() );
        return new RespEntity(resp.getBody().getErrorCode(), resp.getBody().getErrorMsg());
    }
}
