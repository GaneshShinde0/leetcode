class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int jumps = 0;
        int start = 0, end = 0;
        while(end<n-1){
            int farthest =end;
            int curr = 0;
            for(int i=start; i<=end;i++){
                farthest = Math.max(i+nums[i],farthest);
            }
            if(farthest==end) return -1;
            start = end+1;
            end = farthest;
            jumps++;
        }
        return jumps;
    }
}