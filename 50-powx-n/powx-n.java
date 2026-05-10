class Solution {
    public double myPow(double x, int n) {
        return binaryExp(x,n);
    }
    private double binaryExp(double x, long n){
        if(n==0) return 1;
        if(n<0) return 1.0/binaryExp(x,-n);
        if(n%2==0) return binaryExp(x*x,n/2);
        else return x*binaryExp(x*x,n/2);
    }
}