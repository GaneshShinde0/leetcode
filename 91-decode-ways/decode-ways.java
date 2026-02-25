class Solution {

    private static final int MOD = 1_000_000_007;
    public int numDecodingsInitial(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return s.length()==0?0:decode(0,s,memo);
    }
    private int decode(int i, String s, int[] memo){
        int n = s.length();
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(memo[i]!=-1) return memo[i];
        int res = decode(i+1, s, memo);
        if(i<n-1&& (s.charAt(i)=='1'||(s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
            res+=decode(i+2,s,memo);
        }
        memo[i] = res;
        return res;
    }







































    public int numDecodings(String s) {
        HashMap<Integer,Integer> idxToWays = new HashMap<>();
        return decodeWays(s,0,idxToWays);
    }

    private int decodeWays(String s, int idx,HashMap<Integer,Integer> idxToWays){
        if(idx==s.length()) return 1;
        if(idxToWays.containsKey(idx)) return idxToWays.get(idx);
        if(s.charAt(idx)=='0') return 0;
        int result = decodeWays(s,idx+1,idxToWays);
        if(idx<(s.length()-1) && (s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<='6'))){
            result+=decodeWays(s,idx+2,idxToWays);
        }
        idxToWays.put(idx,result);
        return result;
    }
}