package com.example.interfacedemo;

public class Playground {
    public static void main(String[] args) {
        System.out.println((toDouble("3.5")==3.5));
        System.out.println(toDouble("7")==7);
        System.out.println(toDouble("13.1")==13.1);
        System.out.println(toDouble("A"));
        System.out.println(toDouble("a"));
        System.out.println(toDouble("13,1"));
        System.out.println(toDouble("a.5"));
        System.out.println(toDouble("A,h"));

    }

    private static double toDouble(String s) {
        s=s.replace(',','.');
        s=s.replaceAll("[\\p{L}]", "0");
        return Double.parseDouble(s);
    }



}
