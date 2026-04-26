class Solution {
    public int maxCoins(int[] arr) {
        int[] nums = new int[arr.length+2];
        int n = 1;
        for(int x:arr) if(x>0) nums[n++]=x;
        nums[0] = nums[n++] = 1;
        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n-1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right){
        if(left+1==right) return 0;
        if(memo[left][right]>0) return memo[left][right];
        int ans = 0;
        for(int i=left+1;i<right;i++){
            ans = Math.max(ans,nums[left]* nums[i]*nums[right]+burst(memo,nums, left, i)+burst(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
    public int maxCoinsDoesNotWork(int[] nums) {
        int sum = 0, n = nums.length;
        int taken = 0;
        while(taken<n){
            int currMin = getMinIndex(nums);
            int left = currMin-1;
            int right = currMin+1;
            while(left>=0 && nums[left]==-1){
                left--;
            }
            while(right<n && nums[right]==-1){
                right++;
            }
            int leftProd = left<0?1:nums[left];
            int rightProd = right>=n?1:nums[right];
            sum+=nums[currMin]*leftProd*rightProd;
            nums[currMin] = -1;
            taken++;
        }
        return sum;
    }
    private int getMinIndex(int[] nums){
        int minIdx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-1 && nums[minIdx]>nums[i]){
                minIdx = i;
            }
        }
        return minIdx;
    }
}