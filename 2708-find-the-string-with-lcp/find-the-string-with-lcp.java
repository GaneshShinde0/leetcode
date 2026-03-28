class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        char curr = 'a';
        for(int i=0;i<n;i++){
            if(s[i]!=0) continue;
            if(curr>'z') return "";
            for(int j=i;j<n;j++){
                if(lcp[i][j]>0){
                    s[j] = curr;
                }
            }
            curr++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int expected = s[i]==s[j]?1:0;
                if(expected>0 && i<n-1 && j<n-1){
                    expected += lcp[i+1][j+1];
                }
                if(expected != lcp[i][j]) return "";
            }
        }
        return String.valueOf(s);

    }

















}

class SolutionWithComments {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        char curr = 'a';

        // 1. Greedy Construction
        for (int i = 0; i < n; i++) {
            // If this index hasn't been assigned a character yet
            if (s[i] == 0) {
                // If we've already used 'z', we can't form a string with only 26 lowercase letters
                if (curr > 'z') return "";
                
                // Assign the current character to all indices j where lcp[i][j] > 0
                // Starting j from 0 as you requested
                for (int j = 0; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        s[j] = curr;
                    }
                }
                curr++;
            }
        }

        // 2. Verification
        // Any greedy construction must be verified because the lcp matrix 
        // might contain contradictions (e.g., non-symmetric or invalid values).
        // 2. Verification (Forward Loop)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int expected = (s[i] == s[j]) ? 1 : 0;
                if (expected > 0 && i + 1 < n && j + 1 < n) {
                    expected += lcp[i + 1][j + 1];
                }
                
                if (lcp[i][j] != expected) return "";
            }
        }

        return new String(s);
    }
}

/*
  a b a b
a[4,0,2,0]
b[0,3,0,1]
a[2,0,2,0]
b[0,1,0,1]
*/