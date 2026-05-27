class Solution {
    public int maxSubarrayLength(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        // Find strictly decreasing stack based on last element.
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()|| nums[i]<nums[stack.peek()]){
                stack.push(i);
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                int j = stack.pop();
                max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
}