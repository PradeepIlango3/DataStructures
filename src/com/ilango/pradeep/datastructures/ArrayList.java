package com.ilango.pradeep.datastructures;

import java.security.InvalidParameterException;

public class ArrayList<E> {

    Object[] data;
    int size;
    int length;

    ArrayList(int size) {
        if (size <= 0) {
            throw new InvalidParameterException("Array size should be greater than zero.");
        }
        data = new Object[size];
        this.size = size;
    }

    public void add(E e) {
        if (size == length) {
            throw new ArrayIndexOutOfBoundsException("Array size is less. You cannot insert beyond.");
        }
        data[length] = e;
        length++;
    }

    public E get(int index) {
        if (index >= size) {
            throw new InvalidParameterException("Array index is greater than the size.");
        }
        if (index < 0) {
            throw new InvalidParameterException("Invalid Index.");
        }
        return (E)data[index];
    }

    public E remove(int index) {
        validateIndex(index);
        Object item = data[index];
        for (int i=index; i<length-1; i++) {
            data[i] = data[i+1];
        }
        length--;
        return (E)item;
    }

    private void validateIndex(int index) {
        if (index >= size) {
            throw new InvalidParameterException("Array index is greater than the size.");
        }
        if (index < 0) {
            throw new InvalidParameterException("Invalid Index.");
        }
    }

    public static void main(String [] args) {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        for (int i=0; i< list.length; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        list.remove(0);
        for (int i=0; i< list.length; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        list.remove(4);
        for (int i=0; i< list.length; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
