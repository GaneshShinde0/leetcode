class Solution {
    public int countMajoritySubarraysInitial(int[] nums, int target) {
        int n = nums.length;
        int res = 0;
        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            int targetCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) targetCount++;
                int len = j - i + 1;
                if (targetCount * 2 > len) res++;
            }
        }

        return res;
    }

    public int countMajoritySubarrays(int[] nums, int target){
        int n = nums.length;
        int[] pre = new int[2*n+1];
        pre[n] = 1;
        int cnt = n;
        int preSum = 0, ans = 0;
        for(int x:nums){
            if(x==target){
                preSum+=pre[cnt];
                cnt++;
                pre[cnt]++;
            }else{
                cnt--;
                preSum-=pre[cnt];
                pre[cnt]++;
            }
            ans += preSum;
        }
        return ans;
    }
}
