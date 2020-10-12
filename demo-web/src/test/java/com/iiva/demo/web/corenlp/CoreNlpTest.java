package com.iiva.demo.web.corenlp;

import com.iiva.demo.web.corenlp.support.CoreNlpSupport;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreNlpTest {

    @Test
    public void coreNlpSupportTest(){

        String text = "北京今天的天气很好。特朗普也确诊新冠了！";

        coreNlpSupport.demoForNlp(text);
    }

    @Autowired
    private CoreNlpSupport coreNlpSupport;
}
