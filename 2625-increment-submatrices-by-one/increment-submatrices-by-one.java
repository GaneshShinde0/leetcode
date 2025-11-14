/*

When Question says 1,1 2,2 
Then we can set 1,1 to 1 ; 2, 1 to 1;
and then 1,3 to  -1 2,3 to -1 
*/

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];
            for(int j = x1; j<=x2;j++){
                res[j][y1]+=1;
            }
            
            for(int j = x1; j<=x2;j++){
                if(y2+1<n) res[j][y2+1]-=1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                res[i][j]+=res[i][j-1]; 
            }
        }
        return res;
    }
}