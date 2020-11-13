package com.iiva.demo.web.corenlp.support;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.iiva.demo.web.corenlp.constant.CoreNlpConst.CORENLP_CHINESE_PROPERTIES;

@Component
public class CoreNlpDemoSupport {

    /**
     * standardDemoForNlp（标准的套路）
     * @param text
     */
    public void standardDemoForNlp(String text) {

        // 指定props文件
        String props="CoreNLP-chinese.properties";  // 文件放在了main/resources下
        // 创建管道
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // 创建Annotation（构造参数为注解目标文本）
        Annotation annotation = new Annotation(text);
        // 启动管道中配置的注解器（见配置文件）
        pipeline.annotate(annotation);
        // 输出结果
        this.printResult(annotation);
    }

    /**
     * quickDemo（快速的方式，未经过完备的测试）
     * @param text
     */
    public void quickDemoForNlp(String text) {

        Properties props = new Properties();
        // 指定注解器组
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        // 创建管道
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // 创建文档对象
        CoreDocument document = new CoreDocument(text);
        // 启动管道中配置的注解器（见配置文件）
        pipeline.annotate(document);

        // 运行开始
        System.out.println(" ");
        System.out.println("《- 运行开始 -》.................................");

        // 提取句子
        List<CoreSentence> sentences = document.sentences();
        List<String> sentenceList = new ArrayList<>();

        // 循环输出句子
        for (CoreSentence sentence : sentences) {

            sentenceList.add(sentence.toString());
        }

        // 输出句子
        System.out.println(" ");
        System.out.println("<- 句子 ->：");
        System.out.println(sentenceList);

        // 提取分词
        List<CoreLabel> tokens = document.tokens();
        List<String> wordList = new ArrayList<>();

        // 循环输出分词
        for (CoreLabel token : tokens) {

            wordList.add(token.toString());
        }
        // 输出分词
        System.out.println(" ");
        System.out.println("<- 分词 ->：");
        System.out.println(wordList);

        // 运行结束
        System.out.println(" ");
        System.out.println("《- 运行结束 -》.................................");
    }

    /**
     * quickDemo（官方文档中说明的“简单、快速的API”，但它比注释管道接口要笨拙得多，而且通常不鼓励使用。也有非确定性。）
     * @param text
     */
    public void simpleDemoForNlp(String text) {

        // Create a document. No computation is done yet.
        Document doc = new Document(text);
        for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences
            // We're only asking for words -- no need to load any models yet
            System.out.println("The second word of the sentence '" + sent + "' is " + sent.word(1));
            // When we ask for the lemma, it will load and run the part of speech tagger
            System.out.println("The third lemma of the sentence '" + sent + "' is " + sent.lemma(2));
            // When we ask for the parse, it will load and run the parser
            System.out.println("The parse of the sentence '" + sent + "' is " + sent.parse());
            // ...
        }

        // nerTags
        Sentence sent = new Sentence(text);
        List<String> nerTags = sent.nerTags();
        System.out.println(nerTags);
    }

    /**
     * Java client to the server（推荐理由：
     * The models are not re-loaded every time your program runs. This is useful when debugging a block of code which runs CoreNLP annotations, as the CoreNLP models often take on the order of minutes to load from disk.
     * The machine running the server has more compute and more memory than your local machine. Never again must Chrome and CoreNLP compete for the same memory.）
     * @param text
     */
    public void javaClientDemoForNlp(String text) {

        // creates a StanfordCoreNLP object with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
        StanfordCoreNLPClient pipeline = new StanfordCoreNLPClient(props, "http://192.168.100.5", 9000, 2);
        // create an empty Annotation just with the given text
        Annotation annotation = new Annotation(text);
        // run all Annotators on this text
        pipeline.annotate(annotation);
        // 输出结果
        this.printResult(annotation);
    }

    /**输出注解器处理结果
     *
     * @param annotation
     */
    private void printResult(Annotation annotation){

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
