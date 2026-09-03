/*
We need to determine the correct position of the minimum and the maximum element in the unsorted subarray to determine the boundaries of the required unsorted subarray.
To do so, we make use of stack. Traversenums, as we go facing 
*/
class Solution{
    public int findUnsortedSubarray(int[] nums){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) flag = true;
            if(flag) min = Math.min(min, nums[i]);
        }
        flag = false;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]) flag = true;
            if(flag) max = Math.max(max, nums[i]);
        }
        int l, r;
        for(l=0;l<nums.length;l++){
            if(min<nums[l]) break;
        }
        for(r=nums.length-1;r>=0;r--){
            if(max>nums[r]) break;
        }
        return r-l<0?0:r-l+1;
    }
}
class SolutionUsingStack{
    public int findUnsortedSubarray(int[] nums){
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i= nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r-l>0?r-l+1:0;
    }
}
class SolutionUsingAnotherArray {
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