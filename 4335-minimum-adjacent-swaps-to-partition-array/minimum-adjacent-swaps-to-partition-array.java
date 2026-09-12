/*
100000-1

All 1s should go after last 0...
All -1 should go after first 0....
*/
class Solution {
    public int minAdjacentSwaps1(int[] nums, int a, int b) {
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
                res+=ones; // When we see zero that zero needs to go to left by one count.
            }else if(arr[i]==1){
                ones++;
            }else{
                res+=zero+ones; // When you see  a negative one you need to move it to left by zero+ones count..
            }
        }
        return (int) (res%1_000_000_007);
    }

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
        int negOnes = 0, ones = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                res+= i-negOnes;
                negOnes++;
            }else if(arr[i]==0){
                res+=ones;
            }else{
                ones++;
            }
        }
        return (int) (res%1_000_000_007);
    }
}