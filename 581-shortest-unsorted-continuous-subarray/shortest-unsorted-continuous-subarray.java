/*
We need to determine the correct position of the minimum and the maximum element in the unsorted subarray to determine the boundaries of the required unsorted subarray.
To do so, we make use 
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int start = sorted.length, end = 0;
        for(int i=0;i<sorted.length;i++){
            if(sorted[i] != nums[i]){
                start = Math.min(start, i);
                end = Math.max(end,i);
            }
        }
        return (end-start>=0?end-start+1:0);
    }
}