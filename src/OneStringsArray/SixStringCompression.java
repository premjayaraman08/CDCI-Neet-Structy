package OneStringsArray;

//compress string if there is continous streak of letter,
// return original string is compressed string is less than original length
public class SixStringCompression {
    public static void main(String[] args) {
        // String str = "aaccccbbbbaaccccbbbb";
        //  String str = "abbqqqqqqqqqqqqqqqcccddddwwwwww";
        String str = "aaa";
        //assumptions only: continuous alphabets

//        String output = oneCompression(str);
        String output = twoCompressionTwoPointer(str);
        System.out.println("Original string:" + str + ", updated str:" + output);
//        String uncompressed = unCompress(output);
//        System.out.println("Uncomressed string" + uncompressed);
    }

    static String twoCompressionTwoPointer(String str) {
        //               i
        //m1 : input aaabb o/p a3  b2c,
        //               j
        // ideas : comparing next element , if they are different we need to append compression
        //  2pointer approach 1st pointer moves on new character, 2nd pointer always moves
        int i = 0, j = 0;
        int freq = 1;
        char ch = str.charAt(i);


        StringBuilder strb = new StringBuilder();
        // Iterate 2nd pointer end
        while (j < str.length()) {
            // If both pointers are same increment running pointer
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            } else {
                // if both are different
                //  compute frequency based on both pointers
                freq = j - i;
                ch = str.charAt(i);

                //  append character to result
                strb.append(ch);

                if (freq > 1) {
                    // handle single character compression
                }

                // handle pointer computation
                i = j;
            }
        }

        //  append character to result
        freq = j - i;
        if (freq == 1) {
            // handle single character compression
            strb.append(ch);
        } else {
            strb.append(freq);
            strb.append(ch);
        }

        return strb.toString();
    }

    public static String unCompress(String str) {
        //1. given compressed string with 2digit followed by character decompress it
        // idea : Have 2 pointers one for digits, another for alphabets
        int i = 0, j = 0;
        //   j
        // 33s4d
        // i
        StringBuilder out = new StringBuilder();
        // Iterate each character , check if current cha is digit or alphabet
        while (j < str.length()) {
            // if char increment digits pointers
            if (Character.isDigit(str.charAt(j))) {
                j++;
            } else {
                // if non digit increment append result by printing freq and alphabet
                char ch = str.charAt(j);
                System.out.println("i:" + i + ", j:" + j);
                int freq = Integer.parseInt(str.substring(i, j));
                //Append result
                for (int k = 1; k <= freq; k++) {
                    out.append(ch);
                }
                j++;
                //reset pointer
                i = j;

            }
        }
        return out.toString();
    }

    public static String oneCompression(String str) {
        //idea : have counter to count streak alphabets
        int streakCount = 0;

        int compressedCount = countCompression(str);
        System.out.println("compressedCount:" + compressedCount);
        if (compressedCount > str.length()) return str;
        //str abc
        StringBuilder compressedString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            streakCount++;
            // compare current to next character, if alphabet is different append to compressed string, reset coutner
            if (i + 1 >= str.length() || (str.charAt(i) != str.charAt(i + 1))) {
                compressedString.append(streakCount);
                compressedString.append(str.charAt(i));
                streakCount = 0;
            }
        }

        return compressedString.toString();


    }

    public static int countCompression(String str) {
        int streakCount = 0;
        int finalCount = 0;
        for (int i = 0; i < str.length(); i++) {
            streakCount++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                //Why StringVaueOf Convert to digits
                finalCount += 1 + String.valueOf(streakCount).length(); // convert int to String , then add length
                streakCount = 0;
            }
        }
        return finalCount;
    }
}
