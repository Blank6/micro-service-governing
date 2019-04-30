package org.springcloud.service.governing.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:16
*/
@Aspect
@Configuration
public class Pointcuts {
    @Pointcut(value = "execution(* com.test.service..*.*(..))")
    public void serviceCall() {}

    @Pointcut(value = "execution(* com.test.controller..*.*(..))")
    public void controllerCall() {}
}


