class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        int currrentOperatedWindowLength = 1;
        for(int i=n-1;i>0;i--){
            if(nums[i]!=nums[i-1]){
                result+=currrentOperatedWindowLength;
            }
            currrentOperatedWindowLength++;
        }
        return result;
    }
}