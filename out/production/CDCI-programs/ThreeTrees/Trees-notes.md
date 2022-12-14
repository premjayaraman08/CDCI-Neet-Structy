
# Binary Trees notes

- Binary Trees have left, right nodes with a value stored in them
- Can be traversed only in 1 direction

## Keywords
- Root : Start top portion of node
- leaf : Nodes with empty left and right values
- Parent/Children 
- Ancestor/descendants
- **height** : No of edges from root to most distant leaf node (down -> up though edges are topdown)
  - empty node has height -1
  - leaf node height is 0
  - tree node height = 1 + max(left height, right height)
- **depth** : No of edges from root to X node ( top -> down)
  - root depth is 0

- balanced binary tree : nodes are even distributed instead of skewed on one side

## Operations
- Creation
  - use TreeNode to create skeleton 
- Insertion    o(log n) 
  - pass(rootNode, insertItem)
  - keep going right if greater or left
  - could lead to unbalance tree eg: 3 ->4 -> 5-> 6 becomes similar to LL
    - use AVL to have balanced trees 
- Find/Search  o(log n)
  - simple search left or right, remember to have right return values on recursion 
- Deletion     o(log n)
  - handle case2 of 0 children, 1 children and 2 children separately
  - handle proper return values on remove and insert operations

### Code 
```java 
//Basic tree Node
class TreeNode{
   int val; // to hold data
   TreeNode left; // Binary Tree left
   TreeNode right; // Binary Tree right side
   
   public TreeNode(int item){
      this.val = item;  // left, righ properties are null by default
   }
}

class BinaryTree{
  // add/insert ( root, item)
  // remove/delete (root , item)
  // search/find
  // traverse/print
}
```

### Sample code reference
https://github.com/dtfiedler/java-binary-tree/blob/99e38242f1189621f77234770b2c5aa193da5d82/src/BinaryTree.java#L67