package AdvancedAlogsNeet;

public class SlidingWindowVariableSize {
    public static void main(String[] args) {
        //given array
        int[] nums = new int[]{2,3,1,2,7,4,5,6,1,2};
        int target = 7;
        System.out.println(getMinLengthForTarget(nums, target));

    }

    public static int getMinLengthForTarget(int[] nums, int target){
        int length = Integer.MAX_VALUE;
        int L = 0; int currentSum = 0;

        for(int R=0; R< nums.length; R++){
            currentSum += nums[R];

            //Keep decrementing to min length
            while(currentSum >= target){
                length = Math.min((R - L) + 1, length);
                currentSum -= nums[L] ;
                L++;
            }
        }

        // if length not updated return 0
        if(length == Integer.MAX_VALUE){
            return 0;
        }
        return length;

    }
}
