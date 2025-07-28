class Solution {
    public int countMaxOrSubsetsRecursion(int[] nums) {
        int maxOrValue = 0, n = nums.length;
        for(int i=0;i<n; i++){
            maxOrValue |= nums[i];
        }
        return countSubsets(nums,0,0, maxOrValue);
    }
    private int countSubsets(int[] nums, int index, int currentOr, int targetOr){
        if(index == nums.length) return currentOr==targetOr?1:0;
        int countWithout = countSubsets(nums, index+1, currentOr,targetOr);
        int countWith = countSubsets(nums,index+1, currentOr|nums[index], targetOr);
        return countWithout+countWith;
    }

    public int countMaxOrSubsetsMemoization(int[] nums){
        int n = nums.length, maxOrValue = 0;
        for(int i:nums) maxOrValue |= i;
        Integer[][] memo = new Integer[n][maxOrValue+1];
        return countSubsetsRecursive(nums,0,0,maxOrValue, memo);
    }
    public int countSubsetsRecursive(int[] nums, int index, int currentOr, int targetOr, Integer[][] memo){
        if(index == nums.length) return currentOr==targetOr?1:0;
        if(memo[index][currentOr]!=null){
            return memo[index][currentOr];
        }
        int countWithout = countSubsetsRecursive(nums,index+1, currentOr, targetOr, memo);
        int countWith = countSubsetsRecursive(nums,index+1, currentOr|nums[index], targetOr, memo);
        return memo[index][currentOr] = countWithout + countWith;
    }
    // Not getting this approach
    public int countMaxOrSubsets(int[] nums){
        int n = nums.length, maxOrValue = 0;
        for(int i:nums) maxOrValue |= i;
        int totalSubsets = 1<<nums.length;
        int subsetsWithMaxOr = 0;
        // Iterate through all possible subsets
        for(int subsetMask = 0; subsetMask<totalSubsets; subsetMask++){
            int currentOrValue = 0;
            // Calculate OR value for the current subset
            for(int i=0; i<nums.length; i++){
                if(((subsetMask>>i)&1)==1) currentOrValue |=nums[i];
            }
            if(currentOrValue==maxOrValue) subsetsWithMaxOr++;
        }
        return subsetsWithMaxOr;
    }
}