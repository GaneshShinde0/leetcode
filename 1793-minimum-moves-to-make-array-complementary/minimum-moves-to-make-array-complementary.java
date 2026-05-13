/*
[5,5,5,1,1,5,5,5]
*/
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int min = Math.min(nums[i],nums[n-1-i]);
            int max = Math.max(nums[i],nums[n-1-i]);

            diff[2]+=2;
            diff[min+1] -=1;
            diff[min+max] -=1;
            diff[min+max+1] +=1;
            diff[max+limit+1] +=1;
        }
        int minOps = n;
        int currentOps = 0;
        for(int i=2;i<=2*limit;i++){
            currentOps+=diff[i];
            minOps = Math.min(currentOps,minOps);
        }
        return minOps;
    }
}