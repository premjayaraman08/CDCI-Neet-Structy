package OneStringsArray;

//Give https://leetcode.com/discuss/general-discussion/651658/understanding-urlify-code-from-cracking-the-code-interview-book
public class ThreeUrlify {
    //Given a word, replace spaces by %20 , word contains spaces needed for replacement

    public static void main(String[] args) {

        String s = "Mr John Smith    ";
        char[] str = s.toCharArray();
        int trueLength = findTrueLength(str);

        oneReplaceString(str, trueLength);
        System.out.println(new String(str));
    }



    public static void oneReplaceString(char[] str, int trueLength){
        // str    = "Mr John Smith    ", trueLength = 13
        //          ("M","r"," ","J","o","h","n"," ","S","m","i","t","h"," ", " ", " ", " ")
        //           0   1    2   3   4   5   6   7   8   9  10  11   12  13   14   15   16
        //           1   2    3   4 .........     |                                       17
//                                            read   write %  2    0  S  m   i    t    h
        // rtring = "Mr%20John%Smith"

        //Count spaces from char array string
        int spaceCount = 0;

        for(int i=0; i<=trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }

        //Find total length including spaces, // Write pointer is calculated with multiple of 2 extrae spaces
        int writeIndex = trueLength + spaceCount * 2;

        //Have 2 pointers , 1 read pointer, 1 write pointer
        // Read pointer reads from true length size
        // Iterate backwards from read pointer until no more character to read
        for(int readIndex = trueLength ; readIndex >= 0; readIndex --) {
            // if char is not space, replace read char index into write index, decrement write index
            if(str[readIndex] != ' ' ){
                str[writeIndex] = str[readIndex];
                writeIndex --;
            }else {
                //replace character %20
                str[writeIndex ] = '0';
                str[writeIndex - 1 ] = '2';
                str[writeIndex - 2 ] = '%';
                writeIndex = writeIndex -3 ;
                // else, for each char replace all character
            }
        }
    }

    public static int findTrueLength(char[] str) {
        //Iterate back until not null character found
        for(int i =str.length -1 ; i >= 0; i--){
            if(str[i] != ' '){
                return i;
            }
        }
        return -1;
    }

}
