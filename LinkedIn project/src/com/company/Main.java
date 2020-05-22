package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Graph<Integer> graph = new Graph<Integer>();
        /*
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        graph.AddEdge(1, 7);
        graph.AddEdge(2, 4);
        graph.AddEdge(4, 7);
        graph.AddEdge(7, 8);
        graph.AddEdge(3, 4);
        graph.AddEdge(7, 6);
        graph.AddEdge(5, 6);
        graph.AddEdge(9, 7);
    */
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter number of vertices:");
        int vertices= scanner.nextInt();
        System.out.println("please enter number of edges:");
        int edges= scanner.nextInt();
        int v1,v2;
        System.out.println("please enter edges in the form (u v):");
        for (int i = 0; i <edges ; i++) {
             v1=scanner.nextInt();
             v2 = scanner.nextInt();
            graph.AddEdge(v1,v2);
        }
        System.out.println("please enter starting vertex:");
        int source= scanner.nextInt();
        System.out.println("please enter value k :");
        int key=scanner.nextInt();

        graph.GetKthRelation(source,key);




    }
}
