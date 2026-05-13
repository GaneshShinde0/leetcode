/*
[5,5,5,1,1,5,5,5]

5 Stages. 
[2, min] → Requires 2 moves
[min + 1, min + max - 1] → Requires 1 move
[min + max] → Requires 0 moves
[min + max + 1, max + limit] → Requires 1 move
[max + limit + 1, 2 * limit] → Requires 2 moves

*/
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int min = Math.min(nums[i],nums[n-1-i]);
            int max = Math.max(nums[i],nums[n-1-i]);

            diff[2]+=2; // Assume every sum starting from 2 requires 2 moves.
            diff[min+1] -=1; // As sum reaches min+1, we enter 1 move range... the cost drops from 2 to 1, hence -1.
            diff[min+max] -=1; // As sum reaches max+min, we enter 0 move range.. the cost drops again by 1.
            diff[min+max+1] +=1; // As sum moves past exact sum, it is no longer 0 moves, cost goes up by 1.
            diff[max+limit+1] +=1; //Now we can replace max by 1,cost goes again by 1.
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