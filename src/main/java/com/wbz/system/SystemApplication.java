package com.wbz.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * 学生跟随系统
 */
@MapperScan({"com.wbz.system.mapper"})
@SpringBootApplication
@EnableAutoConfiguration( exclude = { SecurityAutoConfiguration.class } )
public class SystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  学生跟随系统启动成功  ");
    }
}
