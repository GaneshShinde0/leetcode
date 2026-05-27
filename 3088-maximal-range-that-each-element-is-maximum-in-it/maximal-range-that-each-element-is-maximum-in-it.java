class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<=nums.length;i++){
            while(stack.peek()!=-1 && (i==nums.length || nums[stack.peek()]<nums[i])){
                ans[stack.pop()] = i-1-stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}