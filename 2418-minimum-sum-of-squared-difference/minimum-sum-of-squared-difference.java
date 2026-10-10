class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1+k2, max = 0;
        int[] num = new int[n];
        int[] diffs = new int[100001];
        long res = 0, sum = 0;
        for(int i=0;i<n;i++){
            int x = Math.abs(nums1[i]-nums2[i]);
            sum+=x;
            diffs[x]++;
            max = Math.max(max, x);
        }
        if(sum<=k) return 0;
        for(int i = max;i>0;i--){
            int move = Math.min(k, diffs[i]);
            diffs[i] -= move;
            diffs[i-1] += move;
            k-=move;
            res += 1l*i*i*diffs[i];
        }
        return res;
    }
}