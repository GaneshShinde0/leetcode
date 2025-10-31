class Solution {
    public int firstMissingPositive(int[] nums) {
        // int min = Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int i:nums){
            if(i<0 || i>n) continue;
            else freq[i]++;
        }
        for(int i=1;i<nums.length+1;i++){
            if(freq[i]==0) return i;
        }
        return n+1;
    }
}