package com.ilango.pradeep.datastructures;


public class Queue<E> {

    Object[] data;
    int rear;
    int front;
    int capacity;
    int size;

    Queue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        rear = -1;
        front = -1;
    }

    public void enqueue(E data) {
        if (size == capacity) {
            throw new IndexOutOfBoundsException("Queue is Full");
        }
        rear = (rear + 1)%capacity;
        this.data[rear] = data;
        if (front == -1) {
            front = rear;
        }
        size++;
    }

    public E dequeue() {
        if (front == -1) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        E data;
        data = (E) this.data[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = ((front + 1)) % capacity;
        }
        size--;
        return data;
    }

    public void print() {
        if ( front == -1) {
            System.out.println("Queue is Empty");
        }
        if (front <= rear) {
            for (int i =front; i<=rear; i++) {
                System.out.println(data[i]);
            }
        } else {
            for (int i =front; i<capacity; i++) {
                System.out.println(data[i]);
            }
            for (int i =0; i<=rear; i++) {
                System.out.println(data[i]);
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.enqueue(10);
        queue.enqueue(10);
        queue.print();
    }
}
