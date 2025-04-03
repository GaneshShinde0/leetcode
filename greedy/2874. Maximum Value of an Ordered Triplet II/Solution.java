class Solution {
    public long maximumTripletValueGreedyPrefixSum(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i=1;i<n;i++){
            leftMax[i]= Math.max(leftMax[i-1],nums[i-1]);
            rightMax[n-i-1]=Math.max(rightMax[n-i],nums[n-i]);
        }
        // System.out.println(Arrays.toString(leftMax));
        // System.out.println(Arrays.toString(rightMax));
        long res = 0;
        for(int j=1;j<n;j++){
            res = Math.max(res, (long) (leftMax[j]-nums[j])*rightMax[j]);
        }
        return res;
    }

    public long maximumTripletValue(int[] nums){
        int n = nums.length;
        long res = 0, imax=0, dmax=0;
        for(int k=0;k<n;k++){
            res = Math.max(res, dmax*nums[k]);
            dmax = Math.max(dmax, imax-nums[k]);
            imax = Math.max(imax,nums[k]);
        }
        return res;
    }
}
