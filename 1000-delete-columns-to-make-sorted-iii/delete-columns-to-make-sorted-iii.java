class Solution {
    public int minDeletionSizeFails(String[] strs) {
        boolean[] del = new boolean[strs[0].length()];
        Arrays.fill(del,false);
        int n = strs[0].length();
        for(int i=0;i<strs.length;i++){
            for(int j=1;j<n;j++){
                if(strs[i].charAt(j)<strs[i].charAt(j-1)){
                    del[j] = true;
                }
            }
        }
        int res = 0;
        for(boolean b:del){
            if(b) res++;
        }
        return res;
    }
    
    public int minDeletionSize(String[] strs) {
        // Lets See Number of columns to Keep, Instead of number of columns to delete; We can substract that from length of string to get our ans.
        // Suppose we must keep first column C. Then next column D we keep must have all rows lexicographically sorted. i.e. C[i]<=D[i] and we can say that we have deleted all columns between c and D.

        // We can use DP to solve problem in this manner. Let dp[k] be number of columns that are kept in answering the question for input row[k:] for row in strs; 

        // The above gives a simple recursion for dp[k]

        int width = strs[0].length();
        int[] dp = new int[width];
        Arrays.fill(dp, 1); // If only one column is there it is always valid. (We can keep it)

        for(int i= width-2;i>=0;i--){
            search: for(int j=i+1;j<width;j++){
                for(String row: strs){
                    if(row.charAt(i)>row.charAt(j)) continue search;
                }
                // We can use break above and check if we have reached last string..or width... If yes we will add one more break here as well.
                dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }
        int kept = 0;
        for(int i:dp) kept = Math.max(kept, i);
        return width-kept;
    }
}