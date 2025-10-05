class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(nums,0,0,dp,target);
    }

    private int backtrack(int[] nums, int i, int total, Map<String,Integer> dp, int target){
        if(i==nums.length) return total==target?1:0;
        if(dp.containsKey(i+"-"+total)) return dp.get(i+"-"+total);
        dp.put(i+"-"+total, backtrack(nums,i+1,total+nums[i],dp,target)+backtrack(nums,i+1,total-nums[i],dp,target));
        return dp.get(i+"-"+total);
    }
}