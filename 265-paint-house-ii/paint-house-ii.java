/*
There
*/
class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, m = costs[0].length;
        int[] res = new int[m];
        res = costs[0].clone();
        for(int i=1;i<n;i++){
            int[] temp = res.clone();
            int[] minFromLeft = new int[m];
            int[] minFromRight = new int[m];
            Arrays.fill(minFromLeft,Integer.MAX_VALUE);
            Arrays.fill(minFromRight,Integer.MAX_VALUE);
            minFromLeft[0] = temp[0];
            minFromRight[m-1] = temp[m-1];
            for(int j=1;j<m;j++){
                minFromLeft[j] = Math.min(minFromLeft[j-1],temp[j]);
            }
            for(int j=m-2;j>=0;j--){
                minFromRight[j] = Math.min(minFromRight[j+1],temp[j]);
            }

            for(int j=0;j<m;j++){
                int choose = 0;
                if(j==0) choose=minFromRight[1];
                else if(j==m-1) choose=minFromLeft[j-1];
                else choose=Math.min(minFromLeft[j-1],minFromRight[j+1]);
                res[j] =choose+costs[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i:res) result = Math.min(i,result);
        return result;
    }
}