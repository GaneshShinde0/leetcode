class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums1.length%2==0 && nums2.length%2==0) return 0;
        int res = 0;
        if(nums1.length%2==1){
            for(int i:nums2){
                res^=i;
            }
        }
        int res2=0;
        if(nums2.length%2==1){
            for(int i:nums1){
                res2^=i;
            }
        }
        return res^res2;
    }
}
