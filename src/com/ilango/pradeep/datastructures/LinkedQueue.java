package com.ilango.pradeep.datastructures;

public class LinkedQueue<E> {

    Node<E> front, rear;

    public class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }

    public void enqueue(E data) {
        Node<E> node = new Node(data);
        if (rear == null) {
            this.front = this.rear = node;
        }
        rear.next = node;
        rear = node;
    }

    public E dequeue() {
        if (front == null) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        E data= front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return data;
    }

    public void print() {
        if (front == null) {
            System.out.println("Queue is Empty");
        }
        Node<E> node = front;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.print();
    }
}
