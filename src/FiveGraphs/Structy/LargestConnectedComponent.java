package FiveGraphs.Structy;

import java.util.*;

public class LargestConnectedComponent {
    //give graph find largest component
    //Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph. The function should return the number of connected components within the graph.
    //has path
    /*
    connected_components_count({
  0: [8, 1, 5],
  1: [0],
  5: [0, 8],
  8: [0, 5],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2]
}) #
     */

    public static void main(String[] args) {
        //has path
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, List.of(8, 1, 5));
        graph.put(1, List.of(0));
        graph.put(5, List.of(0, 8));
        graph.put(8, List.of(0, 5));
        graph.put(2, List.of(3, 4));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3, 2));

        System.out.println(connectedComponent(graph));
    }

    public static int connectedComponent(HashMap<Integer, List<Integer>> graph){
        int  maxCount = 0;

        boolean[] visited = new boolean[10];
        //Iterate each node in graph
        for(Map.Entry<Integer,List<Integer>>  entry : graph.entrySet()){
            int current  = entry.getKey();
            int currentCount = exploreBFS(graph, current, visited);
            maxCount = Math.max(currentCount,maxCount);
        }

        return maxCount;
    }
    public static int exploreBFS(HashMap<Integer, List<Integer>> graph, Integer current, boolean[] visited) {
        if(visited[current]){
            return 0;
        }

        int count =1;
        Queue<Integer> q = new LinkedList<>();
        q.add(current);
        visited[current] = true;

        while(!q.isEmpty()){
            int poppedItem = q.remove();

            //add neighbor to quue if no visited
            for(int neighbor:graph.get(poppedItem)) {
                if(!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                    count++;
                }
            }
        }

        return count;

    }
    public static int explore(HashMap<Integer, List<Integer>> graph, Integer current, boolean[] visited){
        if (visited[current]){
            return 0;
        }

        visited[current] = true;

        int count = 1;
        for(int neighbor : graph.get(current)) {
            System.out.println("count: "+count + ", current:" + current + ", neighbor:" + neighbor);
            count += explore(graph, neighbor, visited);
        }

        return count;
    }
}