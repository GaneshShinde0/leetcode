class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, max = 0;
        for(int i:nums){
            if(i==1){
                res++;
            }else{
                res =0;
            }
            // System.out.println("Res: "+res+", Max: "+max);
            if(res>max) max = res;
        }
        return max;
    }
}