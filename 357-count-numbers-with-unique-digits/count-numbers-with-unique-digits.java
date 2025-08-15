class Solution {
    int[] arr = new int[9];
    public int countNumbersWithUniqueDigitsBruteForce(int n) {
        if (n==0) return 1;
        if(n==1) return 10;
        if(n==2) return 91;
        if(n==3) return (91*8+10+1);
        if(n==4) return(739*7+91+10+1);
        if(n==5) return(countNumbersWithUniqueDigits(4)*6+739+91+10+1);
        if(n==6) return(countNumbersWithUniqueDigits(5)*5+5275+739+91+10+1);
        return 0;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10; // f(0) + f(1)
        int uniqueDigits = 9; // First digit choices (1-9)
        int availableDigits = 9; // Remaining digits (excluding one already used)

        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigits *= availableDigits;
            ans += uniqueDigits;
            availableDigits--;
        }

        return ans;
    }
}
    