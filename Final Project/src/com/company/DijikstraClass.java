package com.company;

import javafx.util.Pair;

import java.util.HashMap;

public class DijikstraClass {
    HashMap<Pair<Integer, Integer>,Integer> h = new HashMap<>();
    HashMap<Pair<Integer, Integer>,Integer> t = new HashMap<>();
    int totaltime = 0;
    int nodes;
    public void setNodes(int nodes){
        this.nodes = nodes;
    }

    public void addNode(int source, int destination, int time, int cost, int M)
    {
        int totalcost = M*time+cost;
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(source, destination);
        t.put(new Pair<>(source,destination), time);
        h.put(p, totalcost);
    }
    void Dijkstra(int src, int dest, int m) {
        nodes++;
        int dist[] = new int[nodes];
        int times[] = new int[nodes];
        Boolean sptSet[] = new Boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            times[i] = 0;
        }

        dist[src] = 0;

        for (int count = 0; count < nodes - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < nodes; v++)
            {
                if (!sptSet[v] && h.containsKey(new Pair<>(u, v)) &&  h.get(new Pair<>(u, v)) != 0  &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + h.get(new Pair<>(u, v)) < dist[v])
                {
                    if(u != src && v != src)
                    {
                        dist[v] = dist[u] + h.get(new Pair<>(u, v)) + m;
                        times[v]=times[u]+t.get(new Pair<>(u, v)) + 1;
                    }
                    else
                    {
                        times[v]= times[u]+t.get(new Pair<>(u, v));
                        dist[v] = dist[u] + h.get(new Pair<>(u, v));
                    }
                }

            }
        }
        printSolution(dist, src, dest, times);
    }
    void printSolution(int dist[], int src, int dest, int times[])
    {
        System.out.println("Total cost " + dist[dest]);
        System.out.println("Total time " + times[dest] + " hours");
    }
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < nodes; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
}
