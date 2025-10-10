class Solution {
    public int minProductSumInitial(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0, n = nums1.length;
        for(int i=0;i<nums1.length;i++){
            res+=nums1[i]*nums2[n-i-1];
        }
        return res;
    }
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] count1 = new int[101]; // since nums[i] <= 100
        int[] count2 = new int[101];

        for (int x : nums1) count1[x]++;
        for (int x : nums2) count2[x]++;

        int sum = 0;
        int i = 0, j = 100;
        while (i <= 100 && j >= 0) {
            if (count1[i] == 0) { i++; continue; }
            if (count2[j] == 0) { j--; continue; }

            int freq = Math.min(count1[i], count2[j]);
            sum += freq * i * j;
            count1[i] -= freq;
            count2[j] -= freq;
        }

        return sum;
    }
}