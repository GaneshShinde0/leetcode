class Solution {
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