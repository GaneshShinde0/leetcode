/*
0^1 => 1
1^0 => 1
0^0 => 0
1^1 => 0

If All elements are zero => return 0;
All Elements are same=> 
    If number of elements is odd then return n
    else return n-1

Running XOR

*/

class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = nums[0], first = nums[0], n = nums.length;
        boolean allZero = nums[0]==0;
        for(int i=1;i<n;i++){
            xor^=nums[i];
            if(nums[i]!=0) allZero = false;
        }
        if(allZero) return 0;
        if(xor==0) return n-1;
        else return n;
    }
}