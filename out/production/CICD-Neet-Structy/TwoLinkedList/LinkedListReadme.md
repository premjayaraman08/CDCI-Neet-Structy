## Linked List notes


### Initialize Node
```java
class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val){
        this.val = val;
    }
}

class LinkedList(){
    ListNode head;
    ListNode tail;
    int size ; //optional
    
}
```

### Operations
- insert
  - first : Edge case: handle tail pointer on empty node
  - last  : Edge case: handle tail pointer on empty node 
  - atIndex : Travel to one node previous to current node or start from 1 instead of 0 
    - On exiting loop curr has already moved to next, so have counter - 1  
- delete
  - first
  - last : On exiting loop curr has already moved to next, so have counter - 1
  - atIndex :
- Find : Iterate until next value found else empty  
