class Solution {
    public int arrangeCoinsNaive(int n) {
        int curr=0;
        for(int i=0;i<=n;i++){
            curr+=i;
            if((curr-n)>0) return i-1;
        }
        return 1;
    }

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(n * 8L + 1) - 1 ) / 2;
    }

    public int arrangeCoinsBinarySearch(int n) {
        long l =1;long r= n;
        while(l<=r){
            long m = l+(r-l)/2;
            long s = m*(m+1)/2;
            if(s==n)
            return (int)m;
            else if (s<n)
             l =m+1;

            else
              r=m-1; 
        }
        return (int)r;
    }
}
