class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int cnt = 1; // As single element, will always be default result.
        int precnt = 1;
        int n = nums.size();
        int ans = 0;

        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                cnt++;
            }else{
                precnt = cnt;
                cnt = 1;
            }
            ans = Math.max(ans,Math.min(precnt,cnt));
            ans = Math.max(ans,cnt/2);
        }
        return ans;

    }
}