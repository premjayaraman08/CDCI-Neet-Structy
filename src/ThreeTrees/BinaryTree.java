package ThreeTrees;


import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

//Steps
// Create Node structure
class TreeNode{
    int data ;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.data = val;
        left = right = null;
    }
}
class BinaryTree{


    /*
           3
        /  \
       2     14
           6    15
     */
    public static void main(String[] args){
       BinaryTree bt = new BinaryTree();
       bt.run();
    }

    public void run(){
        BinaryTree bt = new BinaryTree();
        TreeNode current =bt.insert(null, 4);
        bt.insert(current, 3);
        bt.insert(current, 2);
        bt.insert(current, 6);
        bt.insert(current, 5);
        bt.insert(current, 7);
        System.out.println("Inorder:" ); bt.inOrderTraverse(current);

        System.out.println("\nPreorder:" ); bt.preOrderTraverse(current);
        System.out.println(bt.search(current, -3));
       // bt.remove(current, 4);
        System.out.println("Inorder:" ); bt.inOrderTraverse(current);
        bt.BFS(current);
    }

    public TreeNode remove(TreeNode root, int val){
        if (root == null) return null;

        //keep going right if target val greater else left if smaller
        if(val > root.data){
            root.right = remove(root.right, val);
        }else if(val < root.data){
            root.left = remove(root.left, val);
        }else{
            //handle 0 children
            if(root.left == null && root.right == null){
                return null;
            }
             //  3
            //  2  7
            // 1   5  6

            //case 1 child eg: 2 right is null
            if(root.right == null){
                return root.left;
            }

            if(root.left == null){
                return root.right;
            }

            //case 2 children // remove 4
            // findMinFromRightSubtree
            // assign min value to current place
            // remove the replace duplicate from org place by checking right
            TreeNode minNode = this.minTree(root.right);
            root.data = minNode.data;
            root.right = remove(root.right, minNode.data);
        }

        return root;

    }

    public TreeNode minTree(TreeNode root){
        TreeNode current = root;
        while ( current != null && current.left != null){
            current = current.left;
        }
        return current;
    }
    public TreeNode insert(TreeNode current, int value){
        //handle empty tree
        if(current == null){
            return new TreeNode(value);
        }

        // if greater than current add to right
        if( value > current.data) {
            current.right = insert( current.right, value);
        }else if(value < current.data){
            current.left = insert(current.left, value);
        }

        return current;
    }

    public boolean search(TreeNode current, int item){
        if(current == null){
            return false;
        }

        if(item > current.data){
            return search(current.right, item);
        }else if(item < current.data){
            return search(current.left, item);
        }

        return true;

    }

    public void inOrderTraverse(TreeNode current){
        if( current != null){
            inOrderTraverse(current.left);
            System.out.print("," + current.data);
            inOrderTraverse(current.right);
        }
    }

    public void BFS(TreeNode root){
        //root is empty return empty
        //add root to Q for traversal
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){

            //Iterate for each q added
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode current = q.removeFirst();
                System.out.println("LEVEL: "+level + "values:"+current.data);
                //add to que current left or right is not emptu
                if (current.left != null) q.add(current.left);
                if (current.right!= null) q.add(current.right);
            }
            level++;
        }

    }

    public void preOrderTraverse(TreeNode current){
        if( current != null){
            System.out.print("," +current.data);
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }

    }
}