/*

*/

class Solution {
    public int minArrayLengthFailsOneTestCCase(int[] nums, int k) {
        long res = 1, curr = 1;
        for(int num:nums){
            if(num==0) return 1;
            if(num*curr>k){
                curr=num;
                res++;
            }else{
                curr = curr*num;
            }
        }
        return (int) (res);
    }

    public int minArrayLength(int[] nums, int k) {
        long res = 1, curr = nums[0];
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num==0) return 1;
            if(num*curr>k){
                curr=num;
                res++;
            }else{
                curr = curr*num;
            }
        }
        return (int) (res);
    }
}