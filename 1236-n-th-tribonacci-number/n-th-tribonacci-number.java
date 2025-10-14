class Solution {
    public int tribonacci(int n) {
        int t0=0,t1=1,t2=1;
        if(n==0) return t0;
        else if (n==1) return t1;
        else if (n==2) return t2;
        for(int i=3;i<=n;i++){
            int temp1 = t2;
            int temp0 = t1;
            t2 = t2+t1+t0;
            t1=temp1;
            t0=temp0;
        }
        return t2;
    }
}