class Solution {
    // private static HashMap<Integer, Integer> hm;
    // static{
    //     hm = new HashMap<>();
    //     for(int i=0;i<101;i++){
    //         hm.put(i,i*(i+1)/2);
    //     }
    // }
    public double champagneTowerDoesNotWork(int poured, int query_row, int query_glass) {
        int curr = 1, remainder = 0, temp = query_row;
        while(poured>0 && query_row>0){
            poured-=curr;
            query_row--; 
            curr++;
        }
        if(query_row<0) return 0.0;
        else{
            
            return Math.min(poured*1.0/(temp+1),1.0);
        }
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][102];
        dp[0][0] = (double) poured;
        for(int r=0;r<=query_row; r++){
            for(int c =0;c<=r;c++){
                double q = (dp[r][c]-1.0)/2.0;
                if(q>0){
                    dp[r+1][c]+=q;
                    dp[r+1][c+1]+=q;
                }
            }
        }
        return Math.min(1,dp[query_row][query_glass]);
    }
}

/*
poured = 25, row = 6

poured = 24
row = 5
curr = 2

poured = 22
row = 4
curr = 3

poured = 19
row = 3
curr = 4

poured = 15
row = 2
curr = 5

poured = 10
row = 1
curr = 6

poured = 4
row = 0
curr = 7

*/