class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int prodDigs = prodDigs(n);
            if(prodDigs%t==0) return n;
            n++;
        }
    }
    int prodDigs(int n){
        int prod = 1;
        while(n>0){
            prod*=n%10;
            n = n/10;
        }
        return prod;
    }
}