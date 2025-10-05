class Solution {
    public int climbStairsUsingTwoVariables(int n) {
        int n1 = 0, n2 =1;
        int i=1;
        if(n==1) return 1;
        while(i<=n){
            i++;
            int temp = n2;
            n2=n1+n2;
            n1=temp;
        }
        return n2;
    }
    public int climbStairsDPArray(int n) {
        int[] dp = new int[n+2];
        dp[1] = 1;
        for(int i = 2;i<=n+1;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n+1];
    }

    public int climbStairs(int n){
        int one=1;
        int two =1;
        for(int i=1;i<n;i++){
            int temp = one;
            one = one+two;
            two = temp;
        }
        return one;
    }
}