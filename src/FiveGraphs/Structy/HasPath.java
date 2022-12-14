package FiveGraphs.Structy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* graph = {
  'f': ['g', 'i'],
  'g': ['h'],
  'h': [],
  'i': ['g', 'k'],
  'j': ['i'],
  'k': []
}
*          h
*     f -> g
           i -> g
           |
           k

           j -> i
has_path(graph, 'f', 'k') # True
* * */
public class HasPath {

    public static void main(String[] args){
        //has path
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("f", List.of("g", "i"));
        graph.put("g", List.of("h"));
        graph.put("h", List.of());
        graph.put("i", List.of("g","k"));
        graph.put("j", List.of("i"));
        graph.put("k", List.of());

        System.out.println(graph);
        System.out.println("HAS PATH BFS: ?" + hasPathBFS(graph,"f","k"));

    }

    public static boolean hasPathBFS(HashMap<String, List<String>> grid, String src, String dst){
        //check if src, dst are same if not
        if(src.equals(dst)){
            return true;
        }

        // add current element to Q
        Queue<String> q = new LinkedList<>();
        q.add(src);

        // Iterate until q is empty, add neighbors to q
        while(!q.isEmpty()) {
            for(int size= q.size(); size > 0; size --) {
                String current = q.remove();

                //check neighbors
                for(String neighbor : grid.get(current)) {
                    System.out.println("src:" + src+ ", neighbor:"+neighbor+ ", dst:" + dst);

                    if (neighbor.equals(dst)) {
                        return true;
                    }
                    q.add(neighbor);
                }

                // if src is dst return has path
                // end of q no path
            }
        }
        return false;
    }

    public static boolean hasPathDFS(HashMap<String, List<String>> grid, String src, String dst){
        // explore DFS
        // if src and dst are same return true
        if (src.equals(dst)){
            return true;
        }

        // check neighbors from current src node by recursive fn call
        for( String neighbor : grid.get(src)){
            System.out.println("src:" + src+ ", neighbor:"+neighbor+ ", dst:" + dst);
             if(hasPathDFS(grid, neighbor, dst)){
                 return true;
             }
        }

        return false;

    }

}
