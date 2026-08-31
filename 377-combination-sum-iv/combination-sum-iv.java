/*
[1,2] target 2

[1,1]
[2]
=> 2

Target [3]
[1,1,1]
[1,2]
[2,1]

Suppose Target => 4
[1,2]


[1,1,1,1]
[1,2,1]
[2,1,1]
[1,1,2]
[2,2]

So Basically We have to add 1+combinationSum(nums,target-nums[i]);
*/
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1; // There is 1 way to form 0, that is not selecting anything.
        for(int i= 0;i<=target;i++){
            if(dp[i]==0) continue;
            for(int num:nums){
                if(i+num<=target) dp[i+num] +=dp[i];
            }
        }
        return dp[target];
    }
}
class SolutionUsingRecursion{
    HashMap<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        this.memo = new HashMap<>();
        return combCount(nums, target);
    }
    private int combCount(int[] nums,int remainingTarget){
        if(memo.containsKey(remainingTarget)) return memo.get(remainingTarget);
        if(remainingTarget==0) return 1;
        if(remainingTarget<0) return 0;
        int counts = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            counts += combCount(nums, remainingTarget-nums[i]);
        }
        memo.put(remainingTarget, counts);
        return memo.get(remainingTarget);
    }
}