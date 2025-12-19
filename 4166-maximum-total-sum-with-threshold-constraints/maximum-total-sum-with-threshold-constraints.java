class Solution {
    public long maxSum(int[] nums, int[] threshold) {
        int n = nums.length;
        long res = 0;
        int[][] numsToThreshold = new int[n][2];
        for(int i=0;i<n;i++){
            numsToThreshold[i][0] = nums[i];
            numsToThreshold[i][1] = threshold[i];
        }
        Arrays.sort(numsToThreshold, (a,b)->Integer.compare(a[1],b[1]));
        int step = 1;
        for(int i=0;i<n;i++){
            if(numsToThreshold[i][1]<=step){
                step++;
                res+=numsToThreshold[i][0];
            }else{
                break;
            }
        }
        return res;
    }
}