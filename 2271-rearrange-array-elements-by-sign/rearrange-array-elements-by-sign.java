class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, posIdx =0, negIdx=1;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                res[posIdx] = nums[i];
                posIdx+=2;
            }else{
                res[negIdx] = nums[i];
                negIdx+=2;
            }
        }
        return res;
    }
}