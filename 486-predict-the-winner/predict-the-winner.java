class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = Arrays.copyOf(nums, n);

        for(int diff = 1; diff<n; diff++){
            for(int left = 0; left<n-diff; left++){
                int right = left+diff;
                dp[left] = Math.max(nums[left]-dp[left+1], nums[right]-dp[left]);
            }
        }
        return dp[0]>=0;
    }
}   
class SolutionDPBottomUp{
    public boolean predictTheWinner(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = nums[i];

        for(int diff = 1;diff<n;diff++){
            for(int left = 0; left<n-diff;left++){
                int right = left+diff;
                dp[left][right] = Math.max(nums[left] - dp[left+1][right], nums[right]-dp[left][right-1]);
            }
        }
        return dp[0][n-1]>=0;
    }
}
class SolutionRecursiveOptimized{
    int[][] memo;

    private int maxDiff(int[] nums, int left, int right){
        if(memo[left][right]!=-1) return memo[left][right];
        if(left == right) return nums[left];
        int scoreByLeft = nums[left] -maxDiff(nums, left+1, right);
        int scoreByRight = nums[right] - maxDiff(nums, left, right-1);
        memo[left][right] = Math.max(scoreByLeft, scoreByRight);
        return memo[left][right];
    }

    public boolean predictTheWinner(int[] nums){
        int n = nums.length;
        memo = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return maxDiff(nums,0,n-1)>=0;
    }
}
class SolutionRecursion{
    public boolean predictTheWinner(int[] nums) {
        boolean turn = true;
        int scoreA=0, scoreB=0;
        return helper(turn,0, nums.length-1, scoreA, scoreB, nums);
    }

    public boolean helper(boolean turn, int i, int j, int a, int b, int[] nums){
        if(i>j && a>=b) return true;
        else if(i>j && b>a) return false;
        // Player 1 will choose whichever choice works for him.
        if(j>=0 && i<nums.length &&turn) return helper(!turn,i+1,j,a+nums[i],b,nums) || helper(!turn,i,j-1, a+nums[j],b,nums);
        // Player 2 will choose choice that results in false as he wants to make sure player 1 loses. (So need to take && )
        if(j>=0 && i<nums.length &&!turn) return helper(!turn,i+1,j,a,nums[i]+b,nums) && helper(!turn,i,j-1, a,nums[j]+b,nums);
        return false;
    }
}