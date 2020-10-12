package com.iiva.demo.web.corenlp.support;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoreNlpSupport {

    // 初次Demo
    public void demoForNlp(String text) {

        // 指定props文件
        String props="CoreNLP-chinese.properties";  // 文件放在了main/resources下
        // 创建管道
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // 创建Annotation（构造参数为注解目标文本）
        Annotation annotation = new Annotation(text);
        // 启动管道中配置的注解器（见配置文件）
        pipeline.annotate(annotation);

        // 运行开始
        System.out.println(" ");
        System.out.println("《- 运行开始 -》.................................");


        // 提取句子
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

        // 循环处理句子
        for (CoreMap sentence : sentences) {

            // 输出当前句子
            System.out.println(" ");
            System.out.println("<- 句子 ->：");
            System.out.println(sentence.toString());

            // - 分词、词性、实体识别
            List<String> words = new ArrayList<>();

            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)){
                // 分词
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // 词性
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // 实体识别
                String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                words.add(word + ":" + pos + ":" + ner);
            }
            System.out.println("- 分词、词性、实体识别 -：");
            System.out.println(words.toString());

            // - 语法树（依赖annotators：tokenize, ssplit, pos, parse）
            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            System.out.println("- 语法树 -：");
            System.out.println(tree.toString());

            // - 依存分析
            SemanticGraph graph = sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
            System.out.println("- 依存分析 -：");
            System.out.println(graph.toString());

        }

        // 运行结束
        System.out.println(" ");
        System.out.println("《- 运行结束 -》.................................");
    }




}
