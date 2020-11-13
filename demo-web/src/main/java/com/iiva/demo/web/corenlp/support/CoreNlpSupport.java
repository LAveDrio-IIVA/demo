package com.iiva.demo.web.corenlp.support;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.iiva.demo.web.corenlp.constant.CoreNlpConst.CORENLP_CHINESE_PROPERTIES;

@Component
public class CoreNlpSupport {

    /**
     * 分词
     * @param text
     * @return
     */
    public List<String> tokenize(String text) {

        String props = CORENLP_CHINESE_PROPERTIES;
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);

        List<String> words = new ArrayList<>();
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)){

                String word = token.get(CoreAnnotations.TextAnnotation.class);
                words.add(word);
            }
        }

        return words;
    }
}
