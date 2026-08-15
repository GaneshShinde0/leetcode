class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allZero = true;
        int n = nums.length;
        for(int num:nums){
            xor^=num;
            if(num!=0)allZero=false;
        }
        if(allZero) return 0;
        if(xor>0)return n;
        else return n-1;
    }
}