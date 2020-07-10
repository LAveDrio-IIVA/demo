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
    @Test
    public void verifyToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0ZWM2NWNhNC0wZjVmLTRlOTktOTI5NS1mYWUyN2UwODIzYzQiLCJpYXQiOjE1NzY0OTI4NjYsImV4cCI6MTU3NjQ5NjQ2NiwiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lIjoi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.6Z18aIA6y52ntQkV3BwlYiVK3hL3R2WFujjTmuvimww";
        int result = JwtUtils.verifyToken(token);
        System.out.println(result);
    }

    /**
     * 解析token
     */
    @Test
    public void parseToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0ZWM2NWNhNC0wZjVmLTRlOTktOTI5NS1mYWUyN2UwODIzYzQiLCJpYXQiOjE1NzY0OTI4NjYsImV4cCI6MTU3NjQ5NjQ2NiwiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lIjoi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.6Z18aIA6y52ntQkV3BwlYiVK3hL3R2WFujjTmuvimww";

        Map<String, Object> map = JwtUtils.parseToken(token);
        System.out.println(map);
    }
}
