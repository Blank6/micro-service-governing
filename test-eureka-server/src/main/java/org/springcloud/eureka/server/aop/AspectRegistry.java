package org.springcloud.eureka.server.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/23 18:24
*/

@Aspect
@Component
public class AspectRegistry {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public RestTemplate restTemplate;

    @Around(value = "org.springcloud.eureka.server.aop.Pointcuts.registerAspect()")
    public Object resourcesCallAround(ProceedingJoinPoint point) throws Throwable {
        try{
            logger.info("SERVICE:" + editLogContent4Begin(point));
        }catch(Throwable t){
            logger.error("Logging for service method error.", t);
        }
        /*
         *  拦截注册请求，到治理中心进行验证
        */
//        Object result = restTemplate.postForEntity("http://localhost:30000/validApplication", null, String.class);
//        logger.info("***********************************");
//        logger.info(result.toString());
        logger.info("***********************************");
        return point.proceed();
    }


    private String editLogContent4Begin(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer sbLog = new StringBuffer(256);
        sbLog.append("URL : ");
        sbLog.append(request.getRequestURL().toString());
        sbLog.append(" | ");
        sbLog.append("HTTP_METHOD : ");
        sbLog.append(request.getMethod());
        sbLog.append(" | ");
        sbLog.append("IP : ");
        sbLog.append(request.getRemoteAddr());
        sbLog.append(" | ");
        sbLog.append("CLASS_METHOD : ");
        sbLog.append(joinPoint.getSignature().getDeclaringTypeName());
        sbLog.append(".");
        sbLog.append(joinPoint.getSignature().getName());
        sbLog.append("() start. Parameters: {");
        sbLog.append(Arrays.toString(joinPoint.getArgs()));
        sbLog.append("}");
        return sbLog.toString();
    }
}
