class Solution {
    public boolean isInterleaveMN(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if((m+n)!=s3.length()) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<=m;i++){ // I cannot start this from 1 as as dp[0][j] needs to be iterated fully.
            for(int j=0;j<=n;j++){ // I cannot start this from 1 as as dp[i][0] needs to be iterated fully.
                if((i>0 && s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j])
                    || (j>0 && s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1])
                ){
                    dp[i][j]=true;
                }
            }
        }
        return dp[m][n];
    }

    public boolean isInterleave(String s1, String s2, String s3){
        int m = s1.length(), n = s2.length();
        if(m+n!=s3.length()) return false;
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        // Initialize first row using only s2;
        for(int j=1;j<=n;j++){
            dp[j] = dp[j-1] && s2.charAt(j-1)==s3.charAt(j-1);        
        }

        for(int i=1;i<=m;i++){
            // Update first column using only s1
            dp[0] = dp[0]&&s1.charAt(i-1)==s3.charAt(i-1);
            for(int j=1;j<=n;j++){
                dp[j] = (dp[j] && s1.charAt(i-1)==s3.charAt(i+j-1))
                    || (dp[j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[n];
    }
}

class SolutionOld{
    public boolean isInterleave(String s1, String s2, String s3) {
        int i=0,j=0;
        int m = s1.length(), n = s2.length();
        if((m+n)!=s3.length()) return false;
        for(int k=0;k<s3.length();k++){
            if(i<m && s3.charAt(k)==s1.charAt(i)){
                i++;
            }else if(j<n && s3.charAt(k)==s2.charAt(j)){
                j++;
            }
        }
        if ((i+j)==s3.length()) return true;
        i=0;j=0;
        for(int k=0;k<s3.length();k++){
            if(j<n && s3.charAt(k)==s2.charAt(j)){
                j++;
            }else if(i<m && s3.charAt(k)==s1.charAt(i)){
                i++;
            }
        }
        if ((i+j)==s3.length()) return true;
        return false;

    }
}

/*
aadbbcbcac
i = 5
j = 3
k = 8
*/
/*
aadbbcbcac
i = 5
j = 3
k = 8
*/