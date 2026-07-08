class Solution {
    public boolean predictTheWinner(int[] nums) {
        boolean turn = true;
        int scoreA=0, scoreB=0;
        return helper(turn,0, nums.length-1, scoreA, scoreB, nums);
    }

    public boolean helper(boolean turn, int i, int j, int a, int b, int[] nums){
        if(i>j && a>=b) return true;
        else if(i>j && b>a) return false;
        if(j>=0 && i<nums.length &&turn) return helper(!turn,i+1,j,a+nums[i],b,nums) || helper(!turn,i,j-1, a+nums[j],b,nums);
        if(j>=0 && i<nums.length &&!turn) return helper(!turn,i+1,j,a,nums[i]+b,nums) && helper(!turn,i,j-1, a,nums[j]+b,nums);
        return false;
    }
}