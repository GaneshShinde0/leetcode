class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0, y = 0;
        int n = nums.length;
        int temp = 1;
        for(int i=n-1;i>0;i--){
            if(nums[i]!=nums[i-1]){
                res+=temp;
            }
            temp++;
        }
        return res;
    }
}