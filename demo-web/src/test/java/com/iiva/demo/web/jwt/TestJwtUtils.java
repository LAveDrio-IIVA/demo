package com.iiva.demo.web.jwt;

import com.iiva.demo.web.jwt.util.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJwtUtils {

    /**
     * 创建token
     */
    @Test
    public void createToken(){

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1002);
        map.put("userName", "张晓明");
        map.put("age", 12);
        map.put("address", "山东省青岛市李沧区");
        String token = JwtUtils.createToken(map);
        System.out.println(token);
    }

    /**
     * 验证token
     */
    public void verifyToken() {

    }

    /**
     * 解析token
     */
    public void parseToken() {

    }
}
