package com.ilango.pradeep.datastructures;

public class LinkedStack<E> {
    Node<E> top;

    class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public void push(E data) {
        Node<E> node = new Node(data);
        node.next = top;
        top = node;
    }

    public E pop() {
        if (top == null) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    public E peek() {
        if (top == null) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return top.data;
    }

    public void print() {
        if (top == null) {
            System.out.println("com.ilango.pradeep.datastructures.Stack is Empty");
        }
        System.out.println("com.ilango.pradeep.datastructures.Stack: ");
        Node<E> node = top;
        while (node!= null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.print();
    }
}
