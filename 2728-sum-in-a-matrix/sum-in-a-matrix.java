class Solution {
    public int matrixSumInitial(int[][] nums) {
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
    public int matrixSumSecond(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        List<Integer>[] rowPQ= new List[m];
        for(int i=0;i<m;i++){
            rowPQ[i] = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                rowPQ[i].add(nums[i][j]);
            }
            Collections.sort(rowPQ[i]);
        }
        int res = 0;
        for(int j=0;j<n;j++){
            int max = 0;
            for(int i=0;i<m;i++){
                max = Math.max(max,(int)rowPQ[i].get(n-j-1));
            }
            res+=max;
        }
        return res;
    }
    
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        for(int[] row:nums) Arrays.sort(row);
        int res = 0;
        for(int j=0;j<n;j++){
            int max = 0;
            for(int i=0;i<m;i++){
                max = Math.max(max,nums[i][n-j-1]);
            }
            res+=max;
        }
        return res;
    }
}