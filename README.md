## Algorithms learnings from CDCI, NeetCode, Structy

## Java
## Main DataStructures Table
DataStructure | Search/ Find     <div style="width:200px">                       | Insert/ Remove                                                    | Update            | Misc 
--- |------------------------------------------------------------------|-------------------------------------------------------------------|----------------------------|------| 
Arrays/Dynamic arrays | <ul><li> index known - O(1) </li><li> unknown index - O(n) </li> | <ul><li>  start/end - O(1) </li><li>  mid - O(n) </li></ul>       | <ul><li>  start/end - O(1) </li><li>  mid - O(n) </li></ul> |  
Linked List | O(n)                                                             | O(1)- start/end<br/>, O(n) - mid                                  |   O(1)- start/end<br/>, O(n) - mid      |      |
Stack | NA                                                               | <ul><li> O(1)- push (add ) </li><ul> pop() remove() </ul>         |   NA                       |
Queues | NA                                                               | O(1)- push (add ), pop() remove()                                 |  NA         |
Tree | O(log n)                                                         | O(1)- push (add ), pop() remove()                                 |  NA          |
Graph | grid O(n*m)                                                      | O(1)- push (add ), pop() remove()                                 |  NA          |
Heap | O(n)                                                             | O(1)- push (add ), pop() remove()                                 |  NA          | <ul><li> PriorityQ minHeap - minimum is O(1) </li></ul>
Trie | O(n)                                                             | O(n) - if letter from word not present in hash create one and add |  NA          | <ul><li> has 0-26 children for a-z at one level, used </li><li> children- HashMap , content 

## Basic DataStructure implementation
- Arrays ```int[] nums = new int[] ```
- Dynamic Arrays     ``` ArrayList<Integer> nums = new ArrayList<Integer>() ```
  - LinkedList  
      ``` java
     class ListNode {
         int val;
         ListNode next;
         ListNode(){
        }
      }
    class SingleLL{
        ListNode head; ListNode tail;
        
        SingleLL(){
            head = new ListNode()
            tail = head
        }
    ```
  - Operations :
    - insert : if inserting to beginning or end using head and tail its O(1) else O(n)
    - search : loop until element is found
    - remove : Loop until index to be removed
- 

``` java 
import java.util.*;

class Main {
    //String to charArray
    String s = "Prem";
    for(char c: s.toCharArray())

    // Arrays
    char[] ch = new char[10]; //size needed
    char[] ch = new char[]{'a', 'b', 'c'}; //Note singe quotes 
    int[] values = new int[]{1, 2, 3}; // no need size when initialized
    String[] alphabets = new String[]{"a", "b", "c"}; //notice double qutoes 

    // Dynamic Array / List
    ArrayList<Integer> dynamicInt = new ArrayList<>();
    ArrayList<Integer> copiedInt = new ArrayList<>(dynamicInt);
    List<List<Integer>> listOfList = new ArrayList<>();

    // List Interface is part of collection framework containing
    // LinkedList, ArrayList

    // Set
    HashSet<Integer> uniqInt = new HashSet<>();//containsKey

    // Stack
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    int lastItemAdded = stack.pop();

    // Queue
    Queue<Integer>  q = new ArrayDeque<>(); // 
    Deque<Integer>  dq = new LinkedList<>();
    
    //HashMap
    HashMap<String, List<String>> hm= new HashMap<>();
    for( Map.Entry<String, List<String>> entry : hm.entrySet() ){}
    for( String name : hm.keySet() ){}
    
    //
}
```