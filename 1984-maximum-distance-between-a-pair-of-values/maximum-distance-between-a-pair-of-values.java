/*
nums1 = [55,30,5,4,2]  => index i
nums2 = [100,20,10,10,5] => index j

nums1[0]<=nums2[0] => res[0]
i = 0, j= 0 => i=0, j= 1

nums1[0]>nums2[1] => res[0]
- As array is strictly decreasing we will just increase that i, until we find some i which is having nums[i]<=nums[j]

After doing all this,

outr new indexes will become
i = 2
j = 1

But the thing is i>j now, that will not cause any issue with our code for now... 
But we will just keep incrementing j Until we find some nums[j]<nums[i]

we did that and we reached end i.e. 4 in this case.

res = Math.max(0,4-2)=> 2
*/
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0, i = 0, j =  0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                res = Math.max(res, j-i);
                j++;
            }else{
                i++;
            }
        }
        return res;
    }
}