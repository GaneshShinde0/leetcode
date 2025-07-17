class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int currSub = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=currSub){
                currSub = nums[i];
                count++;
            }
        }
        return count;
    }
}