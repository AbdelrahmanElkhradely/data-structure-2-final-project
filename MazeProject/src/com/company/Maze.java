package com.company;

import java.util.Scanner;

public class Maze {
    int N;
    int[][] mazeplan;
    int[][] key;

    // short answer if there is no exist
    boolean IfValidMaze(int[][] maze, int n) {
        if (maze[0][0] != 1 || maze[n - 1][n - 1] != 1) return true;
        else return false;
    }

    //show if this is a valid move
    boolean CanMove(int x, int y, int n, int[][] maze, int[][] sol) {
        // if (x, y outside maze) return false
        return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 0 && sol[x][y] == 0;
    }

    void SolveTheMaze(int[][] maze, int[][] sol, int n) {

        if (getsolution(0, 0, maze, sol, n) == false) {
            System.out.print("Solution doesn't exist");
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(sol[i][j] + " ");

            /*if(sol[i][j]==1) {
                System.out.print(" (" +i+","+j + "), ");
            }*/
                }
                System.out.println();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (sol[i][j] == 1)
                        System.out.print("(" + i + "," + j + ") -> ");

            /*if(sol[i][j]==1) {
                System.out.print(" (" +i+","+j + "), ");
            }*/
                }
            }
        }
    }

    boolean getsolution(int x, int y, int[][] maze, int[][] sol, int n) {
        if (x == N - 1 && y == N - 1 && mazeplan[x][y] == 0) {
            sol[x][y] = 1;
            return true;
        }
        if (CanMove(x, y, n, maze, sol)) {
            sol[x][y] = 1;
            if (getsolution(x + 1, y, maze, sol, n)) {

                return true;
            }

            if (getsolution(x, y + 1, maze, sol, n)) {
                return true;
            }

            if (getsolution(x - 1, y, maze, sol, n)) {
                return true;
            }

            if (getsolution(x, y - 1, maze, sol, n)) {
                return true;
            }
            sol[x][y] = 0;
            return false;

        }
        return false;
    }

    public static void main(String[] args) {
        int n;
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);
        System.out.println("entre the size of maze");
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

}
