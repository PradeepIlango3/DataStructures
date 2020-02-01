package com.ilango.pradeep.datastructures;

public class LinkedList<E> {
    Node<E> head;
    int size;

    class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public void add(E data) {
        Node<E> newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<E> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    public void add(int pos, E data) {
        rangeCheck(pos);
        if (pos == 0) {
            linkFirst(data);
        } else {
            linkBefore(data, pos);
        }
        size++;
    }

    private void linkFirst(E data) {
        Node<E> node = new Node<>(data);
        node.next =  head;
        head = node;
    }

    private void linkBefore(E data, int pos) {
        Node<E> prev = head;
        for (int i=0; i<pos-1; i++) {
            prev = prev.next;
        }
        Node<E> node = new Node<>(data);
        node.next = prev.next;
        prev.next = node;
     }

    private void rangeCheck(int pos) {
        if (pos<0 || pos>size) {
            throw new IndexOutOfBoundsException(outOfBoundsMessage(pos));
        }
    }

    private String outOfBoundsMessage(int pos) {
        return "Index: " + pos + ", Size: " + size;
    }

    public int size() {
        return size;
    }

    public void delete(int pos) {
        rangeCheckForDelete(pos);
        if (pos == 0) {
            head = head.next;
        } else {
            Node<E> prev = head;
            for(int i=0; i<pos-1; i++) {
                prev = prev.next;
            }
            Node<E> node = prev.next;
            prev.next = node.next;
            node.next = null;
        }
        size--;
    }

    private void rangeCheckForDelete(int pos) {
       if ((pos < 0) || (pos >= size))  {
           throw new IndexOutOfBoundsException(outOfBoundsMessage(pos));
       }
    }

    public void printList() {
        Node<E> head = this.head;
        System.out.println("Linked List: ");
        while (head!=null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> next = null;
        Node<E> current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printReverse(Node<E> head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    public void rReverse(Node<E> head) {
        if (head.next == null) {
            this.head = head;
            return;
        }
        rReverse(head.next);
        head.next.next = head;
        head.next = null;
    }

    public static void main(String [] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("com.ilango.pradeep.datastructures.LinkedList Addition");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1,5);
        list.add(0, 10);
        list.add(5, 100);
        // list.add(9, 1000); exception testing
        list.printList();
        System.out.println("com.ilango.pradeep.datastructures.LinkedList Deletion");
        list.delete(0);
        list.delete(5);
        list.delete(5);
        list.printList();
        System.out.println("com.ilango.pradeep.datastructures.LinkedList Reverse");
        list.reverse();
        list.printList();
        System.out.println("com.ilango.pradeep.datastructures.LinkedList Reverse Print");
        list.printReverse(list.head);
        System.out.println();
        list.printList();
        list.rReverse(list.head);
        list.printList();
    }
}
