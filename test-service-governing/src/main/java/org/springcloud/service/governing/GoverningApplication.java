package org.springcloud.service.governing;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @Description:    spring boot 启动类
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:18
*/

@SpringBootApplication
@MapperScan("org.springcloud.service.governing.dao")
public class GoverningApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(GoverningApplication.class, args);
    }
}
