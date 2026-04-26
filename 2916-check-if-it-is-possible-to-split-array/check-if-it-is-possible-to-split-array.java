/*
[1, 5, 3, 2, 8, 9]  = 10

=> If array size is 1 then it is good.
=> The sum of the elements of the array is greater than or equal to m.
=> In each step, you can select an existing array (which may be the result of previous steps) with a length of at least two and split it into two arrays, if both resulting arrays are good.

We basically need n subarrays whose sum is greater than m.
-> It is possible with following things
    -> [Sum of left subaray>=m]
    -> [Sum of right subarray>=m]
-> This is only possible if any any point we have arr[i]+arr[i+1]>=m
    -> This way we can combine arr[]
*/
class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size()<=2) return true;
        int cumSum = 0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)+nums.get(i-1)>=m) return true; 
        }
        return false;
    }
}