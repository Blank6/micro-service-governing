package org.springcloud.eureka.server.aop;


import io.micrometer.core.instrument.util.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springcloud.eureka.server.Service.ValidService;
import org.springcloud.eureka.server.entity.response.RespEntity;
import org.springcloud.eureka.server.execption.ConstantResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


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

    @Autowired
    ValidService validService;

//    @Around(value = "org.springcloud.eureka.server.aop.Pointcuts.registerAspect()")
//    public Object resourcesCallAround(ProceedingJoinPoint point) throws Throwable {
//
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        logger.info("Aspect******** getParameter:" + request.getParameter("appID"));
//        BufferedReader br = null;
//        StringBuilder sb = new StringBuilder("");
//
//        /*
//         *  拦截注册请求，到治理中心进行验证
//        */
//        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        headers.setContentType(type);
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//        HttpEntity fromEntity = new HttpEntity(null, headers);
//        /**
//         * 验证
//         */
//        logger.info("Aspect*****************发送验证请求到治理中心*******************");
//       // RespEntity respEntity = validService.validClient("http://localhost:30000/validApplication", fromEntity);
//        try{
//            if (respEntity.getErrorCode() != 200) {
//                logger.info("验证未通过：" + respEntity.toString());
//                return new RespEntity(ConstantResultCode.VALID_ERROR, null);
//            }
//        } catch (Throwable throwable) {
//            logger.error("Validated error", throwable);
//        }
//        /**
//         * 通过验证，使用proceed()方法来执行目标方法
//         */
//        Object result = null;
//        try{
//            logger.info("验证结果：" + respEntity.toString());
//            result = point.proceed();
//        } catch (Throwable throwable) {
//            logger.error("validated proceed error", throwable);
//        }
//        return result;
//    }

    protected Map<String, String> initRequestParams(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<String, String>();
        if (request == null) {
            return paramMap;
        }
        Enumeration<?> paramNames = request.getParameterNames();
        /*
        Enumeration<?>代表可以传递任意类型，?是通配符即Object及其下的子类，也就是java的所有对象了。

        request.getParameterNames()方法是将发送请求页面中form表单里所有具有name属性的表单对象获取(包括button).返回一个Enumeration类型的枚举.

        通过Enumeration的hasMoreElements()方法遍历.再由nextElement()方法获得枚举的值.此时的值是form表单中所有控件的name属性的值.

        最后通过request.getParameter()方法获取表单控件的value值.
        */
        if (request != null && paramNames != null && paramNames.hasMoreElements()) {
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String[] paramValues = request.getParameterValues(paramName);
        /*
        先获得变量mane再获得其值，对于getParameterName（）其值是变量/对象的名称，getParameterValue（）获得的是变量/对象的值。
        request.getParameterValues("name")方法将获取所有form表单中name属性为"name"的值.该方法返回一个数组.遍历数组就可得到value值.
        */
                if (paramValues.length == 1) {
                    paramMap.put(paramName, paramValues[0]);
                } else {
                    paramMap.put(paramName, ArrayUtils.toString(paramValues));
                }
            }
        }
        return paramMap;
    }
    /*
    request.getParameterNames()的值是无序排列request.getParameterValues()是按照from表单的控件顺序排列.
    */

    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
