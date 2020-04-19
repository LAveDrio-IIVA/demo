package com.iiva.demo.web.main;

import java.util.regex.Pattern;

public class RegularExpressionMain {

    public static void main(String[] args) {

        // \
        System.out.println(Pattern.matches("a","a"));

        // ^
        System.out.println(Pattern.matches("^a","a"));

        // $
        System.out.println(Pattern.matches("^a","a"));

        // *
        System.out.println(Pattern.matches("ab*","abb"));
        System.out.println(Pattern.matches("ab*","a"));

        // +
        System.out.println(Pattern.matches("ab+","ab"));
        System.out.println(Pattern.matches("ab+","abb"));

        // ?
        System.out.println(Pattern.matches("ab?","a"));
        System.out.println(Pattern.matches("ab?","ab"));

        // {n}
        System.out.println(Pattern.matches("ab{2}","abb"));

        // {n}
        System.out.println(Pattern.matches("ab{2}","abb"));

        // {n,m}
        System.out.println(Pattern.matches("ab{2,3}","abb"));
        System.out.println(Pattern.matches("ab{2,4}","abbbb"));

        // x|y
        System.out.println(Pattern.matches("a|b","a"));
        System.out.println(Pattern.matches("a|b","b"));

        // [abc]
        System.out.println(Pattern.matches("[abc]","a"));
        System.out.println(Pattern.matches("[abc]","b"));

        // [^abc]
        System.out.println(!Pattern.matches("[^abc]","a"));
        System.out.println(Pattern.matches("[^abc]","f"));

        // [a-c]
        System.out.println(Pattern.matches("[a-c]","a"));
        System.out.println(!Pattern.matches("[a-c]","f"));

        // [^a-c]
        System.out.println(!Pattern.matches("[^a-c]","a"));
        System.out.println(Pattern.matches("[^a-c]","f"));

        // \b
        System.out.println(Pattern.matches("a\\b","a"));

        // \B
        System.out.println(!Pattern.matches("a\\B","a"));

        // \d
        System.out.println(Pattern.matches("a\\d","a3"));

        // \D
        System.out.println(Pattern.matches("a\\D","ab"));

        // (ab)|(cd) 不同于 a(b|c)d
        System.out.println(Pattern.matches("(ab)|(cd)","cd"));
        System.out.println(Pattern.matches("a(b|c)d","abd"));

        // \s
        System.out.println(Pattern.matches("\\s"," "));


    }
}
