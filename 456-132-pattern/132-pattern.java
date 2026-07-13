class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1;i<n;i++){
            min[i] = Math.min(nums[i], min[i-1]);
        }

        Stack<Integer> stk = new Stack<>();
        for(int j = nums.length-1;j>=0;j--){
            while(!stk.empty() && stk.peek()<nums[j]){
                if(stk.peek()>min[j]){
                    return true;
                }
                stk.pop();
            }
            stk.push(nums[j]);
        }
        return false;
    }
}