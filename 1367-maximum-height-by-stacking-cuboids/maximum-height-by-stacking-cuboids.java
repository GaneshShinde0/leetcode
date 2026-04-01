class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int[] cuboid:cuboids) Arrays.sort(cuboid);
        // Decreasing order
        Arrays.sort(cuboids, (a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[2],b[2]);
        });

        int n= cuboids.length, res = 0, dp[] = new int[n];

        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(cuboids[i]));
            dp[i] = Math.max(cuboids[i][2],dp[i]);
            for(int j=i+1;j<n;j++){
                if(cuboids[i][0]<=cuboids[j][0] && cuboids[i][1]<=cuboids[j][1] && cuboids[i][2]<=cuboids[j][2]){
                    dp[j] = Math.max(dp[j],dp[i]+cuboids[j][2]);
                }
                res = Math.max(res,dp[j]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}