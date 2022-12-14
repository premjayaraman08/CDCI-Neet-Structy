package OneStringsArray;
// given a string check strings is a permutation of a palindrome
// palindrome : reading string forward or backward yields same results
//      madam a - 2, m-2, d-1 // max 1 odd character

import java.util.Arrays;

// input : string output : boolean
// assumption : only lower case letters
public class FourPalindromePermutation {
    public static void main (String[] args){
        String str = "abbcaa";

     //   boolean  isTrue = oneHashSingleLoop(str);
//        boolean  isTrue = oneHashTwoLoops(str);
        boolean  isTrue = threeBitVector(str);

        System.out.println("is String :" + str + " palindrome ?" + isTrue);
    }

    public static boolean threeBitVector(String str){
        // using int bit vector we can turn use each bit for all character a-z 4 bytes 32 bits
        int bitVector = 0;

        //assume only checking lower case alphabets, weeding out rest
        // abbac
        for(char ch: str.toCharArray()){
            if (!(ch >= 'a' && ch <= 'z' )) continue;
            int gotoIndex = ch - 'a';
            // Assigning bit mask for each character by left shifting by one
            int mask = 1 << gotoIndex;
            bitVector = toggleBit( bitVector, mask);
        }

        // ch   BV          index mask   toggleBv BitVector
        // a   0.. 000000    0     001    00001     000000
        //                                        & 000001 =
        //                                          000000 =0 OR with 00001 -
        // b   0000001       1     010    0001 & 010 = 0000 = 0 OR 00011
        // a   0000011       0     001    011 & 001 = 010 !=0 Turn OFF A bit

        // turn off a,~mask    110    011
        //                              & 110 =  010
        // finally check number of bits turned on , max can be more than 1 bit
        // 000010 - 1 ( 2's complement )
        // 111101
        //    + 1

        // 111110
        // 000010
        //
        return checkOddBits(bitVector);

    }

    public static boolean checkOddBits(int bitVector){
        return (bitVector & (bitVector - 1)) == 0;
    }


    public static int toggleBit(int bitVector, int mask){
        // Check BV with mask if turn OFF or ON
        if( (bitVector & mask) == 0){ // is OFF
            bitVector |= mask ;  // turn ON bit
        }else{
            bitVector &= ~mask; // turn OFF bit         // if OFF turn ON, else turn OFF
        }

        return bitVector;
    }

    public static boolean isAlphabet(char c){
        //char store ascii values of
        if(c== '1') {
            System.out.println("Oh no");
        }
        return c>='a' && c<='z';
    }
    public static boolean oneHashTwoLoops(String str){
        //idea : is maximum is odd character everything else should be even
        //store letter count in a table for each char in string
        int[] freqTable = new int[128]; //assume ascii

        for(int i=0; i< str.length(); i++){
            if(!isAlphabet(str.charAt(i))) continue;
            freqTable[str.charAt(i)]++;

        }

        System.out.println(Arrays.toString(freqTable));
        int count = 0;
        //check if frequency count odd or even count
        for (int freq : freqTable) {
            count += freq % 2;
        }

        return count<=1;

    }

    public static boolean oneHashSingleLoop(String str){

        //construct frequency table
        int[] freqTable = new int[128];
        int oddCount = 0;
        for(char ch: str.toCharArray()){
            if(Character.isAlphabetic(ch))continue;
            freqTable[ch]++;
            if(freqTable[ch] % 2 == 1){
                oddCount++;
            }else{
                oddCount--;
            }
        }

        System.out.println("oddCount + :" + (int)oddCount);
        return oddCount<=1;
    }
}
