package OneStringsArray;

// Given 2 strings s1 and s2 check if edit is one difference away when inserted, replaced, removal of a char
public class FiveOneAwayEdit {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "apples";

        boolean isOneWay = oneCompare(str1, str2);
        System.out.println(str1 + ", " + str2 + " isOneAway ? " + isOneWay);
    }
    public static boolean oneCompare(String str1,String str2){
        // idea : is 2 strings are equal length compare each index pointers, note difference counter.
        //check length of both strings
        int s1Len = str1.length();
        int s2Len = str2.length();

        // if length is same use replace logic
        if(str1.equals(str2)){
            return false;
        } else if(s1Len == s2Len){
            return checkReplacementOneWay(str1, str2);
        }else if(s1Len +1 == s2Len){
            return checkInsertLogic(str1, str2); //pass shorter 1st s1
        }else if(s2Len + 1 == s1Len){
            return checkInsertLogic(str2, str1); // pass shorted 1st s2
        }
        return false; // when length difference is greater than 1
        // if length differs use insert logic , insert or remove logic is similar when considering xchanging strings

        // if more than one return failure else true
        // if unequal , increment unequal count increment longer counter
    }

    public static boolean checkInsertLogic(String s1, String s2){
        //s1 = apl e, s2 = appl le
        //iterate both string index run out
        //move both pointers until unmatched characters,if not matached increment longer pointer
        // assume s1 is less than s2
        int shortIndex = s1.length();
        int longIndex = s2.length();
        // have 2 pointers
        int s1Index =0 ; int s2Index = 0;
        //boolean hasDiff = false;

        while(s1Index <shortIndex && s2Index < longIndex){
            if(s1.charAt(s1Index) !=s2.charAt(s2Index)){
                if(s1Index !=s2Index){                 //move only the long index
                    return false;
                }

                s2Index ++;
            }else{
                s1Index ++;
                s2Index ++;
            }
        }

        return true;
    }

    public static boolean checkReplacementOneWay(String str1, String str2){
        boolean hasDiff = false;
        // str1 = car str2 = cat
        for(int i = 0; i<str1.length(); i++){
            // compare each index , if different mark has difference flag is not marked before
            if(str1.charAt(i) != str2.charAt(i)){
                if(hasDiff){ // already marked once, so entering second time means its false
                    return false;
                }
                hasDiff = true;
            }
        }

        return false;
    }
}
