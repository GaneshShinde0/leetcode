class Solution {
    public long numberOfSubstrings(String s, int k) {
        long res = 0;
        int left = 0, n = s.length();
        int[] freq = new int[26];
        for(int right=0;right<n;right++){
            char curr = s.charAt(right);
            freq[curr -'a']++;
            while(freq[curr-'a']>=k){
                res += (1l*(n-right));
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return res;
    }
}