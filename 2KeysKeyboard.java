class 2KeysKeyboard {
    public int minSteps2ms(int n) {
        if(n==1) return 0;
        // Create a dp array to store minsteps from 1 to n.
        int[] dp = new int[n+1];
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            int primefactor = primefactor(i);
            if(primefactor==i) dp[i]=primefactor;
            else dp[i]=dp[primefactor]+dp[i/primefactor];
        }
        return dp[n];        
    }

    public int primefactor(int n){
        int res =2;
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                res=i;
                n=n/i;
                
            }
        }
        if (n>1) res = Math.max(res,n);
        return res;
    }

    public int minSteps(int n) {
       int ans=0;
       for(int i=2;i*i<=n;){
            if(n%i==0){
                ans+=i;
                n=n/i;
            }else{
                i++;
            }
       }
       if(n!=1) ans=ans+n;
       return ans;
    }
}
