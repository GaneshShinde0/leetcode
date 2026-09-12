/*
100000-1

All 1s should go after last 0...
All -1 should go after first 0....
*/
class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        // Lets simplify problem;
        int[] arr = Arrays.copyOf(nums,nums.length);
        int firstZero = -1, lastZero = -1;
        for(int i=0;i<arr.length;i++){
            arr[i] = nums[i]>b?1:nums[i]<a?-1:0;
        }
        // System.out.println(Arrays.toString(arr));
        // Now bascally we have to get this array sorted.. so that all 0's come in middle ones come to right, and -1s come to left.
        long res = 0;
        int zero = 0, ones = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zero++;
                res+=ones;
            }else if(arr[i]==1){
                ones++;
            }else{
                res+=zero+ones;
            }
        }
        return (int) (res%1_000_000_007);
    }

}