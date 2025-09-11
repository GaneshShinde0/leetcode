class Solution {
    public boolean canJumpAlternate(int[] nums) {
        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(reachable>=i) reachable = Math.max(nums[i]+i,reachable);
        }
        return reachable>=nums.length-1;
    }

    public boolean canJumpNaive(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        int n = nums.length;
        if(n==1) return true;
        arr[0] = true;
        for(int i=0;i<n;i++){
            int j=i;
            while(arr[i] && j<=(i+nums[i])&&j<n){
                arr[j]=true;
                j++;
            }
            if(arr[i]==false) return false;
        }
        return arr[n-1];
    }

    public boolean canJump(int[] nums){
        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(i>reachable) return false;
            reachable = Math.max(nums[i]+i,reachable);
        }
        return true;
    }
}