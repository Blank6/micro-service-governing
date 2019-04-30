package org.springcloud.service.governing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springcloud.service.governing.entity.response.ResponseEntity;
import org.springcloud.service.governing.execption.ConstantResultCode;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:38
*/

@Order(1)
@Aspect
@Configuration
public class AspectAuthen {
    protected final Logger logger = LoggerFactory.getLogger(getClass());


    @Around(value = "org.springcloud.service.governing.aop.Pointcuts.controllerCall()")
    public Object controllerCallAround(ProceedingJoinPoint point) {

        Object result = null;
        try{
            if(validToken(point) == false){
                return new ResponseEntity(ConstantResultCode.TOKEN_ERROR, null);
            }
        } catch (Throwable throwable) {
            logger.error("Token Validated error", throwable);
        }

        try{
            // 使用proceed()方法来执行目标方法
            result = point.proceed();
        } catch (Throwable throwable) {
            logger.error("Controller proceed error", throwable);
        }
        return result;
    }

    /**
     * 要和认证中心/服务治理平台结合
     * @param point
     * @return
     */
    public boolean validToken(JoinPoint point) {
        return true;
    }
}

