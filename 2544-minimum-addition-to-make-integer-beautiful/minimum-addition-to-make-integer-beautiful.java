/*
While current sum of digits is bigger than target.

We do n = n//10+1;

Example:
n = 123456, The Process is
123456, -> 123460-> 123500-> 124000 -> 130000 -> 200000
*/
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long start = n, base = 1;
        while(sum(n)>target){
            n=n/10+1;
            base*=10;
        }
        return n*base-start;
    }

    private int sum(long n){
        int res = 0;
        while(n>0){
            res += n%10;
            n/=10;
        }
        return res;
    }
}