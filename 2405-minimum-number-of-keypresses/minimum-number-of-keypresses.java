class Solution {
    public int minimumKeypresses(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        Arrays.sort(freq);
        int res = 0;
        for(int i=0;i<26;i++){
            // if(freq[i]==0) continue;
            int mult = (i>=17)?1:(i>=8)?2:3;
            res += mult*freq[i];
        }
        return res;
    }
    public int minimumKeypressesAlternate(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;
        
        Arrays.sort(freq);
        
        int res = 0;
        // Iterate from largest frequency (index 25) down to smallest (index 0)
        // j represents how many characters we have processed so far (0, 1, 2...)
        for (int i = 25, j = 0; i >= 0; i--, j++) {
            // Optimization: If freq is 0, we can stop early (no more chars in string)
            if (freq[i] == 0) break;
            
            // Math trick: 
            // First 9 items (0-8) get multiplier 1
            // Next 9 items (9-17) get multiplier 2
            int mult = (j / 9) + 1;
            
            res += freq[i] * mult;
        }
        return res;
    }
}