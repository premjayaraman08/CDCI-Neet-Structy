package OneStringsArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//https://www.geeksforgeeks.org/determine-string-unique-characters/
public class OneUniqueString {
    public static void main(String[] args){

        //string has unique characters
        //myfear
//        String str = "abcd10jk";//true
//        String str = "abcdhappy";//false
        String str = "abcda";//false
//        String str = "hutg9mnd!k";//true
//        boolean isUnique = oneBruteForce2(str);

       // boolean isUnique = twoSorting2(str);
        // boolean isUnique = oneBruteForce1(str);
        // boolean isUnique = twoSorting(str);
        // boolean isUnique = threeHashMap(str);
        // boolean isUnique = fourHashSet(str);
         boolean isUnique = fourHashSetEnhancedFor(str);
        // boolean isUnique = fiveAscii(str);
//         boolean isUnique = sixAscii2(str);
//
  //      boolean isUnique = sevenBitVector(str);
         System.out.println("Is `" + str + "` Unique? " + isUnique);
//
    }

    public static boolean oneBruteForce2(String str){
        // a b c d
        // i^
        //   ^
        for (int i=0;i < str.length(); i++){
            for(int j=i+1; j < str.length() ; j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean sixAscii2(String str){
        String[] arr = {"a", "b", "c"};
        for (String a: arr) {
            System.out.print(a + " ");
        }

        int MAX_INTEGER = 256;

        //initialize visited
        Boolean[] visited = new Boolean[MAX_INTEGER];
        // Initialize indexs with false
        Arrays.fill(visited, false);

        for (int i=0; i<str.length(); i++){
            //get index of character
            int index = str.charAt(i);

            if(visited[index]){
                return false;
            }

            visited[index] = true;
        }

        return true;

    }

    public static boolean fourHashSet(String str) {
        HashSet<Character> hasSet = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            hasSet.add(str.charAt(i));
        }
        return hasSet.size() == str.length();
    }

    public static boolean fourHashSetEnhancedFor(String s){
        HashSet<Character> hs = new HashSet<>();
        for(char ch : s.toCharArray()){
            hs.add(ch);
        }

        return hs.size() == s.length();

    }

    public static boolean fiveAscii(String str1){
        //Initialize Character Array with indexes
        Boolean[] chars = new Boolean[256];
        Arrays.fill( chars, false );

        //iterate and mark true when not visited
        for( int i=0; i<str1.length(); i++){
            //get index from string

            char c1 = str1.charAt(i);
            int index1 = (int) c1;              //str a b c a d
                                               //i   0 1 2 3 4
            System.out.println("index:"+ index1);

            if(chars[index1] == true){
                System.out.println("NOT UNIQUE");
                return false; //NOT UNIQUE
            }
            chars[index1] = true;
        }


        System.out.println("UNIQUE");
        return true;

    }

    public static boolean threeAscii(String str){

        int MAX_CHAR = 256;

        //initialize boolean array of characters
        Boolean[] chars = new Boolean[MAX_CHAR];

        //initialize chars to false
        Arrays.fill(chars, false);

        //iterate each character and check if element has alreay been added
        for( int i=0; i<str.length(); i++){
//            if
        }

        return false;

    }

    // T(n) = O(nlogn) Space = O(1)
    public static boolean twoSorting(String str){
        //sort the string
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        //Iterate and Compare with adjacent character
        for(int i=0; i<str.length()-1; i++){
            if(chars[i] == chars[i+1]){
                return false;
            }
        }
        return true;

    }

    //T(n) = O(n)^2 , S(n) = O(1)
    public static boolean oneBruteForce1(String str){
        //outer loop start iterating all characters
        for(int i=0; i<str.length(); i++){
            //inner loop, start index in character after ith index
            for(int j=i+1; j<str.length(); j++){
                //compare adjacent characters
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return  true;

    }

    public static boolean threeHashMap(String str){
        HashMap<Character, Boolean> visited = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            if(visited.containsKey(str.charAt(i))){
                return false;
            }
            visited.put(str.charAt(i), true);
        }
        return true;
    }

    public static boolean twoSorting2(String str){
        //Converting string to sorted array
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        //Compare with adjacent elements
        for(int i=0; i<str.length() - 1; i++){
            //if adjacent elements are same then not unique
            if(chs[i] == chs[i+1]){
                return false;
            }
        }
        return true;

    }

    public static boolean sevenBitVector(String str){
        //idea is fit a-z lower char within 8 bytes i.e 32 bits
        // each character occupying a bit a - 0 b -1 ... z = 25

        //break string to character
        char[] chrs = str.toCharArray();

        // initialize a bit vector
        int charBitVector = 0;

        //Iterate on each character,
        for(int i=0; i<str.length(); i++) {
            System.out.println("i:"+ i +":" + Integer.toBinaryString(charBitVector));
            // convert character to indexes bit index
            int charIndex = str.charAt(i) - 'a' ;

            //store char as bit index by left shifting
            int mask = 1 << charIndex;
            System.out.println("charIndex:"+ charIndex+ ", mask:"+mask+":" + Integer.toBinaryString(mask));

            //check bitwise vector and charIndex result is 1m 101 ( cba) & 001
            if ((mask & charBitVector) > 0){ //bitwise & with same letter in 1
                return false;
            }
            // else add OR result
            charBitVector |=  mask;
        }
        return true;
    }
}
