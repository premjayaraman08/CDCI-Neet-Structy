package FiveGraphs.Structy;
//given edges check path edges = [[0,1],[0,2],[3,5],[5,4],[4,3]],

import java.util.*;

public class hasPathUndirected {

    public static void main(String[] args){
        //edges
        int[][]edges = {{0,1}, {0,2},{3,5}, {5,4},{4,3},{1,3} };

        int number = 6;


        // HashMap<Integer, List<Integer>> graph = new HashMap<>();
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

         for(int i=0; i< number; i++){
             graph.add(new ArrayList<>());
         }

        //build graph from static number
        for(int[] edge: edges){
            Integer src = edge[0]; Integer dst =  edge[1];

            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }

        System.out.println("Has path DFS" +     hasPathDFS(graph, 0, 5, new boolean[number]));
      //  System.out.println("Has path BFS" + hasPathBFS(graph, 0, 5, new HashSet<>()));
    }
    public static boolean hasPathBFS(HashMap<Integer, List<Integer>> graph , int src, int dst, boolean[] visited){


        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        //Iterate until q is empty
        while(!q.isEmpty()) {
            int current = q.remove();

            //check if src, dst are equal
            if (current == dst){
                return true;
            }

            // Loop over all items in Q
//            for(int size= q.size(); size > 0; size--) {
                for(int neighbor : graph.get(current)) {
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        q.add(neighbor);
                    }
                    // check neighbors from a node
                    // if target node found add neighor to q and mark visited
               // }
            }
        }

        return false;
    }
    public static boolean hasPathDFS(ArrayList<ArrayList<Integer>> graph , int src, int dst, boolean[] visited){

        //check if src, dst are equal
        if (src == dst){
            return true;
        }
        // src has already been visited
        if(!visited[src]){
            return false;
        }
        visited[src] =true;

        // iterate neighbor from current node recursively
        for( int neighbor : graph.get(src)){
            if(hasPathDFS(graph, neighbor, dst, visited )){
                return true;
            }
        }

        return false;
    }
}
