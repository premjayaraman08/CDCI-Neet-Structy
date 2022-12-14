package AdvancedAlogsNeet;

import java.util.HashSet;

public class SlidingWindowFixedSize {
    public static void main(String[] args){
        //given array
        // 4 -1 2 -7 3 4
        // l
        int[] nums = new int[]{1,2,3,2,3,3};
        int k = 3;
        int L = 0;
        HashSet<Integer> window = new HashSet<>();

        for(int R = L+1; R < nums.length; R++){
            //keep expanding window until out of lime
            if( R - L + 1 > k){
                //increment L index
                window.remove(nums[L]);
                L += 1;
            }
            if (window.contains(nums[R])){
                System.out.println("FOUND ANSWER:"+  nums[R]);
            }
            window.add(nums[R]);
        }
    }


}
