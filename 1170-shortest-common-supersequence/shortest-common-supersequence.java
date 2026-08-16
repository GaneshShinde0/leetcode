class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(m>0 && n>0){
            char c1 = str1.charAt(m-1), c2 = str2.charAt(n-1);
            if(c1==c2){
                sb.append(c1);
                m--;
                n--;
            }else if(dp[m][n-1]>dp[m-1][n]){
                sb.append(c2);
                n--;
            }else{
                sb.append(c1);
                m--;
            }
        }
        while(m>0) sb.append(str1.charAt(--m));
        while(n>0) sb.append(str2.charAt(--n));
        return sb.reverse().toString();
    }
}

class SolutionPrevious {
    public String shortestCommonSupersequenceBackTrackingTLE(String str1, String str2) {
        if(str1.isEmpty() && str2.isEmpty()) return "";
        if(str1.isEmpty()) return str2;
        if(str2.isEmpty()) return str1;
        if(str1.charAt(0)==str2.charAt(0)) return str1.charAt(0)+shortestCommonSupersequence(str1.substring(1),str2.substring(1));
        else{
            String pickStr1 = str1.charAt(0)+shortestCommonSupersequence(str1.substring(1),str2);
            String pickStr2 = str2.charAt(0)+shortestCommonSupersequence(str1,str2.substring(1));
            return (pickStr1.length()<pickStr2.length())?pickStr1:pickStr2;
        }
    }

    public String shortestCommonSupersequenceMemoizationTLE(String str1, String str2){
        String memoKey = str1+" " +str2;
        HashMap<String, String> memo = new HashMap<>();
        // Check if result is already computed.
        if(memo.containsKey(memoKey)) return memo.get(memoKey);
        if(str1.isEmpty() && str2.isEmpty()) {
            memo.put(memoKey,"");
            return "";
        }
        // Base Case: One String is empty, apend the other String
        if(str1.isEmpty()) return str2;
        if(str2.isEmpty()) return str1;
        // If the first characters match, include it in the supersequence
        if(str1.charAt(0)==str2.charAt(0)){
            String result = str1.charAt(0)+shortestCommonSupersequence(str1.substring(1),str2.substring(1));
            memo.put(memoKey,result);
            return result;
        }
        // Try Both options, Picking from str1 or str2 and choose the shorter one.
        String pickStr1 = str1.charAt(0)+shortestCommonSupersequence(str1.substring(1), str2);
        String pickStr2 = str2.charAt(0)+shortestCommonSupersequence(str1,str2.substring(1));
        String result = pickStr1.length()<pickStr2.length()?pickStr1:pickStr2;
        memo.put(memoKey,result);
        return result;
    }
    public String shortestCommonSupersequence(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        // Initialize the first row, when str1 is empty; the supersequence is str2's prefix.
        String[] prevRow = new String[n+1];
        for(int i = 0;i<=n;i++){
            prevRow[i] = str2.substring(0,i);
        }
        // Fill the DP table row by row
        for(int i=1;i<=m;i++){
            // Initialize the first column when str2 is empty, then supersequence is str1's prefix
            String[] currRow = new String[n+1];
            currRow[0] = str1.substring(0, i);
            for(int j=1;j<=n;j++){
                // If characters match, extend the supersequence from the diagonal value
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    currRow[j] = prevRow[j-1]+str1.charAt(i-1);
                }else{
                    // If characters do not match, choose the shorter supersequence from previous row (exclude current str1 char).
                    String pickS1 = prevRow[j];
                    // From previous column (exclude current Str2 char)
                    String pickS2 = currRow[j-1];
                    currRow[j] = (pickS1.length()<pickS2.length())?pickS1+str1.charAt(i-1):pickS2+str2.charAt(j-1);
                }
            }
            // Move to the next row (Update previous row reference)
            prevRow = currRow;
        }
        // Return the shortest common supersequence from the last cell
        return prevRow[n];
    }

    
}