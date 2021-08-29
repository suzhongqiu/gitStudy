package com.home.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("provider.xml");
        cpx.start();
        System.in.read();
    }
}
