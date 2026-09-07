/*
aa

At every moment... Addition of current character can give two things.
    - A complete new subsequence..
    - A subsequence formed with previous subsequences which was already present.

-- Can we check how many subsequences of distinct length are possible?
-- So first find all subsequences of length1's count
-- Then length 2's count..
...
Until n

*/
class Solution {
    private final int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] endsWith = new long[26];
        for(int i=0;i<n;i++){
            endsWith[s.charAt(i)-'a']  = 1+getSum(endsWith);
        }
        return (int) getSum(endsWith);
    }

    private long getSum(long[] endsWith){
        long sumOfEndsWith = 0;
        for(long l:endsWith) sumOfEndsWith = (sumOfEndsWith+l)%MOD;
        return sumOfEndsWith;
    }
}