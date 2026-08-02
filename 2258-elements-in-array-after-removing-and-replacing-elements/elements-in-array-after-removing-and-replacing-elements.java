/*
Basically At any point of time we have to see what is the start, what is the end of array.

At 0 , start = 0, end = n; Array Size = end-start = n;
At 1,  start = 1, end = n;
At n,  start = n, end = n; array size = 0;

At n+1, start = 0, end = 1; array size = 1;
At n+2, start = 0, end = 2; Array Size = 2;
*/
class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int time = queries[i][0]%(2*n); // 2n+1 cycle time
            int index = queries[i][1];
            int start = 0, end = n;
            if(time<n){
                start = time%n;
                end = n;
            }else{
                start = 0;
                end = time%n;
            }
            if(index>=end-start) res[i]=-1;
            else res[i] = nums[start+index];
        }
        return res;
    }
}