class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length, m = String.valueOf(nums[0]).length();
        long res = 1l*m*n*(n-1)/2; // m digits, n*(n-1)/2 digit combinations i.e. putting n digit with remaining n-1 digit... we will have to consider (a,b) same as (b,a) hence /2.
        int[][] count = new int[m][10]; // count[i][v]  means frequency of v of ith digit.
        // Iterate all numbers and iterate all digits.
        // res-=count[i][v] remove the duplicate same pair of digits, then increment the count of frequency by count[i][v]++;
        for(int num:nums){
            for(int i=0;i<m;i++){
                res -=count[i][num%10]++;
                num/=10;
            }
        }
        return res;
    }
}