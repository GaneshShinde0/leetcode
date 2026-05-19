class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0, p2= 0, len1 = nums1.length, len2 = nums2.length;
        while(p1<len1 && p2<len2){
            if(nums1[p1]==nums2[p2]) return nums1[p1];
            else if(nums1[p1]>nums2[p2]) p2++;
            else p1++;
        }
        return -1;
    }
}