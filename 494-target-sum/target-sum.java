class Solution {
    public int findTargetSumWaysInitial(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(nums,0,0,dp,target);
    }

    private int backtrack(int[] nums, int i, int total, Map<String,Integer> dp, int target){
        if(i==nums.length) return total==target?1:0;
        if(dp.containsKey(i+"-"+total)) return dp.get(i+"-"+total);
        dp.put(i+"-"+total, backtrack(nums,i+1,total+nums[i],dp,target)+backtrack(nums,i+1,total-nums[i],dp,target));
        return dp.get(i+"-"+total);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;
        
        // If target is out of possible range, return 0 early
        if (Math.abs(target) > total) return 0;

        // memo[i][sum + total] = ways
        Integer[][] memo = new Integer[nums.length][2 * total + 1];
        return dfs(nums, 0, 0, target, total, memo);
    }

    private int dfs(int[] nums, int i, int sum, int target, int offset, Integer[][] memo) {
        if (i == nums.length) return sum == target ? 1 : 0;
        if (memo[i][sum + offset] != null) return memo[i][sum + offset];

        int add = dfs(nums, i + 1, sum + nums[i], target, offset, memo);
        int subtract = dfs(nums, i + 1, sum - nums[i], target, offset, memo);

        memo[i][sum + offset] = add + subtract;
        return memo[i][sum + offset];
    }
}