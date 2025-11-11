class Solution {
    public int findMaxFormTLE3Recursion(String[] strs, int m, int n) {
        return calculate(strs, 0, m, n);
    }
    public int calculate(String[] strs, int i, int zeroes, int ones) {
        if (i == strs.length)
            return 0;
        int[] count = countZerosOnes(strs[i]);
        int taken = -1;
        if (zeroes - count[0] >= 0 && ones - count[1] >= 0)
            taken = calculate(strs, i + 1, zeroes - count[0], ones - count[1]) + 1;
        int not_taken = calculate(strs, i + 1, zeroes, ones);
        return Math.max(taken, not_taken);
    }
    public int findMaxFormTLE1(String[] strs, int m, int n){
        int maxLen = 0;
        int strsLen = strs.length;
        for(int i=0;i<(1<<strsLen);i++){
            int zeros = 0, ones = 0, len = 0;
            for(int j=0; j<strsLen;j++){
                if((i&(1<<j))!=0){
                    int[] count = countZerosOnes(strs[j]);
                    zeros+=count[0];
                    ones+=count[1];
                    len++;
                }
            }
            if(zeros<=m && ones<=n){
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }

    public int findMaxFormTLE(String[] strs, int m, int n){
        int maxLen = 0;
        for(int i=0;i<(1<<strs.length);i++){
            int zeros=0, ones=0, len = 0;
            for(int j=0;j<32;j++){
                if((i & (1<<j))!=0){
                    int[] count = countZerosOnes(strs[j]);
                    zeros+=count[0];
                    ones+=count[1];
                    if(zeros>m || ones>n) break;
                    len++;
                }
            }
            if(zeros<=m && ones<=n) maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
    public int findMaxForm(String[] strs, int m, int n) {   
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<len;i++){
            int[] count = countZerosOnes(strs[i]);
            for(int zeros=m;zeros>=count[0];zeros--){
                for(int ones = n; ones>=count[1]; ones--){
                    dp[zeros][ones] = Math.max(1+dp[zeros-count[0]][ones-count[1]], dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] countZerosOnes(String s){
        int[] c = new int[2];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
    public int findMaxFormThisGivesSubArray(String[] strs, int m, int n) {   
        int len = strs.length;
        int[][] track = new int[len][2];
        for(int i=0;i<len;i++){
            int j = 0;
            int zeroCount =0, oneCount = 0;
            while(j<strs[i].length()){
                if(strs[i].charAt(j)=='0') zeroCount++;
                else oneCount++;
                j++;
            }
            track[i] = new int[]{zeroCount,oneCount};
        }
        int left =0, right = 0, res = 0, zeroCount = 0, oneCount = 0;
        while(right<len){
            while(zeroCount>m&&oneCount>n){
                zeroCount-=track[left][0];
                oneCount-=track[left][1];
                left++;
            }
            zeroCount+=track[right][0];
            oneCount+=track[right][1];
            if(zeroCount<=m && oneCount<=n){
                res = Math.max(right-left+1,res);
            }
            right++;
        }
        return res;
    }
    public int findMaxFormTotallyDiff(String[] strs, int m, int n) {
        int len = strs.length;
        boolean[] track = new boolean[len];
        for(int i=0;i<len;i++){
            int j = 0;
            int zeroCount =0, oneCount = 0;
            while(j<strs[i].length()){
                if(strs[i].charAt(j)=='0') zeroCount++;
                else oneCount++;
                j++;
            }
            track[i] = m>=zeroCount && n>=oneCount;
        }
        int count = 0, res = 0;
        for(int i=0;i<len;i++){
            if(track[i]){
                count++;
            }else{
                res = Math.max(res,count);
                count = 0;
            }
        }
        return res;
    }
}