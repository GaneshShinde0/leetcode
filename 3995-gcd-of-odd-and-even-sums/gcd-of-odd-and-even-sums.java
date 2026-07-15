class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = n*n, evenSum = n*(n+1);
        return gcd(oddSum, evenSum);
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}