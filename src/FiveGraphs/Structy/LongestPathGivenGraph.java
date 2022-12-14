package FiveGraphs.Structy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestPathGivenGraph {

    //i/p graph adjlist o/p  : longest path
    /*
    graph = {
        'a': ['c', 'b'],
        'b': ['c'],
        'c': []
    }

    graph = {
  'a': ['b'],
  'b': ['c'],
  'c': [],
  'e': ['f'],
  'f': ['g'],
  'g': ['h'],
  'h': []
}

graph = {
  'a': ['c', 'b'],
  'b': ['c'],
  'c': [],
  'q': ['r'],
  'r': ['s', 'u', 't'],
  's': ['t'],
  't': ['u'],
  'u': []
}

    longest_path(graph) # -> 2
    longest_path(graph) # -> 3
    */
    public static void main(String[] args) {
        //has path
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> distance = new HashMap<>();

        graph.put('a', List.of('c','b'));
        graph.put('b', List.of('c'));
        graph.put('c', List.of());
        graph.put('q', List.of('r'));
        graph.put('r', List.of('s','u', 't'));
        graph.put('s', List.of('t'));
        graph.put('t', List.of('u'));
        graph.put('u', List.of());

        //Iterate each node in graph, initialize distance as 0 for each node
        for(Character node: graph.keySet()){
            distance.put(node, 0);
        }
        for(Character node: graph.keySet()){
            longestPath(graph, distance, node, new HashSet<Character>());

        }

        System.out.println(distance);
        System.out.println("Max distance is:" + Collections.max(distance.values()));
    }

    public static void longestPath(HashMap<Character, List<Character>> graph, HashMap<Character, Integer> distanceMap ,
                                  Character current, HashSet<Character> visited){
       if(visited.contains(current)){
           return;
       }

       int longest = 0;
       for(Character neighbor : graph.get(current)){
           //mark visited
           int newDistance = distanceMap.get(current) +1;
           System.out.println("current:"+ current + ", neighbor:"+ neighbor + "distanaMAps:" + newDistance);
           distanceMap.put(neighbor, distanceMap.get(current) +1);
           visited.add(neighbor);
           longestPath(graph, distanceMap, neighbor, visited);
       }
    }

    // identify terminal nodes

}
