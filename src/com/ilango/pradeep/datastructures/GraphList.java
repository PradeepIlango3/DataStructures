package com.ilango.pradeep.datastructures;
import java.util.LinkedList;

public class GraphList {

    int V;
    LinkedList<Integer> list[];

    GraphList(int v) {
        this.V = v;
        this.list = new LinkedList[v];

        for (int i=0; i < v; i++) {
            this.list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        this.list[src].add(dest);
        this.list[dest].add(src);
    }

    public void print() {
        System.out.println("Graph: ");
        for (int i =0; i < V; i++) {
            System.out.println("Adjacency List of vertex : " + i);
            System.out.println("head");
            for(Integer j : list[i]) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(15);
        graph.addEdge(1, 10);
        graph.addEdge(1, 12);
        graph.addEdge(1, 13);
        graph.addEdge(12, 13);
        graph.print();
    }

}
