class Solution {
    public int equalCountSubstrings(String s, int count) {
        int ans = 0;
        for(int k=1;k<=26;k++){
            int[] freq = new int[26];
            int distinct = 0;
            for(int i=0;i<s.length();i++){
                if(++freq[s.charAt(i)-'a']==count) distinct++;
                if(i>=k*count && freq[s.charAt(i-k*count)-'a']--==count) --distinct;
                if(distinct == k) ans++;
            }
        }
        return ans;
    }
}