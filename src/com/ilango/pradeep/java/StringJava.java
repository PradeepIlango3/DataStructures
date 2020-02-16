package com.ilango.pradeep.java;

public class StringJava {
    public static void main(String[] args) {
        String a = new String("Pradeep");
        System.out.println(a.length());
        System.out.println(a.indexOf('e'));
        System.out.println(a.indexOf("de"));
        System.out.println(a.lastIndexOf("e"));
        System.out.println(a.substring(1,6));
    }
}
