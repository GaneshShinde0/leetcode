class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++) prefix[i] = prefix[i-1]+nums[i];

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int leftSum = prefix[i]-nums[i];
            int rightSum = prefix[n-1]-prefix[i];

            int leftHas = i, rightHas = n-i-1;
            int leftTotal = leftHas*nums[i]-leftSum; // Getting absolute of left elements
            int rightTotal = rightSum - rightHas*nums[i]; // Getting absolute of right elements are they are bigger than curr;
            ans[i] = leftTotal+rightTotal;
        }
        return ans;
    }
}

/*
Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.

Input: nums = [1,4,6,8,10]
result[0] = |1-1|+|1-4|+|1-6|+|1-8|+|1-10| => 24
result[1] = |4-1|+|4-4|+|4-6|+|4-8|+|4-10| => 24

*/