class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i:nums)sum+=i;
        if(sum%2==0) return n-1;
        else return 0;
    }
}