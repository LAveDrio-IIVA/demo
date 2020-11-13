package com.iiva.demo.web.corenlp.controller;

import com.iiva.demo.web.corenlp.service.CoreNlpSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "CoreNlp",tags = {"CoreNlp接口"})
@RequestMapping("/coreNLP")
public class CoreNlpController {

    // Swagger Documnet Url : http://localhost:8080/demo/swagger-ui.html

    @ApiOperation(value = "提取文本词汇",notes = "提取一段文本里的词汇")
    @ApiImplicitParams({
            @ApiImplicitParam(name="text", value="待分析文本",paramType = "query", required=true, dataType = "string",example = "今天天气很好。骑上我心爱的小摩托，它永远不会堵车。"),
    })
    @GetMapping("/tokenize")
    public List<String> tokenize(@RequestParam String text) {

        return coreNlpSerivce.tokenize(text);
    }

    @Autowired
    private CoreNlpSerivce coreNlpSerivce;

}
