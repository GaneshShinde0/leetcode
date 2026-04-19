/*
Input: 
nums1 = [55,30,5,4,2]
nums2 = [100,20,10,10,5]

*/
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0, p1=0,p2=0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]>nums2[p2]){
                p1++;
            }else{
                ans= Math.max(ans, p2-p1);
                p2++;
            }
        }
        return ans;
    }

}