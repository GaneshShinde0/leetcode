class Solution {
    public long maxProfitInitialDoesNotWork(int[] prices, int[] strategy, int k) {
        long original = 0;
        int n = prices.length;
        for(int i=0;i<n;i++){
            original = original+prices[i]*strategy[i];
        }
        int left = 0, right = 0, window = k/2;
        long curr = original;
        long res = Long.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(i<window){
               curr += (-1)*strategy[i]*prices[i];
            }else{
                if(strategy[i]==-1) curr+=prices[i]*2;
                if(strategy[i]==0) curr+=prices[i];
            }
        }
        res = Math.max(original, res);
        res = Math.max(curr, res);
        System.out.println(curr);
        for(int i=window+1;i<n-window;i++){
            if(strategy[i-window]==-1) curr+=(-1)*strategy[i]*prices[i-window];
            if(strategy[i+window]==-1) curr+=prices[i+window]*2;
            if(strategy[i+window]==0) curr+=prices[i+window];
            res = Math.max(curr, res);
            if(strategy[i-window]==-1) curr-=prices[i-window]*2;
            if(strategy[i-window]==0) curr-=prices[i-window];
            if(strategy[i-window]==1) curr+=prices[i-window];
        }
        return res;
    }

    public long maxProfit(int[] prices, int[] strategy, int k){
        int n = prices.length;
        long[] profitSum = new long[n+1];
        long[] priceSum = new long[n+1];
        for(int i=0;i<n;i++){
            profitSum[i+1] = profitSum[i] +(long) prices[i]* strategy[i];
            priceSum[i+1] = priceSum[i]+prices[i];
        }
        long res = profitSum[n];
        for(int i=k-1;i<n;i++){
            long leftProfit = profitSum[i-k+1];
            long rightProfit = profitSum[n]-profitSum[i+1];
            long changeProfit = priceSum[i+1]-priceSum[i-k/2+1];
            res = Math.max(res, leftProfit+changeProfit+rightProfit);
        }
        return res;
    }
}

/*
original = 4;
window = 1, k = 2;

curr = 10

i= 1
curr = 10 + 

*/