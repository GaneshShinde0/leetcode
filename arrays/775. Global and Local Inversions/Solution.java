class Solution {
    public boolean isIdealPermutationTLE(int[] nums) {
        int local=0,global=0, n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) local++;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]) global++;
                if(global>local) return false;
            }
        }
        return global==local;
    }

    public boolean isIdealPermutation(int[] nums){
        int max = 0;
        for(int i=0;i<nums.length-2;i++){
            max = Math.max(max,nums[i]);
            if(max>nums[i+2]) return false;
        }
        return true;
    }
}
