package com.iiva.demo.web.corenlp;

import com.iiva.demo.web.corenlp.support.CoreNlpDemoSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreNlpTest {

    @Test
    public void coreNlpSupportTest(){

        Date startTime = new Date();
        String text = "今天天气很好！骑上我心爱的小摩托，他永远不会堵车！不知道解析的速度和句子的长度有没有关系。温馨提示：为确保您的交易安全注册需要验证您的身份信息。中国公民必须使用身份证，并使用证件上的中文姓名，勿使用拼音。非中国公民请使用护照及护照上的相关信息。";
//          coreNlpDemoSupport.standardDemoForNlp(text);
//        coreNlpDemoSupport.quickDemoForNlp(text);
//        coreNlpDemoSupport.simpleDemoForNlp("add your text here! It can contain multiple sentences.");
        coreNlpDemoSupport.javaClientDemoForNlp(text);

        Date endTime = new Date();
        long costTime = endTime.getTime() - startTime.getTime();

        System.out.println("----接口耗时：" + costTime + "ms\r\n");
    }



    @Autowired
    private CoreNlpDemoSupport coreNlpDemoSupport;
}
