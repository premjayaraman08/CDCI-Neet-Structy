/*
https://www.geeksforgeeks.org/trie-insert-and-search/

//Step 1: Initialize Trie node with children as hashmap, body
// and isValidWord flag for current node is terminal inserted valid word
Step 2 : Class to have insert and search operation
Step 3 : For Insert operation
            Given root of Trie, iterate each word to get char,
            for each char initialize a new Tier for a char if not present
             mark is valid word
           eg: prem     p
                      r
                     e
                    m ( mark is valid )


Step 4 : For Search operation
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Operations
// Insert  O (n)
// Find    o (n)
// Remove  o (n)
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            System.out.println("CH:" + ch + "index:" + index);
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current  = current.children[index];


            current.isValidWord = true;
            //}
        }
    }

    public boolean search (String word){

        TrieNode current = root;

        System.out.println(current.toString());
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            TrieNode children = current.children[index];
            if (children == null) {
                return false;
            }
            current = children;
        }

        return current.isValidWord;

    }


    public static void main(String[] args) {
        //Insert
        Trie tr = new Trie();
        tr.insert("qrem");
        tr.insert("qreneetha");
        tr.insert("qrot");

        System.out.println(tr);
          System.out.println(tr.search("qrem"));
//        System.out.println(tr.search("prem"));
//
    }

    private class TrieNode {
        // HashMap<Character, TrieNode> children = new HashMap<>(); // can be implemented as linked list
        TrieNode[] children;
        boolean isValidWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isValidWord = false;
        }
    }
}
    //




