package AdvancedAlogsNeet;

import java.util.HashMap;


class TriePremNode {
    HashMap<Character, TriePremNode> children = new HashMap<>();
    char c;
    boolean isWord;

    TriePremNode(){}
}

class TriePremCore{
    // Have a root node
    TriePremNode root;

    TriePremCore(){
        this.root = new TriePremNode(); // created empty tre
    }


    public void insertWord(String word){
        TriePremNode current =  root;
        for(char ch: word.toCharArray()){
            if(!current.children.containsKey(ch)){
                // if current char has no char in trie
                current.children.put(ch, new TriePremNode());
            }

            // start move to next char
            current = current.children.get(ch);

        }
        current.isWord = true;

    }

    public boolean search(String word){
        TriePremNode current = root;

        for(char ch: word.toCharArray()){
            if(!current.children.containsKey(ch)){
                return false ;
            }

            current = current.children.get(ch);
        }

        return current.isWord;

    }
}

public class TriePrem {
    public static void main(String[] args){
        //A trie consist of a character and its children

        //  [ a]
        //  p
        // p
        // l s (apps)
        // e
        // s (apples)

        TriePremCore tr = new TriePremCore();
        tr.insertWord("apples");
        tr.insertWord("apple");
        tr.insertWord("apps");
        System.out.println(tr.search("aps"));
        System.out.println(tr.search("apps"));
    }

}

