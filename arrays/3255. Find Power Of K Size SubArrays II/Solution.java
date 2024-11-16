class Solution {
    public int[] resultsArrayTLE(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<res.length;i++){
            int max = nums[i];
            for(int j=i+1;j<i+k;j++){
                if(nums[j]==nums[j-1]+1){
                    max = nums[j];
                }else{
                    max = -1;
                    break;
                }
            }
            res[i]=max;
        }
        return res;
    }
    public int[] resultsArray(int[] nums, int k) {
        if(k==1) return nums;
        int n = nums.length;
        int[] res = new int[n-k+1];
        Arrays.fill(res,-1);
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                j++;
            }else{
                j=1;
            }
            if(j>=k){
                res[i-k+1]=nums[i];
            }
        }
        return res;
    }
}
