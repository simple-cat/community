package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)   //将运行的测试代码设置为以原来src中运行类为测试类
public class LoggerTests {
    //每一个类单独实例一个logger
    private static final Logger logger= LoggerFactory.getLogger(LoggerTests.class);   //logback自带的实例化工厂可以实例化Logger对象

    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");  //然后再配置文件里声明要启用什么级别的日志

        //注意，实际服务器访问时并不会安装IDEA，而是一个应用程序，那打印到控制台的日志就没有意义了（因为看不到了）
        //所以，还需要在配置文件里声明日志文件存放的位置，以便将日志文件保存下来
        //但实际开发中，还需要将日志文件分别保存在不同目录之下，且当文件大小超出限度，就分文件写，这样可以避免日志文件过大
        //所以，将配置文件中的声明注释了，导入一个logback相关的xml文件：
        // logback-spring.xml，放在resources目录下，Spring Boot可以自动启用该文件中的配置（注意文件名只能是logback-spring.xml才能自动发现）
    }
}
