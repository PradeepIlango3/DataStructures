package com.ilango.pradeep.java;

public class Arrays {

    public static void main(String[] args) {

        // 1-D Array
        int[] a = new int[1];
        int[] b = {8, 9, 3, 2, 10};
        System.out.println(a.length);
        System.out.println(a[0]);
        a[0] = 1;
        System.out.println(a.length);
        System.out.println(a[0]);
        System.out.println(a.getClass());
        System.out.println(java.util.Arrays.binarySearch(b, 8));
        java.util.Arrays.sort(b);
        System.out.println(java.util.Arrays.binarySearch(b, 8));
        java.util.Arrays.fill(b, -5);
        int[] c = b.clone();


        // 2-D Array

        int[][] a2 = new int[5][2];
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                System.out.print(a2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(a2);
        System.out.println(a2[0]);
        System.out.println(a2[0][0]);

        int[][] b2 = new int[5][];

        for (int i = 0; i < b2.length; i++) {
            b2[i] = new int[i];
        }

        for (int i = 0; i < b2.length; i++) {
            for (int j = 0; j < b2[i].length; j++) {
                System.out.print(b2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
