package org.springcloud.service.governing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
* @Description:    日志切面
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:16
*/

@Order(2)
@Aspect
@Configuration
public class AspectLog {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

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

    @Before(value = "org.springcloud.service.governing.aop.Pointcuts.serviceCall()")
    public void serviceCallBefore(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringTypeName();
//        String methodName = joinPoint.getSignature().getName();
//        if ("com.test.service.UserService".equals(className)
//                && "getUser".equals(methodName)) {
//            System.out.println("***********************************************");
//            return;
//        }
        try{
            logger.info("SERVICE:" + editLogContent4Begin(joinPoint));
        }catch(Throwable t){
            logger.error("Logging for service method error.", t);
        }
    }

    @Before(value = "org.springcloud.service.governing.aop.Pointcuts.controllerCall()")
    public void controllerCallBefore(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringTypeName();
//        String methodName = joinPoint.getSignature().getName();
//        if ("com.test.controller.UserController".equals(className)
//                && "getUser".equals(methodName)) {
//            System.out.println("#######################################");
//            return;
//        }
        try{
            logger.info("CONTROLLER:" + editLogContent4Begin(joinPoint));
        }catch(Throwable t){
            logger.error("Logging for service method error.", t);
        }
    }

    /*
    @Before(value = "com.test.aop.Pointcuts.controllerCall()")
    public void controllerCallBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数
        Enumeration<String> enu = request.getParameterNames();
        List<String> paramsName = new ArrayList<>();

        while(enu.hasMoreElements()) {
            paramsName.add(enu.nextElement());
        }
        if(paramsName != null) {
            logger.info("PARAMS : " + paramsName.toString());
        }
    }
    */

}
