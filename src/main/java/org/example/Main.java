package org.example;


import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
//        try {
//            System.setErr(new PrintStream(new FileOutputStream("lib/errorAddDialect.txt", false), true));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
    }
}