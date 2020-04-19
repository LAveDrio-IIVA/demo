package com.iiva.demo.web.main;

public class AssertMain {

    public static void main(String[] args) {

        int i = 1;

        i = 2;

        assert i == 2;

        System.out.println("success " + i);

        assert i == 3:"Assert Exception,program shut down";
    }
}
