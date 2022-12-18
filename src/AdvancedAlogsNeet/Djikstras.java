package AdvancedAlogsNeet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 Given weighted graphs and starting node, find the shortest path and distance to all other nodes
Idea : Eliminate longer path on each iteration,
 Use priority keep to get shortest path
Trick : Remove ( R ) M* ( Mark), W ( Work), A ( Add )\


Method 1:
- add starting node with weight to priority queue PQ
- Until priority queue is empty
-   remove current element from PQ
-   get node and its weight
-   if node is already in shortest map skip since smallest would have been already based on min PQ
-   if not added already, mark by adding current node to Distance map
-   Start the work by checking neighbors of current node
-    For each neighbor add nodes to pq with weight if not added


Method 2:
Initialize node to +infinity
- Covert 2d-edge with right to adjacency list
- Initialize Short HashMap distance, priority q with comparator fn n1,n2
Evaluation
- Add to nodes to pq set with distance,
- Evaluate and add shortest nodes  ( use priority q)



 */
public class Djikstras {

    public static void main(String[] args) {
        //Given edge find getShortestDistance
        // 2-d array with each array having source, dst, weight

        //Build a graph of characters with adjacency list
        // buildGraph
        HashMap<Character, ArrayList<Edge>> graph = new HashMap<>();

        graph.put('a', new ArrayList<Edge>());
        graph.get('a').add(new Edge('a','b', 10));
        graph.get('a').add(new Edge('a','c', 15));
        graph.put('b', new ArrayList<Edge>());
        graph.get('b').add(new Edge('b','f', 15));
        graph.get('b').add(new Edge('b','d', 12));

        graph.put('c', new ArrayList<Edge>());
        graph.put('d', new ArrayList<Edge>());
        graph.put('f', new ArrayList<Edge>());
        graph.put('e', new ArrayList<Edge>());
        graph.get('c').add(new Edge('c','e', 10));
        graph.get('d').add(new Edge('d','f', 1));
        graph.get('d').add(new Edge('d','f', 2));
        graph.get('d').add(new Edge('d','e', 2));
        graph.get('f').add(new Edge('f','e', 5));

        System.out.println(graph);

        // DS : Shortest Distance is going to be
        HashMap<Character, Integer> shortestDistance = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->(p1.wsf - p2.wsf)); // Comparator

        char src = 'a';
        //Add starting path

        pq.add(new Pair(src, src + "" , 0 ));

        //Iterate until PQ is empty
        while(!pq.isEmpty()){
            // Remove min element from priority Q
            Pair current = pq.remove();

            //get removed character and weight
            char currChar = current.ch;
            int currWeight = current.wsf;

            //Check if element exists in distance map, if exists skip else proceed to work
            if(shortestDistance.containsKey(currChar)){
                continue;
            }

            // Mark visited
            shortestDistance.put(currChar, currWeight);

            System.out.println(current.ch + " via "+  current.psf +  "@" + current.wsf  );
            // Iterate each neighbor for current node
            for( Edge edge: graph.get(currChar)) {
                // Check if neighbor node is not in shortestDistance
                if(shortestDistance.containsKey(edge.nbr )){
                    continue;
                }

                // Add neighbor to PQ
                pq.add(new Pair(edge.nbr,  currChar + " " + edge.nbr, currWeight + edge.weight ));
            }
        }

        System.out.println(shortestDistance);
        System.out.println();
    }

    static class Pair{
        char ch;
        String psf ;
        int wsf ;

        Pair(char ch, String psf, int wsf){
            this.ch =  ch;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    static class Edge{
        char src;
        char nbr;
        int weight;

        Edge(char src, char nbr, int weight){
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }

    }
}
