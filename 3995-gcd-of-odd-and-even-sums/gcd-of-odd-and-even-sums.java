class Solution {
    public int gcdOfOddEvenSumsInitialSolution(int n) {
        int sumEven = (n*(n+1));
        int sumOdd = (n*n);
        return n; // Returning n as it is obvious gcd will be n;
    }
    public int gcdOfOddEvenSums(int n) {
        int sumEven = (n*(n+1));
        int sumOdd = (n*n);
        return gcd(sumEven,sumOdd);
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}