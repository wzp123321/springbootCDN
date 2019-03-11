package com.springboot.demo;

import com.springboot.demo.entity.User;
import com.springboot.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() {
        System.out.println(dataSource);
        String pwd = userMapper.findPwdByUserId(3);
        System.out.println(pwd);
    }

}

