package com.iiva.demo.web.corenlp.service;

import com.iiva.demo.web.corenlp.support.CoreNlpSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@Service
public class CoreNlpSerivceImpl implements CoreNlpSerivce{

    @Override
    public List<String> tokenize(String text) {

        return coreNlpSupport.tokenize(text);
    }

    @Autowired
    private CoreNlpSupport coreNlpSupport;
}
