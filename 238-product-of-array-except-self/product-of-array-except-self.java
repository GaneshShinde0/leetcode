class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int zeroCount = 0;
        int product = 1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
                if(zeroCount == 2) return res;
            }else{
                product*=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(zeroCount == 1 && nums[i]!=0){
                res[i]=0;
            }else if(zeroCount==1 && nums[i]==0){
                res[i]=product;
            }else{
                res[i]=product/nums[i];
            }
        }
        return res;
    }
}