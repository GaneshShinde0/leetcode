class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length-2;i++){
            int localTarget = target-nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]<localTarget){
                    sum+=right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return sum;
    }
}