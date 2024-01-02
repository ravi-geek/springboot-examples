package com.ravi.string;

import java.sql.SQLOutput;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = new String("test");
        String s2 = "test";
        String s3 = "test";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s2));
        String s4 = new String("test");
        System.out.println(s1 == s4);
    }
}
