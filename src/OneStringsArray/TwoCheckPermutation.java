package OneStringsArray;

import java.util.Arrays;
import java.util.HashMap;

//Given two strings, write a method to decide if one is a permutation of the other.
public class TwoCheckPermutation {

    public static void main(String[] args) {
        String str1 = "ddedgs";
        String str2 = "adedds";


//        boolean isEqual = checkPermutationHashMap(str1, str2);
//        boolean isEqual =  oneHashSet(str1, str2);
        boolean isEqual =  twoCharFreqArray(str1, str2);
        System.out.println("Result:" + isEqual);

        //sort both strings
    }

    public static boolean twoCharFreqArray(String str1, String str2){
        if(str1.length() !=str2.length()){
            return false;
        }
        int[] frequency = new int[128];

        // count letter frequency from string 1
        for (char c:str1.toCharArray()) {
            System.out.println(c + ":" + (int)c);
            System.out.println(frequency[c]);
            frequency[c] = frequency[c] +1;
        }

        //decrement letter frequency from string 2
        for(char ch: str2.toCharArray()){
            frequency[ch] = frequency[ch] -1 ;
            if(frequency[ch] < 0){
                return false;
            }
        }
        return true;

    }


    //Data type
    // primitives int, char, boolean
    // Non primitive Integer, String, Boolean


    public static boolean checkPermutationHashMap(String s1, String s2) {

        if(s1.length() !=s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        //1st String iteration to store letter count
        for (char ch1 : s1.toCharArray()) {
            int val;
            if(map.get(ch1) == null){
                val = 1;
            }else{
                val = map.get(ch1) + 1;
            }
            map.put(ch1, val);
            System.out.println("ch1:"+ch1 + ",val:"+map.get(ch1));

        }


        //2nd String iteration to decrement letter count
        for (char ch2 : s2.toCharArray()) {
            if(map.get(ch2) != null){
                map.put(ch2, map.get(ch2) - 1);
            }
        }

        System.out.println(map);
        for(int counter : map.values()) {
            if (counter != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermutation(String s1, String s2){

        //if lengths between 2 strings are unequal return false
        if(s1.length() !=s2.length()){
            return false;
        }

       //assuming its got ascii characters
        int[] letters = new int[128]; //128 vs 256
        System.out.println("OUT");
        System.out.println(letters);

        //counter
        for(char c: s1.toCharArray()){
            letters[c]++;

            System.out.println(c+":" + letters[c]);
        }

        return false;

    }

    public static String sort(String s){
        char[] chars1 = s.toCharArray();

        //sort
        Arrays.sort(chars1);

        //check if sorted charter are equal in arrays
        return new String(chars1);

    }



    public static boolean checkPermutationSorted(String s1, String s2){

        //if lengths between 2 strings are unequal return false
        if(s1.length() !=s2.length()){
            return false;
        }

        //convert string to character array

        return sort(s1).equals(sort(s2));
        //return Arrays.equals(chars1, chars2);


    }


}
