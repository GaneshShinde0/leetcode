class Solution {
    private static final int MOD = 1_000_000_007;
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return s.length()==0? 0:decode(0,s,memo);
    }
    private int decode(int i, String s,int[] memo){
        int n = s.length();
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(memo[i]!=-1) return memo[i];
        int res = decode(i+1,s,memo);
        if(i<n-1 && (s.charAt(i)=='1' ||( s.charAt(i)=='2'&& s.charAt(i+1)<'7'))){
            res += decode(i+2,s,memo);
        }
        memo[i] = res;
        return res;
    }
}