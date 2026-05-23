class Solution {
    public int maximumPossibleSize(int[] nums) {
        int res =0,prevMax = -1;
        for(int num:nums){
            if(num>=prevMax){
                res++;
                prevMax=num;
            }
        }
        return res;
    }
}