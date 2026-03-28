class Solution1 {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        char curr = 'a';
        System.out.println(Arrays.toString(s));
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

        // Verification using DP to compute the actual LCP of constructed String
        int[][] actualLCP = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s[i]==s[j]){
                    actualLCP[i][j] = actualLCP[i+1][j+1]+1;
                }else{
                    actualLCP[i][j]=0;
                }

                if(actualLCP[i][j]!=lcp[i][j]) return "";
            }
        }
        return new String(s);
    }
}

class Solution {
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
        int[][] actualLCP = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Check if characters match
                if (s[i] == s[j]) {
                    actualLCP[i][j] = actualLCP[i + 1][j + 1] + 1;
                } else {
                    actualLCP[i][j] = 0;
                }
                
                // The computed LCP must exactly match the input matrix
                if (actualLCP[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        // Final check to ensure every character was assigned (handles edge cases)
        for (int i = 0; i < n; i++) {
            if (s[i] == 0) return "";
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