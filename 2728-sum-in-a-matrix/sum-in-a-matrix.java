class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        PriorityQueue[] rowPQ= new PriorityQueue[m];
        for(int i=0;i<m;i++){
            rowPQ[i] = new PriorityQueue<Integer>((a,b)-> Integer.compare(b,a));
            for(int j=0;j<n;j++){
                rowPQ[i].add(nums[i][j]);
            }
        }
        int res = 0;
        for(int j=0;j<n;j++){
            int max = 0;
            for(int i=0;i<m;i++){
                max = Math.max(max,(int)rowPQ[i].poll());
            }
            res+=max;
        }
        return res;
    }
}