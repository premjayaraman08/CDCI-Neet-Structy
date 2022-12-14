## Graph notes
- Have Vertices ( Nodes) and Edges connecting each other
- Connection between nodes could be uni-direction or bi-direction with weighted connections

### Code
``` java 
class GraphNode{
    int val;
    List<GraphNode> neighbors;
    
    GraphNode( int item) {
        this.val = item;
        this.neighbors = new ArrayList<GraphNode>()
    } 
}  
```

## Representation

1. Grid Matrix as rows and columns
2. Adjacency Matrix
   - Each vertex is given an array index
   - If 2 vertex is connected mark rows and columns in grid true
   - Aij = Aji 
   - too much space  
3. Adjacency List ( common )
   - Each vertex has a list of connected vertex stored as linked list
4. Edge List weighted representation

## Common operations
- has path between 2 vertex
- Shortest path between 2 points Matrix BFS

## Good resources
- Grid graph traversal Bundle co-ordinate + distance https://www.youtube.com/watch?v=CABaqOkWbgQ&t=2s
- Adjacency Graph build https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
- 

### Graph Pattern
## DFS
- If using recursion identify base case like already visited or out of boundary etc
  - includes finding target and returning answer
- Add current node to visited
- ***Get current node neighbors and iterate***
- For each neighbor call same fn recursive
  - Might need to append result
- Remove current node from visited if backtrack when no answer found in the recusion 
- Key in answer is returned in early in call stack

## BFS
- Initialize Q with key and List of connected nodes
- Add start node to queue and a visited set
- Iterate until queue is empty
- For each Que items added check level by level
- Get current item from q
- Iterate neighbors of current node from graph
- Check if right conditions satisfied
  - Add neighbor to queue
  - Mark neighbor visited

## Counts
- longest path DFS eg: semester pre-req 
- min/short path BFS path to target given some blocks

## Tips
 
### BFS 
 - Always add starting node to Q before iterating Q
 - Iterate all items added to Q by running a for loop to pick an item for checking main logic
 - While looping through each item if target found return count for each level
### DFS
 - Always take a visited set of , hashmap as part of recursive fn call parameter
 - Check base conditions first or success condition and return
 - Pay attention to return values as they might not bubble or be added
- might need to store distance when add position to Q
 
# Data structures used
```java
 Queue<String> q = new LinkedList<>()  // python deque from collections 
 HashSet<String> visited  = new HashSet<>()  //python set() , dict {}, tuple (),list [] 
 boolean[][] visited = new boolean[];

 // edges
 HashMap<String, LinkedList<String>> adjGraph = new HashMap<>();
 
 // Iterating maps
for(Map.Entry<String,LinkedList<String> map: adjGraph.entrySet())){
    //getting keys 
        map.getKey()
        map.getValue()
}
        
 //Getting only keys
 for(String key:adjGraph.keySet()){}
 
 //Max from hashMap
 Collections.map(adjGraph.values);
```

### Best teaching resource
- Structy
- NeetCode

BackTrack
Subset
LinkedList - Kunal Kushwaha