package FiveGraphs;

import java.util.*;

public class AdjacencyListGraph {

    public static void  main(String[] args) {
        //Given dges list

        // Construct adjacent list
        HashMap<String, ArrayList<String>> graph  = new HashMap<>();

        String[][] edges = {{"A", "B"}, {"B", "C"},{"A", "D"},{"C", "E"}, {"E", "D"}};

        graph = buildAdjList(edges);

        int count =  pathCountDFS(graph, "A", "E", new HashSet<>());
        System.out.println("Count to path A to E using DFS: " + count) ;

        printGraph(graph);
        int shortestCount = shortedPathBFS(graph, "A", "E");
        System.out.println("shortest Count from path A to E: " + shortestCount) ;

    }

    public static int shortedPathBFS(HashMap<String, ArrayList<String>> graph ,String src, String dst ){
        //Initialize variables, Datastructures, count
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        // Add src to queue, mark item visited
        q.add(src);
        visited.add(src);

        // Iterate until queue is empty
        while (! q.isEmpty()) {
            // Check for each level or until all queue is explored and count at each level
            for(int size = q.size() ;size > 0; size--) {

                String current = q.poll();

                // check if current node reaches destination
                if(current.equals(dst)){
                    return level;
                }
                // Check neighbors f not visited, add to queue and mark visited
                for(String neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level ++;
        }

        return level;
    }

    public static int pathCountDFS(HashMap<String, ArrayList<String>> graph, String src, String dst, HashSet<String> visited){
        // if already visited return 0
        if( visited.contains(src)){
            return 0;
        }
        if( src.equals(dst)){
            return 1;
        }

        // Variable initialization
        int count = 0; //why 0 current node is 0

        // add current node to visited set
       // visited = new HashSet<String>();
        visited.add(src);

        //Iterate neighbors
        for(String neighbor : graph.get(src)){
            System.out.println("SRC:" + src);
            System.out.println("Neighbor:" + neighbor);
            count += pathCountDFS(graph, neighbor, dst, visited);
        }

        visited.remove(src);
        return count;
    }

    public static void printGraph(HashMap<String, ArrayList<String>> graph){
        StringBuilder sb = new StringBuilder();

        for(String vertex: graph.keySet()){
            System.out.println("Vertex V:" + vertex );
            // Each node has a list of neighbors
            sb.append(vertex + ": ");
            for(String neighbor : graph.get(vertex)){
                sb.append( neighbor + " ");
            }
            sb.append(" \n");
        }

        System.out.println(sb.toString());
    }

    public static HashMap<String, ArrayList<String>> buildAdjList(String[][] edges){
        HashMap<String, ArrayList<String>> adj = new HashMap<>();

        //build vertices with empty is vertex not present
        String src, dst;
        for(String[] edge: edges){
            src = edge[0]; dst = edge[1];

            if(!adj.containsKey(src)){
                adj.put(src, new ArrayList<>());
            }
            if(!adj.containsKey(dst)){
                adj.put(dst, new ArrayList<>());
            }

            // Add at src , append dst
            adj.get(src).add(dst);
            adj.get(dst).add(src); //for bi direction
        }
        // append tree if vertex already present

        return adj;

    }
}
