class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        long res = 0, prev = 0;
        for(int i=0;i<n;i++){
            res += Math.max(target[i]-nums[i]-prev,0);
            prev = target[i]-nums[i];
        }
        return res+Math.max(-prev,0);
    }
}