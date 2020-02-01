package com.ilango.pradeep.datastructures;

import sun.plugin.javascript.navig.Link;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class HelloWorld {
    public static void main(String [] args) {
        System.out.println("Hello World");

        List<Integer> list = new ArrayList<>(50);
        list.add(1);
        list.add(2);
        list.get(0);
        list.remove(0);
        list.remove(new Integer(2));
        list.add(0, 2);
        list.add(50);
        System.out.println(list.size());

        System.out.println("ArrayList:");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        int[] i = new int[5];
        i[0] = 1;
        System.out.println("Array Length :" + i.length);
        int[] j = {1,2,3,4,5,6};
        System.out.println(j.length);
        char[] c = {'a','b','{'};
        System.out.println(c.length);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(1,4);
        Iterator it1 = linkedList.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println(linkedList.size());
        Object a = new Object();
        a = test(a);
        System.out.println(a);

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(5);
        queue.add(7);
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        queue.remove();
        iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static Object test(Object a) {
        a = null;
        return a;
    }
}