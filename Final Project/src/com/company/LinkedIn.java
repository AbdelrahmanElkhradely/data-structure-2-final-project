package com.company;

import java.util.*;

public class LinkedIn<I extends Number> {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    ArrayList vertex= new ArrayList();
    static int edgenumber = 0, edgecount = 0;
    int size;

    public void AddVertex(int source)
    {
        graph.put(source, new LinkedList<Integer>());
    }

    public void AddEdge(int source, int destination)
    {

        if (!graph.containsKey(source))
            AddVertex(source);

        if (!graph.containsKey(destination))
            AddVertex(destination);

        graph.get(source).add(destination);
        graph.get(destination).add(source);
        if(!vertex.contains(source)){
            vertex.add(source);
        }
        if(!vertex.contains(destination)){
            vertex.add(destination);
        }

    }

    public void GetKthRelation(int source, int key)
    {
        int counter=0;
        int rel;
        size=graph.keySet().size();

        for (int i = 0; i <vertex.size(); i++) {
            rel=shortestpath(source,(int)vertex.get(i));
            if (rel==key)
                counter++;
        }
        System.out.println("there are "+counter+" people with "+ key+" connections away starting from "+ source);
    }

    public void getshortestpath(boolean[] visited, int src, int des)
    {

        visited[src] = true;

        if (src == des)
        {
            if (edgenumber > edgecount)
                edgenumber = edgecount;
        }

        else
        {
            for (int i : graph.get(src))
            {
                int v = i;
                if (!visited[v])
                {
                    edgecount++;
                    getshortestpath(visited, v, des);
                }
            }
        }

        // Decrement the count of number of edges
        // and mark current vertex as unvisited
        visited[src] = false;
        edgecount--;
    }

    public int shortestpath(int source, int dest)
    {

        boolean[] visited = new boolean[size+1];
        Arrays.fill(visited, false);
        edgenumber = Integer.MAX_VALUE;
        edgecount = 0;

        if(graph.containsKey(source) && graph.containsKey(dest)) {
            getshortestpath(visited, source, dest);
        }
        else {
            edgenumber=0;
        }
        // Print the minimum number of edges
        return edgenumber;
    }

}