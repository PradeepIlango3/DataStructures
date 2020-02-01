package com.ilango.pradeep.datastructures;

import java.security.InvalidParameterException;

public class Stack<E> {
    Object[] data;
    int capacity;
    int size;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new InvalidParameterException("com.ilango.pradeep.datastructures.Stack size should be greater than zero.");
        }
        data = new Object[capacity];
        this.capacity = capacity;
    }

    public void push(E data) {
        if (size == capacity-1) {
            throw new IndexOutOfBoundsException("Index out of Bound");
        }
        this.data[size++]= data;
    }

    public E pop() {
        if (size == 0) {
            throw new InvalidParameterException("com.ilango.pradeep.datastructures.Stack size should be greater than zero.");
        }
        E data = (E) this.data[size-1];
        size--;
        return data;
    }

    public E peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("com.ilango.pradeep.datastructures.Stack size should be greater than zero.");
        }
        return (E) data[size-1];
    }

    public void print() {
        if (size == 0) {
            System.out.println("com.ilango.pradeep.datastructures.Stack is Empty");
        }
        System.out.println("com.ilango.pradeep.datastructures.Stack:");
        for (int i=(size-1); i>=0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public static void main(String [] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.peek());
        stack.print();
    }
}
