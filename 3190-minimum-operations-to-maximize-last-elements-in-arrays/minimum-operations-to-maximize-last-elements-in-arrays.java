class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int count1 = 0;// When last elements are not swapped.
        int count2 = 0;// When last elements are swapped.
        int min = Math.min(nums1[n-1],nums2[n-1]), max = Math.max(nums1[n-1],nums2[n-1]);
        for(int i=0;i<n;i++){
            int n1 = nums1[i], n2 = nums2[i];
            if(Math.max(n1,n2)>max) return -1; // No swap will work.
            if(Math.min(n1,n2)>min) return -1; // No swap will work.
            if(n1>nums1[n-1]||n2>nums2[n-1]) count1++; // When last elements are not swapped.
            if(n1>nums2[n-1]||n2>nums1[n-1]) count2++; // When last elements are swapped.
        }
        return Math.min(count1,count2);
    }
}