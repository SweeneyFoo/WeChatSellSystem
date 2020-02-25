package com.wechatsell.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private  final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void Test1(){
        String name = "imooc";
        String password = "123456";
        log.debug("debug......");//log报错的话需要添加lombok插件并重启idea
        log.info("info....");
        log.info("name: {},password: {}",name,password);
        log.error("error.......");


    }
}
