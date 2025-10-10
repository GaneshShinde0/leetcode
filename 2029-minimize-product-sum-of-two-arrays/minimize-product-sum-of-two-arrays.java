class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0, n = nums1.length;
        for(int i=0;i<nums1.length;i++){
            res+=nums1[i]*nums2[n-i-1];
        }
        return res;
    }
}