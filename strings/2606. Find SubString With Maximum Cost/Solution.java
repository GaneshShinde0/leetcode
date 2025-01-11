class Solution {
    // Kadane's Algorithm
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] valsFinal = new int[26];
        for(int i=0;i<26;i++){
            valsFinal[i] =i+1;
            int temp=chars.indexOf('a'+i);
            if(temp>-1) valsFinal[i]=vals[temp];
        }
        int res = 0, cur=0;
        for(int i=0;i<s.length();i++){
            cur = Math.max(cur+valsFinal[s.charAt(i)-'a'],0);
            res = Math.max(res, cur);
        }
        return res;
    }
}
