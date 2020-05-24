package com.company;

import java.util.Scanner;

public class Main {
    static DijikstraClass dijikstraClass = new DijikstraClass();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter the number of the required problem or 4 to exit");
            int problem;
            problem = scanner.nextInt();
            if(problem == 1)
            {
                scanner = new Scanner(System.in);

                LinkedIn<Integer> graph = new LinkedIn<Integer>();

                int vertices;
                System.out.println("please enter number of vertices");
                vertices=scanner.nextInt();

                int edges;
                System.out.println("please enter number of edges");
                edges = scanner.nextInt();

                System.out.println("please enter edges in the form(u v)");
                while(edges > 0)
                {
                    int source;
                    int destination;
                    source = scanner.nextInt();
                    destination = scanner.nextInt();
                    graph.AddEdge(source,destination);
                    edges--;
                }

                System.out.println("please enter starting vertex");
                int source= scanner.nextInt();

                System.out.println("please enter value k");
                int key=scanner.nextInt();
                graph.GetKthRelation(source,key);

            }
            else if(problem == 2)
            {
                int n;
                Maze maze = new Maze();
                System.out.println("enter the size of maze");
                n = scanner.nextInt();

                int i;
                int j;
                int[][] mazeplan = new int[n][n];
                int[][] solution = new int[n][n];
                //scanning the maze
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        mazeplan[i][j] = scanner.nextInt();
                    }

                }
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        solution[i][j] = 0;
                    }

                }
                maze.mazeplan = mazeplan;
                maze.N = n;
                maze.key = solution;

                //printing the maze
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        System.out.print(maze.mazeplan[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("-----------------------------------------------------------------------");
                boolean flag = maze.IfValidMaze(maze.mazeplan, maze.N);
                if (flag) {
                    maze.SolveTheMaze(maze.mazeplan, maze.key, maze.N);
                } else {
                    System.out.println("you can't escape from the maze");

                }
            }
            else if(problem == 3)
            {

                int M;
                System.out.println("Please enter the amont M: ");
                M = scanner.nextInt();
                int Cities;
                System.out.println("Please enter the number of Cities: ");
                Cities = scanner.nextInt();
                int Routes;
                System.out.println("Please enter the number of Routes: ");
                Routes = scanner.nextInt();
                int source;
                int destination;
                int time;
                int cost;
                dijikstraClass.setNodes(Cities);
                while(Routes > 0)
                {
                    System.out.println("please enter source , destination, time and cost for each route: ");
                    source = scanner.nextInt();
                    destination = scanner.nextInt();
                    time = scanner.nextInt();
                    cost = scanner.nextInt();
                    dijikstraClass.addNode(source, destination, time, cost, M);
                    Routes--;
                }
                int srccity;
                System.out.println("Enter the source city");
                srccity = scanner.nextInt();
                int destcity;
                System.out.println("Enter the destination city");
                destcity = scanner.nextInt();
                dijikstraClass.Dijkstra(srccity,destcity, M);
            }
            else if(problem == 4)
            {
                return;
            }
            else
            {
                System.out.println("please enter a valid number :) ");
            }
        }

    }
}
