class Solution {
    public int minimumKeypresses(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        Arrays.sort(freq);
        int res = 0;
        for(int i=0;i<26;i++){
            int mult = (i>=17)?1:(i>=8)?2:3;
            res += mult*freq[i];
        }
        return res;
    }
}