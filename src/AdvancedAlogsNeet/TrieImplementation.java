package AdvancedAlogsNeet;//This is the full example of Trie Implementation using HashMap.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class TrieNode{

    private char c;
    private Map<Character,TrieNode> children = new HashMap<>();
    private boolean isLeaf = false;

    TrieNode(){

    }

    /**
     * @param c the c to set
     */
    public void setC(char c) {
        this.c = c;
    }

    /**
     * @return the children
     */
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * @return the isLeaf
     */
    public boolean isLeaf() {
        return isLeaf;
    }

    /**
     * @return the c
     */
    public char getC() {
        return c;
    }

    /**
     * @param isLeaf the isLeaf to set
     */
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}

class Trie{

    TrieNode rootNode;

    public Trie(){
        rootNode = new TrieNode();
    }

    public void insertWord(String word){
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Map<Character,TrieNode> children = current.getChildren();
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                TrieNode trieNode = new TrieNode();
                children.put(c, trieNode);
                current = children.get(c);
            }
        }
        current.setLeaf(true);
    }

    public boolean searchWord(String word){
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Map<Character,TrieNode> children = current.getChildren();
            char c = word.charAt(i);
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                return false;
            }
        }

        if(current.isLeaf() && current!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public void print(TrieNode rootNode,int level, StringBuilder sequence) {
        if(rootNode.isLeaf()){
            sequence = sequence.insert(level, rootNode.getC());
            System.out.println(sequence);
        }

        Map<Character, TrieNode> children = rootNode.getChildren();
        Iterator<Character> iterator = children.keySet().iterator();
        while (iterator.hasNext()) {
            char character = iterator.next();
            sequence = sequence.insert(level, character);
            print(children.get(character), level+1, sequence);
            sequence.deleteCharAt(level);
        }
    }
}

class TrieImplementation {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("Done");
        trie.insertWord("Dont");
        trie.insertWord("Donor");
        trie.insertWord("Sanjay");
        trie.insertWord("Ravi");
        trie.insertWord("RaviRaj");
        TrieNode root = trie.rootNode;
        trie.print(root, 0, new StringBuilder(""));
        System.out.println(trie.searchWord("Dont"));
        System.out.println(trie.searchWord("Donor"));
        System.out.println(trie.searchWord("Jay"));
        System.out.println(trie.searchWord("Saviraj"));
        System.out.println(trie.searchWord("RaviRaj"));
        System.out.println(trie.searchWord("Aaviraj"));
    }
}