package com.ilango.pradeep.java;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListJava {

    public static void main(String[] args) {

        //1-D Array
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        System.out.println("List: ");
        System.out.println(a);
        System.out.println(a.size());

        //2-D Array
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>();
        a2.add(new ArrayList<Integer>());
        a2.add(new ArrayList<Integer>());
        a2.add(new ArrayList<Integer>());

        for (int i = 0; i < a2.size(); i++) {
            System.out.println(a2.get(i).add(i + 1));
            System.out.println(a2.get(i).add(i + 2));
            System.out.println(a2.get(i).add(i + 3));
        }

        for (int i = 0; i < a2.size(); i++) {
            for (int j = 0; j < a2.get(i).size(); j++) {
                System.out.print(a2.get(i).get(j) + " ");
            }
            System.out.println();
        }

        Iterator iterator = a2.iterator();
        while (iterator.hasNext()) {
            List<Integer> list = (List<Integer>) iterator.next();
            Iterator iterator1 = list.iterator();
            while (iterator1.hasNext()) {
                System.out.print(iterator1.next() + " ");
            }
            System.out.println();
        }

        a2.forEach(num -> num.forEach(num2 -> System.out.println(num2)));
    }
}
