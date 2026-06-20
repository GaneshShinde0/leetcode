class Solution {
    public long minCost(int n) {
        if(n<=2){
            return n-1;
        }
        return 1l*n*(n-1)/2;
    }
    private long helper(int n){
        if(n<=2){
            return n-1;
        }
        if(n%2==1){
            return 1l*helper(n/2)*helper(n/2+1);
        }else{
            return 1l*helper(n/2)*helper(n/2);
        }
    }
}