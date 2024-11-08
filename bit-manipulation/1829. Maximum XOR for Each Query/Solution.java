class Solution {
    public int[] getMaximumXorAlternate(int[] nums, int maximumBit) {
        int[] prefixXOR = new int[nums.length];
        prefixXOR[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixXOR[i] = prefixXOR[i-1]^nums[i];
        }
        int[] ans = new int[nums.length];
        int mask = (1<<maximumBit)-1; // Gives 2^n -1
        for(int i=0; i<nums.length; i++){
            int currentXOR = prefixXOR[prefixXOR.length-1-i];
            ans[i]= currentXOR^mask;
        }
        return ans;
    }

    // Approach 2: Optimized Calculation + Bit Masking
    public int[] getMaximumXor(int[] nums, int maximumBit){
        int xorProduct = 0;
        for(int i=0; i<nums.length; i++){
            xorProduct = xorProduct^nums[i];
        }
        int[] ans = new int[nums.length];
        int mask = (1<<maximumBit) - 1;
        for(int i=0;i<nums.length;i++){
            ans[i] = xorProduct ^ mask;
            xorProduct = xorProduct ^ nums[nums.length-1-i];
        }
        return ans;
    }
}
