class Solution {

    public int countKDifferenceOnXn(int[] nums, int k) {
        int count =0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(nums[i]-nums[j])==k) count++;
            }
        }
        return count;
    }

    
    public int countKDifferenceCountingSort(int[] nums, int k) {
        var n = nums.length;
        var ans = 0;

        var counts = new int[100 + 1];
        for (var num : nums) {
            if (num > k) ans += counts[num - k]; // [1,2], k=1
            if (num + k < 101) ans += counts[k + num]; // [2,1], k=1 
            counts[num]++;
        }
        return ans;
    }

    public int countKDifference(int[] nums, int k) {
        int[] arr = new int[101];
        for (int num:nums) {
            arr[num]++;
        }
        int res = 0;
        for (int i = k+1; i < 101; i++) {
            res += arr[i]*arr[i-k];
        }
        return res;    
    }
}
