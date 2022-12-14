package AdvancedAlogsNeet;
// given array find max sub array
// sub array means continuous index
public class kadane {
    public static void main(String[] args){
        //given array
        // 4 -1 2 -7 3 4
        // l

        int[] nums = new int[]{4,-1,2,-7,3,4,-6,6,1};

        int maxSum = 0 ;
        int sumSoFar = 0;
        int L = 0;
        int MaxL = 0  , MaxR = 0;
        for(int R =0; R< nums.length ; R++){
            //reset left right pointer
            if(sumSoFar<0){
                sumSoFar = 0;
                L = R;
            }
            // keep expanding window sums , store indices
            sumSoFar += nums[R];
            if(sumSoFar> maxSum){
                maxSum = sumSoFar;
                MaxL = L; MaxR = R;
            }
            System.out.println("Left:" + L+ ", RIGHT:" + R + ",sumSoFar:" + sumSoFar);
            maxSum = Math.max(sumSoFar,maxSum);
        }

        System.out.println("MAX SUM:" + maxSum);
        System.out.println("MAX SUM INDEX STart:" + MaxL + ", END:" + MaxR);
    }
}
