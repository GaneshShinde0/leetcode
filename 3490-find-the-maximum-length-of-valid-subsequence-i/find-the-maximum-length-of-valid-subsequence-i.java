class Solution {
    public int maximumLengthInitial(int[] nums) {
        /*
        The remainder sequence can be 
        0,0
        1,1
        0,1
        1,0
        as we are dividing with 2
        */
        int[] count = new int[2], end = new int[2];
        for(int i:nums){
            count[i%2]++;
            end[i%2]=end[1-i%2]+1;
            System.out.println(Arrays.toString(count));
            System.out.println(Arrays.toString(end));
        }
        return Math.max(Math.max(count[0],count[1]), Math.max(end[0], end[1]));
    }

    // Dynamic programming
    /*

    */
    public int maximumLength(int[] A){
        int res = 0, k =2, dp[][] = new int[k][k];
        for(int a:A){
            for(int b = 0; b<k; b++){
                dp[b][a%k] = dp[a%k][b]+1;
                res = Math.max(res, dp[b][a%k]);
            }
        }
        return res;
    }

}